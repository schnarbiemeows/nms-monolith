package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDisplayRecord;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietRequest;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalRecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ServingRatioNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteRecipesRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipesRepository;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.*;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 *
 * @author Dylan I. Kessler
 */
@Service
public class RecipesService {

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
    /**
     * JPA Repository handle
     */
    @Autowired
    private RecipesRepository globalRecipesRepository;

    @Autowired
    private LocalRecipesService localRecipesService;

    @Autowired
    RecipeStepsService recipeStepsService;

    @Autowired
    private FavoriteRecipesRepository favoriteRecipesRepository;

    @Autowired
    private FavoriteRecipesService favoriteRecipesService;

    @Autowired
    SpicesService spicesService;

    @Autowired
    RecipeCalculatorUtility recipeCalculatorUtility;

    @Autowired
    IngredientsService ingredientsService;

    @Autowired
    RecipeIngredientsService recipeIngredientsService;

    @Autowired
    RecipeSpicesService recipeSpicesService;

    @Autowired
    LocalRecipeIngredientsService localRecipeIngredientsService;

    @Autowired
    ServingTypesService servingTypesService;

    @Autowired
    private DailyDietService dailyDietService;

    @Autowired
    private DietaryTemplatesService dietaryTemplatesService;

    @Autowired
    private UnsyncedService unsyncedService;

    /**
     * get all Recipes records
     *
     * @return
     * @throws Exception
     */
    public List<RecipesDTO> getAllRecipes() throws Exception {
        Iterable<Recipes> recipes = globalRecipesRepository.findAll();
        Iterator<Recipes> recipesItems = recipes.iterator();
        List<RecipesDTO> recipesdto = new ArrayList();
        while (recipesItems.hasNext()) {
            Recipes item = recipesItems.next();
            recipesdto.add(item.toDTO());
        }
        return recipesdto;
    }

    /**
     * get all Recipes records
     *
     * @return
     * @throws Exception
     */
    public List<RecipesDTO> findAllActiveRecipes() throws Exception {
        Iterable<Recipes> recipes = globalRecipesRepository.findAllActiveRecipes();
        Iterator<Recipes> recipesItems = recipes.iterator();
        List<RecipesDTO> recipesdto = new ArrayList();
        while (recipesItems.hasNext()) {
            Recipes item = recipesItems.next();
            recipesdto.add(item.toDTO());
        }
        return recipesdto;
    }

    public List<RecipesDTO> findAllRecipesRanked(String rankBy) throws Exception {
        Iterable<Recipes> recipes = null;
        if(rankBy.equals(MacroType.tot_protein.getValue())) {
            recipes = globalRecipesRepository
                    .findRecipesByProtein();
        } else if(rankBy.equals(MacroType.tot_fat.getValue())) {
            recipes = globalRecipesRepository
                    .findRecipesByFats();
        } else if(rankBy.equals(MacroType.mono_fat.getValue())) {
            recipes = globalRecipesRepository
                    .findRecipesByMonoFats();
        } else if(rankBy.equals(MacroType.tot_carbs.getValue())) {
            recipes = globalRecipesRepository
                    .findRecipesByCarbs();
        } else if(rankBy.equals(MacroType.tot_fiber.getValue())) {
            recipes = globalRecipesRepository
                    .findRecipesByFiber();
        }
        Iterator<Recipes> recipesItems = recipes.iterator();
        List<RecipesDTO> recipesdto = new ArrayList();
        while (recipesItems.hasNext()) {
            Recipes item = recipesItems.next();
            recipesdto.add(item.toDTO());
        }
        return recipesdto;
    }

    public RecipeWrapper getAllRecipeDisplays(int userId) throws Exception {
        List<RecipesDTO> globals = findAllActiveRecipes();
        List<RecipeRecordDisplay> globalDisplays = new ArrayList();
        for (RecipesDTO item : globals) {
            globalDisplays.add(item.toDisplayObject());
        }
        List<LocalRecipesDTO> locals = localRecipesService.getAllLocalRecipes(userId);
        List<RecipeRecordDisplay> localDisplays = new ArrayList();
        for (LocalRecipesDTO item : locals) {
            localDisplays.add(item.toDisplayObject());
        }
        List<FavoriteRecipesDTO> favorites = getFavoriteRecipes(userId);
        return new RecipeWrapper(globalDisplays, localDisplays, favorites);
    }

