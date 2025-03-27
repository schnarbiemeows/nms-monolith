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
@RequestMapping(path="/localrecipesteps")
public class LocalRecipeStepsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipeStepsService service;

	/**
	 * get all LocalRecipeSteps records
	 * @return Iterable<LocalRecipeSteps>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalRecipeStepsDTO>> getAllLocalRecipeSteps() throws Exception {
		List<LocalRecipeStepsDTO> localrecipesteps = service.getAllLocalRecipeSteps();
		return ResponseEntity.status(HttpStatus.OK).body(localrecipesteps);
	}

	/**
	 * get LocalRecipeSteps by primary key
	 * @param id
	 * @return LocalRecipeSteps
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LocalRecipeStepsDTO> findLocalRecipeStepsById(@PathVariable int id) throws Exception {
		LocalRecipeStepsDTO results = service.findLocalRecipeStepsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LocalRecipeSteps
	 * @param data
	 * @return LocalRecipeSteps
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalRecipeStepsDTO> createLocalRecipeSteps(@Valid @RequestBody LocalRecipeStepsDTO data) throws Exception {
		try {
		    LocalRecipeStepsDTO createdData = service.createLocalRecipeSteps(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipeSteps
	 * @param data
	 * @return LocalRecipeSteps
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LocalRecipeStepsDTO> updateLocalRecipeSteps(@Valid @RequestBody LocalRecipeStepsDTO data) throws Exception {
		LocalRecipeStepsDTO updatedData = service.updateLocalRecipeSteps(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LocalRecipeSteps by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLocalRecipeSteps(@PathVariable int id) throws Exception {
		service.deleteLocalRecipeSteps(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LocalRecipeStepsDTO> by foreign key : recipeId
	 * @param id
	 * @return List<LocalRecipeSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeId/{id}")
	public ResponseEntity<List<LocalRecipeStepsDTO>> findLocalRecipeStepsByRecipeId(@PathVariable int id) throws Exception {
		List<LocalRecipeStepsDTO> results = service.findLocalRecipeStepsByRecipeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalRecipeStepsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalRecipeSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LocalRecipeStepsDTO>> findLocalRecipeStepsByImageLoc(@PathVariable int id) throws Exception {
		List<LocalRecipeStepsDTO> results = service.findLocalRecipeStepsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalRecipeStepsDTO> by foreign key : RecipeIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/findByRecipeIdAndImageLoc/{id0}/{id1}")
	public ResponseEntity<List<LocalRecipeStepsDTO>> findLocalRecipeStepsByRecipeIdAndImageLoc(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<LocalRecipeStepsDTO> results = service.findLocalRecipeStepsByRecipeIdAndImageLoc(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
