package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DietaryTemplatesDTO;
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
@RequestMapping(path="/dietarytemplates")
public class DietaryTemplatesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DietaryTemplatesService dietaryTemplatesService;

	/**
	 * get all DietaryTemplates records
	 * @return Iterable<DietaryTemplates>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<DietaryTemplatesDTO>> getAllDietaryTemplates() throws Exception {
		List<DietaryTemplatesDTO> dietarytemplates = dietaryTemplatesService.getAllDietaryTemplates();
		return ResponseEntity.status(HttpStatus.OK).body(dietarytemplates);
	}

	/**
	 * get DietaryTemplates by primary key
	 * @param id
	 * @return DietaryTemplates
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<DietaryTemplatesDTO> findDietaryTemplatesById(@PathVariable int id) throws Exception {
		DietaryTemplatesDTO results = dietaryTemplatesService.findDietaryTemplatesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new DietaryTemplates
	 * @param data
	 * @return DietaryTemplates
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<DietaryTemplatesDTO> createDietaryTemplates(@Valid @RequestBody DietaryTemplatesDTO data) throws Exception {
		try {
		    DietaryTemplatesDTO createdData = dietaryTemplatesService.createDietaryTemplates(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DietaryTemplates
	 * @param data
	 * @return DietaryTemplates
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<DietaryTemplatesDTO> updateDietaryTemplates(@Valid @RequestBody DietaryTemplatesDTO data) throws Exception {
		DietaryTemplatesDTO updatedData = dietaryTemplatesService.updateDietaryTemplates(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a DietaryTemplates by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteDietaryTemplates(@PathVariable int id) throws Exception {
		dietaryTemplatesService.deleteDietaryTemplates(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<DietaryTemplatesDTO> by foreign key : userId
	 * @param id
	 * @return List<DietaryTemplates>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<DietaryTemplatesDTO>> findDietaryTemplatesByUserId(@PathVariable int id) throws Exception {
		List<DietaryTemplatesDTO> results = dietaryTemplatesService.findDietaryTemplatesByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
