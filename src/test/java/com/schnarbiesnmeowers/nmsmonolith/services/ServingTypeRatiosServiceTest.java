package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ServingTypeRatiosServiceTest {


	/**
	 * get all ServingTypeRatios records
	 * @return
	 * @throws Exception
	 */
	public List<ServingTypeRatiosDTO> getAllServingTypeRatios() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<ServingTypeRatiosDTO> servingtyperatiosDTO = new ArrayList<ServingTypeRatiosDTO>();
		return servingtyperatiosDTO;
	}

	/**
	 * get ServingTypeRatios by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ServingTypeRatiosDTO findServingTypeRatiosById(int id) throws Exception {
		return new ServingTypeRatiosDTO();
	}

	/**
	 * create a new ServingTypeRatios
	 * @param data
	 * @return
	 */
	public ServingTypeRatiosDTO createServingTypeRatios(ServingTypeRatiosDTO data) {
        data.setServTypeRatioId(1);
        return data;
	}

	/**
	 * update a ServingTypeRatios
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ServingTypeRatiosDTO updateServingTypeRatios(ServingTypeRatiosDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a ServingTypeRatios by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteServingTypeRatios(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : servTypeId1
	 * @param id
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	public List<ServingTypeRatiosDTO> findServingTypeRatiosByServTypeId1(int id) throws Exception {
		List<ServingTypeRatiosDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : servTypeId2
	 * @param id
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	public List<ServingTypeRatiosDTO> findServingTypeRatiosByServTypeId2(int id) throws Exception {
		List<ServingTypeRatiosDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : ServTypeId1AndServTypeId2
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<ServingTypeRatiosDTO> findServingTypeRatiosByServTypeId1AndServTypeId2(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<ServingTypeRatiosDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
