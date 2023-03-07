package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ServingTypesServiceTest {


	/**
	 * get all ServingTypes records
	 * @return
	 * @throws Exception
	 */
	public List<ServingTypesDTO> getAllServingTypes() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<ServingTypesDTO> servingtypesDTO = new ArrayList<ServingTypesDTO>();
		return servingtypesDTO;
	}

	/**
	 * get ServingTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ServingTypesDTO findServingTypesById(int id) throws Exception {
		return new ServingTypesDTO();
	}

	/**
	 * create a new ServingTypes
	 * @param data
	 * @return
	 */
	public ServingTypesDTO createServingTypes(ServingTypesDTO data) {
        data.setServTypeId(1);
        return data;
	}

	/**
	 * update a ServingTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ServingTypesDTO updateServingTypes(ServingTypesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a ServingTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteServingTypes(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<ServingTypesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<ServingTypes>
	 * @throws Exception
	*/
	public List<ServingTypesDTO> findServingTypesByImageLoc(int id) throws Exception {
		List<ServingTypesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
