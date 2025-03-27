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
@RequestMapping(path="/muscles")
public class MusclesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MusclesService businessService;

	/**
	 * get all Muscles records
	 * @return Iterable<Muscles>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<MusclesDTO>> getAllMuscles() throws Exception {
		List<MusclesDTO> muscles = businessService.getAllMuscles();
		return ResponseEntity.status(HttpStatus.OK).body(muscles);
	}

	/**
	 * get Muscles by primary key
	 * @param id
	 * @return Muscles
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<MusclesDTO> findMusclesById(@PathVariable int id) throws Exception {
		MusclesDTO results = businessService.findMusclesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Muscles
	 * @param MusclesDTO
	 * @return Muscles
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<MusclesDTO> createMuscles(@Valid @RequestBody MusclesDTO data) throws Exception {
		try {
		    MusclesDTO createdData = businessService.createMuscles(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Muscles
	 * @param MusclesDTO
	 * @return Muscles
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<MusclesDTO> updateMuscles(@Valid @RequestBody MusclesDTO data) throws Exception {
		MusclesDTO updatedData = businessService.updateMuscles(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Muscles by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteMuscles(@PathVariable int id) throws Exception {
		businessService.deleteMuscles(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<MusclesDTO> by foreign key : muscleGroupId
	 * @param muscleGroupId
	 * @return List<Muscles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMuscleGroupId/{id}")
	public ResponseEntity<List<MusclesDTO>> findMusclesByMuscleGroupId(@PathVariable int id) throws Exception {
		List<MusclesDTO> results = businessService.findMusclesByMuscleGroupId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<MusclesDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Muscles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<MusclesDTO>> findMusclesByImageLoc(@PathVariable int id) throws Exception {
		List<MusclesDTO> results = businessService.findMusclesByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<MusclesDTO> by foreign key : MuscleGroupIdAndImageLoc
	 * @param MuscleGroupIdAndImageLoc
	 * @return List<Muscles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMuscleGroupIdAndImageLoc/{id0}/{id1}")
	public ResponseEntity<List<MusclesDTO>> findMusclesByMuscleGroupIdAndImageLoc(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<MusclesDTO> results = businessService.findMusclesByMuscleGroupIdAndImageLoc(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
