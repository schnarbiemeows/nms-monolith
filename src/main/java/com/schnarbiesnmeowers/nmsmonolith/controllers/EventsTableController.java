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
@RequestMapping(path="/eventstable")
public class EventsTableController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private EventsTableService businessService;

	/**
	 * get all EventsTable records
	 * @return Iterable<EventsTable>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<EventsTableDTO>> getAllEventsTable() throws Exception {
		List<EventsTableDTO> eventstable = businessService.getAllEventsTable();
		return ResponseEntity.status(HttpStatus.OK).body(eventstable);
	}

	/**
	 * get EventsTable by primary key
	 * @param id
	 * @return EventsTable
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<EventsTableDTO> findEventsTableById(@PathVariable int id) throws Exception {
		EventsTableDTO results = businessService.findEventsTableById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new EventsTable
	 * @param EventsTableDTO
	 * @return EventsTable
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<EventsTableDTO> createEventsTable(@Valid @RequestBody EventsTableDTO data) throws Exception {
		try {
		    EventsTableDTO createdData = businessService.createEventsTable(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a EventsTable
	 * @param EventsTableDTO
	 * @return EventsTable
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<EventsTableDTO> updateEventsTable(@Valid @RequestBody EventsTableDTO data) throws Exception {
		EventsTableDTO updatedData = businessService.updateEventsTable(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a EventsTable by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteEventsTable(@PathVariable int id) throws Exception {
		businessService.deleteEventsTable(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<EventsTableDTO> by foreign key : userId
	 * @param userId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<EventsTableDTO>> findEventsTableByUserId(@PathVariable int id) throws Exception {
		List<EventsTableDTO> results = businessService.findEventsTableByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<EventsTableDTO> by foreign key : periodId
	 * @param periodId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByPeriodId/{id}")
	public ResponseEntity<List<EventsTableDTO>> findEventsTableByPeriodId(@PathVariable int id) throws Exception {
		List<EventsTableDTO> results = businessService.findEventsTableByPeriodId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<EventsTableDTO> by foreign key : UserIdAndPeriodId
	 * @param UserIdAndPeriodId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndPeriodId/{id0}/{id1}")
	public ResponseEntity<List<EventsTableDTO>> findEventsTableByUserIdAndPeriodId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<EventsTableDTO> results = businessService.findEventsTableByUserIdAndPeriodId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
