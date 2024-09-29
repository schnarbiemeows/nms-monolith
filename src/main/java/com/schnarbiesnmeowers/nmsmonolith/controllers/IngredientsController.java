package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeIngredientDisplay;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.math.BigDecimal;
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
@RequestMapping(path="/ingredients")
public class IngredientsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private IngredientsService ingredientsService;

	/**
	 * get all Ingredients records
	 * @return Iterable<Ingredients>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<IngredientsDTO>> getAllIngredients() throws Exception {
		List<IngredientsDTO> ingredients = ingredientsService.getAllIngredients();
		return ResponseEntity.status(HttpStatus.OK).body(ingredients);
	}

	/**
	 * get all Ingredients records
	 * @return Iterable<Ingredients>
	 */
	@GetMapping(path = "/all-displays/{id}")
	public ResponseEntity<IngredientsWrapper> getAllIngredientDisplays(@PathVariable int id) throws Exception {
		IngredientsWrapper ingredients = ingredientsService.getAllIngredientDisplays(id);
		return ResponseEntity.status(HttpStatus.OK).body(ingredients);
	}

	@GetMapping(path = "/all-displays-ranked/{id}/{rankedBy}")
	public ResponseEntity<IngredientsWrapper> getAllIngredientDisplaysRanked(@PathVariable int id,
		@PathVariable String rankedBy) throws Exception {
		IngredientsWrapper ingredients = ingredientsService.getIngredientsByRanking(id, rankedBy);
		return ResponseEntity.status(HttpStatus.OK).body(ingredients);
	}

	/**
	 * get Ingredients by primary key
	 * @param id
	 * @return Ingredients
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<IngredientsDTO> findIngredientsById(@PathVariable int id) throws Exception {
		IngredientsDTO results = ingredientsService.findIngredientsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get Ingredient by primary key
	 * this happens when a user selects an ingredient on the ingredients page for inclusion in a recipe
	 * and returns to the recipe page
	 * @param id
	 * @return LocalIngredients
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeIngredientDisplay> findIngredientDisplayById(@PathVariable int id) throws Exception {
		RecipeIngredientDisplay results = ingredientsService.findIngredientDisplayById(id);
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
			BigDecimal results = ingredientsService.findM1(data) ;
			return ResponseEntity.status(HttpStatus.OK).body(results);
		} catch(Exception e) {
			throw e;
		}
	}
	/**
	 * create a new ingredient
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<IngredientsDTO> createIngredients(@Valid @RequestBody IngredientsDTO data) throws Exception {
		try {
		    IngredientsDTO createdData = ingredientsService.createIngredients(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update an ingredient
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<IngredientsDTO> updateIngredients(@Valid @RequestBody IngredientsDTO data) throws Exception {
		IngredientsDTO updatedData = ingredientsService.updateIngredients(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Ingredients by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteIngredients(@PathVariable int id) throws Exception {
		ingredientsService.deleteIngredients(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<IngredientsDTO> by foreign key : ingrTypeId
	 * @param ingrTypeId
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByIngrTypeId/{id}")
	public ResponseEntity<List<IngredientsDTO>> findIngredientsByIngrTypeId(@PathVariable int ingrTypeId) throws Exception {
		List<IngredientsDTO> results = ingredientsService.findIngredientsByIngrTypeId(ingrTypeId);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<IngredientsDTO> by foreign key : brandId
	 * @param brandId
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByBrandId/{id}")
	public ResponseEntity<List<IngredientsDTO>> findIngredientsByBrandId(@PathVariable int brandId) throws Exception {
		List<IngredientsDTO> results = ingredientsService.findIngredientsByBrandId(brandId);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<IngredientsDTO> by foreign key : servTypeId
	 * @param servTypeId
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId/{id}")
	public ResponseEntity<List<IngredientsDTO>> findIngredientsByServTypeId(@PathVariable int servTypeId) throws Exception {
		List<IngredientsDTO> results = ingredientsService.findIngredientsByServTypeId(servTypeId);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<IngredientsDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<Ingredients>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<IngredientsDTO>> findIngredientsByImageLoc(@PathVariable int imageLoc) throws Exception {
		List<IngredientsDTO> results = ingredientsService.findIngredientsByImageLoc(imageLoc);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<IngredientsDTO> by ingrTypeId and brandId
	 * @param ingrTypeId
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/findByIngrTypeIdAndBrandId/{ingrTypeId}/{brandId}")
	public ResponseEntity<List<IngredientsDTO>> findIngredientsByIngrTypeIdAndBrandId(@PathVariable int ingrTypeId,
		@PathVariable int brandId) throws Exception {
		List<IngredientsDTO> results = ingredientsService.findIngredientsByIngrTypeIdAndBrandId(ingrTypeId, brandId);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
