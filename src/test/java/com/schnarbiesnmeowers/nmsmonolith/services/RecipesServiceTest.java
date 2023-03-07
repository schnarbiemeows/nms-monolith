package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipesServiceTest {


	/**
	 * get all Recipes records
	 * @return
	 * @throws Exception
	 */
	public List<RecipesDTO> getAllRecipes() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RecipesDTO> recipesDTO = new ArrayList<RecipesDTO>();
		return recipesDTO;
	}

	/**
	 * get Recipes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipesDTO findRecipesById(int id) throws Exception {
		return new RecipesDTO();
	}

	/**
	 * create a new Recipes
	 * @param data
	 * @return
	 */
	public RecipesDTO createRecipes(RecipesDTO data) {
        data.setRecipeId(1);
        return data;
	}

	/**
	 * update a Recipes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipesDTO updateRecipes(RecipesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Recipes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipes(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RecipesDTO> by foreign key : ingrId
	 * @param ingrId
	 * @return List<Recipes>
	 * @throws Exception
	*/
	public List<RecipesDTO> findRecipesByIngrId(int id) throws Exception {
		List<RecipesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
