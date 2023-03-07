package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalRecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipeIngredients;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LocalRecipeIngredientsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LocalRecipeIngredientsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipeIngredientsRepository localRecipeIngredientsRepository;

	@Autowired
	private RecipeIngredientsService recipeIngredientsService;

	/**
	 * get all LocalRecipeIngredients records
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeIngredientsDTO> getAllLocalRecipeIngredients() throws Exception {
		Iterable<LocalRecipeIngredients> localrecipeingredients = localRecipeIngredientsRepository.findAll();
		Iterator<LocalRecipeIngredients> localrecipeingredientss = localrecipeingredients.iterator();
		List<LocalRecipeIngredientsDTO> localrecipeingredientsdto = new ArrayList();
		while(localrecipeingredientss.hasNext()) {
			LocalRecipeIngredients item = localrecipeingredientss.next();
			localrecipeingredientsdto.add(item.toDTO());
		}
		return localrecipeingredientsdto;
	}

	/**
	 * get LocalRecipeIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LocalRecipeIngredientsDTO findLocalRecipeIngredientsById(int id) throws Exception {
		Optional<LocalRecipeIngredients> localrecipeingredientsOptional = localRecipeIngredientsRepository.findById(id);
		if(localrecipeingredientsOptional.isPresent()) {
			LocalRecipeIngredients results = localrecipeingredientsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LocalRecipeIngredients
	 * @param data
	 * @return
	 */
	public LocalRecipeIngredientsDTO createLocalRecipeIngredients(LocalRecipeIngredientsDTO data) {
		try {
		    LocalRecipeIngredients createdData = data.toEntity();
		    createdData = localRecipeIngredientsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipeIngredients
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LocalRecipeIngredientsDTO updateLocalRecipeIngredients(LocalRecipeIngredientsDTO data) throws Exception {
		Optional<LocalRecipeIngredients> localrecipeingredientsOptional = localRecipeIngredientsRepository.findById(data.getRecipeIngrId());
		if(localrecipeingredientsOptional.isPresent()) {
		    LocalRecipeIngredients updatedData = data.toEntity();
			updatedData = localRecipeIngredientsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeIngrId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LocalRecipeIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLocalRecipeIngredients(int id) throws Exception {
		Optional<LocalRecipeIngredients> localrecipeingredientsOptional = localRecipeIngredientsRepository.findById(id);
		if(localrecipeingredientsOptional.isPresent()) {
			localRecipeIngredientsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	public boolean checkForRecipesThatAreDependentOnAnIngredient(int id, boolean local) {
		if(local) {
			Iterable<LocalRecipeIngredients> dependencies = localRecipeIngredientsRepository
					.findLocalRecipesThatAreDependentUponGivenLocalIngredient(id);
			if(null!=dependencies&&dependencies.iterator().hasNext()) {
				return true;
			}
			return false;
		} else {
			Iterable<LocalRecipeIngredients> dependencies = localRecipeIngredientsRepository
					.findLocalRecipesThatAreDependentUponGivenGlobalIngredient(id);
			if(null!=dependencies&&dependencies.iterator().hasNext()) {
				return true;
			}
			return false;
		}
	}

	/**
	 * BECAUSE RECIPE_ID pk'S ARE UNIQUE WITHIN LOCAL_RECIPES, THERE IS NO NEED TO USE THE USER_ID
	 * IN THIS SEARCH
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeIngredientsDTO> findRecipeIngredientsByRecipeId(int id) throws Exception {
		Iterable<LocalRecipeIngredients> results =
				localRecipeIngredientsRepository.findLocalRecipeIngredientsByRecipeId(id);
		Iterator<LocalRecipeIngredients> iter = results.iterator();
		List<LocalRecipeIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public int deleteRecipeIngredientsForaLocalRecipe(int id, int userId) throws Exception {
		int result = localRecipeIngredientsRepository.deleteRecipeIngredientsByRecipeIdAndUserId(id, userId);
		return result;
	}

	/**
	 * BECAUSE RECIPE_ID pk'S ARE UNIQUE WITHIN LOCAL_RECIPES, THERE IS NO NEED TO USE THE USER_ID
	 * IN THIS SEARCH
	 * this method will find local recipes that are dependent on a given local recipe
	 * but only for a given user(this is OK, because local recipes are only relevant for a given user)
	 * @param id
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeIngredientsDTO>
	findLocalRecipesThatAreDependentOnThisLocalRecipe(int id) throws Exception {
		Iterable<LocalRecipeIngredients> results =
				localRecipeIngredientsRepository.findLocalRecipesThatAreDependentUponGivenLocalRecipe(id);
		Iterator<LocalRecipeIngredients> iter = results.iterator();
		List<LocalRecipeIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * this method will find local recipes that are dependent on a given Global recipe
	 * (need to check across all users)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeIngredientsDTO>
	findLocalRecipesThatAreDependentUponGivenGlobalRecipe(int id) {
		Iterable<LocalRecipeIngredients> results =
				localRecipeIngredientsRepository.findLocalRecipesThatAreDependentUponGivenGlobalRecipe(id);
		Iterator<LocalRecipeIngredients> iter = results.iterator();
		List<LocalRecipeIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * this method will find local recipes that are dependent on a given Global recipe
	 * (need to check across all users)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeIngredientsDTO>
	findLocalRecipesThatAreDependentUponGivenGlobalIngredient(int id) {
		Iterable<LocalRecipeIngredients> results =
				localRecipeIngredientsRepository.findLocalRecipesThatAreDependentUponGivenGlobalIngredient(id);
		Iterator<LocalRecipeIngredients> iter = results.iterator();
		List<LocalRecipeIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * this method will find local recipes that are dependent on a given Global recipe
	 * (need to check across all users)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<LocalRecipeIngredientsDTO>
	findLocalRecipesThatAreDependentUponGivenLocalIngredient(int id) {
		Iterable<LocalRecipeIngredients> results =
				localRecipeIngredientsRepository.findLocalRecipesThatAreDependentUponGivenLocalIngredient(id);
		Iterator<LocalRecipeIngredients> iter = results.iterator();
		List<LocalRecipeIngredientsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			LocalRecipeIngredients item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}
}
