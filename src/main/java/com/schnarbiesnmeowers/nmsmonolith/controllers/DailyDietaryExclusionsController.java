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
@RequestMapping(path="/dailydietaryexclusions")
public class DailyDietaryExclusionsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietaryExclusionsService dailyDietaryExclusionsService;

	/**
	 * get all DailyDietaryExclusions records
	 * @return Iterable<DailyDietaryExclusions>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<DailyDietaryExclusionsDTO>> getAllDailyDietaryExclusions() throws Exception {
		List<DailyDietaryExclusionsDTO> dailydietaryexclusions = dailyDietaryExclusionsService.getAllDailyDietaryExclusions();
		return ResponseEntity.status(HttpStatus.OK).body(dailydietaryexclusions);
	}

	/**
	 * get DailyDietaryExclusions by primary key
	 * @param id
	 * @return DailyDietaryExclusions
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<DailyDietaryExclusionsDTO> findDailyDietaryExclusionsById(@PathVariable int id) throws Exception {
		DailyDietaryExclusionsDTO results = dailyDietaryExclusionsService.findDailyDietaryExclusionsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new DailyDietaryExclusions
	 * @param data
	 * @return DailyDietaryExclusions
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<DailyDietaryExclusionsDTO> createDailyDietaryExclusions(@Valid @RequestBody DailyDietaryExclusionsDTO data) throws Exception {
		try {
		    DailyDietaryExclusionsDTO createdData = dailyDietaryExclusionsService.createDailyDietaryExclusions(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDietaryExclusions
	 * @param data
	 * @return DailyDietaryExclusions
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<DailyDietaryExclusionsDTO> updateDailyDietaryExclusions(@Valid @RequestBody DailyDietaryExclusionsDTO data) throws Exception {
		DailyDietaryExclusionsDTO updatedData = dailyDietaryExclusionsService.updateDailyDietaryExclusions(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a DailyDietaryExclusions by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteDailyDietaryExclusions(@PathVariable int id) throws Exception {
		dailyDietaryExclusionsService.deleteDailyDietaryExclusions(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * update a DailyDietaryExclusions
	 * @param data
	 * @return DailyDietaryExclusions
	 */
	@PostMapping(path = "/remove")
	public ResponseEntity<ResponseMessage> deleteDailyDietaryExclusions(@Valid @RequestBody DailyDietaryExclusionsDTO data) throws Exception {
		dailyDietaryExclusionsService.deleteDailyDietaryExclusions(data.getUserId(),data.getCalendarDate());
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<DailyDietaryExclusionsDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietaryExclusions>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<DailyDietaryExclusionsDTO>> findDailyDietaryExclusionsByUserId(@PathVariable int id) throws Exception {
		List<DailyDietaryExclusionsDTO> results = dailyDietaryExclusionsService.findDailyDietaryExclusionsByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
