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
@RequestMapping(path="/periods")
public class PeriodsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PeriodsService businessService;

	/**
	 * get all Periods records
	 * @return Iterable<Periods>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<PeriodsDTO>> getAllPeriods() throws Exception {
		List<PeriodsDTO> periods = businessService.getAllPeriods();
		return ResponseEntity.status(HttpStatus.OK).body(periods);
	}

	/**
	 * get Periods by primary key
	 * @param id
	 * @return Periods
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<PeriodsDTO> findPeriodsById(@PathVariable int id) throws Exception {
		PeriodsDTO results = businessService.findPeriodsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Periods
	 * @param PeriodsDTO
	 * @return Periods
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<PeriodsDTO> createPeriods(@Valid @RequestBody PeriodsDTO data) throws Exception {
		try {
		    PeriodsDTO createdData = businessService.createPeriods(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Periods
	 * @param PeriodsDTO
	 * @return Periods
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<PeriodsDTO> updatePeriods(@Valid @RequestBody PeriodsDTO data) throws Exception {
		PeriodsDTO updatedData = businessService.updatePeriods(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Periods by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePeriods(@PathVariable int id) throws Exception {
		businessService.deletePeriods(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<PeriodsDTO> by foreign key : periodTypeId
	 * @param periodTypeId
	 * @return List<Periods>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByPeriodTypeId/{id}")
	public ResponseEntity<List<PeriodsDTO>> findPeriodsByPeriodTypeId(@PathVariable int id) throws Exception {
		List<PeriodsDTO> results = businessService.findPeriodsByPeriodTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
