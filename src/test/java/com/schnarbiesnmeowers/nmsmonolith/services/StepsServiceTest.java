package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.StepsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class StepsServiceTest {


	/**
	 * get all Steps records
	 * @return
	 * @throws Exception
	 */
	public List<StepsDTO> getAllSteps() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<StepsDTO> stepsDTO = new ArrayList<StepsDTO>();
		return stepsDTO;
	}

	/**
	 * get Steps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public StepsDTO findStepsById(int id) throws Exception {
		return new StepsDTO();
	}

	/**
	 * create a new Steps
	 * @param data
	 * @return
	 */
	public StepsDTO createSteps(StepsDTO data) {
        data.setStepId(1);
        return data;
	}

	/**
	 * update a Steps
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public StepsDTO updateSteps(StepsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Steps by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteSteps(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<StepsDTO> by foreign key : workoutId
	 * @param id
	 * @return List<Steps>
	 * @throws Exception
	*/
	public List<StepsDTO> findStepsByWorkoutId(int id) throws Exception {
		List<StepsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
