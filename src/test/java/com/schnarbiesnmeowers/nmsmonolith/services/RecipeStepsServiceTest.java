package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeStepsServiceTest {


	/**
	 * get all RecipeSteps records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeStepsDTO> getAllRecipeSteps() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RecipeStepsDTO> recipestepsDTO = new ArrayList<RecipeStepsDTO>();
		return recipestepsDTO;
	}

	/**
	 * get RecipeSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeStepsDTO findRecipeStepsById(int id) throws Exception {
		return new RecipeStepsDTO();
	}

	/**
	 * create a new RecipeSteps
	 * @param data
	 * @return
	 */
	public RecipeStepsDTO createRecipeSteps(RecipeStepsDTO data) {
        data.setRecipeStepId(1);
        return data;
	}

	/**
	 * update a RecipeSteps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeStepsDTO updateRecipeSteps(RecipeStepsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RecipeSteps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeSteps(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : recipeId
	 * @param id
	 * @return List<RecipeSteps>
	 * @throws Exception
	*/
	public List<RecipeStepsDTO> findRecipeStepsByRecipeId(int id) throws Exception {
		List<RecipeStepsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<RecipeSteps>
	 * @throws Exception
	*/
	public List<RecipeStepsDTO> findRecipeStepsByImageLoc(int id) throws Exception {
		List<RecipeStepsDTO> resultsdto = new ArrayList();
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
		List<RecipeStepsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
