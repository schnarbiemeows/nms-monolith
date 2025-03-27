package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/recipespices")
public class RecipeSpicesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeSpicesService recipeSpicesService;

	/**
	 * get all RecipeSpices records
	 * @return Iterable<RecipeSpices>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipeSpicesDTO>> getAllRecipeSpices() throws Exception {
		List<RecipeSpicesDTO> recipespices = recipeSpicesService.getAllRecipeSpices();
		return ResponseEntity.status(HttpStatus.OK).body(recipespices);
	}

	/**
	 * get RecipeSpices by primary key
	 * @param id
	 * @return RecipeSpices
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeSpicesDTO> findRecipeSpicesById(@PathVariable int id) throws Exception {
		RecipeSpicesDTO results = recipeSpicesService.findRecipeSpicesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecipeSpices
	 * @param data
	 * @return RecipeSpices
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipeSpicesDTO> createRecipeSpices(@Valid @RequestBody RecipeSpicesDTO data) throws Exception {
		try {
		    RecipeSpicesDTO createdData = recipeSpicesService.createRecipeSpices(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeSpices
	 * @param data
	 * @return RecipeSpices
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecipeSpicesDTO> updateRecipeSpices(@Valid @RequestBody RecipeSpicesDTO data) throws Exception {
		RecipeSpicesDTO updatedData = recipeSpicesService.updateRecipeSpices(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecipeSpices by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipeSpices(@PathVariable int id) throws Exception {
		recipeSpicesService.deleteRecipeSpices(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecipeSpicesDTO> by foreign key : recipeId
	 * @param id
	 * @return List<RecipeSpices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeId/{id}")
	public ResponseEntity<List<RecipeSpicesDTO>> findRecipeSpicesByRecipeId(@PathVariable int id) throws Exception {
		List<RecipeSpicesDTO> results = recipeSpicesService.findRecipeSpicesByRecipeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecipeSpicesDTO> by foreign key : spiceId
	 * @param id
	 * @return List<RecipeSpices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findBySpiceId/{id}")
	public ResponseEntity<List<RecipeSpicesDTO>> findRecipeSpicesBySpiceId(@PathVariable int id) throws Exception {
		List<RecipeSpicesDTO> results = recipeSpicesService.findRecipeSpicesBySpiceId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}


}
