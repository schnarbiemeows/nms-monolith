package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.FavoriteRecipesDTO;
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
@RequestMapping(path="/favoriterecipes")
public class FavoriteRecipesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteRecipesService service;

	/**
	 * get all FavoriteRecipes records
	 * @return Iterable<FavoriteRecipes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<FavoriteRecipesDTO>> getAllFavoriteRecipes() throws Exception {
		List<FavoriteRecipesDTO> favoriterecipes = service.getAllFavoriteRecipes();
		return ResponseEntity.status(HttpStatus.OK).body(favoriterecipes);
	}

	/**
	 * get FavoriteRecipes by primary key
	 * @param id
	 * @return FavoriteRecipes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<FavoriteRecipesDTO> findFavoriteRecipesById(@PathVariable int id) throws Exception {
		FavoriteRecipesDTO results = service.findFavoriteRecipesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new FavoriteRecipes
	 * @param data
	 * @return FavoriteRecipes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<FavoriteRecipesDTO> createFavoriteRecipes(@Valid @RequestBody FavoriteRecipesDTO data) throws Exception {
		try {
		    FavoriteRecipesDTO createdData = service.createFavoriteRecipes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteRecipes
	 * @param data
	 * @return FavoriteRecipes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<FavoriteRecipesDTO> updateFavoriteRecipes(@Valid @RequestBody FavoriteRecipesDTO data) throws Exception {
		FavoriteRecipesDTO updatedData = service.updateFavoriteRecipes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a FavoriteRecipes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteFavoriteRecipes(@PathVariable int id) throws Exception {
		service.deleteFavoriteRecipes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
