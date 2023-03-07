package com.schnarbiesnmeowers.nmsmonolith.services;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeSpiceDisplay;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.*;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalSpices;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Spices;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalSpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.repositories.SpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.NO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class SpicesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
	public static final String ID_EQUALS = "id = ";
	public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private SpicesRepository spicesRepository;

	@Autowired
	private LocalSpicesRepository localSpicesRepository;

	@Autowired
	private FavoriteSpicesService favoriteSpicesService;

	@Autowired
	private LocalSpicesService localSpicesService;

	@Autowired
	private RecipeSpicesService recipeSpicesService;

	@Autowired
	private RecipesService recipesService;

	@Autowired
	private LocalRecipesService localRecipesService;

	@Autowired
	private LocalRecipeSpicesService localRecipeSpicesService;

	@Autowired
	RecipeCalculatorUtility recipeCalculatorUtility;

	@Autowired
	ServingTypesService servingTypesService;

	/**
	 * get all Spices records
	 * @return
	 * @throws Exception
	 */
	public List<SpicesDTO> getAllSpices() throws Exception {
		Iterable<Spices> spices = spicesRepository.findAllActiveGlobalSpices();
		Iterator<Spices> spicesIterator = spices.iterator();
		List<SpicesDTO> spicesdto = new ArrayList();
		while(spicesIterator.hasNext()) {
			Spices item = spicesIterator.next();
			spicesdto.add(item.toDTO());
		}
		return spicesdto;
	}

	/**
	 * get all of the spice displays for a user, consisting of:
	 * - global spice displays
	 * - local spice displays for the user
	 * - favorite spices for the user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public SpicesWrapper getAllSpiceDisplays(int userId) throws Exception {
		List<SpicesDTO> globals = getAllSpices();
		List<SpiceRecordDisplay> globalDisplays = new ArrayList();
		for(SpicesDTO item : globals) {
			globalDisplays.add(item.toDisplayObject());
		}
		List<LocalSpicesDTO> locals = getAllLocalSpices(userId);
		List<SpiceRecordDisplay> localDisplays = new ArrayList();
		for(LocalSpicesDTO item : locals) {
			localDisplays.add(item.toDisplayObject());
		}
		List<FavoriteSpicesDTO> favorites = getFavoriteSpices(userId);

		return new SpicesWrapper(globalDisplays,localDisplays,favorites);
	}

	/**
	 * get all the local spices for a given user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<LocalSpicesDTO> getAllLocalSpices(int userId) throws Exception {
		Iterable<LocalSpices> spices = localSpicesRepository
				.findLocalSpicesByUserId(userId);
		Iterator<LocalSpices> spicesIterator = spices.iterator();
		List<LocalSpicesDTO> spicesdto = new ArrayList();
		while(spicesIterator.hasNext()) {
			LocalSpices item = spicesIterator.next();
			spicesdto.add(item.toDTO());
		}
		return spicesdto;
	}

	/**
	 * get all of the favorite spices for a user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteSpicesDTO> getFavoriteSpices(int userId) throws Exception {
		return favoriteSpicesService.getFavoriteSpicesByUserId(userId);
	}

	/**
	 * get Spices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SpicesDTO findSpicesById(int id) throws Exception {
		Optional<Spices> spicesOptional = spicesRepository.findById(id);
		if(spicesOptional.isPresent()) {
			Spices results = spicesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public List<RecipeSpiceDisplay> findSpicesByIds(SpiceArrayInput data) throws Exception {
		int defaultServingType = servingTypesService.findServingTypeForTsp();
		List<RecipeSpiceDisplay> results = new ArrayList();
		for(int id : data.getGlobalSpiceIds()) {
			RecipeSpiceDisplay globalSpice = convertToDisplayDTO(findSpicesById(id));
			globalSpice.setServUnitId(defaultServingType);
			results.add(globalSpice);
		}
		for(int id : data.getLocalSpiceIds()) {
			RecipeSpiceDisplay localSpice = localSpicesService.convertToDisplayDTO(localSpicesService.findLocalSpicesById(id));
			localSpice.setServUnitId(defaultServingType);
			results.add(localSpice);
		}
		return results;
	}
	/**
	 * create a new Spice
	 * @param data
	 * @return
	 */
	public SpicesDTO createSpices(SpicesDTO data) {
		try {
			Spices createdData = data.toEntity();
			createdData = spicesRepository.save(createdData);
			return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update an Spice
	 * also have to recursively update any local and global recipes that depend upon this spice
	 * 1. use the recipe_spices table to find any global and local recipes that are dependent upon it
	 * 2. update the recipe(s) recursively
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public SpicesDTO updateSpices(SpicesDTO data) throws Exception {
		Optional<Spices> spicesOptional = spicesRepository.findById(data.getSpiceId());
		if(spicesOptional.isPresent()) {
			if(NO.equals(data.getActv())) {
				checkForDependencies(data.getSpiceId());
			}
			Spices updatedData = data.toEntity();
			updatedData = spicesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getSpiceId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Spices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteSpices(int id) throws Exception {
		Optional<Spices> spicesOptional = spicesRepository.findById(id);
		if(spicesOptional.isPresent()) {
			checkForDependencies(id);
			Spices spice = spicesOptional.get();
			spice.setActv(NO);
			spicesRepository.save(spice);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * delete a Spices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteSpiceRecordForRecipe(int id) throws Exception {
		Optional<Spices> spicesOptional = spicesRepository.findById(id);
		if(spicesOptional.isPresent()) {
			Spices spice = spicesOptional.get();
			spice.setActv(NO);
			spicesRepository.save(spice);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	private void checkForDependencies(int id) throws DependencyExistsException {
		if(checkForFavoriteDependencies(id, null)) {
			throw new DependencyExistsException("A Favorite(s) has been found for this Spice. Delete these " +
					"Favorite(s) before deleting this Spice.");
		}
		if(checkForSpiceDependencies(id)) {
			throw new DependencyExistsException("A Recipe(s) has been found for this Spice. Delete these Recipe(s)" +
					" before deleting this Spice.");
		}
	}

	private boolean checkForFavoriteDependencies(int id, Integer userId) {
		return favoriteSpicesService.checkForFavoriteDependencies(id,userId,false);
	}

	private boolean checkForSpiceDependencies(int id) {
		return recipeSpicesService.checkForGlobalRecipesThatAreDependentUponThisGlobalSpice(id)
				&& localRecipeSpicesService.checkForRecipesThatAreDependentOnAnSpice(id,null,false);
	}

	/**
	 * get List<SpicesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Spices>
	 * @throws Exception
	 */
	public List<SpicesDTO> findSpicesByImageLoc(int id) throws Exception {
		Iterable<Spices> results = spicesRepository.findSpicesByImageLoc(id);
		Iterator<Spices> iter = results.iterator();
		List<SpicesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Spices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public RecipeSpiceDisplay findSpiceDisplayById(int id) throws Exception {
		SpicesDTO spiceInfo = findSpicesById(id);
		RecipeSpiceDisplay displayInfo = convertToDisplayDTO(spiceInfo);
		return displayInfo;
	}

	private RecipeSpiceDisplay convertToDisplayDTO(SpicesDTO spiceInfo) {
		RecipeSpiceDisplay display = new RecipeSpiceDisplay(spiceInfo.getSpiceId(),
				spiceInfo.getSpiceName(),false, BigDecimal.ZERO,null, null);
		return display;
	}
	

	
}
