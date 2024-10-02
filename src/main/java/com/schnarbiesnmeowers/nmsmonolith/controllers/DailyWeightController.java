package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;
import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 *
 * @author Dylan I. Kessler
 * what methods do I need in here?
 * 
 */
@CrossOrigin
@RestController
@RequestMapping(path="/dailyweight")
public class DailyWeightController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyWeightService dailyWeightService;

	/**
	 * get all DailyWeight records
	 * @return Iterable<DailyWeight>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<DailyWeightDataPoint>> getAllDailyWeight() throws Exception {
		List<DailyWeightDataPoint> dailyweight = dailyWeightService.getAllDailyWeight();
		return ResponseEntity.status(HttpStatus.OK).body(dailyweight);
	}

	/**
	 * get DailyWeight by primary key
	 * @param id
	 * @return DailyWeight
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<DailyWeightDataPoint> findDailyWeightById(@PathVariable int id) throws Exception {
		DailyWeightDataPoint results = dailyWeightService.findDailyWeightById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new DailyWeight
	 * @param data
	 * @return DailyWeight
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<DailyWeightDataPoint> createDailyWeight(@Valid @RequestBody DailyWeightDataPoint data) throws Exception {
		try {
		    DailyWeightDataPoint createdData = dailyWeightService.createDailyWeight(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping(path = "/upload")
	public ResponseEntity<String> uploadData() throws Exception {
		String filepath = "C:\\temp\\Phase3\\dreamWeight\\weight5.xlsx";
		int userId = 1;
		String tabName = "weight3";
		int columnNumber = 2;
		dailyWeightService.uploadFile(filepath,userId,tabName,columnNumber);
		return ResponseEntity.status(HttpStatus.CREATED).body("Done!");
	}

	/**
	 * update a DailyWeight
	 * @param data
	 * @return DailyWeight
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<DailyWeightDataPoint> updateDailyWeight(@Valid @RequestBody DailyWeightDataPoint data) throws Exception {
		DailyWeightDataPoint updatedData = dailyWeightService.updateDailyWeight(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a DailyWeight by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteDailyWeight(@PathVariable int id) throws Exception {
		dailyWeightService.deleteDailyWeight(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<DailyWeightDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyWeight>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<DailyWeightDataPoint>> findDailyWeightByUserId(@PathVariable int id) throws Exception {
		List<DailyWeightDataPoint> results = dailyWeightService.findDailyWeightByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/findByUserIdSorted/{id}")
	public ResponseEntity<List<DailyWeightDataPoint>> findDailyWeightByUserIdSorted(@PathVariable int id) throws Exception {
		List<DailyWeightDataPoint> results = dailyWeightService.findDailyWeightByUserIdSorted(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/findByUserIdForRange/{id}/{days}")
	public ResponseEntity<DailyWeightDTO> findDailyWeightByUserIdForRange(@PathVariable int id, @PathVariable int days) throws Exception {
		DailyWeightDTO results = dailyWeightService.findDailyWeightByUserIdAndDate(id,days);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
