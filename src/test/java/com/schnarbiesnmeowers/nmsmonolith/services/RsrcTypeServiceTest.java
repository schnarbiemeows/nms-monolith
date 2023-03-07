package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RsrcTypeDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class RsrcTypeServiceTest {


	/**
	 * get all RsrcType records
	 * @return
	 * @throws Exception
	 */
	public List<RsrcTypeDTO> getAllRsrcType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<RsrcTypeDTO> rsrctypeDTO = new ArrayList<RsrcTypeDTO>();
		return rsrctypeDTO;
	}

	/**
	 * get RsrcType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RsrcTypeDTO findRsrcTypeById(int id) throws Exception {
		return new RsrcTypeDTO();
	}

	/**
	 * create a new RsrcType
	 * @param data
	 * @return
	 */
	public RsrcTypeDTO createRsrcType(RsrcTypeDTO data) {
        data.setRsrcTypeId(1);
        return data;
	}

	/**
	 * update a RsrcType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public RsrcTypeDTO updateRsrcType(RsrcTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a RsrcType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteRsrcType(int id) throws Exception {
		return "Successfully Deleted";
	}

}
