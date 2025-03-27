package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WeightWorkoutTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/weightworkouttype")
public class WeightWorkoutTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WeightWorkoutTypeService service;

	/**
	 * get all WeightWorkoutType records
	 * @return Iterable<WeightWorkoutType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<WeightWorkoutTypeDTO>> getAllWeightWorkoutType() throws Exception {
		List<WeightWorkoutTypeDTO> weightworkouttype = service.getAllWeightWorkoutType();
		return ResponseEntity.status(HttpStatus.OK).body(weightworkouttype);
	}

	/**
	 * get WeightWorkoutType by primary key
	 * @param id
	 * @return WeightWorkoutType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<WeightWorkoutTypeDTO> findWeightWorkoutTypeById(@PathVariable int id) throws Exception {
		WeightWorkoutTypeDTO results = service.findWeightWorkoutTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new WeightWorkoutType
	 * @param data
	 * @return WeightWorkoutType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<WeightWorkoutTypeDTO> createWeightWorkoutType(@Valid @RequestBody WeightWorkoutTypeDTO data) throws Exception {
		try {
		    WeightWorkoutTypeDTO createdData = service.createWeightWorkoutType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WeightWorkoutType
	 * @param data
	 * @return WeightWorkoutType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<WeightWorkoutTypeDTO> updateWeightWorkoutType(@Valid @RequestBody WeightWorkoutTypeDTO data) throws Exception {
		WeightWorkoutTypeDTO updatedData = service.updateWeightWorkoutType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a WeightWorkoutType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteWeightWorkoutType(@PathVariable int id) throws Exception {
		service.deleteWeightWorkoutType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}
}
