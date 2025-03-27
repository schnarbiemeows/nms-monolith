package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.FavoriteBrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteBrands;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteBrandsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class FavoriteBrandsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteBrandsRepository favoriteBrandsRepository;

	/**
	 * get all FavoriteBrands records
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteBrandsDTO> getAllFavoriteBrands() throws Exception {
		Iterable<FavoriteBrands> favoritebrands = favoriteBrandsRepository.findAll();
		Iterator<FavoriteBrands> favoritebrandss = favoritebrands.iterator();
		List<FavoriteBrandsDTO> favoritebrandsdto = new ArrayList();
		while(favoritebrandss.hasNext()) {
			FavoriteBrands item = favoritebrandss.next();
			favoritebrandsdto.add(item.toDTO());
		}
		return favoritebrandsdto;
	}

	/**
	 * get FavoriteBrands by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public FavoriteBrandsDTO findFavoriteBrandsById(int id) throws Exception {
		Optional<FavoriteBrands> favoritebrandsOptional = favoriteBrandsRepository.findById(id);
		if(favoritebrandsOptional.isPresent()) {
			FavoriteBrands results = favoritebrandsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new FavoriteBrands
	 * NOTE: this will first check to see if there is an inactive favorite that may have
	 * previously been there and will then just activate it
	 * @param data
	 * @return
	 */
	public FavoriteBrandsDTO createFavoriteBrands(FavoriteBrandsDTO data) throws Exception {
		try {
			Iterable<FavoriteBrands> favorites = favoriteBrandsRepository.findInactiveFavoriteBrandsByUserIdAndBrandId(data.getUserId(),
					data.getBrandId());
			if(favorites!=null&&favorites.iterator().hasNext()) {
				FavoriteBrands favorite = favorites.iterator().next();
				favorite.setActv("Y");
				FavoriteBrandsDTO dto = favorite.toDTO();
				this.updateFavoriteBrands(dto);
				return dto;
			}
		    FavoriteBrands createdData = data.toEntity();
		    createdData = favoriteBrandsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteBrands
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public FavoriteBrandsDTO updateFavoriteBrands(FavoriteBrandsDTO data) throws Exception {
		Optional<FavoriteBrands> favoritebrandsOptional = favoriteBrandsRepository.findById(data.getFavoriteBrandId());
		if(favoritebrandsOptional.isPresent()) {
		    FavoriteBrands updatedData = data.toEntity();
			updatedData = favoriteBrandsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getFavoriteBrandId() + NOT_FOUND);
		}
	}

	/**
	 * delete a FavoriteBrands by primary key
	 * NOTE: this will not actually delete the favorite, just inactivate it
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteFavoriteBrands(int id) throws Exception {
		Optional<FavoriteBrands> favoritebrandsOptional = favoriteBrandsRepository.findById(id);
		if(favoritebrandsOptional.isPresent()) {
			FavoriteBrands favorite = favoritebrandsOptional.get();
			favorite.setActv("N");
			FavoriteBrandsDTO dto = favorite.toDTO();
			this.updateFavoriteBrands(dto);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public String deleteFavoriteByUserIdandBrandId(int userId, int brandId) throws Exception {
		Iterable<FavoriteBrands> favorites = favoriteBrandsRepository.findFavoriteBrandsByUserIdAndBrandId(userId, brandId);
		if(favorites!=null&&favorites.iterator().hasNext()) {
			FavoriteBrands favorite = favorites.iterator().next();
			favorite.setActv("N");
			FavoriteBrandsDTO dto = favorite.toDTO();
			this.updateFavoriteBrands(dto);
			return "Successfully Deleted";
		}
		return "no record found!";
	}

	public boolean checkForFavoriteDependencies(int id, Integer userId, boolean local) {
		if(local) {
			Iterable<FavoriteBrands> favorites = favoriteBrandsRepository.findLocalFavoriteBrandsByUserIdAndBrandId(userId,id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		} else {
			Iterable<FavoriteBrands> favorites = favoriteBrandsRepository.findGlobalFavoriteBrandsByBrandId(id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		}

	}
}
