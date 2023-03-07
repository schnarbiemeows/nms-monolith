package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PeriodsServiceTest {


	/**
	 * get all Periods records
	 * @return
	 * @throws Exception
	 */
	public List<PeriodsDTO> getAllPeriods() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<PeriodsDTO> periodsDTO = new ArrayList<PeriodsDTO>();
		return periodsDTO;
	}

	/**
	 * get Periods by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PeriodsDTO findPeriodsById(int id) throws Exception {
		return new PeriodsDTO();
	}

	/**
	 * create a new Periods
	 * @param data
	 * @return
	 */
	public PeriodsDTO createPeriods(PeriodsDTO data) {
        data.setPeriodId(1);
        return data;
	}

	/**
	 * update a Periods
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PeriodsDTO updatePeriods(PeriodsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Periods by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePeriods(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<PeriodsDTO> by foreign key : periodTypeId
	 * @param id
	 * @return List<Periods>
	 * @throws Exception
	*/
	public List<PeriodsDTO> findPeriodsByPeriodTypeId(int id) throws Exception {
		List<PeriodsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
