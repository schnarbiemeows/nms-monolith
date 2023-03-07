package com.schnarbiesnmeowers.nmsmonolith.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;

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
	private WorkoutsService businessService;

	/**
	 * get all Workouts records
	 * @return Iterable<Workouts>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<WorkoutsDTO>> getAllWorkouts() throws Exception {
		List<WorkoutsDTO> workouts = businessService.getAllWorkouts();
		return ResponseEntity.status(HttpStatus.OK).body(workouts);
	}

	/**
	 * get Workouts by primary key
	 * @param id
	 * @return Workouts
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<WorkoutsDTO> findWorkoutsById(@PathVariable int id) throws Exception {
		WorkoutsDTO results = businessService.findWorkoutsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Workouts
	 * @param WorkoutsDTO
	 * @return Workouts
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<WorkoutsDTO> createWorkouts(@Valid @RequestBody WorkoutsDTO data) throws Exception {
		try {
		    WorkoutsDTO createdData = businessService.createWorkouts(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Workouts
	 * @param WorkoutsDTO
	 * @return Workouts
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<WorkoutsDTO> updateWorkouts(@Valid @RequestBody WorkoutsDTO data) throws Exception {
		WorkoutsDTO updatedData = businessService.updateWorkouts(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Workouts by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteWorkouts(@PathVariable int id) throws Exception {
		businessService.deleteWorkouts(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : userId
	 * @param userId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<WorkoutsDTO>> findWorkoutsByUserId(@PathVariable int id) throws Exception {
		List<WorkoutsDTO> results = businessService.findWorkoutsByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : exerciseTypeId
	 * @param exerciseTypeId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByExerciseTypeId/{id}")
	public ResponseEntity<List<WorkoutsDTO>> findWorkoutsByExerciseTypeId(@PathVariable int id) throws Exception {
		List<WorkoutsDTO> results = businessService.findWorkoutsByExerciseTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WorkoutsDTO> by foreign key : UserIdAndExerciseTypeId
	 * @param UserIdAndExerciseTypeId
	 * @return List<Workouts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndExerciseTypeId/{id0}/{id1}")
	public ResponseEntity<List<WorkoutsDTO>> findWorkoutsByUserIdAndExerciseTypeId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<WorkoutsDTO> results = businessService.findWorkoutsByUserIdAndExerciseTypeId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
