package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeSpices;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeSpices;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeSpicesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeSpicesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeSpicesRepository recipeSpicesRepository;

	/**
	 * get all RecipeSpices records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeSpicesDTO> getAllRecipeSpices() throws Exception {
		Iterable<RecipeSpices> recipespices = recipeSpicesRepository.findAll();
		Iterator<RecipeSpices> recipespicess = recipespices.iterator();
		List<RecipeSpicesDTO> recipespicesdto = new ArrayList();
		while(recipespicess.hasNext()) {
			RecipeSpices item = recipespicess.next();
			recipespicesdto.add(item.toDTO());
		}
		return recipespicesdto;
	}

	/**
	 * get RecipeSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeSpicesDTO findRecipeSpicesById(int id) throws Exception {
		Optional<RecipeSpices> recipespicesOptional = recipeSpicesRepository.findById(id);
		if(recipespicesOptional.isPresent()) {
			RecipeSpices results = recipespicesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RecipeSpices
	 * @param data
	 * @return
	 */
	public RecipeSpicesDTO createRecipeSpices(RecipeSpicesDTO data) {
		try {
		    RecipeSpices createdData = data.toEntity();
		    createdData = recipeSpicesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeSpices
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeSpicesDTO updateRecipeSpices(RecipeSpicesDTO data) throws Exception {
		Optional<RecipeSpices> recipespicesOptional = recipeSpicesRepository.findById(data.getRecipeSpiceId());
		if(recipespicesOptional.isPresent()) {
		    RecipeSpices updatedData = data.toEntity();
			updatedData = recipeSpicesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeSpiceId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RecipeSpices by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeSpices(int id) throws Exception {
		Optional<RecipeSpices> recipespicesOptional = recipeSpicesRepository.findById(id);
		if(recipespicesOptional.isPresent()) {
			recipeSpicesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RecipeSpicesDTO> by foreign key : spiceId
	 * @param id
	 * @return List<RecipeSpices>
	 * @throws Exception
	*/
	public List<RecipeSpicesDTO> findRecipeSpicesBySpiceId(int id) throws Exception {
		Iterable<RecipeSpices> results = recipeSpicesRepository.findRecipeSpicesBySpiceId(id);
		Iterator<RecipeSpices> iter = results.iterator();
		List<RecipeSpicesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeSpices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}


	public List<RecipeSpicesDTO> findRecipeSpicesByRecipeId(int id) throws Exception {
		Iterable<RecipeSpices> results = recipeSpicesRepository.findRecipeSpicesByRecipeId(id);
		Iterator<RecipeSpices> iter = results.iterator();
		List<RecipeSpicesDTO> resultsdto = new ArrayList();
		while (iter.hasNext()) {
			RecipeSpices item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public int deleteRecipeSpicesForaGlobalRecipe(int id) throws Exception {
		int result = recipeSpicesRepository.deleteRecipeSpicesByRecipeId(id);
		return result;
	}

	public boolean checkForGlobalRecipesThatAreDependentUponThisGlobalSpice(int spiceId) {
		Iterable<RecipeSpices> dependencies = recipeSpicesRepository
				.findGlobalRecipesThatAreDependentUponThisGlobalSpice(spiceId);
		if (dependencies != null && dependencies.iterator().hasNext()) {
			return true;
		}
		return false;
	}

}
