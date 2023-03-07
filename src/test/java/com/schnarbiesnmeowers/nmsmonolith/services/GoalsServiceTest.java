package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalsServiceTest {


	/**
	 * get all Goals records
	 * @return
	 * @throws Exception
	 */
	public List<GoalsDTO> getAllGoals() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GoalsDTO> goalsDTO = new ArrayList<GoalsDTO>();
		return goalsDTO;
	}

	/**
	 * get Goals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalsDTO findGoalsById(int id) throws Exception {
		return new GoalsDTO();
	}

	/**
	 * create a new Goals
	 * @param data
	 * @return
	 */
	public GoalsDTO createGoals(GoalsDTO data) {
        data.setGoalId(1);
        return data;
	}

	/**
	 * update a Goals
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalsDTO updateGoals(GoalsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Goals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoals(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GoalsDTO> by foreign key : userId
	 * @param userId
	 * @return List<Goals>
	 * @throws Exception
	*/
	public List<GoalsDTO> findGoalsByUserId(int id) throws Exception {
		List<GoalsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalsDTO> by foreign key : gcId
	 * @param gcId
	 * @return List<Goals>
	 * @throws Exception
	*/
	public List<GoalsDTO> findGoalsByGcId(int id) throws Exception {
		List<GoalsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalsDTO> by foreign key : UserIdAndGcId
	 * @param UserIdAndGcId
	 * @return List<Goals>
	 * @throws Exception
	*/
	public List<GoalsDTO> findGoalsByUserIdAndGcId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<GoalsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
