package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeOptionsDTO;
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

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/servingtypeoptions")
public class ServingTypeOptionsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ServingTypeOptionsService service;

	/**
	 * get all ServingTypeOptions records
	 * @return Iterable<ServingTypeOptions>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ServingTypeOptionsDTO>> getAllServingTypeOptions() throws Exception {
		List<ServingTypeOptionsDTO> servingtypeoptions = service.getAllServingTypeOptions();
		return ResponseEntity.status(HttpStatus.OK).body(servingtypeoptions);
	}

	/**
	 * get ServingTypeOptions by primary key
	 * @param id
	 * @return ServingTypeOptions
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ServingTypeOptionsDTO> findServingTypeOptionsById(@PathVariable int id) throws Exception {
		ServingTypeOptionsDTO results = service.findServingTypeOptionsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ServingTypeOptions
	 * @param data
	 * @return ServingTypeOptions
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ServingTypeOptionsDTO> createServingTypeOptions(@Valid @RequestBody ServingTypeOptionsDTO data) throws Exception {
		try {
		    ServingTypeOptionsDTO createdData = service.createServingTypeOptions(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ServingTypeOptions
	 * @param data
	 * @return ServingTypeOptions
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ServingTypeOptionsDTO> updateServingTypeOptions(@Valid @RequestBody ServingTypeOptionsDTO data) throws Exception {
		ServingTypeOptionsDTO updatedData = service.updateServingTypeOptions(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ServingTypeOptions by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteServingTypeOptions(@PathVariable int id) throws Exception {
		service.deleteServingTypeOptions(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<ServingTypeOptionsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<ServingTypeOptions>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId/{id}")
	public ResponseEntity<List<ServingTypeOptionsDTO>> findServingTypeOptionsByServTypeId(@PathVariable int id) throws Exception {
		List<ServingTypeOptionsDTO> results = service.findServingTypeOptionsByServTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ServingTypeOptionsDTO> by foreign key : menuOption
	 * @param id
	 * @return List<ServingTypeOptions>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMenuOption/{id}")
	public ResponseEntity<List<ServingTypeOptionsDTO>> findServingTypeOptionsByMenuOption(@PathVariable int id) throws Exception {
		List<ServingTypeOptionsDTO> results = service.findServingTypeOptionsByMenuOption(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ServingTypeOptionsDTO> by foreign key : ServTypeIdAndMenuOption
	 * @param id
	 * @return List<ServingTypeOptions>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeIdAndMenuOption/{id0}/{id1}")
	public ResponseEntity<List<ServingTypeOptionsDTO>> findServingTypeOptionsByServTypeIdAndMenuOption(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<ServingTypeOptionsDTO> results = service.findServingTypeOptionsByServTypeIdAndMenuOption(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
