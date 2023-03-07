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
@RequestMapping(path="/musclegroups")
public class MuscleGroupsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MuscleGroupsService businessService;

	/**
	 * get all MuscleGroups records
	 * @return Iterable<MuscleGroups>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<MuscleGroupsDTO>> getAllMuscleGroups() throws Exception {
		List<MuscleGroupsDTO> musclegroups = businessService.getAllMuscleGroups();
		return ResponseEntity.status(HttpStatus.OK).body(musclegroups);
	}

	/**
	 * get MuscleGroups by primary key
	 * @param id
	 * @return MuscleGroups
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<MuscleGroupsDTO> findMuscleGroupsById(@PathVariable int id) throws Exception {
		MuscleGroupsDTO results = businessService.findMuscleGroupsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new MuscleGroups
	 * @param MuscleGroupsDTO
	 * @return MuscleGroups
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<MuscleGroupsDTO> createMuscleGroups(@Valid @RequestBody MuscleGroupsDTO data) throws Exception {
		try {
		    MuscleGroupsDTO createdData = businessService.createMuscleGroups(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a MuscleGroups
	 * @param MuscleGroupsDTO
	 * @return MuscleGroups
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<MuscleGroupsDTO> updateMuscleGroups(@Valid @RequestBody MuscleGroupsDTO data) throws Exception {
		MuscleGroupsDTO updatedData = businessService.updateMuscleGroups(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a MuscleGroups by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteMuscleGroups(@PathVariable int id) throws Exception {
		businessService.deleteMuscleGroups(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
