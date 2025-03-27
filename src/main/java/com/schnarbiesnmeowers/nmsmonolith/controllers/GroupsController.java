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
@RequestMapping(path="/groups")
public class GroupsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GroupsService businessService;

	/**
	 * get all Groups records
	 * @return Iterable<Groups>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GroupsDTO>> getAllGroups() throws Exception {
		List<GroupsDTO> groups = businessService.getAllGroups();
		return ResponseEntity.status(HttpStatus.OK).body(groups);
	}

	/**
	 * get Groups by primary key
	 * @param id
	 * @return Groups
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GroupsDTO> findGroupsById(@PathVariable int id) throws Exception {
		GroupsDTO results = businessService.findGroupsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Groups
	 * @param data
	 * @return Groups
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GroupsDTO> createGroups(@Valid @RequestBody GroupsDTO data) throws Exception {
		try {
		    GroupsDTO createdData = businessService.createGroups(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Groups
	 * @param data
	 * @return Groups
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GroupsDTO> updateGroups(@Valid @RequestBody GroupsDTO data) throws Exception {
		GroupsDTO updatedData = businessService.updateGroups(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Groups by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGroups(@PathVariable int id) throws Exception {
		businessService.deleteGroups(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
