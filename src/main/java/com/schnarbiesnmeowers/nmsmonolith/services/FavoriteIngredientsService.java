package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteBrands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.FavoriteIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteIngredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteIngredientsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class FavoriteIngredientsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteIngredientsRepository favoriteIngredientsRepository;

	/**
	 * get all FavoriteIngredients records
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteIngredientsDTO> getAllFavoriteIngredients() throws Exception {
		Iterable<FavoriteIngredients> favoriteingredients = favoriteIngredientsRepository.findAll();
		Iterator<FavoriteIngredients> favoriteingredientss = favoriteingredients.iterator();
		List<FavoriteIngredientsDTO> favoriteingredientsdto = new ArrayList();
		while(favoriteingredientss.hasNext()) {
			FavoriteIngredients item = favoriteingredientss.next();
			favoriteingredientsdto.add(item.toDTO());
		}
		return favoriteingredientsdto;
	}

	/**
	 * get FavoriteIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public FavoriteIngredientsDTO findFavoriteIngredientsById(int id) throws Exception {
		Optional<FavoriteIngredients> favoriteingredientsOptional = favoriteIngredientsRepository.findById(id);
		if(favoriteingredientsOptional.isPresent()) {
			FavoriteIngredients results = favoriteingredientsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get all of the favorite ingredients for a user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteIngredientsDTO> getFavoriteIngredientsByUserId(int userId) throws Exception {
		Iterable<FavoriteIngredients> ingredients = favoriteIngredientsRepository.findFavoriteIngredientsByUserId(userId);
		Iterator<FavoriteIngredients> ingredientsIterator = ingredients.iterator();
		List<FavoriteIngredientsDTO> ingredientsdto = new ArrayList();
		while(ingredientsIterator.hasNext()) {
			FavoriteIngredients item = ingredientsIterator.next();
			ingredientsdto.add(item.toDTO());
		}
		return ingredientsdto;
	}

	/**
	 * create a new FavoriteIngredients
	 * @param data
	 * @return
	 */
	public FavoriteIngredientsDTO createFavoriteIngredients(FavoriteIngredientsDTO data) {
		try {
		    FavoriteIngredients createdData = data.toEntity();
		    createdData = favoriteIngredientsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteIngredients
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public FavoriteIngredientsDTO updateFavoriteIngredients(FavoriteIngredientsDTO data) throws Exception {
		Optional<FavoriteIngredients> favoriteingredientsOptional = favoriteIngredientsRepository.findById(data.getFavoriteIngredientId());
		if(favoriteingredientsOptional.isPresent()) {
		    FavoriteIngredients updatedData = data.toEntity();
			updatedData = favoriteIngredientsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getFavoriteIngredientId() + NOT_FOUND);
		}
	}

	/**
	 * delete a FavoriteIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteFavoriteIngredients(int id) throws Exception {
		Optional<FavoriteIngredients> favoriteingredientsOptional = favoriteIngredientsRepository.findById(id);
		if(favoriteingredientsOptional.isPresent()) {
			favoriteIngredientsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public boolean checkForFavoriteDependencies(int id, Integer userId, boolean local) {
		if(local) {
			Iterable<FavoriteIngredients> favorites = favoriteIngredientsRepository.findLocalIngredientsInAnyUserFavorites(userId,id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		} else {
			Iterable<FavoriteIngredients> favorites = favoriteIngredientsRepository.findGlobalIngredientsInAnyUserFavorites(id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		}
	}
}
