package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpiceArrayInput;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeSpiceDisplay;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
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
@RequestMapping(path="/spices")
public class SpicesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private SpicesService spicesService;

	/**
	 * get all Spices records
	 * @return Iterable<Spices>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<SpicesDTO>> getAllSpices() throws Exception {
		List<SpicesDTO> spices = spicesService.getAllSpices();
		return ResponseEntity.status(HttpStatus.OK).body(spices);
	}

	/**
	 * get all Spices records
	 * @return Iterable<Spices>
	 */
	@GetMapping(path = "/all-displays/{id}")
	public ResponseEntity<SpicesWrapper> getAllSpiceDisplays(@PathVariable int id) throws Exception {
		SpicesWrapper ingredients = spicesService.getAllSpiceDisplays(id);
		return ResponseEntity.status(HttpStatus.OK).body(ingredients);
	}
	
	/**
	 * get Spices by primary key
	 * @param id
	 * @return Spices
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<SpicesDTO> findSpicesById(@PathVariable int id) throws Exception {
		SpicesDTO results = spicesService.findSpicesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get Spices by primary key
	 * @param id
	 * @return Spices
	 */
	@PostMapping(path = "/findByIds")
	public ResponseEntity<List<RecipeSpiceDisplay>> findSpicesByIds(@Valid @RequestBody SpiceArrayInput id) throws Exception {
		List<RecipeSpiceDisplay> results = spicesService.findSpicesByIds(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get Spice by primary key
	 * this happens when a user selects a spice on the spices page for inclusion in a recipe
	 * and returns to the recipe page
	 * @param id
	 * @return LocalSpices
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeSpiceDisplay> findSpiceDisplayById(@PathVariable int id) throws Exception {
		RecipeSpiceDisplay results = spicesService.findSpiceDisplayById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	
	/**
	 * create a new Spices
	 * @param data
	 * @return Spices
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<SpicesDTO> createSpices(@Valid @RequestBody SpicesDTO data) throws Exception {
		try {
		    SpicesDTO createdData = spicesService.createSpices(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Spices
	 * @param data
	 * @return Spices
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<SpicesDTO> updateSpices(@Valid @RequestBody SpicesDTO data) throws Exception {
		SpicesDTO updatedData = spicesService.updateSpices(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Spices by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteSpices(@PathVariable int id) throws Exception {
		spicesService.deleteSpices(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<SpicesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Spices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<SpicesDTO>> findSpicesByImageLoc(@PathVariable int id) throws Exception {
		List<SpicesDTO> results = spicesService.findSpicesByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
