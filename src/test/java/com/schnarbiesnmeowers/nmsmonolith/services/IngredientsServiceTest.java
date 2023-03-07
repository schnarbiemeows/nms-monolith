package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class IngredientsServiceTest {


	/**
	 * get all Ingredients records
	 * @return
	 * @throws Exception
	 */
	public List<IngredientsDTO> getAllIngredients() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<IngredientsDTO> ingredientsDTO = new ArrayList<IngredientsDTO>();
		return ingredientsDTO;
	}

	/**
	 * get Ingredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IngredientsDTO findIngredientsById(int id) throws Exception {
		return new IngredientsDTO();
	}

	/**
	 * create a new Ingredients
	 * @param data
	 * @return
	 */
	public IngredientsDTO createIngredients(IngredientsDTO data) {
        data.setIngrId(1);
        return data;
	}

	/**
	 * update a Ingredients
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public IngredientsDTO updateIngredients(IngredientsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Ingredients by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteIngredients(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<IngredientsDTO> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByIngrTypeId(int id) throws Exception {
		List<IngredientsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : brandId
	 * @param brandId
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByBrandId(int id) throws Exception {
		List<IngredientsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : servTypeId
	 * @param servTypeId
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByServTypeId(int id) throws Exception {
		List<IngredientsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByImageLoc(int id) throws Exception {
		List<IngredientsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<IngredientsDTO> by foreign key : IngrTypeIdAndBrandIdAndServTypeIdAndImageLoc
	 * @param IngrTypeIdAndBrandIdAndServTypeIdAndImageLoc
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	public List<IngredientsDTO> findIngredientsByIngrTypeIdAndBrandIdAndServTypeIdAndImageLoc(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2,@PathVariable int id3) throws Exception {
		List<IngredientsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
