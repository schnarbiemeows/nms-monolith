package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutCardioService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/workoutcardio")
public class WorkoutCardioController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WorkoutCardioService service;

	/**
	 * get all WorkoutCardio records
	 * @return Iterable<WorkoutCardio>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<WorkoutCardioDTO>> getAllWorkoutCardio() throws Exception {
		List<WorkoutCardioDTO> workoutcardio = service.getAllWorkoutCardio();
		return ResponseEntity.status(HttpStatus.OK).body(workoutcardio);
	}

	/**
	 * get WorkoutCardio by primary key
	 * @param id
	 * @return WorkoutCardio
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<WorkoutCardioDTO> findWorkoutCardioById(@PathVariable int id) throws Exception {
		WorkoutCardioDTO results = service.findWorkoutCardioById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new WorkoutCardio
	 * @param data
	 * @return WorkoutCardio
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<WorkoutCardioDTO> createWorkoutCardio(@Valid @RequestBody WorkoutCardioDTO data) throws Exception {
		try {
		    WorkoutCardioDTO createdData = service.createWorkoutCardio(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WorkoutCardio
	 * @param data
	 * @return WorkoutCardio
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<WorkoutCardioDTO> updateWorkoutCardio(@Valid @RequestBody WorkoutCardioDTO data) throws Exception {
		WorkoutCardioDTO updatedData = service.updateWorkoutCardio(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a WorkoutCardio by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteWorkoutCardio(@PathVariable int id) throws Exception {
		service.deleteWorkoutCardio(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<WorkoutCardioDTO> by foreign key : workoutId
	 * @param id
	 * @return List<WorkoutCardio>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByWorkoutId/{id}")
	public ResponseEntity<WorkoutCardioDTO> findWorkoutCardioByWorkoutId(@PathVariable int id) throws Exception {
		WorkoutCardioDTO results = service.findWorkoutCardioByWorkoutId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
}
