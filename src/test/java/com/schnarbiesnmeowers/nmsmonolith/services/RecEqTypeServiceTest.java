package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEqTypeDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RecEqTypeServiceTest {


	/**
	 * get all RecEqType records
	 * @return
	 * @throws Exception
	 */
	public List<RecEqTypeDTO> getAllRecEqType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RecEqTypeDTO> receqtypeDTO = new ArrayList<RecEqTypeDTO>();
		return receqtypeDTO;
	}

	/**
	 * get RecEqType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RecEqTypeDTO findRecEqTypeById(int id) throws Exception {
		return new RecEqTypeDTO();
	}

	/**
	 * create a new RecEqType
	 * @param data
	 * @return
	 */
	public RecEqTypeDTO createRecEqType(RecEqTypeDTO data) {
        data.setRecEqTypeId(1);
        return data;
	}

	/**
	 * update a RecEqType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RecEqTypeDTO updateRecEqType(RecEqTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RecEqType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRecEqType(int id) throws Exception {
		return "Successfully Deleted";
	}

}
