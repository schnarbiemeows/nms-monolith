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
@RequestMapping(path="/receqtype")
public class RecEqTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RecEqTypeService businessService;

	/**
	 * get all RecEqType records
	 * @return Iterable<RecEqType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RecEqTypeDTO>> getAllRecEqType() throws Exception {
		List<RecEqTypeDTO> receqtype = businessService.getAllRecEqType();
		return ResponseEntity.status(HttpStatus.OK).body(receqtype);
	}

	/**
	 * get RecEqType by primary key
	 * @param id
	 * @return RecEqType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RecEqTypeDTO> findRecEqTypeById(@PathVariable int id) throws Exception {
		RecEqTypeDTO results = businessService.findRecEqTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RecEqType
	 * @param RecEqTypeDTO
	 * @return RecEqType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RecEqTypeDTO> createRecEqType(@Valid @RequestBody RecEqTypeDTO data) throws Exception {
		try {
		    RecEqTypeDTO createdData = businessService.createRecEqType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RecEqType
	 * @param RecEqTypeDTO
	 * @return RecEqType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RecEqTypeDTO> updateRecEqType(@Valid @RequestBody RecEqTypeDTO data) throws Exception {
		RecEqTypeDTO updatedData = businessService.updateRecEqType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RecEqType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRecEqType(@PathVariable int id) throws Exception {
		businessService.deleteRecEqType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
