package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutsDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class WorkoutsServiceTest {


	/**
	 * get all Workouts records
	 * @return
	 * @throws Exception
	 */
	public List<WorkoutsDTO> getAllWorkouts() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<WorkoutsDTO> workoutsDTO = new ArrayList<WorkoutsDTO>();
		return workoutsDTO;
	}

	/**
	 * get Workouts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public WorkoutsDTO findWorkoutsById(int id) throws Exception {
		return new WorkoutsDTO();
	}

	/**
	 * create a new Workouts
	 * @param data
	 * @return
	 */
	public WorkoutsDTO createWorkouts(WorkoutsDTO data) {
        data.setWorkoutId(1);
        return data;
	}

	/**
	 * update a Workouts
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public WorkoutsDTO updateWorkouts(WorkoutsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Workouts by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteWorkouts(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : userId
	 * @param id
	 * @return List<Workouts>
	 * @throws Exception
	*/
	public List<WorkoutsDTO> findWorkoutsByUserId(int id) throws Exception {
		List<WorkoutsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : exerciseTypeId
	 * @param id
	 * @return List<Workouts>
	 * @throws Exception
	*/
	public List<WorkoutsDTO> findWorkoutsByExerciseTypeId(int id) throws Exception {
		List<WorkoutsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : UserIdAndExerciseTypeId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<WorkoutsDTO> findWorkoutsByUserIdAndExerciseTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<WorkoutsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
