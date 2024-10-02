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
@RequestMapping(path="/lifts")
public class LiftsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftsService liftsService;

	/**
	 * get all Lifts records
	 * @return Iterable<Lifts>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LiftsDTO>> getAllLifts() throws Exception {
		List<LiftsDTO> lifts = liftsService.getAllLifts();
		return ResponseEntity.status(HttpStatus.OK).body(lifts);
	}

	@GetMapping(path = "/allordered")
	public ResponseEntity<List<LiftsDTO>> getAllLiftsOrdered() throws Exception {
		List<LiftsDTO> lifts = liftsService.getAllLiftsOrdered();
		return ResponseEntity.status(HttpStatus.OK).body(lifts);
	}

	/**
	 * get Lifts by primary key
	 * @param id
	 * @return Lifts
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LiftsDTO> findLiftsById(@PathVariable int id) throws Exception {
		LiftsDTO results = liftsService.findLiftsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Lifts
	 * @param data
	 * @return Lifts
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LiftsDTO> createLifts(@Valid @RequestBody LiftsDTO data) throws Exception {
		try {
		    LiftsDTO createdData = liftsService.createLifts(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Lifts
	 * @param data
	 * @return Lifts
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LiftsDTO> updateLifts(@Valid @RequestBody LiftsDTO data) throws Exception {
		LiftsDTO updatedData = liftsService.updateLifts(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Lifts by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLifts(@PathVariable int id) throws Exception {
		liftsService.deleteLifts(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}


	/**
	 * get List<LiftsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Lifts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LiftsDTO>> findLiftsByImageLoc(@PathVariable int id) throws Exception {
		List<LiftsDTO> results = liftsService.findLiftsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}


}
