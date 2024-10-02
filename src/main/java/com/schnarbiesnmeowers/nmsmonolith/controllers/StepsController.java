package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.StepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.StepsService;
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
@RequestMapping(path="/steps")
public class StepsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private StepsService businessService;

	/**
	 * get all Steps records
	 * @return Iterable<Steps>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<StepsDTO>> getAllSteps() throws Exception {
		List<StepsDTO> steps = businessService.getAllSteps();
		return ResponseEntity.status(HttpStatus.OK).body(steps);
	}

	/**
	 * get Steps by primary key
	 * @param id
	 * @return Steps
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<StepsDTO> findStepsById(@PathVariable int id) throws Exception {
		StepsDTO results = businessService.findStepsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Steps
	 * @param data
	 * @return Steps
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<StepsDTO> createSteps(@Valid @RequestBody StepsDTO data) throws Exception {
		try {
		    StepsDTO createdData = businessService.createSteps(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Steps
	 * @param data
	 * @return Steps
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<StepsDTO> updateSteps(@Valid @RequestBody StepsDTO data) throws Exception {
		StepsDTO updatedData = businessService.updateSteps(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Steps by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteSteps(@PathVariable int id) throws Exception {
		businessService.deleteSteps(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<StepsDTO> by foreign key : workoutId
	 * @param id
	 * @return List<Steps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByWorkoutId/{id}")
	public ResponseEntity<StepsDTO> findStepsByWorkoutId(@PathVariable int id) throws Exception {
		StepsDTO results = businessService.findStepsByWorkoutId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
