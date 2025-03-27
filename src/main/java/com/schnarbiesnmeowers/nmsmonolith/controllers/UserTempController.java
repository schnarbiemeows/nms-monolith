package com.schnarbiesnmeowers.nmsmonolith.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping(path="/usertemp")
public class UserTempController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UserTempService service;

	/**
	 * get all UserTemp records
	 * @return Iterable<UserTemp>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UserTempDTO>> getAllUserTemp() throws Exception {
		List<UserTempDTO> usertemp = service.getAllUserTemp();
		return ResponseEntity.status(HttpStatus.OK).body(usertemp);
	}

	/**
	 * get UserTemp by primary key
	 * @param id
	 * @return UserTemp
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UserTempDTO> findUserTempById(@PathVariable int id) throws Exception {
		UserTempDTO results = service.findUserTempById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new UserTemp
	 * @param data
	 * @return UserTemp
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UserTempDTO> createUserTemp(@Valid @RequestBody UserTempDTO data) throws Exception {
		try {
		    UserTempDTO createdData = service.createUserTemp(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UserTemp
	 * @param data
	 * @return UserTemp
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UserTempDTO> updateUserTemp(@Valid @RequestBody UserTempDTO data) throws Exception {
		UserTempDTO updatedData = service.updateUserTemp(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a UserTemp by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUserTemp(@PathVariable int id) throws Exception {
		service.deleteUserTemp(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
