package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeIngredientDisplay;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.math.BigDecimal;
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
@RequestMapping(path="/localingredients")
public class LocalIngredientsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalIngredientsService localIngredientsService;

	/**
	 * get all LocalIngredients records
	 * @return Iterable<LocalIngredients>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalIngredientsDTO>> getAllLocalIngredients() throws Exception {
		List<LocalIngredientsDTO> localingredients = localIngredientsService.getAllLocalIngredients();
		return ResponseEntity.status(HttpStatus.OK).body(localingredients);
	}

	/**
	 * get LocalIngredients by primary key
	 * @param id
	 * @return LocalIngredients
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LocalIngredientsDTO> findLocalIngredientsById(@PathVariable int id) throws Exception {
		LocalIngredientsDTO results = localIngredientsService.findLocalIngredientsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get LocalIngredients by primary key
	 * @param id
	 * @return LocalIngredients
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeIngredientDisplay> findLocalIngredientDisplayById(@PathVariable int id) throws Exception {
		RecipeIngredientDisplay results = localIngredientsService.findLocalIngredientDisplayById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * this method gets called whenever an ingredient in the ingredients list on the recipe form gets changed
	 * we need to recalculate a new M1 for that ingredient, because they might have changed the serving type
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/findM1")
	public ResponseEntity<BigDecimal> findM1(@Valid @RequestBody RecipeIngredientDisplay data) throws Exception {
		try {
			BigDecimal results = localIngredientsService.findM1(data) ;
			return ResponseEntity.status(HttpStatus.OK).body(results);
		} catch(Exception e) {
			throw e;
		}
	}
	/**
	 * create a new LocalIngredients
	 * @param data
	 * @return LocalIngredients
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalIngredientsDTO> createLocalIngredients(@Valid @RequestBody LocalIngredientsDTO data) throws Exception {
		try {
		    LocalIngredientsDTO createdData = localIngredientsService.createLocalIngredients(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalIngredients
	 * @param data
	 * @return LocalIngredients
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LocalIngredientsDTO> updateLocalIngredients(@Valid @RequestBody LocalIngredientsDTO data) throws Exception {
		LocalIngredientsDTO updatedData = localIngredientsService.updateLocalIngredients(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LocalIngredients by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}/{userId}")
	public ResponseEntity<ResponseMessage> deleteLocalIngredients(@PathVariable int id, @PathVariable int userId) throws Exception {
		localIngredientsService.deleteLocalIngredients(id,userId);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : ingrTypeId
	 * @param id
	 * @return List<LocalIngredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByIngrTypeId/{id}")
	public ResponseEntity<List<LocalIngredientsDTO>> findLocalIngredientsByIngrTypeId(@PathVariable int id) throws Exception {
		List<LocalIngredientsDTO> results = localIngredientsService.findLocalIngredientsByIngrTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<LocalIngredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId/{id}")
	public ResponseEntity<List<LocalIngredientsDTO>> findLocalIngredientsByServTypeId(@PathVariable int id) throws Exception {
		List<LocalIngredientsDTO> results = localIngredientsService.findLocalIngredientsByServTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalIngredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LocalIngredientsDTO>> findLocalIngredientsByImageLoc(@PathVariable int id) throws Exception {
		List<LocalIngredientsDTO> results = localIngredientsService.findLocalIngredientsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalIngredientsDTO> by foreign key : IngrTypeIdAndServTypeIdAndImageLoc
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/findByIngrTypeIdAndServTypeIdAndImageLoc/{id0}/{id1}/{id2}")
	public ResponseEntity<List<LocalIngredientsDTO>> findLocalIngredientsByIngrTypeIdAndServTypeIdAndImageLoc(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<LocalIngredientsDTO> results = localIngredientsService.findLocalIngredientsByIngrTypeIdAndServTypeIdAndImageLoc(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
