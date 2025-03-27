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
@RequestMapping(path="/users")
public class UsersController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UsersService service;

	/**
	 * get all Users records
	 * @return Iterable<Users>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UsersDTO>> getAllUsers() throws Exception {
		List<UsersDTO> users = service.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	/**
	 * get Users by primary key
	 * @param id
	 * @return Users
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UsersDTO> findUsersById(@PathVariable int id) throws Exception {
		UsersDTO results = service.findUsersById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Users
	 * @param data
	 * @return Users
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UsersDTO> createUsers(@Valid @RequestBody UsersDTO data) throws Exception {
		try {
		    UsersDTO createdData = service.createUsers(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Users
	 * @param data
	 * @return Users
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UsersDTO> updateUsers(@Valid @RequestBody UsersDTO data) throws Exception {
		UsersDTO updatedData = service.updateUsers(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Users by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUsers(@PathVariable int id) throws Exception {
		service.deleteUsers(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
