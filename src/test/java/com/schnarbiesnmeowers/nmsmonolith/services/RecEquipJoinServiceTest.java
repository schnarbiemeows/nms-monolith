package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEquipJoinDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecEquipJoinServiceTest {


	/**
	 * get all RecEquipJoin records
	 * @return
	 * @throws Exception
	 */
	public List<RecEquipJoinDTO> getAllRecEquipJoin() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RecEquipJoinDTO> recequipjoinDTO = new ArrayList<RecEquipJoinDTO>();
		return recequipjoinDTO;
	}

	/**
	 * get RecEquipJoin by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecEquipJoinDTO findRecEquipJoinById(int id) throws Exception {
		return new RecEquipJoinDTO();
	}

	/**
	 * create a new RecEquipJoin
	 * @param data
	 * @return
	 */
	public RecEquipJoinDTO createRecEquipJoin(RecEquipJoinDTO data) {
        data.setRecEquipJoinId(1);
        return data;
	}

	/**
	 * update a RecEquipJoin
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecEquipJoinDTO updateRecEquipJoin(RecEquipJoinDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RecEquipJoin by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecEquipJoin(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : recipeId
	 * @param id
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	public List<RecEquipJoinDTO> findRecEquipJoinByRecipeId(int id) throws Exception {
		List<RecEquipJoinDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : recipeEquipId
	 * @param id
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	public List<RecEquipJoinDTO> findRecEquipJoinByRecipeEquipId(int id) throws Exception {
		List<RecEquipJoinDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : RecipeIdAndRecipeEquipId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<RecEquipJoinDTO> findRecEquipJoinByRecipeIdAndRecipeEquipId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<RecEquipJoinDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
