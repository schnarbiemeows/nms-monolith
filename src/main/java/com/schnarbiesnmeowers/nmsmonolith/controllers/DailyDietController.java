package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietRequest;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/dailydiet")
public class DailyDietController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietService dailyDietService;

	/**
	 * get all DailyDiet records
	 * @return Iterable<DailyDiet>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<DailyDietDTO>> getAllDailyDiet() throws Exception {
		List<DailyDietDTO> dailydiet = dailyDietService.getAllDailyDiet();
		return ResponseEntity.status(HttpStatus.OK).body(dailydiet);
	}

	/**
	 * create a new DailyDiet
	 * @param input
	 * @return DailyDiet
	 */
	@PostMapping(path = "/date")
	public ResponseEntity<DailyDietWrapper> getDailyDietForDate(@Valid @RequestBody DailyDietRequest input) throws Exception {
		try {
			DailyDietWrapper dailyData = dailyDietService.getDailyDietForDate(input);
			return ResponseEntity.status(HttpStatus.OK).body(dailyData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * get DailyDiet by primary key
	 * @param id
	 * @return DailyDiet
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<DailyDietDTO> findDailyDietById(@PathVariable int id) throws Exception {
		DailyDietDTO results = dailyDietService.findDailyDietById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new DailyDiet
	 * @param data
	 * @return DailyDiet
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<DailyDietWrapper> createDailyDiet(@Valid @RequestBody DailyDietDTO data) throws Exception {
		try {
			DailyDietWrapper createdData = dailyDietService.createDailyDiet(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * clone all of the DailyDiet and DailyDietaryNote records from one date to another
	 * @param data
	 * @return DailyDiet
	 */
	@PostMapping(path = "/clone")
	public ResponseEntity<DailyDietWrapper> cloneDailyDiet(@Valid @RequestBody DailyDietWrapper data) throws Exception {
		DailyDietWrapper clonedData = dailyDietService.cloneDailyDiet(data);
		return ResponseEntity.status(HttpStatus.OK).body(clonedData);
	}

	/**
	 * update a DailyDiet
	 * @param data
	 * @return DailyDiet
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<DailyDietWrapper> updateDailyDiet(@Valid @RequestBody DailyDietDTO data) throws Exception {
		DailyDietWrapper updatedData = dailyDietService.updateDailyDiet(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a DailyDiet by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<DailyDietWrapper> deleteDailyDiet(@PathVariable int id) throws Exception {
		DailyDietWrapper response = dailyDietService.deleteDailyDiet(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/**
	 * get List<DailyDietDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<DailyDietDTO>> findDailyDietByUserId(@PathVariable int id) throws Exception {
		List<DailyDietDTO> results = dailyDietService.findDailyDietByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<DailyDietDTO> by foreign key : ingrId
	 * @param id
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByIngrId/{id}")
	public ResponseEntity<List<DailyDietDTO>> findDailyDietByIngrId(@PathVariable int id) throws Exception {
		List<DailyDietDTO> results = dailyDietService.findDailyDietByIngrId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<DailyDietDTO> by foreign key : bldstId
	 * @param id
	 * @return List<DailyDiet>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByBldstId/{id}")
	public ResponseEntity<List<DailyDietDTO>> findDailyDietByBldstId(@PathVariable int id) throws Exception {
		List<DailyDietDTO> results = dailyDietService.findDailyDietByBldstId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<DailyDietDTO> by foreign key : UserIdAndIngrIdAndBldstId
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/findByUserIdAndIngrIdAndBldstId/{id0}/{id1}/{id2}")
	public ResponseEntity<List<DailyDietDTO>> findDailyDietByUserIdAndIngrIdAndBldstId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<DailyDietDTO> results = dailyDietService.findDailyDietByUserIdAndIngrIdAndBldstId(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
