package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalGroupsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalGroupsServiceTest {


	/**
	 * get all GoalGroups records
	 * @return
	 * @throws Exception
	 */
	public List<GoalGroupsDTO> getAllGoalGroups() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GoalGroupsDTO> goalgroupsDTO = new ArrayList<GoalGroupsDTO>();
		return goalgroupsDTO;
	}

	/**
	 * get GoalGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalGroupsDTO findGoalGroupsById(int id) throws Exception {
		return new GoalGroupsDTO();
	}

	/**
	 * create a new GoalGroups
	 * @param data
	 * @return
	 */
	public GoalGroupsDTO createGoalGroups(GoalGroupsDTO data) {
        data.setGoalGroupId(1);
        return data;
	}

	/**
	 * update a GoalGroups
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalGroupsDTO updateGoalGroups(GoalGroupsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GoalGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalGroups(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : goalId1
	 * @param goalId1
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	public List<GoalGroupsDTO> findGoalGroupsByGoalId1(int id) throws Exception {
		List<GoalGroupsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : goalId2
	 * @param goalId2
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	public List<GoalGroupsDTO> findGoalGroupsByGoalId2(int id) throws Exception {
		List<GoalGroupsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : GoalId1AndGoalId2
	 * @param GoalId1AndGoalId2
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	public List<GoalGroupsDTO> findGoalGroupsByGoalId1AndGoalId2(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<GoalGroupsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
