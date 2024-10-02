package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/recipeequip")
public class RecipeEquipController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecipeEquipService businessService;

	/**
	 * get all RecipeEquip records
	 * @return Iterable<RecipeEquip>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecipeEquipDTO>> getAllRecipeEquip() throws Exception {
		List<RecipeEquipDTO> recipeequip = businessService.getAllRecipeEquip();
		return ResponseEntity.status(HttpStatus.OK).body(recipeequip);
	}

	/**
	 * get RecipeEquip by primary key
	 * @param id
	 * @return RecipeEquip
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecipeEquipDTO> findRecipeEquipById(@PathVariable int id) throws Exception {
		RecipeEquipDTO results = businessService.findRecipeEquipById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecipeEquip
	 * @param RecipeEquipDTO
	 * @return RecipeEquip
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecipeEquipDTO> createRecipeEquip(@Valid @RequestBody RecipeEquipDTO data) throws Exception {
		try {
		    RecipeEquipDTO createdData = businessService.createRecipeEquip(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecipeEquip
	 * @param RecipeEquipDTO
	 * @return RecipeEquip
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecipeEquipDTO> updateRecipeEquip(@Valid @RequestBody RecipeEquipDTO data) throws Exception {
		RecipeEquipDTO updatedData = businessService.updateRecipeEquip(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecipeEquip by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecipeEquip(@PathVariable int id) throws Exception {
		businessService.deleteRecipeEquip(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : recEqTypeId
	 * @param recEqTypeId
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecEqTypeId/{id}")
	public ResponseEntity<List<RecipeEquipDTO>> findRecipeEquipByRecEqTypeId(@PathVariable int id) throws Exception {
		List<RecipeEquipDTO> results = businessService.findRecipeEquipByRecEqTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<RecipeEquipDTO>> findRecipeEquipByImageLoc(@PathVariable int id) throws Exception {
		List<RecipeEquipDTO> results = businessService.findRecipeEquipByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecipeEquipDTO> by foreign key : RecEqTypeIdAndImageLoc
	 * @param RecEqTypeIdAndImageLoc
	 * @return List<RecipeEquip>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecEqTypeIdAndImageLoc/{id0}/{id1}")
	public ResponseEntity<List<RecipeEquipDTO>> findRecipeEquipByRecEqTypeIdAndImageLoc(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<RecipeEquipDTO> results = businessService.findRecipeEquipByRecEqTypeIdAndImageLoc(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
