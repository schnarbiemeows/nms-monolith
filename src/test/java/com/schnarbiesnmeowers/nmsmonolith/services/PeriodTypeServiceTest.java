package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodTypeDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PeriodTypeServiceTest {


	/**
	 * get all PeriodType records
	 * @return
	 * @throws Exception
	 */
	public List<PeriodTypeDTO> getAllPeriodType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<PeriodTypeDTO> periodtypeDTO = new ArrayList<PeriodTypeDTO>();
		return periodtypeDTO;
	}

	/**
	 * get PeriodType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PeriodTypeDTO findPeriodTypeById(int id) throws Exception {
		return new PeriodTypeDTO();
	}

	/**
	 * create a new PeriodType
	 * @param data
	 * @return
	 */
	public PeriodTypeDTO createPeriodType(PeriodTypeDTO data) {
        data.setPeriodTypeId(1);
        return data;
	}

	/**
	 * update a PeriodType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PeriodTypeDTO updatePeriodType(PeriodTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a PeriodType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePeriodType(int id) throws Exception {
		return "Successfully Deleted";
	}

}
