package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeEquipDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecipeEquipServiceTest {


	/**
	 * get all RecipeEquip records
	 * @return
	 * @throws Exception
	 */
	public List<RecipeEquipDTO> getAllRecipeEquip() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RecipeEquipDTO> recipeequipDTO = new ArrayList<RecipeEquipDTO>();
		return recipeequipDTO;
	}

	/**
	 * get RecipeEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecipeEquipDTO findRecipeEquipById(int id) throws Exception {
		return new RecipeEquipDTO();
	}

	/**
	 * create a new RecipeEquip
	 * @param data
	 * @return
	 */
	public RecipeEquipDTO createRecipeEquip(RecipeEquipDTO data) {
        data.setRecipeEquipId(1);
        return data;
	}

	/**
	 * update a RecipeEquip
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecipeEquipDTO updateRecipeEquip(RecipeEquipDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RecipeEquip by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecipeEquip(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : recEqTypeId
	 * @param id
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	public List<RecipeEquipDTO> findRecipeEquipByRecEqTypeId(int id) throws Exception {
		List<RecipeEquipDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	public List<RecipeEquipDTO> findRecipeEquipByImageLoc(int id) throws Exception {
		List<RecipeEquipDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : RecEqTypeIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<RecipeEquipDTO> findRecipeEquipByRecEqTypeIdAndImageLoc(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<RecipeEquipDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