    public RecipeWrapper getRecipesByRanking(int userId, String rankBy) throws Exception {
        if(MacroType.rankByInEnums(rankBy)) {
            List<RecipesDTO> globals = findAllRecipesRanked(rankBy);
            List<RecipeRecordDisplay> globalDisplays = new ArrayList();
            for (RecipesDTO item : globals) {
                globalDisplays.add(item.toDisplayObject());
            }
            List<LocalRecipesDTO> locals = localRecipesService.getAllLocalRecipesRanked(userId, rankBy);
            List<RecipeRecordDisplay> localDisplays = new ArrayList();
            for (LocalRecipesDTO item : locals) {
                localDisplays.add(item.toDisplayObject());
            }
            List<FavoriteRecipesDTO> favorites = getFavoriteRecipes(userId);
            return new RecipeWrapper(globalDisplays, localDisplays, favorites);
        } else {
            throw new Exception("invalid ranking type");
        }
    }

    /**
     * get all of the favorite ingredients for a user
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<FavoriteRecipesDTO> getFavoriteRecipes(int userId) throws Exception {
        Iterable<FavoriteRecipes> recipes = favoriteRecipesRepository.findFavoriteRecipesByUserId(userId);
        Iterator<FavoriteRecipes> recipesIterator = recipes.iterator();
        List<FavoriteRecipesDTO> recipesDTOS = new ArrayList();
        while (recipesIterator.hasNext()) {
            FavoriteRecipes item = recipesIterator.next();
            recipesDTOS.add(item.toDTO());
        }
        return recipesDTOS;
    }

    /**
     * get Recipes by primary key
     *
     * @param id
     * @return
     * @throws Exception
     */
    public RecipeFormDTO findRecipesById(int id) throws Exception {
        RecipeFormDTO recipeRecordAndIngredientDisplayList = new RecipeFormDTO();
        recipeRecordAndIngredientDisplayList.setLocal(false);
        Optional<Recipes> recipesOptional = globalRecipesRepository.findById(id);
        if (recipesOptional.isPresent()) {
            Recipes results = recipesOptional.get();
            recipeRecordAndIngredientDisplayList.setRecipeMetaData(results.toDTO());
            IngredientsDTO ingredientRecordForRecipe = ingredientsService.findIngredientsById(results.getIngrId());
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

    private List<RecipeIngredientDisplay> getRecipeIngredientDisplays(
            Recipes results) throws Exception {
        List<RecipeIngredientsDTO> ingredientList = recipeIngredientsService
                .findRecipeIngredientsByRecipeId(results.getRecipeId());
        List<RecipeIngredientDisplay> displayList = new ArrayList();
        for (RecipeIngredientsDTO rec : ingredientList) {
            RecipeIngredientDisplay item = new RecipeIngredientDisplay(rec.getRecOrIngrId(),
                    null, false, rec.getRecipeFlg().equals(YES) ? true : false, rec.getServSz(),
                    rec.getServTypeId(), null, null, null);
            ServingTypesDTO servingType = servingTypesService.findServingTypesById(rec.getServTypeId());
            item.setServUnitDesc(servingType.getServTypeCde());
            if (item.isRecipe()) {
                Optional<Recipes> recipe = globalRecipesRepository.findById(rec.getRecOrIngrId());
                item.setDescription(recipe.get().getRecipeName());
                IngredientsDTO ingredient = ingredientsService.findIngredientsById(recipe.get().getIngrId());
                item.setNutritionalData(ingredient);
                item.setMultiplier(calculateM1(item,ingredient));
            } else {
                IngredientsDTO ingredient = ingredientsService.findIngredientsById(rec.getRecOrIngrId());
                item.setDescription(ingredient.getIngrDesc());
                item.setNutritionalData(ingredient);
                item.setMultiplier(calculateM1(item,ingredient));
            }
            displayList.add(item);
        }
        return displayList;
    }

    private List<RecipeSpiceDisplay> getRecipeSpiceDisplays(Recipes results) throws Exception {
        List<RecipeSpicesDTO> spicesList = recipeSpicesService
                .findRecipeSpicesByRecipeId(results.getRecipeId());
        List<RecipeSpiceDisplay> displayList = new ArrayList();
        for (RecipeSpicesDTO rec : spicesList) {
            RecipeSpiceDisplay item = new RecipeSpiceDisplay(rec.getSpiceId(),
                    null, false,
                    rec.getServSz(), rec.getServTypeId(), null);
            ServingTypesDTO servingType = servingTypesService.findServingTypesById(rec.getServTypeId());
            item.setServUnitDesc(servingType.getServTypeCde());

            SpicesDTO spice = spicesService.findSpicesById(rec.getSpiceId());
            item.setDescription(spice.getSpiceName());
            displayList.add(item);
        }
        return displayList;
    }


    private List<RecipeStepsDisplay> getRecipeStepDisplays(Recipes results) throws Exception {
        List<RecipeStepsDTO> stepsList = recipeStepsService
                .findRecipeStepsByRecipeId(results.getRecipeId());
        List<RecipeStepsDisplay> displayList = new ArrayList();
        for (RecipeStepsDTO rec : stepsList) {
            RecipeStepsDisplay item = new RecipeStepsDisplay(rec.getStepDesc());
            displayList.add(item);
        }
        return displayList;
    }
    public Recipes findBasicRecipeInfoByRecipeId(int id) throws Exception {
        Optional<Recipes> recipesOptional = globalRecipesRepository.findById(id);
        if (recipesOptional.isPresent()) {
            return recipesOptional.get();
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    /**
     * create a new Recipe
     *
     * @param data
     * @return
     */
    public RecipesDTO createRecipe(RecipeFormDTO data) throws Exception {
        Recipes createdData = data.getRecipeMetaData().toEntity();
        List<RecipeIngredientDisplay> recipeIngredients = data.getRecipeIngredients();
        // first calculate the recipe totals
        IngredientsDTO ingredientRecord = calculateRecipeTotals(createdData, recipeIngredients,
                data.getServingTypeId(), data.getServingSize());
        // make the recipe record and ingredients record
        IngredientsDTO ingredientRecordForRecipe = ingredientsService.createIngredients(ingredientRecord);
        createdData.setIngrId(ingredientRecordForRecipe.getIngrId());
        createdData = globalRecipesRepository.save(createdData);
        // make the recipe_ingredient records
        createRecipeIngredientRecords(recipeIngredients, createdData.getRecipeId());
        // make the recipe_spice records
        createRecipeSpiceRecords(data.getRecipeSpices(),createdData.getRecipeId());
        // make the recipe_step records
        createRecipeStepRecords(data.getRecipeSteps(), createdData.getRecipeId());
        if(data.isFavor()) {
            favoriteRecipesService.upsertFavoriteGlobalRecipe(createdData.getRecipeId(),
                    data.getUserId());
        }
        return createdData.toDTO();
    }



    /**
     * update a Recipe
     * if the nutritional information gets updated, then we have to:
     * 1. recalculate the recipe totals from the list of ingredients
     * 2. update the ingredients record for that recipe
     * 3. update the recipe record
     * 4. add/update/delete recipe_ingredients records
     * 5. recursively update any global and local recipes that may have this recipe as a dependency
     *
     * @param data
     * @return
     * @throws Exception
     */
    public RecipesDTO updateRecipe(RecipeFormDTO data) throws Exception {
        Optional<Recipes> recipesOptional = globalRecipesRepository.findById(data.getRecipeMetaData().getRecipeId());
        if (recipesOptional.isPresent()) {
            if (NO.equals(data.getRecipeMetaData().getActv())) {
                checkForDependencies(data.getRecipeMetaData().getRecipeId());
                /**
                 * TODO - if the recipe's actv is set to NO, then I am effectively deleting it
                 * so I would want to do what is in the delete() method instead of what I am doing below
                 * we won't mess with this for now on account of the active flag will not be showing on the
                 * edit recipe form
                 * remember, I would need to also delete the ingredient record and the recipe_ingredient records
                 *
                 */
            }
            Recipes updatedData = data.getRecipeMetaData().toEntity();
            // 1. recalculate the recipe totals from the list of ingredients
            List<RecipeIngredientDisplay> recipeIngredients = data.getRecipeIngredients();
            IngredientsDTO ingredientRecord = calculateRecipeTotals(updatedData, recipeIngredients,
                    data.getServingTypeId(), data.getServingSize());
            boolean haveToUpdate = checkIfWeNeedToRecursivelyUpdate(ingredientRecord,data);
            // 2. update the ingredients record for that recipe
            IngredientsDTO ingredientRecordForRecipe = ingredientsService.updateIngredientRecordForRecipe(ingredientRecord);
            // 3. update the recipe record
            updatedData = globalRecipesRepository.save(updatedData);
            // 4. add/update/delete recipe_ingredients records
            updateRecipeIngredientRecords(recipeIngredients, updatedData.getRecipeId());
            // 4. add/update/delete recipe_spice records
            updateRecipeSpiceRecords(data.getRecipeSpices(),updatedData.getRecipeId());
            // 4. add/update recipe_step records
            updateRecipeStepRecords(data.getRecipeSteps(),updatedData.getRecipeId());
            // 5. recursively update any recipes that may have this recipe as a dependency
            if(haveToUpdate) {
                List<Integer> affectedLocalRecipes = new ArrayList();
                List<Integer> affectedGlobalRecipes = new ArrayList();
                /**
                 * 5. recursively update any global recipes that may have this recipe as a dependency
                 */
                affectedGlobalRecipes.add(updatedData.getRecipeId());
                List<RecipeIngredientsDTO> results =
                        recipeIngredientsService
                                .findParentRecipeIngredientsForaGlobalRecipe(updatedData.getRecipeId());
                for (RecipeIngredientsDTO item : results) {
                    System.out.println("recipe ID = " + updatedData.getRecipeId() + " has a parent recipe --> " +
                            item.getRecipeId());
                    affectedGlobalRecipes.add(item.getRecipeId());
                    Recipes dto = findBasicRecipeInfoByRecipeId(item.getRecipeId());
                    updateParentGlobalRecipeRecords(dto,affectedGlobalRecipes,affectedLocalRecipes);
                }
                /**
                 * 5. recursively update any local recipes that may have this recipe as a dependency
                 */
                List<LocalRecipeIngredientsDTO> localResults =
                        localRecipeIngredientsService
                                .findLocalRecipesThatAreDependentUponGivenGlobalRecipe(updatedData.getRecipeId());
                for (LocalRecipeIngredientsDTO item : localResults) {
                    System.out.println("global recipe ID = " + updatedData.getRecipeId() +
                            " has a parent local recipe " + "--> " + item.getRecipeId());
                    affectedLocalRecipes.add(item.getRecipeId());
                    LocalRecipes dto = localRecipesService.findBasicRecipeInfoByRecipeId(item.getRecipeId());
                    localRecipesService.updateParentLocalRecipeRecords(dto,affectedLocalRecipes);
                }
                List<DailyDiet> totalRecords = new ArrayList();
                Map<Integer,Set<Date>> processedTemplates = new HashMap();
                for(int item : affectedGlobalRecipes) {
                    List<DailyDiet> dailyDietRecordsAffectedByGlobalRecipe =
                            dailyDietService.findDailyDietRecordsWithGlobalRecipeId(item);
                    totalRecords.addAll(dailyDietRecordsAffectedByGlobalRecipe);
                }
                for(int item : affectedLocalRecipes) {
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
                            DailyDietRequest request = new DailyDietRequest(record.getUserId(),
                                    record.getCalendarDate());
                            DailyDietWrapper wrapper = dailyDietService.getDailyDietForDate(request);
                            List<DailyDietDisplayRecord> dietaryRecords = wrapper.getIngredients();
                            dailyDietService.createDailyTotalsRecords(dietaryRecords,
                                    record.getCalendarDate(),record.getUserId());
                        }
                        // if so, recalculate the totals for that date
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
                favoriteRecipesService.upsertFavoriteGlobalRecipe(data.getRecipeMetaData().getRecipeId(),
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

    private boolean checkIfWeNeedToRecursivelyUpdate(IngredientsDTO ingredientRecord, RecipeFormDTO data) throws Exception {
        /*IngredientsDTO currentRecipeRecord = ingredientsService
                .findIngredientsById(data.getRecipeMetaData().getIngrId());
        return !areTheyTheSame(ingredientRecord,currentRecipeRecord);*/
        return false;
    }

    private boolean areTheyTheSame(IngredientsDTO ingredientRecord, IngredientsDTO currentRecipeRecord) {
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

    public void updateParentGlobalRecipeRecords(Recipes recipe, List<Integer> affectedGlobalRecipes,
        List<Integer> affectedLocalRecipes) throws Exception {
        /**
         * update GLOBAL
         */
        List<RecipeIngredientDisplay> displayList = getRecipeIngredientDisplays(recipe);
        IngredientsDTO ingredientsRecordForRecipe = ingredientsService
                .findIngredientsById(recipe.getIngrId());
        ingredientsRecordForRecipe = calculateRecipeTotals(recipe, displayList,
                ingredientsRecordForRecipe.getServTypeId(), ingredientsRecordForRecipe.getServSz());
        ingredientsService.updateIngredientRecordForRecipe(ingredientsRecordForRecipe);
        List<RecipeIngredientsDTO> results =
                recipeIngredientsService.findParentRecipeIngredientsForaGlobalRecipe(recipe.getRecipeId());
        for (RecipeIngredientsDTO item : results) {
            System.out.println("global recipe ID = " + recipe.getRecipeId() + " has a parent global recipe --> " +
                    item.getRecipeId());
            affectedGlobalRecipes.add(item.getRecipeId());
            Recipes dto = findBasicRecipeInfoByRecipeId(item.getRecipeId());
            updateParentGlobalRecipeRecords(dto, affectedGlobalRecipes,affectedLocalRecipes);
        }
        /**
         * update LOCAL
         */
        List<LocalRecipeIngredientsDTO> localResults =
                localRecipeIngredientsService
                        .findLocalRecipesThatAreDependentUponGivenGlobalRecipe(recipe.getRecipeId());
        for (LocalRecipeIngredientsDTO item : localResults) {
            System.out.println("global recipe ID = " + recipe.getRecipeId() + " has a parent local recipe --> " +
                    item.getRecipeId());
            affectedLocalRecipes.add(item.getRecipeId());
            LocalRecipes dto = localRecipesService.findBasicRecipeInfoByRecipeId(item.getRecipeId());
            localRecipesService.updateParentLocalRecipeRecords(dto, affectedLocalRecipes);
        }
    }

    /**
     * delete a Recipes by primary key
     *
     * @param id
     * @return
     * @throws Exception
     */
    public String deleteRecipe(int id) throws Exception {
        Optional<Recipes> recipesOptional = globalRecipesRepository.findById(id);
        if (recipesOptional.isPresent()) {
            checkForDependencies(id);
            Recipes recipe = recipesOptional.get();
            recipe.setActv(NO);
            int numRecordsChanged = recipeIngredientsService.deleteRecipeIngredientsForaGlobalRecipe(id);
            System.out.println(" number of global recipe_ingredient records changed = " + numRecordsChanged);
            numRecordsChanged = recipeSpicesService.deleteRecipeSpicesForaGlobalRecipe(id);
            System.out.println(" number of global recipe_spice records changed = " + numRecordsChanged);
            numRecordsChanged = recipeStepsService.deleteRecipeStepsForaGlobalRecipe(id);
            System.out.println(" number of global recipe_step records changed = " + numRecordsChanged);
            ingredientsService.deleteIngredientRecordForRecipe(recipe.getIngrId());
            globalRecipesRepository.save(recipe);
            return "Successfully Deleted";
        } else {
            throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
        }
    }

    private void checkForDependencies(int id) throws Exception {
        if (checkForFavoriteDependencies(id, null)) {
            throw new DependencyExistsException("A Favorite(s) has been found for this Recipe. " +
					"Delete these Favorites before deleting this Recipe.");
        }
        if (checkForParentDependencies(id)) {
            throw new DependencyExistsException("A recipe(s) has been found that depends on this Recipe. " +
					"Delete these dependencies before deleting this Recipe.");
        }
        if(checkForDailyDietDependencies(id)) {
            throw new DependencyExistsException("A daily diet entry has been found for this Recipe. " +
                    "Delete these daily diet entry(s) " +
                    "before deleting this Recipe.");
        }
    }

	private boolean checkForParentDependencies(int id) {
		List<RecipeIngredientsDTO> results =
				recipeIngredientsService.findParentRecipeIngredientsForaGlobalRecipe(id);
		if(null!=results&&results.size()>0) return true;
        List<LocalRecipeIngredientsDTO> resultsLocal =
                localRecipeIngredientsService.findLocalRecipesThatAreDependentUponGivenGlobalRecipe(id);
        if(null!=resultsLocal&&resultsLocal.size()>0) return true;
		return false;
	}

	private boolean checkForFavoriteDependencies(int id, Integer userId) {
        return favoriteRecipesService.checkForFavoriteDependencies(id, userId, false);
    }

    private boolean checkForDailyDietDependencies(int id) throws Exception {
        List<DailyDiet> dailyDietList =  dailyDietService.findDailyDietRecordsWithGlobalRecipeId(id);
        if(dailyDietList.size()>0) {
            return true;
        }
        return false;
    }

    private void createRecipeIngredientRecords(List<RecipeIngredientDisplay> recipeIngredients, Integer recipeId) {
        recipeIngredients.forEach(rec -> {
            RecipeIngredientsDTO dto = new RecipeIngredientsDTO();
            dto.setRecipeId(recipeId);
            dto.setActv("Y");
            dto.setRecipeFlg(rec.isRecipe() == true ? "Y" : "N");
            dto.setRecOrIngrId(rec.getIngrId());
            dto.setServSz(rec.getServSz());
            dto.setServTypeId(rec.getServUnitId());
            recipeIngredientsService.createRecipeIngredients(dto);
        });
    }

    private void createRecipeSpiceRecords(List<RecipeSpiceDisplay> receipeSpices, Integer recipeId) {
        receipeSpices.forEach(rec -> {
            RecipeSpicesDTO dto = new RecipeSpicesDTO();
            dto.setActv("Y");
            dto.setSpiceId(rec.getSpiceId());
            dto.setRecipeId(recipeId);
            dto.setServSz(rec.getServSz());
            dto.setServTypeId(rec.getServUnitId());
            recipeSpicesService.createRecipeSpices(dto);
        });
    }

    private void createRecipeStepRecords(List<RecipeStepsDisplay> recipeSteps, Integer recipeId) {
        int counter = 1;
        for(RecipeStepsDisplay step: recipeSteps) {
            RecipeStepsDTO dto = new RecipeStepsDTO();
            dto.setStepDesc(step.getStepDescription());
            dto.setRecipeId(recipeId);
            dto.setStepNum(counter++);
            dto.setActv("Y");
            recipeStepsService.createRecipeSteps(dto);
        }
    }

    private void updateRecipeIngredientRecords(List<RecipeIngredientDisplay> recipeIngredients, Integer recipeId) throws Exception {
        List<RecipeIngredientsDTO> currentRecipeIngredients = recipeIngredientsService.findRecipeIngredientsByRecipeId(recipeId);
        Map<Integer, RecipeIngredientsDTO> recipeIngredientsMap = new HashMap();
        Map<Integer, RecipeIngredientsDTO> recipeSubrecipeMap = new HashMap();
        currentRecipeIngredients.forEach(rec -> {
            if (rec.getRecipeFlg().equals(YES)) {
                recipeSubrecipeMap.put(rec.getRecOrIngrId(), rec);
            } else {
                recipeIngredientsMap.put(rec.getRecOrIngrId(), rec);
            }
        });
        for (RecipeIngredientDisplay rec : recipeIngredients) {
            if (rec.isRecipe() == true && recipeSubrecipeMap.containsKey(rec.getIngrId())) {
                RecipeIngredientsDTO dto = recipeSubrecipeMap.get(rec.getIngrId());
                dto.setActv("Y");
                dto.setRecipeFlg(YES);
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                recipeIngredientsService.updateRecipeIngredients(dto);
                recipeSubrecipeMap.remove(rec.getIngrId());
            } else if (recipeIngredientsMap.containsKey(rec.getIngrId())) {
                RecipeIngredientsDTO dto = recipeIngredientsMap.get(rec.getIngrId());
                dto.setActv("Y");
                dto.setRecipeFlg(NO);
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                recipeIngredientsService.updateRecipeIngredients(dto);
                recipeIngredientsMap.remove(rec.getIngrId());
            } else {
                RecipeIngredientsDTO dto = new RecipeIngredientsDTO();
                dto.setRecipeId(recipeId);
                dto.setActv("Y");
                dto.setRecipeFlg(rec.isRecipe() == true ? "Y" : "N");
                dto.setRecOrIngrId(rec.getIngrId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                recipeIngredientsService.createRecipeIngredients(dto);
            }
        }
        for (Integer key : recipeIngredientsMap.keySet()) {
            RecipeIngredientsDTO dto = recipeIngredientsMap.get(key);
            dto.setActv(NO);
            recipeIngredientsService.updateRecipeIngredients(dto);
        }
        for (Integer key : recipeSubrecipeMap.keySet()) {
            RecipeIngredientsDTO dto = recipeSubrecipeMap.get(key);
            dto.setActv(NO);
            recipeIngredientsService.updateRecipeIngredients(dto);
        }
    }

    private void updateRecipeSpiceRecords(List<RecipeSpiceDisplay> recipeSpices, Integer recipeId) throws Exception {
        List<RecipeSpicesDTO> currentRecipeSpices = recipeSpicesService.findRecipeSpicesByRecipeId(recipeId);
        Map<Integer, RecipeSpicesDTO> recipeSpicesMap = new HashMap();
        currentRecipeSpices.forEach(rec -> {
            recipeSpicesMap.put(rec.getSpiceId(), rec);
        });
        for (RecipeSpiceDisplay rec : recipeSpices) {
            if (recipeSpicesMap.containsKey(rec.getSpiceId())) {
                RecipeSpicesDTO dto = recipeSpicesMap.get(rec.getSpiceId());
                dto.setActv("Y");
                dto.setSpiceId(rec.getSpiceId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                recipeSpicesService.updateRecipeSpices(dto);
                recipeSpicesMap.remove(rec.getSpiceId());
            } else {
                RecipeSpicesDTO dto = new RecipeSpicesDTO();
                dto.setRecipeId(recipeId);
                dto.setActv("Y");
                dto.setSpiceId(rec.getSpiceId());
                dto.setServSz(rec.getServSz());
                dto.setServTypeId(rec.getServUnitId());
                recipeSpicesService.createRecipeSpices(dto);
            }
        }
        for (Integer key : recipeSpicesMap.keySet()) {
            RecipeSpicesDTO dto = recipeSpicesMap.get(key);
            dto.setActv(NO);
            recipeSpicesService.updateRecipeSpices(dto);
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
     * @throws Exception
     */
    private void updateRecipeStepRecords(List<RecipeStepsDisplay> recipeSteps, Integer recipeId) throws Exception {
        List<RecipeStepsDTO> currentRecords = recipeStepsService.findRecipeStepsByRecipeId(recipeId);
        if(currentRecords!=null&&!currentRecords.isEmpty()&&recipeSteps!=null&&!recipeSteps.isEmpty()) {
            RecipeStepsDTO record = currentRecords.get(0);
            record.setStepDesc(recipeSteps.get(0).getStepDescription());
            recipeStepsService.updateRecipeSteps(record);
        } else if(recipeSteps!=null&&!recipeSteps.isEmpty()) {
            // assuming maybe they wanted to make the recipe first and then add instructions later
            createRecipeStepRecords(recipeSteps,recipeId);
        }
    }

    private IngredientsDTO calculateRecipeTotals(Recipes createdData,
                                                 List<RecipeIngredientDisplay> recipeIngredients,
                                                 Integer servingTypeId, BigDecimal servingSize) throws Exception {
        IngredientsDTO result = initializeDTO(createdData, servingSize, servingTypeId);
        recipeIngredients.forEach(rec -> {
            BigDecimal m1 = BigDecimal.ONE;
            IngredientsDTO ingredient = null;
            ingredient = getIngredientsDTO(rec);
            m1 = calculateM1(rec, ingredient);
            addToTotals(result, rec, m1, ingredient, createdData.getNumSrv());
        });
        return roundResults(result);
    }

    private IngredientsDTO roundResults(IngredientsDTO result) {
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
    private BigDecimal calculateM1(RecipeIngredientDisplay rec, IngredientsDTO ingredient) {
        BigDecimal m1;
        if(rec.getServUnitId()==ingredient.getServTypeId()) {
            m1=BigDecimal.ONE;
        } else if (recipeCalculatorUtility.hasRatio(rec.getServUnitId(), ingredient.getServTypeId())) {
            m1 = recipeCalculatorUtility.getRatio(rec.getServUnitId(), ingredient.getServTypeId());
        } else if (recipeCalculatorUtility.hasFittingRatios(rec.getServUnitId(), ingredient.getServTypeId())) {
            m1 = recipeCalculatorUtility.findFittingRatio(rec.getServUnitId(), ingredient.getServTypeId());
        } else {
            ServingTypesDTO st1 = null;
            ServingTypesDTO st2 = null;
            try {
                st1 = servingTypesService.findServingTypesById(rec.getServUnitId());
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

    private static BigDecimal adder(BigDecimal beginningTotal, BigDecimal recordServingSize,
                                    BigDecimal ingredientServingSize, BigDecimal multiplier,
                                    BigDecimal ingredientTotalPerServing, BigDecimal recipeNumServings) {
        BigDecimal i1 = recordServingSize.divide(ingredientServingSize,2,RoundingMode.HALF_UP)
                .setScale(2,RoundingMode.HALF_UP);
        BigDecimal i2 = i1.multiply(multiplier);
        BigDecimal i3 = i2.multiply(ingredientTotalPerServing);
        BigDecimal i4 = i3.divide(recipeNumServings,2,RoundingMode.HALF_UP)
                .setScale(2,RoundingMode.HALF_UP);
        return beginningTotal.add(i4);
    }
    private static void addToTotals(IngredientsDTO result, RecipeIngredientDisplay rec, BigDecimal m1,
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

    private IngredientsDTO getIngredientsDTO(RecipeIngredientDisplay rec) {
        IngredientsDTO ingredient;
        try {
            int ingrId = rec.getIngrId();
            if(rec.isRecipe()) {
                Recipes recipe = findBasicRecipeInfoByRecipeId(rec.getIngrId());
                ingrId = recipe.getIngrId();
            }
            ingredient = ingredientsService.findIngredientsById(ingrId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ingredient;
    }

    private static IngredientsDTO initializeDTO(Recipes createdData,
                                                BigDecimal servingSize, Integer servingTypeId) {
        IngredientsDTO result = new IngredientsDTO();
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
        return result;
    }


    /**
     * get List<RecipesDTO> by foreign key : ingrId
     *
     * @param id
     * @return List<Recipes>
     * @throws Exception
     */
    public List<RecipesDTO> findRecipesByIngrId(int id) throws Exception {
        Iterable<Recipes> results = globalRecipesRepository.findRecipesByIngrId(id);
        Iterator<Recipes> iter = results.iterator();
        List<RecipesDTO> resultsdto = new ArrayList();
        while (iter.hasNext()) {
            Recipes item = iter.next();
            resultsdto.add(item.toDTO());
        }
        return resultsdto;
    }


    public RecipeIngredientDisplay getRecipeDisplayById(int id) throws Exception {
        Recipes recipeItem = findBasicRecipeInfoByRecipeId(id);
        IngredientsDTO ingredientInfo = ingredientsService.findIngredientsById(recipeItem.getIngrId());
        RecipeIngredientDisplay displayInfo = convertToDisplayDTO(recipeItem, ingredientInfo);
        return displayInfo;
    }

    private RecipeIngredientDisplay convertToDisplayDTO(Recipes recipeItem, IngredientsDTO ingredientInfo) {
        RecipeIngredientDisplay display = new RecipeIngredientDisplay(recipeItem.getRecipeId(),
                recipeItem.getRecipeName(), false, true, ingredientInfo.getServSz(),
                ingredientInfo.getServTypeId(), null, null, ingredientInfo);
        display.setMultiplier(calculateM1(display,ingredientInfo));
        return display;
    }

    public BigDecimal findM1(RecipeIngredientDisplay data) throws Exception {
        Recipes recipeItem = findBasicRecipeInfoByRecipeId(data.getIngrId());
        IngredientsDTO ingredientInfo = ingredientsService.findIngredientsById(recipeItem.getIngrId());
        return calculateM1(data,ingredientInfo);
    }

   /* public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();

    }*/
}
