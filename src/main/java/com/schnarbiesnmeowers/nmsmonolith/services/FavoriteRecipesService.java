package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteIngredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.FavoriteRecipesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteRecipes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteRecipesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class FavoriteRecipesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteRecipesRepository favoriteRecipesRepository;

	/**
	 * get all FavoriteRecipes records
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteRecipesDTO> getAllFavoriteRecipes() throws Exception {
		Iterable<FavoriteRecipes> favoriterecipes = favoriteRecipesRepository.findAll();
		Iterator<FavoriteRecipes> favoriterecipess = favoriterecipes.iterator();
		List<FavoriteRecipesDTO> favoriterecipesdto = new ArrayList();
		while(favoriterecipess.hasNext()) {
			FavoriteRecipes item = favoriterecipess.next();
			favoriterecipesdto.add(item.toDTO());
		}
		return favoriterecipesdto;
	}

	/**
	 * get FavoriteRecipes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public FavoriteRecipesDTO findFavoriteRecipesById(int id) throws Exception {
		Optional<FavoriteRecipes> favoriterecipesOptional = favoriteRecipesRepository.findById(id);
		if(favoriterecipesOptional.isPresent()) {
			FavoriteRecipes results = favoriterecipesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new FavoriteRecipes
	 * @param data
	 * @return
	 */
	public FavoriteRecipesDTO createFavoriteRecipes(FavoriteRecipesDTO data) {
		try {
		    FavoriteRecipes createdData = data.toEntity();
		    createdData = favoriteRecipesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteRecipes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public FavoriteRecipesDTO updateFavoriteRecipes(FavoriteRecipesDTO data) throws Exception {
		Optional<FavoriteRecipes> favoriterecipesOptional = favoriteRecipesRepository.findById(data.getFavoriteRecipeId());
		if(favoriterecipesOptional.isPresent()) {
		    FavoriteRecipes updatedData = data.toEntity();
			updatedData = favoriteRecipesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getFavoriteRecipeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a FavoriteRecipes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteFavoriteRecipes(int id) throws Exception {
		Optional<FavoriteRecipes> favoriterecipesOptional = favoriteRecipesRepository.findById(id);
		if(favoriterecipesOptional.isPresent()) {
			favoriteRecipesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public boolean checkForFavoriteDependencies(int id, Integer userId, boolean local) {
		if(local) {
			Iterable<FavoriteRecipes> favorites = favoriteRecipesRepository.findLocalRecipesInAnyUserFavorites(userId,id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		} else {
			Iterable<FavoriteRecipes> favorites = favoriteRecipesRepository.findGlobalRecipesInAnyUserFavorites(id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		}
	}
}
