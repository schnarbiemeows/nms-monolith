package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalEventDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalEventServiceTest {


	/**
	 * get all GoalEvent records
	 * @return
	 * @throws Exception
	 */
	public List<GoalEventDTO> getAllGoalEvent() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GoalEventDTO> goaleventDTO = new ArrayList<GoalEventDTO>();
		return goaleventDTO;
	}

	/**
	 * get GoalEvent by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalEventDTO findGoalEventById(int id) throws Exception {
		return new GoalEventDTO();
	}

	/**
	 * create a new GoalEvent
	 * @param data
	 * @return
	 */
	public GoalEventDTO createGoalEvent(GoalEventDTO data) {
        data.setGoalEventId(1);
        return data;
	}

	/**
	 * update a GoalEvent
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalEventDTO updateGoalEvent(GoalEventDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GoalEvent by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalEvent(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GoalEventDTO> by foreign key : userId
	 * @param userId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByUserId(int id) throws Exception {
		List<GoalEventDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalEventDTO> by foreign key : goalId
	 * @param goalId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByGoalId(int id) throws Exception {
		List<GoalEventDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalEventDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByEventId(int id) throws Exception {
		List<GoalEventDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalEventDTO> by foreign key : UserIdAndGoalIdAndEventId
	 * @param UserIdAndGoalIdAndEventId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByUserIdAndGoalIdAndEventId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		List<GoalEventDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
