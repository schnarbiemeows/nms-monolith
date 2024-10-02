package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.FavoriteIngredientsDTO;
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
@RequestMapping(path="/favoriteingredients")
public class FavoriteIngredientsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteIngredientsService favoriteIngredientsService;

	/**
	 * get all FavoriteIngredients records
	 * @return Iterable<FavoriteIngredients>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<FavoriteIngredientsDTO>> getAllFavoriteIngredients() throws Exception {
		List<FavoriteIngredientsDTO> favoriteingredients = favoriteIngredientsService.getAllFavoriteIngredients();
		return ResponseEntity.status(HttpStatus.OK).body(favoriteingredients);
	}

	/**
	 * get FavoriteIngredients by primary key
	 * @param id
	 * @return FavoriteIngredients
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<FavoriteIngredientsDTO> findFavoriteIngredientsById(@PathVariable int id) throws Exception {
		FavoriteIngredientsDTO results = favoriteIngredientsService.findFavoriteIngredientsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new FavoriteIngredients
	 * @param data
	 * @return FavoriteIngredients
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<FavoriteIngredientsDTO> createFavoriteIngredients(@Valid @RequestBody FavoriteIngredientsDTO data) throws Exception {
		try {
		    FavoriteIngredientsDTO createdData = favoriteIngredientsService.createFavoriteIngredients(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteIngredients
	 * @param data
	 * @return FavoriteIngredients
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<FavoriteIngredientsDTO> updateFavoriteIngredients(@Valid @RequestBody FavoriteIngredientsDTO data) throws Exception {
		FavoriteIngredientsDTO updatedData = favoriteIngredientsService.updateFavoriteIngredients(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a FavoriteIngredients by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteFavoriteIngredients(@PathVariable int id) throws Exception {
		favoriteIngredientsService.deleteFavoriteIngredients(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
