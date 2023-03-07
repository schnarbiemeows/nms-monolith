package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalCategoriesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalCategoriesServiceTest {


	/**
	 * get all GoalCategories records
	 * @return
	 * @throws Exception
	 */
	public List<GoalCategoriesDTO> getAllGoalCategories() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<GoalCategoriesDTO> goalcategoriesDTO = new ArrayList<GoalCategoriesDTO>();
		return goalcategoriesDTO;
	}

	/**
	 * get GoalCategories by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalCategoriesDTO findGoalCategoriesById(int id) throws Exception {
		return new GoalCategoriesDTO();
	}

	/**
	 * create a new GoalCategories
	 * @param data
	 * @return
	 */
	public GoalCategoriesDTO createGoalCategories(GoalCategoriesDTO data) {
        data.setGcId(1);
        return data;
	}

	/**
	 * update a GoalCategories
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalCategoriesDTO updateGoalCategories(GoalCategoriesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a GoalCategories by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalCategories(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<GoalCategoriesDTO> by foreign key : goalTypeId
	 * @param goalTypeId
	 * @return List<GoalCategories>
	 * @throws Exception
	*/
	public List<GoalCategoriesDTO> findGoalCategoriesByGoalTypeId(int id) throws Exception {
		List<GoalCategoriesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
