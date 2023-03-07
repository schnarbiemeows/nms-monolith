package com.schnarbiesnmeowers.nmsmonolith.services;

import java.math.BigDecimal;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDisplayRecord;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietRequest;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeIngredientDisplay;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ServingRatioNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;
import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalIngredientsRepository;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientsRepository;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.INGREDIENT_TYPE_ID_FOR_RECIPE;
import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.NO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class IngredientsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private IngredientsRepository ingredientsRepository;

	@Autowired
	private LocalIngredientsRepository localIngredientsRepository;

	@Autowired
	private FavoriteIngredientsService favoriteIngredientsService;

	@Autowired
	private IngredientTypesRepository ingredientTypeRepository;

	@Autowired
	private RecipeIngredientsService recipeIngredientsService;

	@Autowired
	private RecipesService recipesService;

	@Autowired
	private LocalRecipesService localRecipesService;

	@Autowired
	private LocalRecipeIngredientsService localRecipeIngredientsService;

	@Autowired
	RecipeCalculatorUtility recipeCalculatorUtility;

	@Autowired
	ServingTypesService servingTypesService;

	@Autowired
	DailyDietService dailyDietService;

	@Autowired
	private DietaryTemplatesService dietaryTemplatesService;

	@Autowired
	private UnsyncedService unsyncedService;

	/**
	 * get all Ingredients records
	 * @return
	 * @throws Exception
	 */
	public List<IngredientsDTO> getAllIngredients() throws Exception {
		Iterable<Ingredients> ingredients = ingredientsRepository
				.findAllActiveIngredients(INGREDIENT_TYPE_ID_FOR_RECIPE);
		Iterator<Ingredients> ingredientsIterator = ingredients.iterator();
		List<IngredientsDTO> ingredientsdto = new ArrayList();
		while(ingredientsIterator.hasNext()) {
			Ingredients item = ingredientsIterator.next();
			ingredientsdto.add(item.toDTO());
		}
		return ingredientsdto;
	}

	/**
	 * get all of the ingredient displays for a user, consisting of:
	 * - global ingredient displays
	 * - local ingredient displays for the user
	 * - favorite ingredients for the user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public IngredientsWrapper getAllIngredientDisplays(int userId) throws Exception {
		List<IngredientsDTO> globals = getAllIngredients();
		List<IngredientRecordDisplay> globalDisplays = new ArrayList();
		for(IngredientsDTO item : globals) {
			globalDisplays.add(item.toDisplayObject());
		}
		List<LocalIngredientsDTO> locals = getAllLocalIngredients(userId);
		List<IngredientRecordDisplay> localDisplays = new ArrayList();
		for(LocalIngredientsDTO item : locals) {
			localDisplays.add(item.toDisplayObject());
		}
		List<FavoriteIngredientsDTO> favorites = getFavoriteIngredients(userId);
		Integer recipeIngredientTypeId = ingredientTypeRepository.findTheIngredientTypeForRecipe();
		return new IngredientsWrapper(globalDisplays,localDisplays,favorites,recipeIngredientTypeId);
	}

	/**
	 * get all the local ingredients for a given user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<LocalIngredientsDTO> getAllLocalIngredients(int userId) throws Exception {
		Iterable<LocalIngredients> ingredients = localIngredientsRepository
				.findLocalIngredientsByUserId(userId, INGREDIENT_TYPE_ID_FOR_RECIPE);
		Iterator<LocalIngredients> ingredientsIterator = ingredients.iterator();
		List<LocalIngredientsDTO> ingredientsdto = new ArrayList();
		while(ingredientsIterator.hasNext()) {
			LocalIngredients item = ingredientsIterator.next();
			ingredientsdto.add(item.toDTO());
		}
		return ingredientsdto;
	}

	/**
	 * get all of the favorite ingredients for a user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteIngredientsDTO> getFavoriteIngredients(int userId) throws Exception {
		return favoriteIngredientsService.getFavoriteIngredientsByUserId(userId);
	}

	/**
	 * get Ingredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IngredientsDTO findIngredientsById(int id) throws Exception {
		Optional<Ingredients> ingredientsOptional = ingredientsRepository.findById(id);
		if(ingredientsOptional.isPresent()) {
			Ingredients results = ingredientsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Ingredient
	 * @param data
	 * @return
	 */
	public IngredientsDTO createIngredients(IngredientsDTO data) {
		try {
		    Ingredients createdData = data.toEntity();
		    createdData = ingredientsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	public IngredientsDTO updateIngredientRecordForRecipe(IngredientsDTO data) throws Exception {
		Optional<Ingredients> ingredientsOptional = ingredientsRepository.findById(data.getIngrId());
		if(ingredientsOptional.isPresent()) {
			Ingredients previous = ingredientsOptional.get();
			Ingredients updatedData = data.toEntity();
			updatedData = ingredientsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getIngrId() + NOT_FOUND);
		}
	}
	/**
	 * update an Ingredient
	 * also have to recursively update any local and global recipes that depend upon this ingredient
	 * 1. use the recipe_ingredients table to find any global and local recipes that are dependent upon it
	 * 2. update the recipe(s) recursively
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public IngredientsDTO updateIngredients(IngredientsDTO data) throws Exception {
		Optional<Ingredients> ingredientsOptional = ingredientsRepository.findById(data.getIngrId());
		if(ingredientsOptional.isPresent()) {
			if(NO.equals(data.getActv())) {
				checkForDependencies(data.getIngrId());
			}
			Ingredients previous = ingredientsOptional.get();
		    Ingredients updatedData = data.toEntity();
			boolean haveToUpdate = checkIfWeNeedToRecursivelyUpdate(updatedData.toDTO(),previous.toDTO());
			updatedData = ingredientsRepository.save(updatedData);
			if(haveToUpdate) {
				List<Integer> affectedGlobalRecipes = new ArrayList();
				List<Integer> affectedLocalRecipes = new ArrayList();
				// 1. use the recipe_ingredients table to find any global recipes that are dependent upon it
				List<RecipeIngredientsDTO> results =
						recipeIngredientsService
								.findParentRecipeIngredientsForaGlobalIngredient(data.getIngrId());
				for (RecipeIngredientsDTO item : results) {
					System.out.println("global ingredient ID = " + data.getIngrId() + " has a parent recipe --> " +
							item.getRecipeId());
					affectedGlobalRecipes.add(item.getRecipeId());
					Recipes dto = recipesService.findBasicRecipeInfoByRecipeId(item.getRecipeId());
					// 2. update the recipe(s) recursively
					recipesService.updateParentGlobalRecipeRecords(dto, affectedGlobalRecipes,affectedLocalRecipes);
				}
				// 1. use the recipe_ingredients table to find any local recipes that are dependent upon it
				List<LocalRecipeIngredientsDTO> localResults =
						localRecipeIngredientsService
								.findLocalRecipesThatAreDependentUponGivenGlobalIngredient(data.getIngrId());
				for (LocalRecipeIngredientsDTO item : localResults) {
					System.out.println("local ingredient ID = " + data.getIngrId() + " has a parent local recipe --> " +
							item.getRecipeId());
					affectedLocalRecipes.add(item.getRecipeId());
					LocalRecipes dto = localRecipesService.findBasicRecipeInfoByRecipeId(item.getRecipeId());
					// 2. update the recipe(s) recursively
					localRecipesService.updateParentLocalRecipeRecords(dto, affectedLocalRecipes);
				}
				/**
				 *
 				 */
				List<DailyDiet> totalRecords = new ArrayList();
				List<DailyDiet> globalDailyDietaryRecords = new ArrayList();
				List<DailyDiet> localDailyDietaryRecords = new ArrayList();
				Map<Integer,Set<Date>> processedTemplates = new HashMap();
				List<DailyDiet> dailyDietRecordsAffectedByIngredient =
						dailyDietService.findDailyDietRecordsWithGlobalIngredientId(updatedData.getIngrId());
				totalRecords.addAll(dailyDietRecordsAffectedByIngredient);
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
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getIngrId() + NOT_FOUND);
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

	private boolean checkIfWeNeedToRecursivelyUpdate(IngredientsDTO ingredientRecord,
													 IngredientsDTO currentRecipeRecord) throws Exception {
		return !areTheyTheSame(ingredientRecord,currentRecipeRecord);
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

	/**
	 * delete a Ingredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteIngredients(int id) throws Exception {
		Optional<Ingredients> ingredientsOptional = ingredientsRepository.findById(id);
		if(ingredientsOptional.isPresent()) {
			checkForDependencies(id);
			Ingredients ingredient = ingredientsOptional.get();
			ingredient.setActv(NO);
			ingredientsRepository.save(ingredient);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * delete a Ingredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteIngredientRecordForRecipe(int id) throws Exception {
		Optional<Ingredients> ingredientsOptional = ingredientsRepository.findById(id);
		if(ingredientsOptional.isPresent()) {
			Ingredients ingredient = ingredientsOptional.get();
			ingredient.setActv(NO);
			ingredientsRepository.save(ingredient);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	private void checkForDependencies(int id) throws Exception {
		if(checkForFavoriteDependencies(id, null)) {
			throw new DependencyExistsException("A Favorite(s) has been found for this Ingredient. Delete these " +
					"Favorite(s) before deleting this Ingredient.");
		}
		if(checkForIngredientDependencies(id)) {
			throw new DependencyExistsException("A Recipe(s) has been found for this Ingredient. Delete these Recipe(s)" +
					" before deleting this Ingredient.");
		}
		if(checkForDailyDietDependencies(id)) {
			throw new DependencyExistsException("A daily diet entry has been found for this Ingredient. " +
					"Delete these daily diet entry(s) " +
					"before deleting this Ingredient.");
		}
	}

	private boolean checkForFavoriteDependencies(int id, Integer userId) {
		return favoriteIngredientsService.checkForFavoriteDependencies(id,userId,false);
	}

	private boolean checkForIngredientDependencies(int id) {
		return recipeIngredientsService.checkForGlobalRecipesThatAreDependentUponThisGlobalIngredient(id)
		  && localRecipeIngredientsService.checkForRecipesThatAreDependentOnAnIngredient(id,false);
	}

	private boolean checkForDailyDietDependencies(int id) throws Exception {
		List<DailyDiet> dates =  dailyDietService.findDailyDietRecordsWithGlobalIngredientId(id);
		if(dates.size()>0) {
			return true;
		}
		return false;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : ingrTypeId
	 * @param id
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByIngrTypeId(int id) throws Exception {
		Iterable<Ingredients> results = ingredientsRepository.findIngredientsByIngrTypeId(id);
		Iterator<Ingredients> iter = results.iterator();
		List<IngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Ingredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : brandId
	 * @param id
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByBrandId(int id) throws Exception {
		Iterable<Ingredients> results = ingredientsRepository.findIngredientsByBrandId(id);
		Iterator<Ingredients> iter = results.iterator();
		List<IngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Ingredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByServTypeId(int id) throws Exception {
		Iterable<Ingredients> results = ingredientsRepository.findIngredientsByServTypeId(id);
		Iterator<Ingredients> iter = results.iterator();
		List<IngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Ingredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByImageLoc(int id) throws Exception {
		Iterable<Ingredients> results = ingredientsRepository.findIngredientsByImageLoc(id);
		Iterator<Ingredients> iter = results.iterator();
		List<IngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Ingredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by ingrTypeId and brandId
	 * @param ingrTypeId
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	public List<IngredientsDTO> findIngredientsByIngrTypeIdAndBrandId(int ingrTypeId,int brandId) throws Exception {
		Iterable<Ingredients> results = ingredientsRepository.findIngredientsByIngrTypeIdAndBrandId(ingrTypeId, brandId);
		Iterator<Ingredients> iter = results.iterator();
		List<IngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Ingredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

    public boolean checkForGlobalIngredientDependencies(int id) {
		Iterable<Ingredients> ingredients = ingredientsRepository.findIngredientsByBrandId(id);
		if(ingredients!=null&&ingredients.iterator().hasNext()) {
			return true;
		}
		return false;
    }

	public RecipeIngredientDisplay findIngredientDisplayById(int id) throws Exception {
		IngredientsDTO ingredientInfo = findIngredientsById(id);
		RecipeIngredientDisplay displayInfo = convertToDisplayDTO(ingredientInfo);
		return displayInfo;
	}

	private RecipeIngredientDisplay convertToDisplayDTO(IngredientsDTO ingredientInfo) {
		RecipeIngredientDisplay display = new RecipeIngredientDisplay(ingredientInfo.getIngrId(),
				ingredientInfo.getIngrDesc(),false, false, ingredientInfo.getServSz(),
				ingredientInfo.getServTypeId(), null, null, ingredientInfo);
		display.setMultiplier(calculateM1(display,ingredientInfo));
		return display;
	}

	/**
	 * TODO - refactor this to the RecipeCalculatorUtility class
	 * @param rec
	 * @param ingredient
	 * @return
	 */
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

	public BigDecimal findM1(RecipeIngredientDisplay data) throws Exception {
		IngredientsDTO dto = findIngredientsById(data.getIngrId());
		return calculateM1(data,dto);
	}
}
