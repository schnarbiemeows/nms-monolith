package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
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
@RequestMapping(path="/liftmuscle")
public class LiftMuscleController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftMuscleService service;

	/**
	 * get all LiftMuscle records
	 * @return Iterable<LiftMuscle>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LiftMuscleDTO>> getAllLiftMuscle() throws Exception {
		List<LiftMuscleDTO> liftmuscle = service.getAllLiftMuscle();
		return ResponseEntity.status(HttpStatus.OK).body(liftmuscle);
	}

	/**
	 * get LiftMuscle by primary key
	 * @param id
	 * @return LiftMuscle
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LiftMuscleDTO> findLiftMuscleById(@PathVariable int id) throws Exception {
		LiftMuscleDTO results = service.findLiftMuscleById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LiftMuscle
	 * @param data
	 * @return LiftMuscle
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LiftMuscleDTO> createLiftMuscle(@Valid @RequestBody LiftMuscleDTO data) throws Exception {
		try {
		    LiftMuscleDTO createdData = service.createLiftMuscle(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftMuscle
	 * @param data
	 * @return LiftMuscle
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LiftMuscleDTO> updateLiftMuscle(@Valid @RequestBody LiftMuscleDTO data) throws Exception {
		LiftMuscleDTO updatedData = service.updateLiftMuscle(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LiftMuscle by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLiftMuscle(@PathVariable int id) throws Exception {
		service.deleteLiftMuscle(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LiftMuscleDTO> by foreign key : liftId
	 * @param id
	 * @return List<LiftMuscle>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftId/{id}")
	public ResponseEntity<List<LiftMuscleDTO>> findLiftMuscleByLiftId(@PathVariable int id) throws Exception {
		List<LiftMuscleDTO> results = service.findLiftMuscleByLiftId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftMuscleDTO> by foreign key : muscleId
	 * @param id
	 * @return List<LiftMuscle>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMuscleId/{id}")
	public ResponseEntity<List<LiftMuscleDTO>> findLiftMuscleByMuscleId(@PathVariable int id) throws Exception {
		List<LiftMuscleDTO> results = service.findLiftMuscleByMuscleId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
}
