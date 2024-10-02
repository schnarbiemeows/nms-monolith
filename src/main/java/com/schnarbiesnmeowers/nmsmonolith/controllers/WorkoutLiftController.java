package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutLiftDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutLiftService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/workoutLift")
public class WorkoutLiftController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WorkoutLiftService workoutLiftService;

	/**
	 * get all WorkoutLift records
	 * @return Iterable<WorkoutLift>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<WorkoutLiftDTO>> getAllWorkoutLift() throws Exception {
		List<WorkoutLiftDTO> WorkoutLift = workoutLiftService.getAllWorkoutLift();
		return ResponseEntity.status(HttpStatus.OK).body(WorkoutLift);
	}

	/**
	 * get WorkoutLift by primary key
	 * @param id
	 * @return WorkoutLift
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<WorkoutLiftDTO> findWorkoutLiftById(@PathVariable int id) throws Exception {
		WorkoutLiftDTO results = workoutLiftService.findWorkoutLiftById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new WorkoutLift
	 * @param data
	 * @return WorkoutLift
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<WorkoutLiftDTO> createWorkoutLift(@Valid @RequestBody WorkoutLiftDTO data) throws Exception {
		try {
		    WorkoutLiftDTO createdData = workoutLiftService.createWorkoutLift(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WorkoutLift
	 * @param data
	 * @return WorkoutLift
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<WorkoutLiftDTO> updateWorkoutLift(@Valid @RequestBody WorkoutLiftDTO data) throws Exception {
		WorkoutLiftDTO updatedData = workoutLiftService.updateWorkoutLift(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a WorkoutLift by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteWorkoutLift(@PathVariable int id) throws Exception {
		workoutLiftService.deleteWorkoutLift(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<WorkoutLiftDTO> by foreign key : workoutId
	 * @param id
	 * @return List<WorkoutLift>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByWorkoutId/{id}")
	public ResponseEntity<List<WorkoutLiftDTO>> findWorkoutLiftByWorkoutId(@PathVariable int id) throws Exception {
		List<WorkoutLiftDTO> results = workoutLiftService.findWorkoutLiftByWorkoutId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WorkoutLiftDTO> by foreign key : liftId
	 * @param id
	 * @return List<WorkoutLift>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftId/{id}")
	public ResponseEntity<List<WorkoutLiftDTO>> findWorkoutLiftByLiftId(@PathVariable int id) throws Exception {
		List<WorkoutLiftDTO> results = workoutLiftService.findWorkoutLiftByLiftId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WorkoutLiftDTO> by foreign key : WorkoutIdAndLiftId
	 * @param id0
	 * @return List<WorkoutLift>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByWorkoutIdAndLiftId/{id0}/{id1}")
	public ResponseEntity<List<WorkoutLiftDTO>> findWorkoutLiftByWorkoutIdAndLiftId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<WorkoutLiftDTO> results = workoutLiftService.findWorkoutLiftByWorkoutIdAndLiftId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
