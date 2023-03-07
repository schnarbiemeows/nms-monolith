package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.itextpdf.text.DocumentException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
@RequestMapping(path="/recipes")
public class RecipesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipesService recipesService;

	/**
	 * get all Recipes records
	 * @return Iterable<Recipes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipesDTO>> getAllRecipes() throws Exception {
		List<RecipesDTO> recipes = recipesService.getAllRecipes();
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}

	/**
	 * gets all of the global recipes plus alll of the local_recipes for a given user id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/all-displays/{id}")
	public ResponseEntity<RecipeWrapper> getAllRecipeDisplays(@PathVariable int id) throws Exception {
		RecipeWrapper recipes = recipesService.getAllRecipeDisplays(id);
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}

	/**
	 * this method gets called when a user selects a recipe for inclusion in another recipe
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeIngredientDisplay> getRecipeDisplayById(@PathVariable int id) throws Exception {
		RecipeIngredientDisplay recipes = recipesService.getRecipeDisplayById(id);
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
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
			BigDecimal results = recipesService.findM1(data) ;
			return ResponseEntity.status(HttpStatus.OK).body(results);
		} catch(Exception e) {
			throw e;
		}
	}

	/**
	 * get Recipes by primary key
	 * @param id
	 * @return Recipes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeFormDTO> findRecipesById(@PathVariable int id) throws Exception {
		RecipeFormDTO results = recipesService.findRecipesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Recipes
	 * @param data
	 * @return Recipes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipesDTO> createRecipes(@Valid @RequestBody RecipeFormDTO data) throws Exception {
		try {
		    RecipesDTO createdData = recipesService.createRecipe(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Recipes
	 * @param data
	 * @return Recipes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ResponseMessage> updateRecipes(@Valid @RequestBody RecipeFormDTO data) throws Exception {
		RecipesDTO updatedData = recipesService.updateRecipe(data);
		ResponseMessage rb = new ResponseMessage("successfully updated");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * delete a Recipes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipes(@PathVariable int id) throws Exception {
		recipesService.deleteRecipe(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecipesDTO> by foreign key : ingrId
	 * @param id
	 * @return List<Recipes>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByIngrId/{id}")
	public ResponseEntity<List<RecipesDTO>> findRecipesByIngrId(@PathVariable int id) throws Exception {
		List<RecipesDTO> results = recipesService.findRecipesByIngrId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/*@GetMapping("/users/export/pdf")
	public void exportToPDF(HttpServletResponse response, ) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<User> listUsers = service.listAll();

		UserPDFExporter exporter = new UserPDFExporter(listUsers);
		exporter.export(response);

	}*/
}
