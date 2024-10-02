package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
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
@RequestMapping(path="/goals")
public class GoalsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalsService businessService;

	/**
	 * get all Goals records
	 * @return Iterable<Goals>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GoalsDTO>> getAllGoals() throws Exception {
		List<GoalsDTO> goals = businessService.getAllGoals();
		return ResponseEntity.status(HttpStatus.OK).body(goals);
	}

	/**
	 * get Goals by primary key
	 * @param id
	 * @return Goals
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GoalsDTO> findGoalsById(@PathVariable int id) throws Exception {
		GoalsDTO results = businessService.findGoalsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Goals
	 * @param GoalsDTO
	 * @return Goals
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GoalsDTO> createGoals(@Valid @RequestBody GoalsDTO data) throws Exception {
		try {
		    GoalsDTO createdData = businessService.createGoals(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Goals
	 * @param GoalsDTO
	 * @return Goals
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GoalsDTO> updateGoals(@Valid @RequestBody GoalsDTO data) throws Exception {
		GoalsDTO updatedData = businessService.updateGoals(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Goals by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGoals(@PathVariable int id) throws Exception {
		businessService.deleteGoals(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GoalsDTO> by foreign key : userId
	 * @param userId
	 * @return List<Goals>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<GoalsDTO>> findGoalsByUserId(@PathVariable int id) throws Exception {
		List<GoalsDTO> results = businessService.findGoalsByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalsDTO> by foreign key : gcId
	 * @param gcId
	 * @return List<Goals>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGcId/{id}")
	public ResponseEntity<List<GoalsDTO>> findGoalsByGcId(@PathVariable int id) throws Exception {
		List<GoalsDTO> results = businessService.findGoalsByGcId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalsDTO> by foreign key : UserIdAndGcId
	 * @param UserIdAndGcId
	 * @return List<Goals>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndGcId/{id0}/{id1}")
	public ResponseEntity<List<GoalsDTO>> findGoalsByUserIdAndGcId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<GoalsDTO> results = businessService.findGoalsByUserIdAndGcId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
