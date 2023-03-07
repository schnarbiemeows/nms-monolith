package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeSteps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeStepsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeStepsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeStepsRepository recipeStepsRepository;

	/**
	 * get all RecipeSteps records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeStepsDTO> getAllRecipeSteps() throws Exception {
		Iterable<RecipeSteps> recipesteps = recipeStepsRepository.findAll();
		Iterator<RecipeSteps> recipestepss = recipesteps.iterator();
		List<RecipeStepsDTO> recipestepsdto = new ArrayList();
		while(recipestepss.hasNext()) {
			RecipeSteps item = recipestepss.next();
			recipestepsdto.add(item.toDTO());
		}
		return recipestepsdto;
	}

	/**
	 * get RecipeSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeStepsDTO findRecipeStepsById(int id) throws Exception {
		Optional<RecipeSteps> recipestepsOptional = recipeStepsRepository.findById(id);
		if(recipestepsOptional.isPresent()) {
			RecipeSteps results = recipestepsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new RecipeSteps
	 * @param data
	 * @return
	 */
	public RecipeStepsDTO createRecipeSteps(RecipeStepsDTO data) {
		try {
		    RecipeSteps createdData = data.toEntity();
		    createdData = recipeStepsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeSteps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeStepsDTO updateRecipeSteps(RecipeStepsDTO data) throws Exception {
		Optional<RecipeSteps> recipestepsOptional = recipeStepsRepository.findById(data.getRecipeStepId());
		if(recipestepsOptional.isPresent()) {
		    RecipeSteps updatedData = data.toEntity();
			updatedData = recipeStepsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getRecipeStepId() + NOT_FOUND);
		}
	}

	/**
	 * delete a RecipeSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeSteps(int id) throws Exception {
		Optional<RecipeSteps> recipestepsOptional = recipeStepsRepository.findById(id);
		if(recipestepsOptional.isPresent()) {
			recipeStepsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : recipeId
	 * @param id
	 * @return List<RecipeSteps>
	 * @throws Exception
	*/
	public List<RecipeStepsDTO> findRecipeStepsByRecipeId(int id) throws Exception {
		Iterable<RecipeSteps> results = recipeStepsRepository.findRecipeStepsByRecipeId(id);
		Iterator<RecipeSteps> iter = results.iterator();
		List<RecipeStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : imageLoc
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<RecipeStepsDTO> findRecipeStepsByImageLoc(int id) throws Exception {
		Iterable<RecipeSteps> results = recipeStepsRepository.findRecipeStepsByImageLoc(id);
		Iterator<RecipeSteps> iter = results.iterator();
		List<RecipeStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : RecipeIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<RecipeStepsDTO> findRecipeStepsByRecipeIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<RecipeSteps> results = recipeStepsRepository.findRecipeStepsByRecipeIdAndImageLoc(id0, id1);
		Iterator<RecipeSteps> iter = results.iterator();
		List<RecipeStepsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			RecipeSteps item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public int deleteRecipeStepsForaGlobalRecipe(int id) throws Exception {
		int result = recipeStepsRepository.deleteRecipeStepsByRecipeId(id);
		return result;
	}
}
