package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BldstTableServiceTest {


	/**
	 * get all BldstTable records
	 * @return
	 * @throws Exception
	 */
	public List<BldstTableDTO> getAllBldstTable() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<BldstTableDTO> bldsttableDTO = new ArrayList<BldstTableDTO>();
		return bldsttableDTO;
	}

	/**
	 * get BldstTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BldstTableDTO findBldstTableById(int id) throws Exception {
		return new BldstTableDTO();
	}

	/**
	 * create a new BldstTable
	 * @param data
	 * @return
	 */
	public BldstTableDTO createBldstTable(BldstTableDTO data) {
        data.setBldstTableId(1);
        return data;
	}

	/**
	 * update a BldstTable
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BldstTableDTO updateBldstTable(BldstTableDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a BldstTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBldstTable(int id) throws Exception {
		return "Successfully Deleted";
	}

}
