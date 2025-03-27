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
@RequestMapping(path="/recipesteps")
public class RecipeStepsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeStepsService businessService;

	/**
	 * get all RecipeSteps records
	 * @return Iterable<RecipeSteps>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipeStepsDTO>> getAllRecipeSteps() throws Exception {
		List<RecipeStepsDTO> recipesteps = businessService.getAllRecipeSteps();
		return ResponseEntity.status(HttpStatus.OK).body(recipesteps);
	}

	/**
	 * get RecipeSteps by primary key
	 * @param id
	 * @return RecipeSteps
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeStepsDTO> findRecipeStepsById(@PathVariable int id) throws Exception {
		RecipeStepsDTO results = businessService.findRecipeStepsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecipeSteps
	 * @param RecipeStepsDTO
	 * @return RecipeSteps
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipeStepsDTO> createRecipeSteps(@Valid @RequestBody RecipeStepsDTO data) throws Exception {
		try {
		    RecipeStepsDTO createdData = businessService.createRecipeSteps(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeSteps
	 * @param RecipeStepsDTO
	 * @return RecipeSteps
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecipeStepsDTO> updateRecipeSteps(@Valid @RequestBody RecipeStepsDTO data) throws Exception {
		RecipeStepsDTO updatedData = businessService.updateRecipeSteps(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecipeSteps by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipeSteps(@PathVariable int id) throws Exception {
		businessService.deleteRecipeSteps(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : recipeId
	 * @param recipeId
	 * @return List<RecipeSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeId/{id}")
	public ResponseEntity<List<RecipeStepsDTO>> findRecipeStepsByRecipeId(@PathVariable int id) throws Exception {
		List<RecipeStepsDTO> results = businessService.findRecipeStepsByRecipeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<RecipeSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<RecipeStepsDTO>> findRecipeStepsByImageLoc(@PathVariable int id) throws Exception {
		List<RecipeStepsDTO> results = businessService.findRecipeStepsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecipeStepsDTO> by foreign key : RecipeIdAndImageLoc
	 * @param RecipeIdAndImageLoc
	 * @return List<RecipeSteps>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeIdAndImageLoc/{id0}/{id1}")
	public ResponseEntity<List<RecipeStepsDTO>> findRecipeStepsByRecipeIdAndImageLoc(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<RecipeStepsDTO> results = businessService.findRecipeStepsByRecipeIdAndImageLoc(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
