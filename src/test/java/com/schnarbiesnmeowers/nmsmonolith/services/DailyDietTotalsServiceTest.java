package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietTotalsServiceTest {


	/**
	 * get all DailyDietTotals records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietTotalsDTO> getAllDailyDietTotals() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<DailyDietTotalsDTO> dailydiettotalsDTO = new ArrayList<DailyDietTotalsDTO>();
		return dailydiettotalsDTO;
	}

	/**
	 * get DailyDietTotals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietTotalsDTO findDailyDietTotalsById(int id) throws Exception {
		return new DailyDietTotalsDTO();
	}

	/**
	 * create a new DailyDietTotals
	 * @param data
	 * @return
	 */
	public DailyDietTotalsDTO createDailyDietTotals(DailyDietTotalsDTO data) {
        data.setDailyDietTotalId(1);
        return data;
	}

	/**
	 * update a DailyDietTotals
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietTotalsDTO updateDailyDietTotals(DailyDietTotalsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a DailyDietTotals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDietTotals(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : userId
	 * @param userId
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	public List<DailyDietTotalsDTO> findDailyDietTotalsByUserId(int id) throws Exception {
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : bldstId
	 * @param bldstId
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	public List<DailyDietTotalsDTO> findDailyDietTotalsByBldstId(int id) throws Exception {
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : UserIdAndBldstId
	 * @param UserIdAndBldstId
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	public List<DailyDietTotalsDTO> findDailyDietTotalsByUserIdAndBldstId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<DailyDietTotalsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
