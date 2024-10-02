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
@RequestMapping(path="/goalgroups")
public class GoalGroupsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalGroupsService businessService;

	/**
	 * get all GoalGroups records
	 * @return Iterable<GoalGroups>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GoalGroupsDTO>> getAllGoalGroups() throws Exception {
		List<GoalGroupsDTO> goalgroups = businessService.getAllGoalGroups();
		return ResponseEntity.status(HttpStatus.OK).body(goalgroups);
	}

	/**
	 * get GoalGroups by primary key
	 * @param id
	 * @return GoalGroups
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GoalGroupsDTO> findGoalGroupsById(@PathVariable int id) throws Exception {
		GoalGroupsDTO results = businessService.findGoalGroupsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GoalGroups
	 * @param GoalGroupsDTO
	 * @return GoalGroups
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GoalGroupsDTO> createGoalGroups(@Valid @RequestBody GoalGroupsDTO data) throws Exception {
		try {
		    GoalGroupsDTO createdData = businessService.createGoalGroups(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalGroups
	 * @param GoalGroupsDTO
	 * @return GoalGroups
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GoalGroupsDTO> updateGoalGroups(@Valid @RequestBody GoalGroupsDTO data) throws Exception {
		GoalGroupsDTO updatedData = businessService.updateGoalGroups(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GoalGroups by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGoalGroups(@PathVariable int id) throws Exception {
		businessService.deleteGoalGroups(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : goalId1
	 * @param goalId1
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGoalId1/{id}")
	public ResponseEntity<List<GoalGroupsDTO>> findGoalGroupsByGoalId1(@PathVariable int id) throws Exception {
		List<GoalGroupsDTO> results = businessService.findGoalGroupsByGoalId1(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : goalId2
	 * @param goalId2
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGoalId2/{id}")
	public ResponseEntity<List<GoalGroupsDTO>> findGoalGroupsByGoalId2(@PathVariable int id) throws Exception {
		List<GoalGroupsDTO> results = businessService.findGoalGroupsByGoalId2(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : GoalId1AndGoalId2
	 * @param GoalId1AndGoalId2
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGoalId1AndGoalId2/{id0}/{id1}")
	public ResponseEntity<List<GoalGroupsDTO>> findGoalGroupsByGoalId1AndGoalId2(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<GoalGroupsDTO> results = businessService.findGoalGroupsByGoalId1AndGoalId2(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
