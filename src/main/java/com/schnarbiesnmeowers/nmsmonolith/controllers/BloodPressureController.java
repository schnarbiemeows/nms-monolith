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
@RequestMapping(path="/bloodpressure")
public class BloodPressureController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BloodPressureService service;

	/**
	 * get all BloodPressure records
	 * @return Iterable<BloodPressure>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<BloodPressureDTO>> getAllBloodPressure() throws Exception {
		List<BloodPressureDTO> bloodpressure = service.getAllBloodPressure();
		return ResponseEntity.status(HttpStatus.OK).body(bloodpressure);
	}

	/**
	 * get BloodPressure by primary key
	 * @param id
	 * @return BloodPressure
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<BloodPressureDTO> findBloodPressureById(@PathVariable int id) throws Exception {
		BloodPressureDTO results = service.findBloodPressureById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new BloodPressure
	 * @param data
	 * @return BloodPressure
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<BloodPressureDTO> createBloodPressure(@Valid @RequestBody BloodPressureDTO data) throws Exception {
		try {
		    BloodPressureDTO createdData = service.createBloodPressure(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a BloodPressure
	 * @param data
	 * @return BloodPressure
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<BloodPressureDTO> updateBloodPressure(@Valid @RequestBody BloodPressureDTO data) throws Exception {
		BloodPressureDTO updatedData = service.updateBloodPressure(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a BloodPressure by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteBloodPressure(@PathVariable int id) throws Exception {
		service.deleteBloodPressure(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<BloodPressureDTO> by foreign key : userId
	 * @param id
	 * @return List<BloodPressure>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<BloodPressureDTO>> findBloodPressureByUserId(@PathVariable int id) throws Exception {
		List<BloodPressureDTO> results = service.findBloodPressureByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
