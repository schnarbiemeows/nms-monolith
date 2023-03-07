package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class DailyDietServiceTest {


	/**
	 * get all DailyDiet records
	 * @return
	 * @throws Exception
	 */
	public List<DailyDietDTO> getAllDailyDiet() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<DailyDietDTO> dailydietDTO = new ArrayList<DailyDietDTO>();
		return dailydietDTO;
	}

	/**
	 * get DailyDiet by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public DailyDietDTO findDailyDietById(int id) throws Exception {
		return new DailyDietDTO();
	}

	/**
	 * create a new DailyDiet
	 * @param data
	 * @return
	 */
	public DailyDietDTO createDailyDiet(DailyDietDTO data) {
        data.setDailyTotalId(1);
        return data;
	}

	/**
	 * update a DailyDiet
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public DailyDietDTO updateDailyDiet(DailyDietDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a DailyDiet by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteDailyDiet(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<DailyDietDTO> by foreign key : userId
	 * @param userId
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByUserId(int id) throws Exception {
		List<DailyDietDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<DailyDietDTO> by foreign key : ingrId
	 * @param ingrId
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByIngrId(int id) throws Exception {
		List<DailyDietDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<DailyDietDTO> by foreign key : bldstId
	 * @param bldstId
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByBldstId(int id) throws Exception {
		List<DailyDietDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<DailyDietDTO> by foreign key : UserIdAndIngrIdAndBldstId
	 * @param UserIdAndIngrIdAndBldstId
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	public List<DailyDietDTO> findDailyDietByUserIdAndIngrIdAndBldstId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		List<DailyDietDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
