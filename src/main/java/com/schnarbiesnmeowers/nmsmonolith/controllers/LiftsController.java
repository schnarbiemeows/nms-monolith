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
@RequestMapping(path="/lifts")
public class LiftsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftsService businessService;

	/**
	 * get all Lifts records
	 * @return Iterable<Lifts>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LiftsDTO>> getAllLifts() throws Exception {
		List<LiftsDTO> lifts = businessService.getAllLifts();
		return ResponseEntity.status(HttpStatus.OK).body(lifts);
	}

	/**
	 * get Lifts by primary key
	 * @param id
	 * @return Lifts
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LiftsDTO> findLiftsById(@PathVariable int id) throws Exception {
		LiftsDTO results = businessService.findLiftsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Lifts
	 * @param LiftsDTO
	 * @return Lifts
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LiftsDTO> createLifts(@Valid @RequestBody LiftsDTO data) throws Exception {
		try {
		    LiftsDTO createdData = businessService.createLifts(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Lifts
	 * @param LiftsDTO
	 * @return Lifts
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LiftsDTO> updateLifts(@Valid @RequestBody LiftsDTO data) throws Exception {
		LiftsDTO updatedData = businessService.updateLifts(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Lifts by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLifts(@PathVariable int id) throws Exception {
		businessService.deleteLifts(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LiftsDTO> by foreign key : muscleId
	 * @param muscleId
	 * @return List<Lifts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMuscleId/{id}")
	public ResponseEntity<List<LiftsDTO>> findLiftsByMuscleId(@PathVariable int id) throws Exception {
		List<LiftsDTO> results = businessService.findLiftsByMuscleId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Lifts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LiftsDTO>> findLiftsByImageLoc(@PathVariable int id) throws Exception {
		List<LiftsDTO> results = businessService.findLiftsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftsDTO> by foreign key : MuscleIdAndImageLoc
	 * @param MuscleIdAndImageLoc
	 * @return List<Lifts>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMuscleIdAndImageLoc/{id0}/{id1}")
	public ResponseEntity<List<LiftsDTO>> findLiftsByMuscleIdAndImageLoc(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<LiftsDTO> results = businessService.findLiftsByMuscleIdAndImageLoc(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
