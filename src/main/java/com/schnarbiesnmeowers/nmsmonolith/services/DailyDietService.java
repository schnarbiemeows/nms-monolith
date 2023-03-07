package com.schnarbiesnmeowers.nmsmonolith.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietaryExclusionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ServingRatioNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;
import com.schnarbiesnmeowers.nmsmonolith.utilities.BldstUtility;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietRepository dailyDietRepository;

	@Autowired
	private DailyDietTotalsService dailyDietTotalsService;

	@Autowired
	private RecipesService recipesService;

	@Autowired
	private LocalRecipesService localRecipesService;

	@Autowired
	private IngredientsService ingredientsService;

	@Autowired
	private LocalIngredientsService localIngredientsService;

	@Autowired
	private DietaryTemplatesService dietaryTemplatesService;

	@Autowired
	private BldstUtility bldstUtility;

	@Autowired
	private DailyDietaryNotesService dailyDietaryNotesService;

	@Autowired
	ServingTypesService servingTypesService;

	@Autowired
	RecipeCalculatorUtility recipeCalculatorUtility;

	@Autowired
	DailyDietaryExclusionsService dailyDietaryExclusionsService;

	@Autowired
	UnsyncedService unsyncedService;

	@Autowired
	UsersService usersService;

	/**
	 * get all DailyDiet records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietDTO> getAllDailyDiet() throws Exception {
		Iterable<DailyDiet> dailydiet = dailyDietRepository.findAll();
		Iterator<DailyDiet> dailydiets = dailydiet.iterator();
		List<DailyDietDTO> dailydietdto = new ArrayList();
		while(dailydiets.hasNext()) {
			DailyDiet item = dailydiets.next();
			dailydietdto.add(item.toDTO());
		}
		return dailydietdto;
	}


	/**
	 * retrieve all of the daily_diet information for a given user for a given day
	 * @param input
	 * @return
	 */
	public DailyDietWrapper getDailyDietForDate(DailyDietRequest input) throws Exception {
		DailyDietWrapper wrapper = new DailyDietWrapper(new ArrayList(),null,
				null,null, false, true, input.getUserId(),null);
		try {
			wrapper.setDaysDate(input.getDate());
			Iterable<DailyDiet> dailyDietaryRecords =
					dailyDietRepository.findDailyDietByUserIdAndDate(input.getUserId(),input.getDate());
			Iterator<DailyDiet> dailydiets = dailyDietaryRecords.iterator();
			List<DailyDietDTO> dailydietdtos = new ArrayList();
			while(dailydiets.hasNext()) {
				DailyDiet item = dailydiets.next();
				dailydietdtos.add(item.toDTO());
			}
			recalculateIngredientTotals(wrapper, dailydietdtos);
			wrapper.setDailyTotals(
					dailyDietTotalsService.findDailyDietTotalsByUserIdAndCalendarDate(input.getUserId(),
							input.getDate()));
			wrapper.setNotes(
					dailyDietaryNotesService.findDailyDietaryNotesByUserIdAndDate(input.getUserId(),input.getDate()));
			if(unsyncedService.hasUnsyncedRecord(input.getUserId(),input.getDate())) {
				wrapper.setSynced(false);
			}
			if(dailyDietaryExclusionsService.hasExclusion(input.getUserId(),input.getDate())) {
				wrapper.setExclude(true);
			}
			wrapper.setUsername(usersService.findUsersById(wrapper.getUserId()).getUsername());
		} catch (Exception e) {
			throw e;
		}
		return wrapper;
	}

	/**
	 *
	 * @param wrapper
	 * @param dailydietdtos
	 * @throws Exception
	 */
	private void recalculateIngredientTotals(DailyDietWrapper wrapper, List<DailyDietDTO> dailydietdtos) throws Exception {
		for(DailyDietDTO dietItem : dailydietdtos) {
			if(dietItem.getIsRecipe()) {
				if(dietItem.getIsLocal()) {
					LocalRecipes recipeItem =
							localRecipesService.findBasicRecipeInfoByRecipeId(dietItem.getIngrId());
					LocalIngredientsDTO localIngredientDTO =
							localIngredientsService.findLocalIngredientsById(recipeItem.getIngrId());
					IngredientsDTO ingredientDTO = localIngredientDTO.returnGlobalDTO();
					/**
					 * here we have to calibrate the totals
					 * we have to
					 */
					IngredientsDTO calibratedDTO = calculateTotalsForOneItem(ingredientDTO,dietItem);
					DailyDietDisplayRecord record = new DailyDietDisplayRecord(calibratedDTO,dietItem);
					wrapper.getIngredients().add(record);
				} else {
					Recipes recipeItem =
							recipesService.findBasicRecipeInfoByRecipeId(dietItem.getIngrId());
					IngredientsDTO ingredientDTO =
							ingredientsService.findIngredientsById(recipeItem.getIngrId());
					IngredientsDTO calibratedDTO = calculateTotalsForOneItem(ingredientDTO,dietItem);
					DailyDietDisplayRecord record = new DailyDietDisplayRecord(calibratedDTO,dietItem);
					wrapper.getIngredients().add(record);
				}
			} else {
				if(dietItem.getIsLocal()) {
					LocalIngredientsDTO localIngredientDTO =
							localIngredientsService.findLocalIngredientsById(dietItem.getIngrId());
					IngredientsDTO ingredientDTO = localIngredientDTO.returnGlobalDTO();
					IngredientsDTO calibratedDTO = calculateTotalsForOneItem(ingredientDTO,dietItem);
					DailyDietDisplayRecord record = new DailyDietDisplayRecord(calibratedDTO,dietItem);
					wrapper.getIngredients().add(record);
				} else {
					IngredientsDTO ingredientDTO =
							ingredientsService.findIngredientsById(dietItem.getIngrId());
					IngredientsDTO calibratedDTO = calculateTotalsForOneItem(ingredientDTO,dietItem);
					DailyDietDisplayRecord record = new DailyDietDisplayRecord(calibratedDTO,dietItem);
					wrapper.getIngredients().add(record);
				}
			}
		}
	}

	private IngredientsDTO calculateTotalsForOneItem(IngredientsDTO ingredientDTO, DailyDietDTO dietItem) throws Exception {
		BigDecimal m1 = calculateM1(dietItem.getServTypeId(), ingredientDTO.getServTypeId(),
				ingredientDTO.getIngrDesc());
		BigDecimal ss = ingredientDTO.getServSz();
		IngredientsDTO calibratedDTO = new IngredientsDTO(ingredientDTO.getIngrId(),
				ingredientDTO.getIngrDesc(),ingredientDTO.getIngrTypeId(),ingredientDTO.getBrandId(),
				dietItem.getNumSrv(),dietItem.getServTypeId(),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getKcalories(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getTotFat(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getSatFat(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getTransFat(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getPolyFat(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getMonoFat(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getCholes(),ss,m1),
				calibrate(dietItem.getNumSrv(),BigDecimal.valueOf(ingredientDTO.getSodium()),ss,m1).intValue(),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getTotCarbs(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getTotFiber(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getTotSugars(),ss,m1),
				calibrate(dietItem.getNumSrv(),ingredientDTO.getTotProtein(),ss,m1),
				null,null,"Y");
		return calibratedDTO;
	}

	private static BigDecimal calibrate(BigDecimal recordServingSize, BigDecimal ingredientTotalPerServing,
										BigDecimal ingrServingSz, BigDecimal multiplier) {
		/**
		 * recordServingSize = num servings coming from the daily_diet record
		 * ingredientTotalPerServing = kcalories, total fat, etc, from ingredients record
		 */
		BigDecimal i1 = recordServingSize.divide(ingrServingSz,2, RoundingMode.HALF_UP);
		BigDecimal i2 = i1.multiply(multiplier);
		return i2.multiply(ingredientTotalPerServing);
	}

	private BigDecimal calculateM1(Integer servingUnitId, Integer ingredientServingTypeId,
		String ingredientDesc) {
		BigDecimal m1;
		if(servingUnitId==ingredientServingTypeId) {
			m1=BigDecimal.ONE;
		} else if (recipeCalculatorUtility.hasRatio(servingUnitId, ingredientServingTypeId)) {
			m1 = recipeCalculatorUtility.getRatio(servingUnitId, ingredientServingTypeId);
		} else if (recipeCalculatorUtility.hasFittingRatios(servingUnitId, ingredientServingTypeId)) {
			m1 = recipeCalculatorUtility.findFittingRatio(servingUnitId, ingredientServingTypeId);
		} else {
			ServingTypesDTO st1 = null;
			ServingTypesDTO st2 = null;
			try {
				st1 = servingTypesService.findServingTypesById(servingUnitId);
				st2 = servingTypesService.findServingTypesById(ingredientServingTypeId);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			throw new ServingRatioNotFoundException("serving type: " + st1.getServTypeCde() +
					" cannot be converted to serving type: " + st2.getServTypeCde() +
					" for ingredient: " + ingredientDesc);
		}
		return m1;
	}

	/**
	 * get DailyDiet by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietDTO findDailyDietById(int id) throws Exception {
		Optional<DailyDiet> dailydietOptional = dailyDietRepository.findById(id);
		if(dailydietOptional.isPresent()) {
			DailyDiet results = dailydietOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new DailyDiet
	 * @param data
	 * @return
	 */
	public DailyDietWrapper createDailyDiet(DailyDietDTO data) throws Exception {
		DailyDietWrapper wrapper = new DailyDietWrapper();
		try {
			DailyDietRequest input = new DailyDietRequest(data.getUserId(),data.getCalendarDate());
			dailyDietRepository.save(data.toEntity());
			wrapper = getDailyDietForDate(input);
			wrapper.setDailyTotals(createDailyTotalsRecords(wrapper.getIngredients(),input.getDate(),input.getUserId()));
			return wrapper;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDiet
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietWrapper updateDailyDiet(DailyDietDTO data) throws Exception {
		DailyDietWrapper wrapper = new DailyDietWrapper();
		Optional<DailyDiet> dailydietOptional = dailyDietRepository.findById(data.getDailyTotalId());
		if(dailydietOptional.isPresent()) {
			DailyDietDTO dto = dailydietOptional.get().toDTO();
			DailyDietRequest input = new DailyDietRequest(dto.getUserId(),dto.getCalendarDate());
			dailyDietRepository.save(data.toEntity());
			wrapper = getDailyDietForDate(input);
			wrapper.setDailyTotals(createDailyTotalsRecords(wrapper.getIngredients(),input.getDate(),input.getUserId()));
			return wrapper;
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getDailyTotalId() + NOT_FOUND);
		}
	}

	/**
	 * when this is called, the data that is in it contains all of the DailyDietWrapper data
	 * from a different date. The only data that is different are the record PKs(all have been
	 * cleared) and the daysDate = the NEW date.
	 * so, the ingredients.data should already be calibrated, because when the ingredients list
	 * is first retrieved they are calibrated, and every time an individual ingredient is updated
	 * that item's IngredientsDTO is calibrated. so we just need to :
	 * 1. create the daily_diet records
	 * 2. create the daily_diet_totals
	 * 3. create any daily_dietary_notes record
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietWrapper cloneDailyDiet(DailyDietWrapper data) throws Exception {
		List<DailyDietDisplayRecord> dailyDietRecords = data.getIngredients();
		for(DailyDietDisplayRecord record : dailyDietRecords) {
			DailyDietDTO dto = record.getDailyInfo();
			dto.setDailyTotalId(null);
			//Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(data.getDaysDate());
			dto.setCalendarDate(data.getDaysDate());
			DailyDiet entity = dto.toEntity();
			dailyDietRepository.save(entity);
		}
		List<DailyDietTotalsDTO> records = createDailyTotalsRecords(dailyDietRecords,data.getDaysDate(),data.getUserId());
		data.setDailyTotals(records);
		//data.setNotes(updateDailyNotesRecord(data.getNotes(),data.getDaysDate(),data.getUserId()));
		//upsertDailyDietaryExclusionRecord(data.getDaysDate(),data.getUserId(),!data.isExclude());
		return data;
	}

	private DailyDietaryNotesDTO updateDailyNotesRecord(DailyDietaryNotesDTO note, Date daysDate, Integer userId) throws Exception {
		DailyDietaryNotesDTO dto = dailyDietaryNotesService.findDailyDietaryNotesByUserIdAndDate(userId,daysDate);
		if(dto!=null) {
			note.setDdnId(dto.getDdnId());
			dailyDietaryNotesService.updateDailyDietaryNotes(note);
		} else {
			if(note!=null) {
				note = dailyDietaryNotesService.createDailyDietaryNotes(note);
			}
		}
		return note;
	}

	private DailyDietaryExclusionsDTO upsertDailyDietaryExclusionRecord(Date daysDate, Integer userId,
		boolean remove) throws Exception {
		DailyDietaryExclusionsDTO exclusion = null;
		if(remove&&dailyDietaryExclusionsService.hasExclusion(userId,daysDate)) {
			dailyDietaryExclusionsService.deleteDailyDietaryExclusions(userId,daysDate);
		}
		if(!remove&&!dailyDietaryExclusionsService.hasExclusion(userId,daysDate)) {
			exclusion = new DailyDietaryExclusionsDTO(null,userId,daysDate);
			exclusion = dailyDietaryExclusionsService.createDailyDietaryExclusions(exclusion);
		}
		return exclusion;
	}
	/**
	 * this method uses the IngredientsDTO records to calculate each of the totals for each of
	 * the daily_dietary_totals for each bldst_id type
	 * here the IngredientsDTO records should already be calibrated
	 * @param dailyDietRecords
	 * @param currentDate
	 * @param userId
	 * @throws Exception
	 */
	public List<DailyDietTotalsDTO> createDailyTotalsRecords(List<DailyDietDisplayRecord> dailyDietRecords,
		Date currentDate, Integer userId) throws Exception {
		Map<String,Integer> bldstMap = bldstUtility.getBldstMap();
		List<DailyDietTotalsDTO> returnRecords = new ArrayList();
		List<DailyDietDisplayRecord> coffeeRecords = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_COFFEE)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> breakfastRecords = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_BREAKFAST)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> lunchRecords = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_LUNCH)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> dinnerRecords = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_DINNER)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> snackRecords = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_SNACK)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> meal1Records = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_MEAL1)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> meal2Records = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_MEAL2)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> meal3Records = dailyDietRecords.stream().filter(rec -> rec.getDailyInfo()
				.getBldstId()==bldstMap.get(BldstUtility.BLDST_MEAL3)).collect(Collectors.toList());
		List<DailyDietDisplayRecord> totalRecords = dailyDietRecords;

		if(coffeeRecords!=null&&coffeeRecords.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(coffeeRecords,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_COFFEE));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			// otherwise, let's say the person initially said they had something for breakfast, but then
			// later deleted that breakfast item. So, we would still want to remove that record from
			// daily_dietary_totals in these cases
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_COFFEE));
		}
		if(breakfastRecords!=null&&breakfastRecords.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(breakfastRecords,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_BREAKFAST));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			// otherwise, let's say the person initially said they had something for breakfast, but then
			// later deleted that breakfast item. So, we would still want to remove that record from
			// daily_dietary_totals in these cases
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_BREAKFAST));
		}
		if(lunchRecords!=null&&lunchRecords.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(lunchRecords,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_LUNCH));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_LUNCH));
		}
		if(dinnerRecords!=null&&dinnerRecords.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(dinnerRecords,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_DINNER));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_DINNER));
		}
		if(snackRecords!=null&&snackRecords.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(snackRecords,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_SNACK));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_SNACK));
		}
		if(meal1Records!=null&&meal1Records.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(meal1Records,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_MEAL1));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_MEAL1));
		}
		if(meal2Records!=null&&meal2Records.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(meal2Records,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_MEAL2));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_MEAL2));
		}
		if(meal3Records!=null&&meal3Records.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(meal3Records,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_MEAL3));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_MEAL3));
		}
		if(totalRecords!=null&&totalRecords.size()>0) {
			DailyDietTotalsDTO totals = createTotalsRecord(totalRecords,userId,
					currentDate,bldstMap.get(BldstUtility.BLDST_TOTAL));
			totals = dailyDietTotalsService.upsertDailyDietTotalsByUserIdAndCalendarDateAndBldstId(totals);
			returnRecords.add(totals);
		} else {
			String message = dailyDietTotalsService
					.deleteDailyDietTotalsByUserIdAndCalendarDateAndBldstId(userId,
							currentDate,bldstMap.get(BldstUtility.BLDST_TOTAL));
		}
		return returnRecords;
	}

	private DailyDietTotalsDTO createTotalsRecord(List<DailyDietDisplayRecord> records, Integer userId,
		Date currentDate, Integer bldstId) {
		IngredientsDTO totals = new IngredientsDTO(null,null,null,null,null,null,
				BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,
				BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,0,
				BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,BigDecimal.ZERO,
				null,null,"Y");
		for(DailyDietDisplayRecord dto : records) {
			totals.setKcalories(totals.getKcalories().add(dto.getData().getKcalories()));
			totals.setTotFat(totals.getTotFat().add(dto.getData().getTotFat()));
			totals.setSatFat(totals.getSatFat().add(dto.getData().getSatFat()));
			totals.setPolyFat(totals.getPolyFat().add(dto.getData().getPolyFat()));
			totals.setMonoFat(totals.getMonoFat().add(dto.getData().getMonoFat()));
			totals.setCholes(totals.getCholes().add(dto.getData().getCholes()));
			totals.setSodium(totals.getSodium()+dto.getData().getSodium());
			totals.setTotCarbs(totals.getTotCarbs().add(dto.getData().getTotCarbs()));
			totals.setTotSugars(totals.getTotSugars().add(dto.getData().getTotSugars()));
			totals.setTotFiber(totals.getTotFiber().add(dto.getData().getTotFiber()));
			totals.setTotProtein(totals.getTotProtein().add(dto.getData().getTotProtein()));
			totals.setTransFat(totals.getTransFat().add(dto.getData().getTransFat()));
		}
		return new DailyDietTotalsDTO(null,userId,currentDate,bldstId,
				totals.getKcalories(),totals.getTotFat(),totals.getSatFat(),
				totals.getTransFat(),totals.getPolyFat(),totals.getMonoFat(),
				totals.getCholes(),totals.getSodium(),totals.getTotCarbs(),
				totals.getTotFiber(),totals.getTotSugars(),totals.getTotProtein());
	}

	/*private RecipeIngredientDisplay transferToRecipeIngredientDisplayRecord(DailyDietDisplayRecord record) {
		RecipeIngredientDisplay outputRecord = new RecipeIngredientDisplay();
		outputRecord.setRecipe(record.getDailyInfo().getIsRecipe());
		outputRecord.setLocal(record.getDailyInfo().getIsLocal());
		outputRecord.setIngrId(record.getDailyInfo().getIngrId());
		outputRecord.setServSz(record.getDailyInfo().getNumSrv());
		outputRecord.setServUnitId(record.getDailyInfo().getServTypeId());
		return outputRecord;
	}*/


	/**
	 * delete a DailyDiet by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietWrapper deleteDailyDiet(int id) throws Exception {
		DailyDietWrapper wrapper = new DailyDietWrapper();
		Optional<DailyDiet> dailydietOptional = dailyDietRepository.findById(id);
		if(dailydietOptional.isPresent()) {
			DailyDietDTO dto = dailydietOptional.get().toDTO();
			DailyDietRequest input = new DailyDietRequest(dto.getUserId(),dto.getCalendarDate());
			dailyDietRepository.deleteById(id);
			wrapper = getDailyDietForDate(input);
			wrapper.setDailyTotals(createDailyTotalsRecords(wrapper.getIngredients(),input.getDate(),input.getUserId()));
			return wrapper;
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<DailyDietDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByUserId(int id) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietByUserId(id);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDietDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDiet item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<DailyDietDTO> by foreign key : ingrId
	 * @param id
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByIngrId(int id) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietByIngrId(id);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDietDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDiet item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<DailyDietDTO> by foreign key : bldstId
	 * @param id
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByBldstId(int id) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietByBldstId(id);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDietDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDiet item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<DailyDietDTO> by foreign key : UserIdAndIngrIdAndBldstId
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietDTO> findDailyDietByUserIdAndIngrIdAndBldstId(int id0, int id1, int id2) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietByUserIdAndIngrIdAndBldstId(id0, id1, id2);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDietDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			DailyDiet item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 *
	 * @param recipeId
	 * @return
	 * @throws Exception
	 */
	public List<DailyDiet> findDailyDietRecordsWithLocalRecipeId(int recipeId) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietRecordsWithLocalRecipeId(recipeId);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDiet> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			resultsdto.add(iter.next());
		}
		return resultsdto;
	}

	/**
	 *
	 * @param recipeId
	 * @return
	 * @throws Exception
	 */
	public List<DailyDiet> findDailyDietRecordsWithGlobalRecipeId(int recipeId) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietRecordsWithGlobalRecipeId(recipeId);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDiet> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			resultsdto.add(iter.next());
		}
		return resultsdto;
	}

	/**
	 *
	 * @param recipeId
	 * @return
	 * @throws Exception
	 */
	public List<DailyDiet> findDailyDietRecordsWithLocalIngredientId(int recipeId) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietRecordsThatHaveLocalIngredientId(recipeId);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDiet> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			resultsdto.add(iter.next());
		}
		return resultsdto;
	}

	/**
	 *
	 * @param recipeId
	 * @return
	 * @throws Exception
	 */
	public List<DailyDiet> findDailyDietRecordsWithGlobalIngredientId(int recipeId) throws Exception {
		Iterable<DailyDiet> results = dailyDietRepository.findDailyDietRecordsThatHaveGlobalIngredientId(recipeId);
		Iterator<DailyDiet> iter = results.iterator();
		List<DailyDiet> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			resultsdto.add(iter.next());
		}
		return resultsdto;
	}
}
