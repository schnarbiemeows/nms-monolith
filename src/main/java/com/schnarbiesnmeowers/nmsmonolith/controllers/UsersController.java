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
@RequestMapping(path="/users")
public class UsersController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UsersService businessService;

	/**
	 * get all Users records
	 * @return Iterable<Users>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UsersDTO>> getAllUsers() throws Exception {
		List<UsersDTO> users = businessService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	/**
	 * get Users by primary key
	 * @param id
	 * @return Users
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UsersDTO> findUsersById(@PathVariable int id) throws Exception {
		UsersDTO results = businessService.findUsersById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Users
	 * @param UsersDTO
	 * @return Users
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UsersDTO> createUsers(@Valid @RequestBody UsersDTO data) throws Exception {
		try {
		    UsersDTO createdData = businessService.createUsers(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Users
	 * @param UsersDTO
	 * @return Users
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UsersDTO> updateUsers(@Valid @RequestBody UsersDTO data) throws Exception {
		UsersDTO updatedData = businessService.updateUsers(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Users by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUsers(@PathVariable int id) throws Exception {
		businessService.deleteUsers(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
