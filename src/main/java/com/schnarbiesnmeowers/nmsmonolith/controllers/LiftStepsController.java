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
@RequestMapping(path="/liftsteps")
public class LiftStepsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftStepsService businessService;

	/**
	 * get all LiftSteps records
	 * @return Iterable<LiftSteps>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LiftStepsDTO>> getAllLiftSteps() throws Exception {
		List<LiftStepsDTO> liftsteps = businessService.getAllLiftSteps();
		return ResponseEntity.status(HttpStatus.OK).body(liftsteps);
	}

	/**
	 * get LiftSteps by primary key
	 * @param id
	 * @return LiftSteps
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LiftStepsDTO> findLiftStepsById(@PathVariable int id) throws Exception {
		LiftStepsDTO results = businessService.findLiftStepsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LiftSteps
	 * @param LiftStepsDTO
	 * @return LiftSteps
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LiftStepsDTO> createLiftSteps(@Valid @RequestBody LiftStepsDTO data) throws Exception {
		try {
		    LiftStepsDTO createdData = businessService.createLiftSteps(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftSteps
	 * @param LiftStepsDTO
	 * @return LiftSteps
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LiftStepsDTO> updateLiftSteps(@Valid @RequestBody LiftStepsDTO data) throws Exception {
		LiftStepsDTO updatedData = businessService.updateLiftSteps(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LiftSteps by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLiftSteps(@PathVariable int id) throws Exception {
		businessService.deleteLiftSteps(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftId/{id}")
	public ResponseEntity<List<LiftStepsDTO>> findLiftStepsByLiftId(@PathVariable int id) throws Exception {
		List<LiftStepsDTO> results = businessService.findLiftStepsByLiftId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LiftStepsDTO>> findLiftStepsByImageLoc(@PathVariable int id) throws Exception {
		List<LiftStepsDTO> results = businessService.findLiftStepsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftStepsDTO> by foreign key : LiftIdAndImageLoc
	 * @param LiftIdAndImageLoc
	 * @return List<LiftSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftIdAndImageLoc/{id0}/{id1}")
	public ResponseEntity<List<LiftStepsDTO>> findLiftStepsByLiftIdAndImageLoc(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<LiftStepsDTO> results = businessService.findLiftStepsByLiftIdAndImageLoc(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
