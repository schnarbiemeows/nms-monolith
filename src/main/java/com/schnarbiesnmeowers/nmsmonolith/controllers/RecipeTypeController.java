package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeTypeMappingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeHierachy;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeTypeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/recipetype")
public class RecipeTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeTypeService recipeTypeService;

	/**
	 * get all RecipeType records
	 * @return Iterable<RecipeType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipeTypeDTO>> getAllRecipeType() throws Exception {
		List<RecipeTypeDTO> recipetype = recipeTypeService.getAllRecipeType();
		return ResponseEntity.status(HttpStatus.OK).body(recipetype);
	}

	/**
	 * get all active RecipeType records
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/allActive")
	public ResponseEntity<List<RecipeTypeDTO>> getAllActiveRecipeType() throws Exception {
		List<RecipeTypeDTO> recipetype = recipeTypeService.getAllActiveRecipeTypes();
		return ResponseEntity.status(HttpStatus.OK).body(recipetype);
	}

	/**
	 * get RecipeType by primary key
	 * @param id
	 * @return RecipeType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeTypeDTO> findRecipeTypeById(@PathVariable int id) throws Exception {
		RecipeTypeDTO results = recipeTypeService.findRecipeTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecipeType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipeTypeDTO> createRecipeType(@Valid @RequestBody RecipeTypeDTO data) throws Exception {
		try {
		    RecipeTypeDTO createdData = recipeTypeService.createRecipeType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeType
	 * @param data
	 * @return RecipeType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecipeTypeDTO> updateRecipeType(@Valid @RequestBody RecipeTypeDTO data) throws Exception {
		RecipeTypeDTO updatedData = recipeTypeService.updateRecipeType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecipeType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipeType(@PathVariable int id) throws Exception {
		recipeTypeService.deleteRecipeType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	@GetMapping(path = "/getRecipeTypeMappings")
	public ResponseEntity<List<RecipeTypeMappingsDTO>> getRecipeTypeMappings() throws Exception {
		List<RecipeTypeMappingsDTO> results = recipeTypeService.getRecipeTypeMappings();
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/getRecipeTypeHierarchy")
	public ResponseEntity<RecipeTypeHierachy> getRecipeTypeHierarchy() throws Exception {
		RecipeTypeHierachy results = recipeTypeService.findGraphOfRecipeTypes(1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/getChildRecipeTypes")
	public ResponseEntity<RecipeTypeHierachy> getChildRecipeTypes() throws Exception {
		RecipeTypeHierachy results = recipeTypeService.getChildRecipeTypes(1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/getRecipeTypeDisplay")
	public ResponseEntity<RecipeTypeHierachy> getRecipeTypeDisplay() throws Exception {
		RecipeTypeHierachy results = recipeTypeService.getChildRecipeTypeDisplays(1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
}
