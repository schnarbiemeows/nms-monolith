package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeIngredientsServiceTest {


	/**
	 * get all RecipeIngredients records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeIngredientsDTO> getAllRecipeIngredients() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RecipeIngredientsDTO> recipeingredientsDTO = new ArrayList<RecipeIngredientsDTO>();
		return recipeingredientsDTO;
	}

	/**
	 * get RecipeIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeIngredientsDTO findRecipeIngredientsById(int id) throws Exception {
		return new RecipeIngredientsDTO();
	}

	/**
	 * create a new RecipeIngredients
	 * @param data
	 * @return
	 */
	public RecipeIngredientsDTO createRecipeIngredients(RecipeIngredientsDTO data) {
        data.setRecipeIngrId(1);
        return data;
	}

	/**
	 * update a RecipeIngredients
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeIngredientsDTO updateRecipeIngredients(RecipeIngredientsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RecipeIngredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeIngredients(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RecipeIngredientsDTO> by foreign key : recipeId
	 * @param id
	 * @return List<RecipeIngredients>
	 * @throws Exception
	*/
	public List<RecipeIngredientsDTO> findRecipeIngredientsByRecipeId(int id) throws Exception {
		List<RecipeIngredientsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
