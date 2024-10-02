package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.LocalRecipesDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeFormDTO;
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
@RequestMapping(path="/localrecipes")
public class LocalRecipesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipesService localRecipesService;

	/**
	 * get all LocalRecipes records
	 * @return Iterable<LocalRecipes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalRecipesDTO>> getAllLocalRecipes() throws Exception {
		List<LocalRecipesDTO> localrecipes = localRecipesService.getAllLocalRecipes();
		return ResponseEntity.status(HttpStatus.OK).body(localrecipes);
	}

	/**
	 * get LocalRecipes by primary key
	 * @param id
	 * @return LocalRecipes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeFormDTO> findLocalRecipesById(@PathVariable int id) throws Exception {
		RecipeFormDTO results = localRecipesService.findLocalRecipesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * this method gets called when you have selected a recipe for inclusion in another recipe
	 * @param id
	 * @return LocalRecipes
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeIngredientDisplay> findLocalRecipeDisplayInfoById(@PathVariable int id) throws Exception {
		RecipeIngredientDisplay results = localRecipesService.getRecipeDisplayById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * this method gets called whenever a child recipe in the ingredients list on the recipe form gets changed
	 * we need to recalculate a new M1 for that recipe, because they might have changed the serving type
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/findM1")
	public ResponseEntity<BigDecimal> findM1(@Valid @RequestBody RecipeIngredientDisplay data) throws Exception {
		try {
			BigDecimal results = localRecipesService.findM1(data) ;
			return ResponseEntity.status(HttpStatus.OK).body(results);
		} catch(Exception e) {
			throw e;
		}
	}

	/**
	 * create a new LocalRecipes
	 * @param data
	 * @return LocalRecipes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalRecipesDTO> createLocalRecipes(@Valid @RequestBody RecipeFormDTO data) throws Exception {
		try {
		    LocalRecipesDTO createdData = localRecipesService.createLocalRecipe(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipes
	 * @param data
	 * @return LocalRecipes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ResponseMessage> updateLocalRecipes(@Valid @RequestBody RecipeFormDTO data) throws Exception {
		LocalRecipesDTO updatedData = localRecipesService.updateLocalRecipes(data);
		ResponseMessage rb = new ResponseMessage("successfully updated");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * delete a LocalRecipes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}/{userId}")
	public ResponseEntity<ResponseMessage> deleteLocalRecipes(@PathVariable int id, @PathVariable int userId) throws Exception {
		localRecipesService.deleteLocalRecipes(id,userId);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
