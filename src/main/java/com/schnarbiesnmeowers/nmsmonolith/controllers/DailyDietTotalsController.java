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
@RequestMapping(path="/dailydiettotals")
public class DailyDietTotalsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietTotalsService businessService;

	/**
	 * get all DailyDietTotals records
	 * @return Iterable<DailyDietTotals>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<DailyDietTotalsDTO>> getAllDailyDietTotals() throws Exception {
		List<DailyDietTotalsDTO> dailydiettotals = businessService.getAllDailyDietTotals();
		return ResponseEntity.status(HttpStatus.OK).body(dailydiettotals);
	}

	/**
	 * get DailyDietTotals by primary key
	 * @param id
	 * @return DailyDietTotals
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<DailyDietTotalsDTO> findDailyDietTotalsById(@PathVariable int id) throws Exception {
		DailyDietTotalsDTO results = businessService.findDailyDietTotalsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new DailyDietTotals
	 * @param data
	 * @return DailyDietTotals
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<DailyDietTotalsDTO> createDailyDietTotals(@Valid @RequestBody DailyDietTotalsDTO data) throws Exception {
		try {
		    DailyDietTotalsDTO createdData = businessService.createDailyDietTotals(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDietTotals
	 * @param data
	 * @return DailyDietTotals
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<DailyDietTotalsDTO> updateDailyDietTotals(@Valid @RequestBody DailyDietTotalsDTO data) throws Exception {
		DailyDietTotalsDTO updatedData = businessService.updateDailyDietTotals(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a DailyDietTotals by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteDailyDietTotals(@PathVariable int id) throws Exception {
		businessService.deleteDailyDietTotals(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<DailyDietTotalsDTO>> findDailyDietTotalsByUserId(@PathVariable int id) throws Exception {
		List<DailyDietTotalsDTO> results = businessService.findDailyDietTotalsByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : bldstId
	 * @param id
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByBldstId/{id}")
	public ResponseEntity<List<DailyDietTotalsDTO>> findDailyDietTotalsByBldstId(@PathVariable int id) throws Exception {
		List<DailyDietTotalsDTO> results = businessService.findDailyDietTotalsByBldstId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<DailyDietTotalsDTO> by foreign key : UserIdAndBldstId
	 * @param id0
	 * @return List<DailyDietTotals>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndBldstId/{id0}/{id1}")
	public ResponseEntity<List<DailyDietTotalsDTO>> findDailyDietTotalsByUserIdAndBldstId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<DailyDietTotalsDTO> results = businessService.findDailyDietTotalsByUserIdAndBldstId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
