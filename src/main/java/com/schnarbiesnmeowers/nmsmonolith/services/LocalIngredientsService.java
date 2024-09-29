package com.schnarbiesnmeowers.nmsmonolith.services;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDisplayRecord;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietRequest;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalRecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeIngredientDisplay;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ServingRatioNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDiet;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipes;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalIngredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalIngredientsRepository;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.INGREDIENT_TYPE_ID_FOR_RECIPE;
import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.NO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LocalIngredientsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalIngredientsRepository localIngredientsRepository;

	@Autowired
	private LocalRecipesService localRecipesService;

	@Autowired
	private LocalRecipeIngredientsService localRecipeIngredientsService;

	@Autowired
	private FavoriteIngredientsService favoriteIngredientsService;

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
	 * get all LocalIngredients records
	 * @return
	 * @throws Exception
	 */
	public List<LocalIngredientsDTO> getAllLocalIngredients() throws Exception {
		Iterable<LocalIngredients> localingredients = localIngredientsRepository.findAll();
		Iterator<LocalIngredients> localingredientss = localingredients.iterator();
		List<LocalIngredientsDTO> localingredientsdto = new ArrayList();
		while(localingredientss.hasNext()) {
			LocalIngredients item = localingredientss.next();
			localingredientsdto.add(item.toDTO());
		}
		return localingredientsdto;
	}

	/**
	 * get LocalIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalIngredientsDTO findLocalIngredientsById(int id) throws Exception {
		Optional<LocalIngredients> localingredientsOptional = localIngredientsRepository.findById(id);
		if(localingredientsOptional.isPresent()) {
			LocalIngredients results = localingredientsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LocalIngredients
	 * @param data
	 * @return
	 */
	public LocalIngredientsDTO createLocalIngredients(LocalIngredientsDTO data) {
		try {
		    LocalIngredients createdData = data.toEntity();
		    createdData = localIngredientsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalIngredients
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalIngredientsDTO updateIngredientRecordForRecipe(LocalIngredientsDTO data) throws Exception {
		Optional<LocalIngredients> localingredientsOptional = localIngredientsRepository.findById(data.getIngrId());
		if(localingredientsOptional.isPresent()) {
			LocalIngredients updatedData = data.toEntity();
			updatedData = localIngredientsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getIngrId() + NOT_FOUND);
		}
	}

	/**
	 * update a local_ingredient record
	 * also have to recursively update any local recipes that depend upon this ingredient
	 * 1. use the recipe_ingredients table to find any local recipes that are dependent upon it
	 * 2. update the recipe(s) recursively
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalIngredientsDTO updateLocalIngredients(LocalIngredientsDTO data) throws Exception {
		Optional<LocalIngredients> localingredientsOptional = localIngredientsRepository.findById(data.getIngrId());
		if(localingredientsOptional.isPresent()) {
			if(NO.equals(data.getActv())) {
				checkForDependencies(data.getIngrId(), data.getUserId());
			}
			LocalIngredients previous = localingredientsOptional.get();
		    LocalIngredients updatedData = data.toEntity();
			boolean haveToUpdate = checkIfWeNeedToRecursivelyUpdate(updatedData.toDTO(),previous.toDTO());
			updatedData = localIngredientsRepository.save(updatedData);
			if(haveToUpdate) {
				List<Integer> affectedRecipes = new ArrayList();
				List<LocalRecipeIngredientsDTO> localResults =
						localRecipeIngredientsService
								.findLocalRecipesThatAreDependentUponGivenLocalIngredient(data.getIngrId());
				for (LocalRecipeIngredientsDTO item : localResults) {
					affectedRecipes.add(item.getRecipeId());
					System.out.println("local ingredient ID = " + data.getIngrId() + " has a parent local " +
							"recipe --> " + item.getRecipeId());
					LocalRecipes dto = localRecipesService.findBasicRecipeInfoByRecipeId(item.getRecipeId());
					// 2. update the recipe(s) recursively
					localRecipesService.updateParentLocalRecipeRecords(dto, affectedRecipes);
				}
				// find all the dates for the ingredient AND all the recipe IDs in affectedRecipes
				List<DailyDiet> totalRecords = new ArrayList();
				List<DailyDiet> localDailyDietaryRecords = new ArrayList();
				Map<Integer,Set<Date>> processedTemplates = new HashMap();
				List<DailyDiet> dailyDietRecordsAffectedByIngredient =
						dailyDietService.findDailyDietRecordsWithLocalIngredientId(data.getIngrId());
				totalRecords.addAll(dailyDietRecordsAffectedByIngredient);
				for(int item : affectedRecipes) {
					List<DailyDiet> dailyDietRecordsAffectedByLocalRecipe =
							dailyDietService.findDailyDietRecordsWithLocalRecipeId(item);
					localDailyDietaryRecords.addAll(dailyDietRecordsAffectedByLocalRecipe);
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
			// 1. use the recipe_ingredients table to find any local recipes that are dependent upon it
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

	private boolean checkIfWeNeedToRecursivelyUpdate(LocalIngredientsDTO ingredientRecord,
		LocalIngredientsDTO currentRecipeRecord) throws Exception {
		return /*!areTheyTheSame(ingredientRecord,currentRecipeRecord);*/ false;
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
	 * delete a LocalIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalIngredients(int id, int userId) throws Exception {
		Optional<LocalIngredients> localingredientsOptional = localIngredientsRepository.findById(id);
		if(localingredientsOptional.isPresent()) {
			LocalIngredients ingredient = localingredientsOptional.get();
			checkForDependencies(id, userId);
			ingredient.setActv(NO);
			localIngredientsRepository.save(ingredient);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalIngredientRecordForRecipe(int id, int userId) throws Exception {
		Optional<LocalIngredients> localingredientsOptional = localIngredientsRepository.findById(id);
		if(localingredientsOptional.isPresent()) {
			LocalIngredients ingredient = localingredientsOptional.get();
			ingredient.setActv(NO);
			localIngredientsRepository.save(ingredient);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	private void checkForDependencies(int id, int userId) throws Exception {
		if(checkForFavoriteDependencies(id, userId)) {
			throw new DependencyExistsException("A Favorite(s) has been found for this Ingredient. Delete these " +
					"Favorite(s) before deleting this Ingredient.");
		}
		if(checkForLocalRecipeDependencies(id, userId)) {
			throw new DependencyExistsException("A Recipe(s) has been found for this Ingredient. " +
					"Delete these Recipe(s) " +
					"before deleting this Ingredient.");
		}
		if(checkForDailyDietDependencies(id, userId)) {
			throw new DependencyExistsException("A daily diet entry has been found for this Ingredient. " +
					"Delete these daily diet entry(s) " +
					"before deleting this Ingredient.");
		}
	}

	private boolean checkForFavoriteDependencies(int id, int userId) {
		return favoriteIngredientsService.checkForFavoriteDependencies(id,userId,true);
	}

	private boolean checkForLocalRecipeDependencies(int id, int userId) {
		return localRecipeIngredientsService.checkForRecipesThatAreDependentOnAnIngredient(id,true);
	}

	private boolean checkForDailyDietDependencies(int id, int userId) throws Exception {
		List<DailyDiet> dailyDietRecords =  dailyDietService.findDailyDietRecordsWithLocalIngredientId(id);
		if(dailyDietRecords.size()>0) {
			return true;
		}
		return false;
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : ingrTypeId
	 * @param id
	 * @return List<LocalIngredients>
	 * @throws Exception
	*/
	public List<LocalIngredientsDTO> findLocalIngredientsByIngrTypeId(int id) throws Exception {
		Iterable<LocalIngredients> results = localIngredientsRepository.findLocalIngredientsByIngrTypeId(id);
		Iterator<LocalIngredients> iter = results.iterator();
		List<LocalIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<LocalIngredients>
	 * @throws Exception
	*/
	public List<LocalIngredientsDTO> findLocalIngredientsByServTypeId(int id) throws Exception {
		Iterable<LocalIngredients> results = localIngredientsRepository.findLocalIngredientsByServTypeId(id);
		Iterator<LocalIngredients> iter = results.iterator();
		List<LocalIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalIngredients>
	 * @throws Exception
	*/
	public List<LocalIngredientsDTO> findLocalIngredientsByImageLoc(int id) throws Exception {
		Iterable<LocalIngredients> results = localIngredientsRepository.findLocalIngredientsByImageLoc(id);
		Iterator<LocalIngredients> iter = results.iterator();
		List<LocalIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : IngrTypeIdAndServTypeIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	public List<LocalIngredientsDTO> findLocalIngredientsByIngrTypeIdAndServTypeIdAndImageLoc(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<LocalIngredients> results = localIngredientsRepository.findLocalIngredientsByIngrTypeIdAndServTypeIdAndImageLoc(id0, id1, id2);
		Iterator<LocalIngredients> iter = results.iterator();
		List<LocalIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

    public boolean checkForLocalIngredientDependencies(int id, int userId) {
		Iterable<LocalIngredients> ingredients = localIngredientsRepository
				.findLocalIngredientsByUserIdAndBrandId(userId,id, INGREDIENT_TYPE_ID_FOR_RECIPE);
		if(ingredients!=null&&ingredients.iterator().hasNext()) {
			return true;
		}
		return false;
    }

	/**
	 * it is important to note here that this method is only being called when the user
	 * initially selects an ingredient for inclusion on a recipe
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeIngredientDisplay findLocalIngredientDisplayById(int id) throws Exception {
		LocalIngredientsDTO ingredientInfo = findLocalIngredientsById(id);
		RecipeIngredientDisplay displayInfo = convertToDisplayDTO(ingredientInfo);
		return displayInfo;
	}

	/**
	 * the serving types and units here are being taken from the ingredients record(and not the
	 * recipe-ingredients record) because of the method explanation above: not recipe-ingredients
	 * record has been created at this point
	 * @param ingredientInfo
	 * @return
	 */
	private RecipeIngredientDisplay convertToDisplayDTO(LocalIngredientsDTO ingredientInfo) {
		RecipeIngredientDisplay display = new RecipeIngredientDisplay(ingredientInfo.getIngrId(),
				ingredientInfo.getIngrDesc(),true, false, ingredientInfo.getServSz(),
				ingredientInfo.getServTypeId(), null, null, ingredientInfo.returnGlobalDTO());
		display.setMultiplier(calculateM1(display,ingredientInfo.returnGlobalDTO()));
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
		LocalIngredientsDTO dto = findLocalIngredientsById(data.getIngrId());
		return calculateM1(data,dto.returnGlobalDTO());
	}
}
