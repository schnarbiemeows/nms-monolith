package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.Brands;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteBrands;
import com.schnarbiesnmeowers.nmsmonolith.entities.LocalBrands;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.DependencyExistsException;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;
import com.schnarbiesnmeowers.nmsmonolith.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import static com.schnarbiesnmeowers.nmsmonolith.utilities.Constants.NO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BrandsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BrandsRepository brandsRepository;


	@Autowired
	private LocalBrandsRepository localBrandsRepository;

	@Autowired
	private FavoriteBrandsRepository favoriteBrandsRepository;

	@Autowired
	private IngredientsService ingredientsService;

	@Autowired
	private FavoriteBrandsService favoriteBrandsService;
	/**
	 * get all Brands records
	 * @return
	 * @throws Exception
	 */
	public List<BrandsDTO> getAllBrands() throws Exception {
		Iterable<Brands> brands = brandsRepository.findActiveBrands();
		Iterator<Brands> brandss = brands.iterator();
		List<BrandsDTO> brandsdto = new ArrayList();
		while(brandss.hasNext()) {
			Brands item = brandss.next();
			brandsdto.add(item.toDTO());
		}
		return brandsdto;
	}

	public BrandsWrapper getAllBrandDisplays(int userId) throws Exception {
		List<BrandsDTO> globals = this.getAllBrands();
		List<BrandRecordDisplay> globalDisplays = new ArrayList();
		for(BrandsDTO item : globals) {
			globalDisplays.add(item.toDisplayObject());
		}
		List<LocalBrandsDTO> locals = getAllLocalBrands(userId);
		List<BrandRecordDisplay> localDisplays = new ArrayList();
		for(LocalBrandsDTO item : locals) {
			localDisplays.add(item.toDisplayObject());
		}
		List<FavoriteBrandsDTO> favorites = getFavoriteBrands(userId);
		return new BrandsWrapper(globalDisplays,localDisplays,favorites);

	}



	private List<LocalBrandsDTO> getAllLocalBrands(int userId) {
		Iterable<LocalBrands> brands = localBrandsRepository.findLocalBrandsByUserId(userId);
		Iterator<LocalBrands> brandsIterator = brands.iterator();
		List<LocalBrandsDTO> brandsdto = new ArrayList();
		while(brandsIterator.hasNext()) {
			LocalBrands item = brandsIterator.next();
			brandsdto.add(item.toDTO());
		}
		return brandsdto;
	}

	private List<FavoriteBrandsDTO> getFavoriteBrands(int userId) {
		Iterable<FavoriteBrands> brands = favoriteBrandsRepository.findFavoriteBrandsByUserId(userId);
		Iterator<FavoriteBrands> brandsIterator = brands.iterator();
		List<FavoriteBrandsDTO> brandsDTO = new ArrayList();
		while(brandsIterator.hasNext()) {
			FavoriteBrands item = brandsIterator.next();
			brandsDTO.add(item.toDTO());
		}
		return brandsDTO;
	}

	/**
	 * get Brands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BrandsDTO findBrandsById(int id) throws Exception {
		Optional<Brands> brandsOptional = brandsRepository.findById(id);
		if(brandsOptional.isPresent()) {
			Brands results = brandsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get Brands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalBrandsDTO findLocalBrandById(int id) throws Exception {
		Optional<LocalBrands> brandsOptional = localBrandsRepository.findById(id);
		if(brandsOptional.isPresent()) {
			LocalBrands results = brandsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Brands
	 * @param data
	 * @return
	 */
	public BrandsDTO createBrands(BrandsDTO data) {
		try {
		    Brands createdData = data.toEntity();
		    createdData = brandsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Brands
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BrandsDTO updateBrands(BrandsDTO data) throws Exception {
		Optional<Brands> brandsOptional = brandsRepository.findById(data.getBrandId());
		if(brandsOptional.isPresent()) {
			if(NO.equals(data.getActv())) {
				checkForDependencies(data.getBrandId());
			}
			Brands updatedData = data.toEntity();
			updatedData = brandsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getBrandId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Brands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBrands(int id) throws Exception {
		Optional<Brands> brandsOptional = brandsRepository.findById(id);
		if(brandsOptional.isPresent()) {
			checkForDependencies(id);
			Brands brand = brandsOptional.get();
			brand.setActv(NO);
			brandsRepository.save(brand);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	private void checkForDependencies(int id) throws DependencyExistsException {
		if(checkForFavoriteDependencies(id)) {
			throw new DependencyExistsException("A Favorite(s) has been found for this Brand. Delete these Favorites before deleting this Brand.");
		}
		if(checkForIngredientDependencies(id)) {
			throw new DependencyExistsException("An Ingredient(s) has been found for this Brand. Delete these Ingredients before deleting this Brand.");
		}
	}

	private boolean checkForFavoriteDependencies(int id) {
		return favoriteBrandsService.checkForFavoriteDependencies(id,null,false);
	}

	private boolean checkForIngredientDependencies(int id) {
		return ingredientsService.checkForGlobalIngredientDependencies(id);
	}

	/**
	 * get List<BrandsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Brands>
	 * @throws Exception
	*/
	public List<BrandsDTO> findBrandsByImageLoc(int id) throws Exception {
		Iterable<Brands> results = brandsRepository.findBrandsByImageLoc(id);
		Iterator<Brands> iter = results.iterator();
		List<BrandsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Brands item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

    public List<BrandMinDTO> getMinimumBrandData() throws Exception {
		List<BrandsDTO> brands = getAllBrands();
		List<BrandMinDTO> minimumData = new ArrayList();
		for(BrandsDTO brand : brands) {
			minimumData.add(new BrandMinDTO(brand.getBrandId(),brand.getBrandName()));
		}
		return minimumData;
    }
}
