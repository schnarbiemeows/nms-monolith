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
@RequestMapping(path="/resources")
public class ResourcesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ResourcesService businessService;

	/**
	 * get all Resources records
	 * @return Iterable<Resources>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ResourcesDTO>> getAllResources() throws Exception {
		List<ResourcesDTO> resources = businessService.getAllResources();
		return ResponseEntity.status(HttpStatus.OK).body(resources);
	}

	/**
	 * get Resources by primary key
	 * @param id
	 * @return Resources
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ResourcesDTO> findResourcesById(@PathVariable int id) throws Exception {
		ResourcesDTO results = businessService.findResourcesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Resources
	 * @param ResourcesDTO
	 * @return Resources
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ResourcesDTO> createResources(@Valid @RequestBody ResourcesDTO data) throws Exception {
		try {
		    ResourcesDTO createdData = businessService.createResources(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Resources
	 * @param ResourcesDTO
	 * @return Resources
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ResourcesDTO> updateResources(@Valid @RequestBody ResourcesDTO data) throws Exception {
		ResourcesDTO updatedData = businessService.updateResources(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Resources by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteResources(@PathVariable int id) throws Exception {
		businessService.deleteResources(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<ResourcesDTO> by foreign key : rsrcTypeId
	 * @param rsrcTypeId
	 * @return List<Resources>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRsrcTypeId/{id}")
	public ResponseEntity<List<ResourcesDTO>> findResourcesByRsrcTypeId(@PathVariable int id) throws Exception {
		List<ResourcesDTO> results = businessService.findResourcesByRsrcTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
