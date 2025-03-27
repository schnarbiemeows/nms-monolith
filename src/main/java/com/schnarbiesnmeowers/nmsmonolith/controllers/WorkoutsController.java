package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.utility.GraphWrapperDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutWrapperDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/workouts")
public class WorkoutsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WorkoutsService workoutsService;

	/**
	 * get all Workouts records
	 * @return Iterable<Workouts>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<WorkoutsDTO>> getAllWorkouts() throws Exception {
		List<WorkoutsDTO> workouts = workoutsService.getAllWorkouts();
		return ResponseEntity.status(HttpStatus.OK).body(workouts);
	}


	/**
	 * get Workouts by primary key
	 * @param id
	 * @return Workouts
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<WorkoutWrapperDTO> findWorkoutsById(@PathVariable int id) throws Exception {
		WorkoutWrapperDTO results = workoutsService.findWorkoutsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Workouts
	 * @param data
	 * @return Workouts
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<WorkoutsDTO> createWorkouts(@Valid @RequestBody WorkoutsDTO data) throws Exception {
		try {
		    WorkoutsDTO createdData = workoutsService.createWorkouts(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * create a new Workouts
	 * @param data
	 * @return Workouts
	 */
	@PostMapping(path = "/createworkout")
	public ResponseEntity<WorkoutWrapperDTO> createWorkout(@Valid @RequestBody WorkoutWrapperDTO data) throws Exception {
		try {
			WorkoutWrapperDTO createdData = workoutsService.createWorkout(data);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Workouts
	 * @param data
	 * @return Workouts
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<WorkoutsDTO> updateWorkouts(@Valid @RequestBody WorkoutsDTO data) throws Exception {
		WorkoutsDTO updatedData = workoutsService.updateWorkouts(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * update a Workouts
	 * @param data
	 * @return Workouts
	 */
	@PostMapping(path = "/updateworkout")
	public ResponseEntity<WorkoutWrapperDTO> updateWorkout(@Valid @RequestBody WorkoutWrapperDTO data) throws Exception {
		WorkoutWrapperDTO updatedData = workoutsService.updateWorkout(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Workouts by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteWorkouts(@PathVariable int id) throws Exception {
		workoutsService.deleteWorkouts(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * delete a Workouts by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/deleteworkout/{id}/{type}")
	public ResponseEntity<ResponseMessage> deleteWorkout(@PathVariable int id,@PathVariable int type) throws Exception {
		workoutsService.deleteWorkout(id,type);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : userId
	 * @param id
	 * @return List<Workouts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<WorkoutsDTO>> findWorkoutsByUserId(@PathVariable int id) throws Exception {
		List<WorkoutsDTO> results = workoutsService.findWorkoutsByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}



	/**
	 * get List<WorkoutsDTO> by foreign key : UserIdAndExerciseTypeId
	 * @param userId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findstepworkouts/{userId}/{daysBack}")
	public ResponseEntity<GraphWrapperDTO> findStepWorkouts(@PathVariable int userId,
															@PathVariable int daysBack) throws Exception {
		GraphWrapperDTO results = workoutsService.findWorkoutStepsByUserIdAndDate(userId, daysBack);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : UserIdAndExerciseTypeId
	 * @param id0
	 * @return List<Workouts>
	 * @throws Exception
	 */
	@GetMapping(path = "/findcardioworkouts/{id0}/{id1}")
	public ResponseEntity<GraphWrapperDTO> findCardioWorkouts(@PathVariable int id0,
		@PathVariable String id1) throws Exception {
		GraphWrapperDTO results = workoutsService.findCardioWorkoutsByUserIdAndDate(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : UserIdAndExerciseTypeId
	 * @param id0
	 * @return List<Workouts>
	 * @throws Exception
	 */
	@GetMapping(path = "/findByUserIdAndDate/{id0}/{id1}")
	public ResponseEntity<List<WorkoutsDTO>> findWorkoutsByUserIdAndDate(@PathVariable int id0, @PathVariable String id1) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date current = df.parse(id1);
		List<WorkoutsDTO> results = workoutsService.findWorkoutsByUserIdAndDate(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
}
