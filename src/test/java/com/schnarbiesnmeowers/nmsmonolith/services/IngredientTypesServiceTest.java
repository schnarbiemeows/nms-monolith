package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class IngredientTypesServiceTest {


	/**
	 * get all IngredientTypes records
	 * @return
	 * @throws Exception
	 */
	public List<IngredientTypesDTO> getAllIngredientTypes() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<IngredientTypesDTO> ingredienttypesDTO = new ArrayList<IngredientTypesDTO>();
		return ingredienttypesDTO;
	}

	/**
	 * get IngredientTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public IngredientTypesDTO findIngredientTypesById(int id) throws Exception {
		return new IngredientTypesDTO();
	}

	/**
	 * create a new IngredientTypes
	 * @param data
	 * @return
	 */
	public IngredientTypesDTO createIngredientTypes(IngredientTypesDTO data) {
        data.setIngrTypeId(1);
        return data;
	}

	/**
	 * update a IngredientTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public IngredientTypesDTO updateIngredientTypes(IngredientTypesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a IngredientTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteIngredientTypes(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<IngredientTypesDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<IngredientTypes>
	 * @throws Exception
	*/
	public List<IngredientTypesDTO> findIngredientTypesByImageLoc(int id) throws Exception {
		List<IngredientTypesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
