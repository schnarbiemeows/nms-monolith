package com.schnarbiesnmeowers.nmsmonolith.services;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeSpiceDisplay;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.entities.LocalSpices;
import com.schnarbiesnmeowers.nmsmonolith.utilities.RecipeCalculatorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalSpicesRepository;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.NO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LocalSpicesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalSpicesRepository localSpicesRepository;

	@Autowired
	private LocalRecipesService localRecipesService;

	@Autowired
	private LocalRecipeSpicesService localRecipeSpicesService;

	@Autowired
	private FavoriteSpicesService favoriteSpicesService;

	@Autowired
	RecipeCalculatorUtility recipeCalculatorUtility;

	@Autowired
	ServingTypesService servingTypesService;
	
	/**
	 * get all LocalSpices records
	 * @return
	 * @throws Exception
	 */
	public List<LocalSpicesDTO> getAllLocalSpices() throws Exception {
		Iterable<LocalSpices> localspices = localSpicesRepository.findAll();
		Iterator<LocalSpices> localspicess = localspices.iterator();
		List<LocalSpicesDTO> localspicesdto = new ArrayList();
		while(localspicess.hasNext()) {
			LocalSpices item = localspicess.next();
			localspicesdto.add(item.toDTO());
		}
		return localspicesdto;
	}

	/**
	 * get LocalSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalSpicesDTO findLocalSpicesById(int id) throws Exception {
		Optional<LocalSpices> localspicesOptional = localSpicesRepository.findById(id);
		if(localspicesOptional.isPresent()) {
			LocalSpices results = localspicesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LocalSpices
	 * @param data
	 * @return
	 */
	public LocalSpicesDTO createLocalSpices(LocalSpicesDTO data) {
		try {
		    LocalSpices createdData = data.toEntity();
		    createdData = localSpicesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalSpices
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalSpicesDTO updateLocalSpices(LocalSpicesDTO data) throws Exception {
		Optional<LocalSpices> localspicesOptional = localSpicesRepository.findById(data.getSpiceId());
		if(localspicesOptional.isPresent()) {
			if(NO.equals(data.getActv())) {
				checkForDependencies(data.getSpiceId(), data.getUserId());
			}
		    LocalSpices updatedData = data.toEntity();
			updatedData = localSpicesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getSpiceId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalSpices(int id, int userId) throws Exception {
		Optional<LocalSpices> localspicesOptional = localSpicesRepository.findById(id);
		if(localspicesOptional.isPresent()) {
			LocalSpices spice = localspicesOptional.get();
			checkForDependencies(id, userId);
			spice.setActv(NO);
			localSpicesRepository.save(spice);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalSpiceRecordForRecipe(int id, int userId) throws Exception {
		Optional<LocalSpices> localspicesOptional = localSpicesRepository.findById(id);
		if(localspicesOptional.isPresent()) {
			LocalSpices spice = localspicesOptional.get();
			spice.setActv(NO);
			localSpicesRepository.save(spice);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}
	
	private void checkForDependencies(int id, int userId) throws DependencyExistsException {
		if(checkForFavoriteDependencies(id, userId)) {
			throw new DependencyExistsException("A Favorite(s) has been found for this Spice. Delete these " +
					"Favorite(s) before deleting this Spice.");
		}
		if(checkForLocalRecipeDependencies(id, userId)) {
			throw new DependencyExistsException("A Recipe(s) has been found for this Spice. Delete these Recipe(s) " +
					"before deleting this Spice.");
		}
	}

	private boolean checkForFavoriteDependencies(int id, int userId) {
		return favoriteSpicesService.checkForFavoriteDependencies(id,userId,true);
	}

	private boolean checkForLocalRecipeDependencies(int id, int userId) {
		return localRecipeSpicesService.checkForRecipesThatAreDependentOnAnSpice(id,userId, true);
	}

	public RecipeSpiceDisplay findLocalSpiceDisplayById(int id) throws Exception {
		LocalSpicesDTO spiceInfo = findLocalSpicesById(id);
		RecipeSpiceDisplay displayInfo = convertToDisplayDTO(spiceInfo);
		return displayInfo;
	}

	public RecipeSpiceDisplay convertToDisplayDTO(LocalSpicesDTO spiceInfo) {
		RecipeSpiceDisplay display = new RecipeSpiceDisplay(spiceInfo.getSpiceId(),
				spiceInfo.getSpiceName(),true, BigDecimal.ZERO,null, null);
		return display;
	}
	/**
	 * get List<LocalSpicesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalSpices>
	 * @throws Exception
	*/
	public List<LocalSpicesDTO> findLocalSpicesByImageLoc(int id) throws Exception {
		Iterable<LocalSpices> results = localSpicesRepository.findLocalSpicesByImageLoc(id);
		Iterator<LocalSpices> iter = results.iterator();
		List<LocalSpicesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalSpices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
