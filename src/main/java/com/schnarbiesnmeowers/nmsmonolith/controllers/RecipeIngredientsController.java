package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
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
@RequestMapping(path="/recipeingredients")
public class RecipeIngredientsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeIngredientsService recipeIngredientsService;

	/**
	 * get all RecipeIngredients records
	 * @return Iterable<RecipeIngredients>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipeIngredientsDTO>> getAllRecipeIngredients() throws Exception {
		List<RecipeIngredientsDTO> recipeingredients = recipeIngredientsService.getAllRecipeIngredients();
		return ResponseEntity.status(HttpStatus.OK).body(recipeingredients);
	}

	/**
	 * get RecipeIngredients by primary key
	 * @param id
	 * @return RecipeIngredients
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeIngredientsDTO> findRecipeIngredientsById(@PathVariable int id) throws Exception {
		RecipeIngredientsDTO results = recipeIngredientsService.findRecipeIngredientsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecipeIngredients
	 * @param data
	 * @return RecipeIngredients
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipeIngredientsDTO> createRecipeIngredients(@Valid @RequestBody RecipeIngredientsDTO data) throws Exception {
		try {
		    RecipeIngredientsDTO createdData = recipeIngredientsService.createRecipeIngredients(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeIngredients
	 * @param data
	 * @return RecipeIngredients
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecipeIngredientsDTO> updateRecipeIngredients(@Valid @RequestBody RecipeIngredientsDTO data) throws Exception {
		RecipeIngredientsDTO updatedData = recipeIngredientsService.updateRecipeIngredients(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecipeIngredients by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipeIngredients(@PathVariable int id) throws Exception {
		recipeIngredientsService.deleteRecipeIngredients(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecipeIngredientsDTO> by foreign key : recipeId
	 * @param id
	 * @return List<RecipeIngredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeId/{id}")
	public ResponseEntity<List<RecipeIngredientsDTO>> findRecipeIngredientsByRecipeId(@PathVariable int id) throws Exception {
		List<RecipeIngredientsDTO> results = recipeIngredientsService.findRecipeIngredientsByRecipeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
