package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.IngredientTypeMappingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypeMinDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
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
@RequestMapping(path="/ingredienttypes")
public class IngredientTypesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private IngredientTypesService ingredientTypesService;

	/**
	 * get all IngredientTypes records
	 * @return Iterable<IngredientTypes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<IngredientTypesDTO>> getAllIngredientTypes() throws Exception {
		List<IngredientTypesDTO> ingredienttypes = ingredientTypesService.getAllIngredientTypes();
		return ResponseEntity.status(HttpStatus.OK).body(ingredienttypes);
	}

	@GetMapping(path = "/getminimumingredienttypedata")
	public ResponseEntity<List<IngredientTypeMinDTO>> getMinIngredientTypeData() throws Exception {
		List<IngredientTypeMinDTO> ingredienttypes = ingredientTypesService.getMinIngredientTypeData();
		return ResponseEntity.status(HttpStatus.OK).body(ingredienttypes);
	}

	/**
	 * get IngredientTypes by primary key
	 * @param id
	 * @return IngredientTypes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<IngredientTypesDTO> findIngredientTypesById(@PathVariable int id) throws Exception {
		IngredientTypesDTO results = ingredientTypesService.findIngredientTypesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new IngredientTypes
	 * @param data
	 * @return IngredientTypes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<IngredientTypesDTO> createIngredientTypes(@Valid @RequestBody IngredientTypesDTO data) throws Exception {
		try {
		    IngredientTypesDTO createdData = ingredientTypesService.createIngredientTypes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a IngredientTypes
	 * @param data
	 * @return IngredientTypes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<IngredientTypesDTO> updateIngredientTypes(@Valid @RequestBody IngredientTypesDTO data) throws Exception {
		IngredientTypesDTO updatedData = ingredientTypesService.updateIngredientTypes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a IngredientTypes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteIngredientTypes(@PathVariable int id) throws Exception {
		ingredientTypesService.deleteIngredientTypes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<IngredientTypesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<IngredientTypes>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<IngredientTypesDTO>> findIngredientTypesByImageLoc(@PathVariable int id) throws Exception {
		List<IngredientTypesDTO> results = ingredientTypesService.findIngredientTypesByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/getIngredientTypeMappings")
	public ResponseEntity<List<IngredientTypeMappingsDTO>> getIngredientTypeMappings() throws Exception {
		List<IngredientTypeMappingsDTO> results = ingredientTypesService.getIngredientTypeMappings();
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
}
