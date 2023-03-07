package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalTypesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalTypesServiceTest {


	/**
	 * get all GoalTypes records
	 * @return
	 * @throws Exception
	 */
	public List<GoalTypesDTO> getAllGoalTypes() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GoalTypesDTO> goaltypesDTO = new ArrayList<GoalTypesDTO>();
		return goaltypesDTO;
	}

	/**
	 * get GoalTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalTypesDTO findGoalTypesById(int id) throws Exception {
		return new GoalTypesDTO();
	}

	/**
	 * create a new GoalTypes
	 * @param data
	 * @return
	 */
	public GoalTypesDTO createGoalTypes(GoalTypesDTO data) {
        data.setGoalTypeId(1);
        return data;
	}

	/**
	 * update a GoalTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalTypesDTO updateGoalTypes(GoalTypesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GoalTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalTypes(int id) throws Exception {
		return "Successfully Deleted";
	}

}
