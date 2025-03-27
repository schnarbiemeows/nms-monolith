package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandMinDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.LocalBrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.entities.LocalBrands;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.NO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LocalBrandsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalBrandsRepository localBrandsRepository;

	@Autowired
	private LocalIngredientsService localIngredientsService;

	@Autowired
	private FavoriteBrandsService favoriteBrandsService;

	/**
	 * get all LocalBrands records
	 * @return
	 * @throws Exception
	 */
	public List<LocalBrandsDTO> getAllLocalBrands() throws Exception {
		Iterable<LocalBrands> localbrands = localBrandsRepository.findAll();
		Iterator<LocalBrands> localbrandss = localbrands.iterator();
		List<LocalBrandsDTO> localbrandsdto = new ArrayList();
		while(localbrandss.hasNext()) {
			LocalBrands item = localbrandss.next();
			localbrandsdto.add(item.toDTO());
		}
		return localbrandsdto;
	}

	/**
	 * get LocalBrands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalBrandsDTO findLocalBrandsById(int id) throws Exception {
		Optional<LocalBrands> localbrandsOptional = localBrandsRepository.findById(id);
		if(localbrandsOptional.isPresent()) {
			LocalBrands results = localbrandsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LocalBrands
	 * @param data
	 * @return
	 */
	public LocalBrandsDTO createLocalBrands(LocalBrandsDTO data) {
		try {
		    LocalBrands createdData = data.toEntity();
		    createdData = localBrandsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalBrands
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalBrandsDTO updateLocalBrands(LocalBrandsDTO data) throws Exception {
		Optional<LocalBrands> localbrandsOptional = localBrandsRepository.findById(data.getBrandId());
		if(localbrandsOptional.isPresent()) {
			if(NO.equals(data.getActv())) {
				checkForDependencies(data.getBrandId(), data.getUserId());
			}
		    LocalBrands updatedData = data.toEntity();
			updatedData = localBrandsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getBrandId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalBrands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalBrands(int id, int userId) throws Exception {
		Optional<LocalBrands> localbrandsOptional = localBrandsRepository.findById(id);
		if(localbrandsOptional.isPresent()) {
			LocalBrands brand = localbrandsOptional.get();
			checkForDependencies(id, userId);
			brand.setActv(NO);
			localBrandsRepository.save(brand);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	private void checkForDependencies(int id, int userId) throws DependencyExistsException {
		if(checkForFavoriteDependencies(id, userId)) {
			throw new DependencyExistsException("A Favorite(s) has been found for this Brand. Delete these Favorites before deleting this Brand.");
		}
		if(checkForLocalIngredientDependencies(id, userId)) {
			throw new DependencyExistsException("An Ingredient(s) has been found for this Brand. Delete these Ingredients before deleting this Brand.");
		}
	}

	private boolean checkForFavoriteDependencies(int id, int userId) {
		return favoriteBrandsService.checkForFavoriteDependencies(id,userId,true);
	}

	private boolean checkForLocalIngredientDependencies(int id, int userId) {
		return localIngredientsService.checkForLocalIngredientDependencies(id,userId);
	}

	/**
	 * get List<LocalBrandsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalBrands>
	 * @throws Exception
	*/
	public List<LocalBrandsDTO> findLocalBrandsByImageLoc(int id) throws Exception {
		Iterable<LocalBrands> results = localBrandsRepository.findLocalBrandsByImageLoc(id);
		Iterator<LocalBrands> iter = results.iterator();
		List<LocalBrandsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalBrands item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public List<BrandMinDTO> getMinimumBrandData(int userId) throws Exception {
		Iterable<LocalBrands> brands = localBrandsRepository.findLocalBrandsByUserId(userId);
		List<BrandMinDTO> minimumData = new ArrayList();
		for(LocalBrands brand : brands) {
			minimumData.add(new BrandMinDTO(brand.getBrandId(),brand.getBrandName()));
		}
		return minimumData;
	}
}
