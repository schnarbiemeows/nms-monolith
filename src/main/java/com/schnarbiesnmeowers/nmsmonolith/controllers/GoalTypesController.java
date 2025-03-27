package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/goaltypes")
public class GoalTypesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalTypesService businessService;

	/**
	 * get all GoalTypes records
	 * @return Iterable<GoalTypes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GoalTypesDTO>> getAllGoalTypes() throws Exception {
		List<GoalTypesDTO> goaltypes = businessService.getAllGoalTypes();
		return ResponseEntity.status(HttpStatus.OK).body(goaltypes);
	}

	/**
	 * get GoalTypes by primary key
	 * @param id
	 * @return GoalTypes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GoalTypesDTO> findGoalTypesById(@PathVariable int id) throws Exception {
		GoalTypesDTO results = businessService.findGoalTypesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GoalTypes
	 * @param data
	 * @return GoalTypes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GoalTypesDTO> createGoalTypes(@Valid @RequestBody GoalTypesDTO data) throws Exception {
		try {
		    GoalTypesDTO createdData = businessService.createGoalTypes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalTypes
	 * @param data
	 * @return GoalTypes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GoalTypesDTO> updateGoalTypes(@Valid @RequestBody GoalTypesDTO data) throws Exception {
		GoalTypesDTO updatedData = businessService.updateGoalTypes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GoalTypes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGoalTypes(@PathVariable int id) throws Exception {
		businessService.deleteGoalTypes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
