package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalRecipeIngredientsDTO;
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
@RequestMapping(path="/localrecipeingredients")
public class LocalRecipeIngredientsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipeIngredientsService localRecipeIngredientsService;

	/**
	 * get all LocalRecipeIngredients records
	 * @return Iterable<LocalRecipeIngredients>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalRecipeIngredientsDTO>> getAllLocalRecipeIngredients() throws Exception {
		List<LocalRecipeIngredientsDTO> localrecipeingredients = localRecipeIngredientsService.getAllLocalRecipeIngredients();
		return ResponseEntity.status(HttpStatus.OK).body(localrecipeingredients);
	}

	/**
	 * get LocalRecipeIngredients by primary key
	 * @param id
	 * @return LocalRecipeIngredients
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LocalRecipeIngredientsDTO> findLocalRecipeIngredientsById(@PathVariable int id) throws Exception {
		LocalRecipeIngredientsDTO results = localRecipeIngredientsService.findLocalRecipeIngredientsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LocalRecipeIngredients
	 * @param data
	 * @return LocalRecipeIngredients
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalRecipeIngredientsDTO> createLocalRecipeIngredients(@Valid @RequestBody LocalRecipeIngredientsDTO data) throws Exception {
		try {
		    LocalRecipeIngredientsDTO createdData = localRecipeIngredientsService.createLocalRecipeIngredients(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipeIngredients
	 * @param data
	 * @return LocalRecipeIngredients
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LocalRecipeIngredientsDTO> updateLocalRecipeIngredients(@Valid @RequestBody LocalRecipeIngredientsDTO data) throws Exception {
		LocalRecipeIngredientsDTO updatedData = localRecipeIngredientsService.updateLocalRecipeIngredients(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LocalRecipeIngredients by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLocalRecipeIngredients(@PathVariable int id) throws Exception {
		localRecipeIngredientsService.deleteLocalRecipeIngredients(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
