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
@RequestMapping(path="/manualfooditems")
public class ManualFoodItemsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ManualFoodItemsService service;

	/**
	 * get all ManualFoodItems records
	 * @return Iterable<ManualFoodItems>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ManualFoodItemsDTO>> getAllManualFoodItems() throws Exception {
		List<ManualFoodItemsDTO> manualfooditems = service.getAllManualFoodItems();
		return ResponseEntity.status(HttpStatus.OK).body(manualfooditems);
	}

	/**
	 * get ManualFoodItems by primary key
	 * @param id
	 * @return ManualFoodItems
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ManualFoodItemsDTO> findManualFoodItemsById(@PathVariable int id) throws Exception {
		ManualFoodItemsDTO results = service.findManualFoodItemsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ManualFoodItems
	 * @param data
	 * @return ManualFoodItems
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ManualFoodItemsDTO> createManualFoodItems(@Valid @RequestBody ManualFoodItemsDTO data) throws Exception {
		try {
		    ManualFoodItemsDTO createdData = service.createManualFoodItems(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ManualFoodItems
	 * @param data
	 * @return ManualFoodItems
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ManualFoodItemsDTO> updateManualFoodItems(@Valid @RequestBody ManualFoodItemsDTO data) throws Exception {
		ManualFoodItemsDTO updatedData = service.updateManualFoodItems(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ManualFoodItems by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteManualFoodItems(@PathVariable int id) throws Exception {
		service.deleteManualFoodItems(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : userId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<ManualFoodItemsDTO>> findManualFoodItemsByUserId(@PathVariable int id) throws Exception {
		List<ManualFoodItemsDTO> results = service.findManualFoodItemsByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : bldstId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByBldstId/{id}")
	public ResponseEntity<List<ManualFoodItemsDTO>> findManualFoodItemsByBldstId(@PathVariable int id) throws Exception {
		List<ManualFoodItemsDTO> results = service.findManualFoodItemsByBldstId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId/{id}")
	public ResponseEntity<List<ManualFoodItemsDTO>> findManualFoodItemsByServTypeId(@PathVariable int id) throws Exception {
		List<ManualFoodItemsDTO> results = service.findManualFoodItemsByServTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : UserIdAndBldstIdAndServTypeId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndBldstIdAndServTypeId/{id0}/{id1}/{id2}")
	public ResponseEntity<List<ManualFoodItemsDTO>> findManualFoodItemsByUserIdAndBldstIdAndServTypeId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<ManualFoodItemsDTO> results = service.findManualFoodItemsByUserIdAndBldstIdAndServTypeId(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
