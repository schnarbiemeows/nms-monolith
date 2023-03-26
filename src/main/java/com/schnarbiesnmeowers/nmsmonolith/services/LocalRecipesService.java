package com.schnarbiesnmeowers.nmsmonolith.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LocalRecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDisplayRecord;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietRequest;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalRecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalRecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ServingRatioNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDiet;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Recipes;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalRecipesRepository;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.*;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 *
 * @author Dylan I. Kessler
 */
@Service
public class LocalRecipesService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private LocalRecipesRepository localRecipesRepository;

    @Autowired
    private RecipesService recipesService;

    @Autowired
    LocalIngredientsService localIngredientsService;

    @Autowired
    LocalSpicesService localSpicesService;

    @Autowired
    LocalRecipeStepsService localRecipeStepsService;

    @Autowired
    SpicesService spicesService;

    @Autowired
    IngredientsService ingredientsService;

    @Autowired
    RecipeIngredientsService recipeIngredientsService;

    @Autowired
    LocalRecipeIngredientsService localRecipeIngredientsService;

    @Autowired
    LocalRecipeSpicesService localRecipeSpicesService;


    @Autowired
    ServingTypesService servingTypesService;

    @Autowired
    RecipeCalculatorUtility recipeCalculatorUtility;

    @Autowired
    private FavoriteRecipesService favoriteRecipesService;

    @Autowired
    private DailyDietService dailyDietService;

    @Autowired
    private DietaryTemplatesService dietaryTemplatesService;

    @Autowired
    private UnsyncedService unsyncedService;

    /**
     * get all LocalRecipes records
     *
     * @return
     * @throws Exception
     */
    public List<LocalRecipesDTO> getAllLocalRecipes() throws Exception {
        Iterable<LocalRecipes> localrecipes = localRecipesRepository.findAll();
        Iterator<LocalRecipes> localrecipess = localrecipes.iterator();
        List<LocalRecipesDTO> localrecipesdto = new ArrayList();
        while (localrecipess.hasNext()) {
            LocalRecipes item = localrecipess.next();
            localrecipesdto.add(item.toDTO());
        }
        return localrecipesdto;
    }

    /**
     * get all the local ingredients for a given user
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<LocalRecipesDTO> getAllLocalRecipes(int userId) throws Exception {
        Iterable<LocalRecipes> recipes = localRecipesRepository.findLocalRecipesByUserId(userId);
        Iterator<LocalRecipes> recipesIterator = recipes.iterator();
        List<LocalRecipesDTO> recipesDTOS = new ArrayList();
        while (recipesIterator.hasNext()) {
            LocalRecipes item = recipesIterator.next();
            recipesDTOS.add(item.toDTO());
        }
        return recipesDTOS;
    }

    public LocalRecipes findBasicRecipeInfoByRecipeId(int id) throws Exception {
        Optional<LocalRecipes> recipesOptional = localRecipesRepository.findById(id);
        if (recipesOptional.isPresent()) {
            return recipesOptional.get();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * get LocalRecipes by primary key
     *
     * @param id
     * @return
     * @throws Exception
     */
    public RecipeFormDTO findLocalRecipesById(int id) throws Exception {
        RecipeFormDTO recipeRecordAndIngredientDisplayList = new RecipeFormDTO();
        recipeRecordAndIngredientDisplayList.setLocal(true);
        Optional<LocalRecipes> localrecipesOptional = localRecipesRepository.findById(id);
        if (localrecipesOptional.isPresent()) {
            LocalRecipes results = localrecipesOptional.get();
            recipeRecordAndIngredientDisplayList.setUserId(results.getUserId());
            Recipes dto = new Recipes(results.getRecipeId(), results.getRecipeName(), results.getRecipeTypeId(),
                    results.getIngrId(), results.getRecipeDesc(), results.getRecipeLink(),
                    results.getNumSrv(), results.getActv());
            recipeRecordAndIngredientDisplayList.setRecipeMetaData(dto.toDTO());
            LocalIngredientsDTO ingredientRecordForRecipe = localIngredientsService.findLocalIngredientsById(results.getIngrId());
            recipeRecordAndIngredientDisplayList.setServingSize(ingredientRecordForRecipe.getServSz());
            recipeRecordAndIngredientDisplayList.setServingTypeId(ingredientRecordForRecipe.getServTypeId());
            List<RecipeIngredientDisplay> displayList = getRecipeIngredientDisplays(results);
            recipeRecordAndIngredientDisplayList.setRecipeIngredients(displayList);
            List<RecipeSpiceDisplay> spiceList = getRecipeSpiceDisplays(results);
            recipeRecordAndIngredientDisplayList.setRecipeSpices(spiceList);
            List<RecipeStepsDisplay> stepsList = getRecipeStepDisplays(results);
            recipeRecordAndIngredientDisplayList.setRecipeSteps(stepsList);
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
        return recipeRecordAndIngredientDisplayList;
    }

    private List<RecipeIngredientDisplay> getRecipeIngredientDisplays(LocalRecipes results) throws Exception {
        List<LocalRecipeIngredientsDTO> ingredientList = localRecipeIngredientsService
                .findRecipeIngredientsByRecipeId(results.getRecipeId());
        List<RecipeIngredientDisplay> displayList = new ArrayList();
        for (LocalRecipeIngredientsDTO rec : ingredientList) {
            RecipeIngredientDisplay item = new RecipeIngredientDisplay(rec.getRecOrIngrId(),
                    null, rec.isLocalRecpIngr(), rec.getRecipeFlg().equals(YES) ? true : false,
                    rec.getServSz(), rec.getServTypeId(), null, null, null);
            ServingTypesDTO servingType = servingTypesService.findServingTypesById(rec.getServTypeId());
            item.setServUnitDesc(servingType.getServTypeCde());
            if (rec.isLocalRecpIngr()) {
                if (item.isRecipe()) {
                    Optional<LocalRecipes> recipe = localRecipesRepository.findById(rec.getRecOrIngrId());
                    item.setDescription(recipe.get().getRecipeName());
                    LocalIngredientsDTO ingredient =
                            localIngredientsService.findLocalIngredientsById(recipe.get().getIngrId());
                    item.setNutritionalData(ingredient.returnGlobalDTO());
                    item.setMultiplier(calculateM1(item.getServUnitId(),ingredient.returnGlobalDTO()));
                } else {
                    LocalIngredientsDTO ingredient =
                            localIngredientsService.findLocalIngredientsById(rec.getRecOrIngrId());
                    item.setDescription(ingredient.getIngrDesc());
                    item.setNutritionalData(ingredient.returnGlobalDTO());
                    item.setMultiplier(calculateM1(item.getServUnitId(),ingredient.returnGlobalDTO()));
                }
            } else {
                if (item.isRecipe()) {
                    Recipes recipe = recipesService.findBasicRecipeInfoByRecipeId(rec.getRecOrIngrId());
                    item.setDescription(recipe.getRecipeName());
                    IngredientsDTO ingredient = ingredientsService.findIngredientsById(recipe.getIngrId());
                    item.setNutritionalData(ingredient);
                    item.setMultiplier(calculateM1(item.getServUnitId(),ingredient));
                } else {
                    IngredientsDTO ingredient = ingredientsService.findIngredientsById(rec.getRecOrIngrId());
                    item.setDescription(ingredient.getIngrDesc());
                    item.setNutritionalData(ingredient);
                    item.setMultiplier(calculateM1(item.getServUnitId(),ingredient));
                }
            }
            displayList.add(item);
        }
        return displayList;
    }

    private List<RecipeSpiceDisplay> getRecipeSpiceDisplays(LocalRecipes results) throws Exception {
        List<LocalRecipeSpicesDTO> spicesList = localRecipeSpicesService
                .findLocalRecipeSpicesByRecipeId(results.getRecipeId());
        List<RecipeSpiceDisplay> displayList = new ArrayList();
        for (LocalRecipeSpicesDTO rec : spicesList) {
            RecipeSpiceDisplay item = new RecipeSpiceDisplay(rec.getSpiceId(),
                    null, rec.getIsLocal(),
                    rec.getServSz(), rec.getServTypeId(), null);
            ServingTypesDTO servingType = servingTypesService.findServingTypesById(rec.getServTypeId());
            item.setServUnitDesc(servingType.getServTypeCde());
            if (rec.getIsLocal()) {
                LocalSpicesDTO spice =
                        localSpicesService.findLocalSpicesById(rec.getSpiceId());
                item.setDescription(spice.getSpiceName());
            } else {
                SpicesDTO spice = spicesService.findSpicesById(rec.getSpiceId());
                item.setDescription(spice.getSpiceName());
            }
            displayList.add(item);
        }
        return displayList;
    }

    private List<RecipeStepsDisplay> getRecipeStepDisplays(LocalRecipes results) throws Exception {
        List<LocalRecipeStepsDTO> stepsList = localRecipeStepsService
                .findLocalRecipeStepsByRecipeId(results.getRecipeId());
        List<RecipeStepsDisplay> displayList = new ArrayList();
        for (LocalRecipeStepsDTO rec : stepsList) {
            RecipeStepsDisplay item = new RecipeStepsDisplay(rec.getStepDesc());
            displayList.add(item);
        }
        return displayList;
    }

    /**
     * create a new LocalRecipes
     *
     * @param data
     * @return
     */
    public LocalRecipesDTO createLocalRecipe(RecipeFormDTO data) throws Exception {
        Recipes metaData = data.getRecipeMetaData().toEntity();
        LocalRecipes createdData = new LocalRecipes(metaData.getRecipeId(), metaData.getRecipeName(),
                metaData.getRecipeTypeId(), metaData.getIngrId(), metaData.getRecipeDesc(),
                metaData.getRecipeLink(), metaData.getNumSrv(), metaData.getActv(), data.getUserId());
        List<RecipeIngredientDisplay> recipeIngredients = data.getRecipeIngredients();
        // first calculate the recipe totals
        LocalIngredientsDTO ingredientRecord = calculateRecipeTotals(createdData,
                recipeIngredients, data.getServingSize(), data.getServingTypeId());
        // make the recipe record and ingredients record
        LocalIngredientsDTO localIngredientRecordForRecipe = localIngredientsService.createLocalIngredients(ingredientRecord);
        createdData.setIngrId(localIngredientRecordForRecipe.getIngrId());
        createdData = localRecipesRepository.save(createdData);
        // make the recipe_ingredient records
        createRecipeIngredientRecords(recipeIngredients, createdData.getRecipeId(), data.getUserId());
        createRecipeSpiceRecords(data.getRecipeSpices(), createdData.getRecipeId(), data.getUserId());
        createRecipeStepRecords(data.getRecipeSteps(), createdData.getRecipeId(), data.getUserId());
        if(data.isFavor()) {
            favoriteRecipesService.upsertFavoriteLocalRecipe(createdData.getRecipeId(),
                    data.getUserId());
        }
        return createdData.toDTO();
    }

    private void createRecipeIngredientRecords(List<RecipeIngredientDisplay> recipeIngredients, Integer recipeId, Integer userId) {
        recipeIngredients.forEach(rec -> {
            //if(rec.isLocal()) {
            LocalRecipeIngredientsDTO dto = new LocalRecipeIngredientsDTO();
            dto.setRecipeId(recipeId);
            dto.setActv("Y");
            dto.setRecipeFlg(rec.isRecipe() == true ? "Y" : "N");
            dto.setRecOrIngrId(rec.getIngrId());
            dto.setLocalRecpIngr(rec.isLocal());
            dto.setServSz(rec.getServSz());
            dto.setServTypeId(rec.getServUnitId());
            dto.setUserId(userId);
            localRecipeIngredientsService.createLocalRecipeIngredients(dto);
			/*} else {
				RecipeIngredientsDTO dto = new RecipeIngredientsDTO();
				dto.setRecipeId(recipeId);
				dto.setActv("Y");
				dto.setRecipeFlg(rec.isRecipe()==true ? "Y" : "N");
				dto.setRecOrIngrId(rec.getIngrId());
				dto.setServSz(rec.getServSz());
				dto.setServTypeId(rec.getServUnitId());
				recipeIngredientsService.createRecipeIngredients(dto);
			}*/
        });
    }

    private void createRecipeSpiceRecords(List<RecipeSpiceDisplay> recipeSpices, Integer recipeId, Integer userId) {
        recipeSpices.forEach(rec -> {
            LocalRecipeSpicesDTO dto = new LocalRecipeSpicesDTO();
            dto.setRecipeId(recipeId);
            dto.setActv("Y");
            dto.setSpiceId(rec.getSpiceId());
            dto.setIsLocal(rec.isLocal());
            dto.setServSz(rec.getServSz());
            dto.setServTypeId(rec.getServUnitId());
            dto.setUserId(userId);
            localRecipeSpicesService.createLocalRecipeSpices(dto);
        });
    }

    private void createRecipeStepRecords(List<RecipeStepsDisplay> recipeSteps, Integer recipeId, Integer userId) {
        int counter = 1;
        for(RecipeStepsDisplay step: recipeSteps) {
            LocalRecipeStepsDTO dto = new LocalRecipeStepsDTO();
            dto.setStepDesc(step.getStepDescription());
            dto.setRecipeId(recipeId);
            dto.setStepNum(counter++);
            dto.setActv("Y");
            dto.setUserId(userId);
            localRecipeStepsService.createLocalRecipeSteps(dto);
        }
    }

    public LocalIngredientsDTO calculateRecipeTotals(LocalRecipes createdData,
                                                      List<RecipeIngredientDisplay> recipeIngredients,
                                                      BigDecimal servingSize, Integer servingTypeId) throws Exception {
        LocalIngredientsDTO result = initializeDTO(createdData, servingTypeId, servingSize);
        recipeIngredients.forEach(rec -> {
            BigDecimal m1 = BigDecimal.ONE;
            IngredientsDTO ingredient = null;
            ingredient = getIngredientsDTO(rec, ingredient);
            m1 = calculateM1(rec.getServUnitId(), ingredient);
            addToTotals(result, rec, m1, ingredient, createdData.getNumSrv());
        });
        return roundResults(result);
    }

    private LocalIngredientsDTO roundResults(LocalIngredientsDTO result) {
        result.setCholes(result.getCholes().setScale(2, RoundingMode.HALF_UP));
        result.setKcalories(result.getKcalories().setScale(2, RoundingMode.HALF_UP));
        result.setMonoFat(result.getMonoFat().setScale(2, RoundingMode.HALF_UP));
        result.setPolyFat(result.getPolyFat().setScale(2, RoundingMode.HALF_UP));
        result.setTotCarbs(result.getTotCarbs().setScale(2, RoundingMode.HALF_UP));
        result.setTotFat(result.getTotFat().setScale(2, RoundingMode.HALF_UP));
        result.setTotFiber(result.getTotFiber().setScale(2, RoundingMode.HALF_UP));
        result.setTotProtein(result.getTotProtein().setScale(2, RoundingMode.HALF_UP));
        result.setTransFat(result.getTransFat().setScale(2, RoundingMode.HALF_UP));
        result.setTotSugars(result.getTotSugars().setScale(2, RoundingMode.HALF_UP));
        result.setServSz(result.getServSz().setScale(2, RoundingMode.HALF_UP));
        result.setSatFat(result.getSatFat().setScale(2, RoundingMode.HALF_UP));
        return result;
    }

    /**
     * TODO - refactor this to the RecipeCalculatorUtility class
     * @param servingUnitId
     * @param ingredient
     * @return
     */
    private BigDecimal calculateM1(Integer servingUnitId, IngredientsDTO ingredient) {
        BigDecimal m1;
        if(servingUnitId==ingredient.getServTypeId()) {
            m1=BigDecimal.ONE;
        } else if (recipeCalculatorUtility.hasRatio(servingUnitId, ingredient.getServTypeId())) {
            m1 = recipeCalculatorUtility.getRatio(servingUnitId, ingredient.getServTypeId());
        } else if (recipeCalculatorUtility.hasFittingRatios(servingUnitId, ingredient.getServTypeId())) {
            m1 = recipeCalculatorUtility.findFittingRatio(servingUnitId, ingredient.getServTypeId());
        } else {
            ServingTypesDTO st1 = null;
            ServingTypesDTO st2 = null;
            try {
                st1 = servingTypesService.findServingTypesById(servingUnitId);
                st2 = servingTypesService.findServingTypesById(ingredient.getServTypeId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            throw new ServingRatioNotFoundException("serving type: " + st1.getServTypeCde() +
                    " cannot be converted to serving type: " + st2.getServTypeCde() +
                    " for ingredient: " + ingredient.getIngrDesc());
        }
        return m1;
    }

    private IngredientsDTO getIngredientsDTO(RecipeIngredientDisplay rec, IngredientsDTO ingredient) {
        try {
            if(rec.isRecipe()) {
                if (rec.isLocal()) {
                    LocalRecipes recipeRecord = findBasicRecipeInfoByRecipeId(rec.getIngrId());
                    LocalIngredientsDTO localIngredient =
                            localIngredientsService.findLocalIngredientsById(recipeRecord.getIngrId());
                    ingredient = localToGlobal(localIngredient, ingredient);
                } else {
                    Recipes recipeRecord = recipesService.findBasicRecipeInfoByRecipeId(rec.getIngrId());
                    ingredient = ingredientsService.findIngredientsById(recipeRecord.getIngrId());
                }
            } else {
                if (rec.isLocal()) {
                    LocalIngredientsDTO localIngredient = localIngredientsService.findLocalIngredientsById(rec.getIngrId());
                    ingredient = localToGlobal(localIngredient, ingredient);
                } else {
                    ingredient = ingredientsService.findIngredientsById(rec.getIngrId());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredient;
    }

    private static BigDecimal adder(BigDecimal beginningTotal, BigDecimal recordServingSize,
                                    BigDecimal ingredientServingSize, BigDecimal multiplier,
                                    BigDecimal ingredientTotalPerServing, BigDecimal recipeNumServings) {
        BigDecimal i1 = recordServingSize.divide(ingredientServingSize,2,RoundingMode.HALF_UP)
                .setScale(2,RoundingMode.HALF_UP);;
        BigDecimal i2 = i1.multiply(multiplier);
        BigDecimal i3 = i2.multiply(ingredientTotalPerServing);
        BigDecimal i4 = i3.divide(recipeNumServings,2,RoundingMode.HALF_UP)
                .setScale(2,RoundingMode.HALF_UP);;
        return beginningTotal.add(i4);
    }
    private static void addToTotals(LocalIngredientsDTO result, RecipeIngredientDisplay rec, BigDecimal m1,
                                    IngredientsDTO ingredient, BigDecimal numSrvgs) {
        result.setKcalories(adder(result.getKcalories(), rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getKcalories(),numSrvgs));
        result.setTotFat(adder(result.getTotFat(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getTotFat(),numSrvgs));
        result.setSatFat(adder(result.getSatFat(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getSatFat(),numSrvgs));
        result.setTransFat(adder(result.getTransFat(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getTransFat(),numSrvgs));
        result.setPolyFat(adder(result.getPolyFat(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getPolyFat(),numSrvgs));
        result.setMonoFat(adder(result.getMonoFat(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getMonoFat(),numSrvgs));
        result.setCholes(adder(result.getCholes(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getCholes(),numSrvgs));
        BigDecimal sodiumSubtotal = adder(BigDecimal.ZERO,rec.getServSz(),ingredient.getServSz(),
                m1,new BigDecimal(ingredient.getSodium()),numSrvgs);
        result.setSodium(result.getSodium().intValue() + sodiumSubtotal.intValue());
        result.setTotCarbs(adder(result.getTotCarbs(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getTotCarbs(),numSrvgs));
        result.setTotFiber(adder(result.getTotFiber(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getTotFiber(),numSrvgs));
        result.setTotSugars(adder(result.getTotSugars(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getTotSugars(),numSrvgs));
        result.setTotProtein(adder(result.getTotProtein(),rec.getServSz(),ingredient.getServSz(),
                m1,ingredient.getTotProtein(),numSrvgs));
    }


    private static LocalIngredientsDTO initializeDTO(LocalRecipes createdData,
                                                     Integer servingTypeId, BigDecimal servingSize) {
        LocalIngredientsDTO result = new LocalIngredientsDTO();
        if (createdData.getIngrId() != null) {
            result.setIngrId(createdData.getIngrId());
        }
        result.setActv(YES);
        result.setIngrDesc(createdData.getRecipeName());
        result.setIngrTypeId(INGREDIENT_TYPE_ID_FOR_RECIPE);
        result.setBrandId(BRAND_ID_FOR_RECIPE);
        result.setServSz(servingSize);
        result.setServTypeId(servingTypeId);
        result.setImageLoc(null);
        result.setKcalories(BigDecimal.ZERO);
        result.setTotFat(BigDecimal.ZERO);
        result.setSatFat(BigDecimal.ZERO);
        result.setTransFat(BigDecimal.ZERO);
        result.setPolyFat(BigDecimal.ZERO);
        result.setMonoFat(BigDecimal.ZERO);
        result.setCholes(BigDecimal.ZERO);
        result.setSodium(0);
        result.setTotCarbs(BigDecimal.ZERO);
        result.setTotFiber(BigDecimal.ZERO);
        result.setTotSugars(BigDecimal.ZERO);
        result.setTotProtein(BigDecimal.ZERO);
        result.setGlycIndx(null);
        result.setUserId(createdData.getUserId());
        return result;
    }

    private IngredientsDTO localToGlobal(LocalIngredientsDTO localIngredient, IngredientsDTO ingredient) {
        ingredient = new IngredientsDTO(localIngredient.getIngrId(), localIngredient.getIngrDesc(),
                localIngredient.getIngrTypeId(), localIngredient.getBrandId(),
                localIngredient.getServSz(), localIngredient.getServTypeId(),
                localIngredient.getKcalories(), localIngredient.getTotFat(),
                localIngredient.getSatFat(), localIngredient.getTransFat(),
                localIngredient.getPolyFat(), localIngredient.getMonoFat(),
                localIngredient.getCholes(), localIngredient.getSodium(),
                localIngredient.getTotCarbs(), localIngredient.getTotFiber(),
                localIngredient.getTotSugars(), localIngredient.getTotProtein(),
                localIngredient.getGlycIndx(), localIngredient.getImageLoc(),
                localIngredient.getActv());
        return ingredient;
    }

    /**
     * update a LocalRecipes
     * if the nutritional information gets updated, then we have to:
     * 1. recalculate the recipe totals from the list of ingredients
     * 2. update the local_ingredients record for that recipe
     * 3. update the local_recipe record
     * 4. add/update/delete local_recipe_ingredients records
     * 5. recursively update any local recipes that may have this recipe as a dependency
     * @param data
     * @return
     * @throws Exception
     */
    public LocalRecipesDTO updateLocalRecipes(RecipeFormDTO data) throws Exception {
        Optional<LocalRecipes> localrecipesOptional = localRecipesRepository.findById(data.getRecipeMetaData().getRecipeId());
        if (localrecipesOptional.isPresent()) {
            if (NO.equals(data.getRecipeMetaData().getActv())) {
                checkForDependencies(data.getRecipeMetaData().getRecipeId(), data.getUserId());
                /**
                 * TODO - if the recipe's actv is set to NO, then I am effectively deleting it
                 * so I would want to do what is in the delete() method instead of what I am doing below
                 * we won't mess with this for now on account of the active flag will not be showing on the
                 * edit recipe form
                 * remember, I would need to also delete the ingredient record and the recipe_ingredient records
                 */
            }
            Recipes metaData = data.getRecipeMetaData().toEntity();
            LocalRecipes updatedData = new LocalRecipes(metaData.getRecipeId(), metaData.getRecipeName(),
                    metaData.getRecipeTypeId(), metaData.getIngrId(), metaData.getRecipeDesc(),
                    metaData.getRecipeLink(), metaData.getNumSrv(), metaData.getActv(), data.getUserId());
            // 1. recalculate the recipe totals from the list of ingredients
            List<RecipeIngredientDisplay> recipeIngredients = data.getRecipeIngredients();
           LocalIngredientsDTO ingredientRecord = calculateRecipeTotals(updatedData, recipeIngredients,
                    data.getServingSize(), data.getServingTypeId());
            // 2. update the local_ingredients record for that recipe
            /**
             * TODO - perform some sort of prime # generation algorithm to check
             */
            boolean haveToUpdate = checkIfWeNeedToRecursivelyUpdate(ingredientRecord,data);
            LocalIngredientsDTO ingredientRecordForRecipe =
                    localIngredientsService.updateIngredientRecordForRecipe(ingredientRecord);
            // 3. update the local_recipe record
            updatedData = localRecipesRepository.save(updatedData);
            // 4. add/update/delete local_recipe_ingredients records
            updateRecipeIngredientRecords(recipeIngredients, updatedData.getRecipeId(), data.getUserId());
            updateRecipeSpiceRecords(data.getRecipeSpices(),updatedData.getRecipeId(), data.getUserId());
            updateRecipeStepRecords(data.getRecipeSteps(),updatedData.getRecipeId(), data.getUserId());
            // 5. recursively update any local recipes that may have this recipe as a dependency
            /**
             * TODO - put this chunk into another method
             *
             */
            if(haveToUpdate) {
                List<Integer> affectedRecipes = new ArrayList();
                affectedRecipes.add(updatedData.getRecipeId());
                List<LocalRecipeIngredientsDTO> results =
                        localRecipeIngredientsService
                                .findLocalRecipesThatAreDependentOnThisLocalRecipe(updatedData.getRecipeId());
                for (LocalRecipeIngredientsDTO item : results) {
                    affectedRecipes.add(item.getRecipeId());
                    System.out.println("recipe ID = " + updatedData.getRecipeId() + " has a parent recipe --> " +
                            item.getRecipeId());
                    LocalRecipes dto = findBasicRecipeInfoByRecipeId(item.getRecipeId());
                    updateParentLocalRecipeRecords(dto, affectedRecipes);
                }
                /**
                 * we will NOT be updating ALL daily_diet_totals records , because that could end up bogging down
                 * the system, however, we do want to update thee daily_diet_totals records for any templates
                 * that contain this recipe and/or any parent recipes
                 */
                /**
                 * update any templates
                 * 0. I need the recipe_id for the recipe
                 * 1. have to check the daily_diet table for any records for this user that have this recipe_id:
                 * select distinct(calendar_date) from daily_diet where
                 * ingr_id = recipe_id and is_recipe = true and is_local = true and user_id = X
                 *
                 * for each of these:
                 * 2. call dailyDietService.getDailyDietForDate
                 * 3. use the List<DailyDietDisplayRecord> ingredients and call
                 *      dailyDietService.createDailyTotalsRecords
                 */
                List<DailyDiet> totalRecords = new ArrayList();
                Map<Integer,Set<Date>> processedTemplates = new HashMap();
                for(int item : affectedRecipes) {
                    List<DailyDiet> dailyDietRecordsAffectedByLocalRecipe =
                            dailyDietService.findDailyDietRecordsWithLocalRecipeId(item);
                    totalRecords.addAll(dailyDietRecordsAffectedByLocalRecipe);
                }
                for(DailyDiet record : totalRecords) {
                    // check the template table to see if there is a template for this date
                    if(dietaryTemplatesService
                            .findDietaryTemplatesByUserIdAndCalendarDate(record.getUserId(),
                                    record.getCalendarDate()).size()>0) {
                        if(updateHashMap(record,processedTemplates)) {
                            // if so, recalculate the totals for that date
                            DailyDietRequest request = new DailyDietRequest(record.getUserId(),
                                    record.getCalendarDate());
                            DailyDietWrapper wrapper = dailyDietService.getDailyDietForDate(request);
                            List<DailyDietDisplayRecord> dietaryRecords = wrapper.getIngredients();
                            dailyDietService.createDailyTotalsRecords(dietaryRecords,
                                    record.getCalendarDate(),record.getUserId());
                        }
                    } else {
                        // else, upsert a record in unsynched so that we know that that day's totals for that
                        // user are incorrect now
                        String result = unsyncedService.upSertUnsynced(record.getUserId(),record.getCalendarDate());
                        System.out.println("unsyched record made for user = "
                                + record.getUserId() + " for date = " + record.getCalendarDate());
                    }
                }
            }
            if(data.isFavor()) {
                favoriteRecipesService.upsertFavoriteLocalRecipe(data.getRecipeMetaData().getRecipeId(),
                        data.getUserId());
            }
            return updatedData.toDTO();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeMetaData().getRecipeId() + NOT_FOUND);
        }
    }

    private boolean updateHashMap(DailyDiet record, Map<Integer, Set<Date>> processedTemplates) {
        if(!processedTemplates.containsKey(record.getUserId())) {
            Set<Date> dates = new HashSet();
            dates.add(record.getCalendarDate());
            processedTemplates.put(record.getUserId(), dates);
            return true;
        } else if(!processedTemplates.get(record.getUserId()).contains(record.getCalendarDate())) {
            Set<Date> dates = processedTemplates.get(record.getUserId());
            dates.add(record.getCalendarDate());
            processedTemplates.put(record.getUserId(), dates);
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIfWeNeedToRecursivelyUpdate(LocalIngredientsDTO ingredientRecord, RecipeFormDTO data) throws Exception {
        LocalIngredientsDTO currentRecipeRecord = localIngredientsService
                .findLocalIngredientsById(data.getRecipeMetaData().getIngrId());
        return !areTheyTheSame(ingredientRecord,currentRecipeRecord);
    }

    private boolean areTheyTheSame(LocalIngredientsDTO ingredientRecord, LocalIngredientsDTO currentRecipeRecord) {
        int checksum1 = 1*getIntVal(ingredientRecord.getKcalories()) +
                2*getIntVal(ingredientRecord.getTotFat()) +
                3*getIntVal(ingredientRecord.getSatFat()) +
                5*getIntVal(ingredientRecord.getTransFat()) +
                7*getIntVal(ingredientRecord.getPolyFat()) +
                11*getIntVal(ingredientRecord.getMonoFat()) +
                13*getIntVal(ingredientRecord.getCholes()) +
                17*ingredientRecord.getSodium() +
                19*getIntVal(ingredientRecord.getTotCarbs()) +
                23*getIntVal(ingredientRecord.getTotFiber()) +
                31*getIntVal(ingredientRecord.getTotSugars()) +
                37*getIntVal(ingredientRecord.getTotProtein()) ;
        int checksum2 = 1*getIntVal(currentRecipeRecord.getKcalories()) +
                2*getIntVal(currentRecipeRecord.getTotFat()) +
                3*getIntVal(currentRecipeRecord.getSatFat()) +
                5*getIntVal(currentRecipeRecord.getTransFat()) +
                7*getIntVal(currentRecipeRecord.getPolyFat()) +
                11*getIntVal(currentRecipeRecord.getMonoFat()) +
                13*getIntVal(currentRecipeRecord.getCholes()) +
                17*currentRecipeRecord.getSodium() +
                19*getIntVal(currentRecipeRecord.getTotCarbs()) +
                23*getIntVal(currentRecipeRecord.getTotFiber()) +
                31*getIntVal(currentRecipeRecord.getTotSugars()) +
                37*getIntVal(currentRecipeRecord.getTotProtein()) ;
        return checksum1 == checksum2;
    }

    private int getIntVal(BigDecimal input) {
        return input.multiply(new BigDecimal(100)).intValue();
    }

    /**
     * recursively update any local recipes that may have this recipe as a dependency
     * 1. recalculate the recipe totals from the list of ingredients
     * 2. update the local_ingredients record for that recipe
     * 3. recursively update any local recipes that may have this recipe as a dependency
     * @param recipe
     */
    public void updateParentLocalRecipeRecords(LocalRecipes recipe, List<Integer> affectedRecipes) throws Exception {
        List<RecipeIngredientDisplay> displayList = getRecipeIngredientDisplays(recipe);
        // 1. recalculate the recipe totals from the list of ingredients
        LocalIngredientsDTO ingredientsRecordForRecipe = localIngredientsService
                .findLocalIngredientsById(recipe.getIngrId());
        ingredientsRecordForRecipe = calculateRecipeTotals(recipe, displayList,
                ingredientsRecordForRecipe.getServSz(), ingredientsRecordForRecipe.getServTypeId());
        // 2. update the local_ingredients record for that recipe
        localIngredientsService.updateIngredientRecordForRecipe(ingredientsRecordForRecipe);
        // 3. recursively update any local recipes that may have this recipe as a dependency
        /**
         * TODO - put this chunk into another method
         */
        List<LocalRecipeIngredientsDTO> results =
                localRecipeIngredientsService
                        .findLocalRecipesThatAreDependentOnThisLocalRecipe(recipe.getRecipeId());
        for (LocalRecipeIngredientsDTO item : results) {
            affectedRecipes.add(item.getRecipeId());
			System.out.println("local recipe ID = " + recipe.getRecipeId() + " has a parent local recipe --> " +
					item.getRecipeId());
            LocalRecipes dto = findBasicRecipeInfoByRecipeId(item.getRecipeId());
            updateParentLocalRecipeRecords(dto, affectedRecipes);
        }
    }

    private void updateRecipeIngredientRecords(List<RecipeIngredientDisplay> recipeIngredients, Integer recipeId,
        int userId) throws Exception {
        List<LocalRecipeIngredientsDTO> currentRecipeIngredients =
          localRecipeIngredientsService.findRecipeIngredientsByRecipeId(recipeId);
        Map<Integer, LocalRecipeIngredientsDTO> globalRecipeIngredientsMap = new HashMap();
        Map<Integer, LocalRecipeIngredientsDTO> globalRecipeSubrecipeMap = new HashMap();
        Map<Integer, LocalRecipeIngredientsDTO> localRecipeIngredientsMap = new HashMap();
        Map<Integer, LocalRecipeIngredientsDTO> localRecipeSubrecipeMap = new HashMap();
        currentRecipeIngredients.forEach(rec -> {
            if (rec.getLocalRecpIngr()) {
                if (rec.getRecipeFlg().equals(YES)) {
                    localRecipeSubrecipeMap.put(rec.getRecOrIngrId(), rec);
                } else {
                    localRecipeIngredientsMap.put(rec.getRecOrIngrId(), rec);
                }
            } else {
                if (rec.getRecipeFlg().equals(YES)) {
                    globalRecipeSubrecipeMap.put(rec.getRecOrIngrId(), rec);
                } else {
                    globalRecipeIngredientsMap.put(rec.getRecOrIngrId(), rec);
                }
            }
        });
        for (RecipeIngredientDisplay rec : recipeIngredients) {
            if (rec.isLocal() && rec.isRecipe() && localRecipeSubrecipeMap.containsKey(rec.getIngrId())) {
                LocalRecipeIngredientsDTO dto = localRecipeSubrecipeMap.get(rec.getIngrId());
                dto.setActv("Y");
                dto.setRecipeFlg(YES);
                dto.setLocalRecpIngr(true);
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
                localRecipeSubrecipeMap.remove(rec.getIngrId());
            } else if (rec.isLocal() && !rec.isRecipe() && localRecipeIngredientsMap.containsKey(rec.getIngrId())) {
                LocalRecipeIngredientsDTO dto = localRecipeIngredientsMap.get(rec.getIngrId());
                dto.setActv("Y");
                dto.setRecipeFlg(NO);
                dto.setLocalRecpIngr(true);
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
                localRecipeIngredientsMap.remove(rec.getIngrId());
            } else if (!rec.isLocal() && rec.isRecipe() && globalRecipeSubrecipeMap.containsKey(rec.getIngrId())) {
                LocalRecipeIngredientsDTO dto = globalRecipeSubrecipeMap.get(rec.getIngrId());
                dto.setActv("Y");
                dto.setRecipeFlg(YES);
                dto.setLocalRecpIngr(false);
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
                globalRecipeSubrecipeMap.remove(rec.getIngrId());
            } else if (!rec.isLocal() && !rec.isRecipe() && globalRecipeIngredientsMap.containsKey(rec.getIngrId())) {
                LocalRecipeIngredientsDTO dto = globalRecipeIngredientsMap.get(rec.getIngrId());
                dto.setActv("Y");
                dto.setRecipeFlg(NO);
                dto.setLocalRecpIngr(false);
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
                globalRecipeIngredientsMap.remove(rec.getIngrId());
            } else {
                LocalRecipeIngredientsDTO dto = new LocalRecipeIngredientsDTO();
                dto.setRecipeId(recipeId);
                dto.setActv("Y");
                dto.setLocalRecpIngr(rec.isLocal());
                dto.setRecipeFlg(rec.isRecipe() == true ? "Y" : "N");
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                dto.setUserId(userId);
                localRecipeIngredientsService.createLocalRecipeIngredients(dto);
            }
        }
        for (Integer key : globalRecipeIngredientsMap.keySet()) {
            LocalRecipeIngredientsDTO dto = globalRecipeIngredientsMap.get(key);
            dto.setActv(NO);
            localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
        }
        for (Integer key : globalRecipeSubrecipeMap.keySet()) {
            LocalRecipeIngredientsDTO dto = globalRecipeSubrecipeMap.get(key);
            dto.setActv(NO);
            localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
        }
        for (Integer key : localRecipeIngredientsMap.keySet()) {
            LocalRecipeIngredientsDTO dto = localRecipeIngredientsMap.get(key);
            dto.setActv(NO);
            localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
        }
        for (Integer key : localRecipeSubrecipeMap.keySet()) {
            LocalRecipeIngredientsDTO dto = localRecipeSubrecipeMap.get(key);
            dto.setActv(NO);
            localRecipeIngredientsService.updateLocalRecipeIngredients(dto);
        }
    }

    private void updateRecipeSpiceRecords(List<RecipeSpiceDisplay> recipeSpices, Integer recipeId, int userId) throws Exception {
        List<LocalRecipeSpicesDTO> currentRecipeSpices = localRecipeSpicesService.findLocalRecipeSpicesByRecipeId(recipeId);
        Map<Integer, LocalRecipeSpicesDTO> globalRecipeSpicesMap = new HashMap();
        Map<Integer, LocalRecipeSpicesDTO> localRecipeSpicesMap = new HashMap();
        currentRecipeSpices.forEach(rec -> {
            if (rec.getIsLocal()) {
                localRecipeSpicesMap.put(rec.getSpiceId(), rec);
            } else {
                globalRecipeSpicesMap.put(rec.getSpiceId(), rec);
            }
        });
        for (RecipeSpiceDisplay rec : recipeSpices) {
            if (rec.isLocal() && localRecipeSpicesMap.containsKey(rec.getSpiceId())) {
                LocalRecipeSpicesDTO dto = localRecipeSpicesMap.get(rec.getSpiceId());
                dto.setActv("Y");
                dto.setIsLocal(true);
                dto.setSpiceId(rec.getSpiceId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                localRecipeSpicesService.updateLocalRecipeSpices(dto);
                localRecipeSpicesMap.remove(rec.getSpiceId());
            } else if (!rec.isLocal() &&  globalRecipeSpicesMap.containsKey(rec.getSpiceId())) {
                LocalRecipeSpicesDTO dto = globalRecipeSpicesMap.get(rec.getSpiceId());
                dto.setActv("Y");
                dto.setIsLocal(false);
                dto.setSpiceId(rec.getSpiceId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                localRecipeSpicesService.updateLocalRecipeSpices(dto);
                globalRecipeSpicesMap.remove(rec.getSpiceId());
            } else {
                LocalRecipeSpicesDTO dto = new LocalRecipeSpicesDTO();
                dto.setRecipeId(recipeId);
                dto.setActv("Y");
                dto.setSpiceId(rec.getSpiceId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                dto.setUserId(userId);
                localRecipeSpicesService.createLocalRecipeSpices(dto);
            }
        }
        for (Integer key : globalRecipeSpicesMap.keySet()) {
            LocalRecipeSpicesDTO dto = globalRecipeSpicesMap.get(key);
            dto.setActv(NO);
            localRecipeSpicesService.updateLocalRecipeSpices(dto);
        }
        for (Integer key : localRecipeSpicesMap.keySet()) {
            LocalRecipeSpicesDTO dto = localRecipeSpicesMap.get(key);
            dto.setActv(NO);
            localRecipeSpicesService.updateLocalRecipeSpices(dto);
        }
    }

    /**
     * TODO - expand this feature to include multiple steps
     * for NOW, we are assuming that all of the recipe's instructions are contained within a single step
     * so, we retrieve the current steps
     * - if there aren't any, we make a new step
     * - otherwise, we just get the first record and overwrite the instructions
     * also, I'm going to make an assumption here that you are not going to have instructions for a recipe
     * initially, and then later delete all instructions
     * @param recipeSteps
     * @param recipeId
     * @param userId
     * @throws Exception
     */
    private void updateRecipeStepRecords(List<RecipeStepsDisplay> recipeSteps, Integer recipeId, int userId) throws Exception {
        List<LocalRecipeStepsDTO> currentRecords = localRecipeStepsService.findLocalRecipeStepsByRecipeId(recipeId);
        if(currentRecords!=null&&!currentRecords.isEmpty()&&recipeSteps!=null&&!recipeSteps.isEmpty()) {
            LocalRecipeStepsDTO record = currentRecords.get(0);
            record.setStepDesc(recipeSteps.get(0).getStepDescription());
            localRecipeStepsService.updateLocalRecipeSteps(record);
        } else if(recipeSteps!=null&&!recipeSteps.isEmpty()) {
            // assuming maybe they wanted to make the recipe first and then add instructions later
            createRecipeStepRecords(recipeSteps,recipeId,userId);
        }
    }
    /**
     * delete a LocalRecipes by primary key
     *
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteLocalRecipes(int id, int userId) throws Exception {
        Optional<LocalRecipes> localrecipesOptional = localRecipesRepository.findById(id);
        if (localrecipesOptional.isPresent()) {
            checkForDependencies(id, userId);
            LocalRecipes recipe = localrecipesOptional.get();
            recipe.setActv(NO);
            int numRecordsChanged = localRecipeIngredientsService.deleteRecipeIngredientsForaLocalRecipe(id, userId);
            System.out.println(" number of local recipe_ingredient records changed = " + numRecordsChanged);
            numRecordsChanged = localRecipeSpicesService.deleteRecipeSpicesForaLocalRecipe(id, userId);
            System.out.println(" number of local recipe_spice records changed = " + numRecordsChanged);
            numRecordsChanged = localRecipeStepsService.deleteRecipeStepsForaLocalRecipe(id);
            System.out.println(" number of local recipe_step records changed = " + numRecordsChanged);
            localIngredientsService.deleteLocalIngredientRecordForRecipe(recipe.getIngrId(), recipe.getUserId());
            localRecipesRepository.save(recipe);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    private void checkForDependencies(int id, int userId) throws Exception {
        if (checkForFavoriteDependencies(id, userId)) {
            throw new DependencyExistsException("A Favorite(s) has been found for this Recipe. " +
                    "Delete these Favorites before deleting this Recipe.");
        }
        if (checkForParentDependencies(id)) {
            throw new DependencyExistsException("A recipe(s) has been found the depends on this Recipe. Delete these " +
                    "dependencies before deleting this Recipe.");
        }
        if(checkForDailyDietDependencies(id)) {
            throw new DependencyExistsException("A daily diet entry has been found for this Recipe. " +
                    "Delete these daily diet entry(s) " +
                    "before deleting this Recipe.");
        }
    }

    private boolean checkForParentDependencies(int id) throws Exception {
        List<LocalRecipeIngredientsDTO> results =
                localRecipeIngredientsService
                        .findLocalRecipesThatAreDependentOnThisLocalRecipe(id);
        if(null!=results&&results.size()>0) {
            return true;
        }
        return false;
    }

    private boolean checkForFavoriteDependencies(int id, Integer userId) {
        return favoriteRecipesService.checkForFavoriteDependencies(id, userId, true);
    }

    private boolean checkForDailyDietDependencies(int id) throws Exception {
        List<DailyDiet> dates =  dailyDietService.findDailyDietRecordsWithLocalRecipeId(id);
        if(dates.size()>0) {
            return true;
        }
        return false;
    }

    public RecipeIngredientDisplay getRecipeDisplayById(int id) throws Exception {
        LocalRecipes recipeItem = findBasicRecipeInfoByRecipeId(id);
        LocalIngredientsDTO ingredientInfo = localIngredientsService.findLocalIngredientsById(recipeItem.getIngrId());
        RecipeIngredientDisplay displayInfo = convertToDisplayDTO(recipeItem, ingredientInfo);
        return displayInfo;
    }

    private RecipeIngredientDisplay convertToDisplayDTO(LocalRecipes recipeItem, LocalIngredientsDTO ingredientInfo) {
        RecipeIngredientDisplay display = new RecipeIngredientDisplay(recipeItem.getRecipeId(),
                recipeItem.getRecipeName(), true, true, ingredientInfo.getServSz(),
                ingredientInfo.getServTypeId(), null, null, ingredientInfo.returnGlobalDTO());
        display.setMultiplier(calculateM1(display.getServUnitId(),ingredientInfo.returnGlobalDTO()));
        return display;
    }

    public BigDecimal findM1(RecipeIngredientDisplay data) throws Exception {
        LocalRecipes recipeItem = findBasicRecipeInfoByRecipeId(data.getIngrId());
        LocalIngredientsDTO ingredientInfo = localIngredientsService.findLocalIngredientsById(recipeItem.getIngrId());
        return calculateM1(data.getServUnitId(),ingredientInfo.returnGlobalDTO());
    }
}
