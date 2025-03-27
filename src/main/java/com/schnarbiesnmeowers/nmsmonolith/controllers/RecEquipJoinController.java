package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
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
@RequestMapping(path="/recequipjoin")
public class RecEquipJoinController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecEquipJoinService businessService;

	/**
	 * get all RecEquipJoin records
	 * @return Iterable<RecEquipJoin>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecEquipJoinDTO>> getAllRecEquipJoin() throws Exception {
		List<RecEquipJoinDTO> recequipjoin = businessService.getAllRecEquipJoin();
		return ResponseEntity.status(HttpStatus.OK).body(recequipjoin);
	}

	/**
	 * get RecEquipJoin by primary key
	 * @param id
	 * @return RecEquipJoin
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecEquipJoinDTO> findRecEquipJoinById(@PathVariable int id) throws Exception {
		RecEquipJoinDTO results = businessService.findRecEquipJoinById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecEquipJoin
	 * @param RecEquipJoinDTO
	 * @return RecEquipJoin
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecEquipJoinDTO> createRecEquipJoin(@Valid @RequestBody RecEquipJoinDTO data) throws Exception {
		try {
		    RecEquipJoinDTO createdData = businessService.createRecEquipJoin(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecEquipJoin
	 * @param RecEquipJoinDTO
	 * @return RecEquipJoin
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecEquipJoinDTO> updateRecEquipJoin(@Valid @RequestBody RecEquipJoinDTO data) throws Exception {
		RecEquipJoinDTO updatedData = businessService.updateRecEquipJoin(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecEquipJoin by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecEquipJoin(@PathVariable int id) throws Exception {
		businessService.deleteRecEquipJoin(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : recipeId
	 * @param recipeId
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeId/{id}")
	public ResponseEntity<List<RecEquipJoinDTO>> findRecEquipJoinByRecipeId(@PathVariable int id) throws Exception {
		List<RecEquipJoinDTO> results = businessService.findRecEquipJoinByRecipeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : recipeEquipId
	 * @param recipeEquipId
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeEquipId/{id}")
	public ResponseEntity<List<RecEquipJoinDTO>> findRecEquipJoinByRecipeEquipId(@PathVariable int id) throws Exception {
		List<RecEquipJoinDTO> results = businessService.findRecEquipJoinByRecipeEquipId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RecEquipJoinDTO> by foreign key : RecipeIdAndRecipeEquipId
	 * @param RecipeIdAndRecipeEquipId
	 * @return List<RecEquipJoin>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeIdAndRecipeEquipId/{id0}/{id1}")
	public ResponseEntity<List<RecEquipJoinDTO>> findRecEquipJoinByRecipeIdAndRecipeEquipId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<RecEquipJoinDTO> results = businessService.findRecEquipJoinByRecipeIdAndRecipeEquipId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
