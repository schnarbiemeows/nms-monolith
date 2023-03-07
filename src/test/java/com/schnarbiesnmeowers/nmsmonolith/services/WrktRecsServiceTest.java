package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.WrktRecsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WrktRecsServiceTest {


	/**
	 * get all WrktRecs records
	 * @return
	 * @throws Exception
	 */
	public List<WrktRecsDTO> getAllWrktRecs() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<WrktRecsDTO> wrktrecsDTO = new ArrayList<WrktRecsDTO>();
		return wrktrecsDTO;
	}

	/**
	 * get WrktRecs by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WrktRecsDTO findWrktRecsById(int id) throws Exception {
		return new WrktRecsDTO();
	}

	/**
	 * create a new WrktRecs
	 * @param data
	 * @return
	 */
	public WrktRecsDTO createWrktRecs(WrktRecsDTO data) {
        data.setWrktRecId(1);
        return data;
	}

	/**
	 * update a WrktRecs
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WrktRecsDTO updateWrktRecs(WrktRecsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a WrktRecs by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWrktRecs(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : workoutId
	 * @param id
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	public List<WrktRecsDTO> findWrktRecsByWorkoutId(int id) throws Exception {
		List<WrktRecsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : liftId
	 * @param id
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	public List<WrktRecsDTO> findWrktRecsByLiftId(int id) throws Exception {
		List<WrktRecsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : WorkoutIdAndLiftId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<WrktRecsDTO> findWrktRecsByWorkoutIdAndLiftId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<WrktRecsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
