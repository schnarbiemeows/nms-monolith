package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteSpices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteSpices;
import com.schnarbiesnmeowers.nmsmonolith.repositories.FavoriteSpicesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class FavoriteSpicesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteSpicesRepository favoriteSpicesRepository;

	/**
	 * get all FavoriteSpices records
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteSpicesDTO> getAllFavoriteSpices() throws Exception {
		Iterable<FavoriteSpices> favoritespices = favoriteSpicesRepository.findAll();
		Iterator<FavoriteSpices> favoritespicess = favoritespices.iterator();
		List<FavoriteSpicesDTO> favoritespicesdto = new ArrayList();
		while(favoritespicess.hasNext()) {
			FavoriteSpices item = favoritespicess.next();
			favoritespicesdto.add(item.toDTO());
		}
		return favoritespicesdto;
	}

	/**
	 * get FavoriteSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public FavoriteSpicesDTO findFavoriteSpicesById(int id) throws Exception {
		Optional<FavoriteSpices> favoritespicesOptional = favoriteSpicesRepository.findById(id);
		if(favoritespicesOptional.isPresent()) {
			FavoriteSpices results = favoritespicesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get all of the favorite spices for a user
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<FavoriteSpicesDTO> getFavoriteSpicesByUserId(int userId) throws Exception {
		Iterable<FavoriteSpices> spices = favoriteSpicesRepository.findFavoriteSpicesByUserId(userId);
		Iterator<FavoriteSpices> spicesIterator = spices.iterator();
		List<FavoriteSpicesDTO> spicesdto = new ArrayList();
		while(spicesIterator.hasNext()) {
			FavoriteSpices item = spicesIterator.next();
			spicesdto.add(item.toDTO());
		}
		return spicesdto;
	}
	
	/**
	 * create a new FavoriteSpices
	 * @param data
	 * @return
	 */
	public FavoriteSpicesDTO createFavoriteSpices(FavoriteSpicesDTO data) {
		try {
		    FavoriteSpices createdData = data.toEntity();
		    createdData = favoriteSpicesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteSpices
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public FavoriteSpicesDTO updateFavoriteSpices(FavoriteSpicesDTO data) throws Exception {
		Optional<FavoriteSpices> favoritespicesOptional = favoriteSpicesRepository.findById(data.getFavoriteSpiceId());
		if(favoritespicesOptional.isPresent()) {
		    FavoriteSpices updatedData = data.toEntity();
			updatedData = favoriteSpicesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getFavoriteSpiceId() + NOT_FOUND);
		}
	}

	/**
	 * delete a FavoriteSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteFavoriteSpices(int id) throws Exception {
		Optional<FavoriteSpices> favoritespicesOptional = favoriteSpicesRepository.findById(id);
		if(favoritespicesOptional.isPresent()) {
			favoriteSpicesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public boolean checkForFavoriteDependencies(int id, Integer userId, boolean local) {
		if(local) {
			Iterable<FavoriteSpices> favorites = favoriteSpicesRepository.findLocalSpicesInAnyUserFavorites(userId,id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		} else {
			Iterable<FavoriteSpices> favorites = favoriteSpicesRepository.findGlobalSpicesInAnyUserFavorites(id);
			if(favorites!=null&&favorites.iterator().hasNext()) {
				return true;
			}
			return false;
		}
	}
}
