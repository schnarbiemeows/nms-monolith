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
@RequestMapping(path="/usercalendar")
public class UserCalendarController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UserCalendarService businessService;

	/**
	 * get all UserCalendar records
	 * @return Iterable<UserCalendar>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UserCalendarDTO>> getAllUserCalendar() throws Exception {
		List<UserCalendarDTO> usercalendar = businessService.getAllUserCalendar();
		return ResponseEntity.status(HttpStatus.OK).body(usercalendar);
	}

	/**
	 * get UserCalendar by primary key
	 * @param id
	 * @return UserCalendar
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UserCalendarDTO> findUserCalendarById(@PathVariable int id) throws Exception {
		UserCalendarDTO results = businessService.findUserCalendarById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new UserCalendar
	 * @param UserCalendarDTO
	 * @return UserCalendar
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UserCalendarDTO> createUserCalendar(@Valid @RequestBody UserCalendarDTO data) throws Exception {
		try {
		    UserCalendarDTO createdData = businessService.createUserCalendar(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UserCalendar
	 * @param UserCalendarDTO
	 * @return UserCalendar
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UserCalendarDTO> updateUserCalendar(@Valid @RequestBody UserCalendarDTO data) throws Exception {
		UserCalendarDTO updatedData = businessService.updateUserCalendar(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a UserCalendar by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUserCalendar(@PathVariable int id) throws Exception {
		businessService.deleteUserCalendar(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : userId
	 * @param userId
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<UserCalendarDTO>> findUserCalendarByUserId(@PathVariable int id) throws Exception {
		List<UserCalendarDTO> results = businessService.findUserCalendarByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEventId/{id}")
	public ResponseEntity<List<UserCalendarDTO>> findUserCalendarByEventId(@PathVariable int id) throws Exception {
		List<UserCalendarDTO> results = businessService.findUserCalendarByEventId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : UserIdAndEventId
	 * @param UserIdAndEventId
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndEventId/{id0}/{id1}")
	public ResponseEntity<List<UserCalendarDTO>> findUserCalendarByUserIdAndEventId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<UserCalendarDTO> results = businessService.findUserCalendarByUserIdAndEventId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
