package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;

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

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/unsynced")
public class UnsyncedController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UnsyncedService service;

	/**
	 * get all Unsynced records
	 * @return Iterable<Unsynced>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UnsyncedDTO>> getAllUnsynced() throws Exception {
		List<UnsyncedDTO> unsynced = service.getAllUnsynced();
		return ResponseEntity.status(HttpStatus.OK).body(unsynced);
	}

	/**
	 * get Unsynced by primary key
	 * @param id
	 * @return Unsynced
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UnsyncedDTO> findUnsyncedById(@PathVariable int id) throws Exception {
		UnsyncedDTO results = service.findUnsyncedById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Unsynced
	 * @param data
	 * @return Unsynced
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UnsyncedDTO> createUnsynced(@Valid @RequestBody UnsyncedDTO data) throws Exception {
		try {
		    UnsyncedDTO createdData = service.createUnsynced(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Unsynced
	 * @param data
	 * @return Unsynced
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UnsyncedDTO> updateUnsynced(@Valid @RequestBody UnsyncedDTO data) throws Exception {
		UnsyncedDTO updatedData = service.updateUnsynced(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Unsynced by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUnsynced(@PathVariable int id) throws Exception {
		service.deleteUnsynced(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<UnsyncedDTO> by foreign key : userId
	 * @param id
	 * @return List<Unsynced>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<UnsyncedDTO>> findUnsyncedByUserId(@PathVariable int id) throws Exception {
		List<UnsyncedDTO> results = service.findUnsyncedByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
