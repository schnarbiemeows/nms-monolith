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
@RequestMapping(path="/goalevent")
public class GoalEventController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalEventService businessService;

	/**
	 * get all GoalEvent records
	 * @return Iterable<GoalEvent>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GoalEventDTO>> getAllGoalEvent() throws Exception {
		List<GoalEventDTO> goalevent = businessService.getAllGoalEvent();
		return ResponseEntity.status(HttpStatus.OK).body(goalevent);
	}

	/**
	 * get GoalEvent by primary key
	 * @param id
	 * @return GoalEvent
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GoalEventDTO> findGoalEventById(@PathVariable int id) throws Exception {
		GoalEventDTO results = businessService.findGoalEventById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GoalEvent
	 * @param GoalEventDTO
	 * @return GoalEvent
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GoalEventDTO> createGoalEvent(@Valid @RequestBody GoalEventDTO data) throws Exception {
		try {
		    GoalEventDTO createdData = businessService.createGoalEvent(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalEvent
	 * @param GoalEventDTO
	 * @return GoalEvent
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GoalEventDTO> updateGoalEvent(@Valid @RequestBody GoalEventDTO data) throws Exception {
		GoalEventDTO updatedData = businessService.updateGoalEvent(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GoalEvent by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGoalEvent(@PathVariable int id) throws Exception {
		businessService.deleteGoalEvent(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GoalEventDTO> by foreign key : userId
	 * @param userId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<GoalEventDTO>> findGoalEventByUserId(@PathVariable int id) throws Exception {
		List<GoalEventDTO> results = businessService.findGoalEventByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalEventDTO> by foreign key : goalId
	 * @param goalId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGoalId/{id}")
	public ResponseEntity<List<GoalEventDTO>> findGoalEventByGoalId(@PathVariable int id) throws Exception {
		List<GoalEventDTO> results = businessService.findGoalEventByGoalId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalEventDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEventId/{id}")
	public ResponseEntity<List<GoalEventDTO>> findGoalEventByEventId(@PathVariable int id) throws Exception {
		List<GoalEventDTO> results = businessService.findGoalEventByEventId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GoalEventDTO> by foreign key : UserIdAndGoalIdAndEventId
	 * @param UserIdAndGoalIdAndEventId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndGoalIdAndEventId/{id0}/{id1}/{id2}")
	public ResponseEntity<List<GoalEventDTO>> findGoalEventByUserIdAndGoalIdAndEventId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<GoalEventDTO> results = businessService.findGoalEventByUserIdAndGoalIdAndEventId(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
