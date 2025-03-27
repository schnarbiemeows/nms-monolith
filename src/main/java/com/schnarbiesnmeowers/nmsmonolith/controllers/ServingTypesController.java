package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeMinDataDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
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
@RequestMapping(path="/servingtypes")
public class ServingTypesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ServingTypesService servingTypesService;

	/**
	 * get all ServingTypes records
	 * @return Iterable<ServingTypes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ServingTypesDTO>> getAllServingTypes() throws Exception {
		List<ServingTypesDTO> servingtypes = servingTypesService.getAllServingTypes();
		return ResponseEntity.status(HttpStatus.OK).body(servingtypes);
	}

	/**
	 * get minimum serving type data for serving types
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/getminimumservingtypedata")
	public ResponseEntity<List<ServingTypeMinDataDTO>> getMinServingTypeData() throws Exception {
		List<ServingTypeMinDataDTO> servingtypes = servingTypesService.getMinServingTypeData();
		return ResponseEntity.status(HttpStatus.OK).body(servingtypes);
	}

	/**
	 * get ServingTypes by primary key
	 * @param id
	 * @return ServingTypes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ServingTypesDTO> findServingTypesById(@PathVariable int id) throws Exception {
		ServingTypesDTO results = servingTypesService.findServingTypesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ServingTypes
	 * @param data
	 * @return ServingTypes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ServingTypesDTO> createServingTypes(@Valid @RequestBody ServingTypesDTO data) throws Exception {
		try {
		    ServingTypesDTO createdData = servingTypesService.createServingTypes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ServingTypes
	 * @param data
	 * @return ServingTypes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ServingTypesDTO> updateServingTypes(@Valid @RequestBody ServingTypesDTO data) throws Exception {
		ServingTypesDTO updatedData = servingTypesService.updateServingTypes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ServingTypes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteServingTypes(@PathVariable int id) throws Exception {
		servingTypesService.deleteServingTypes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<ServingTypesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<ServingTypes>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<ServingTypesDTO>> findServingTypesByImageLoc(@PathVariable int id) throws Exception {
		List<ServingTypesDTO> results = servingTypesService.findServingTypesByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
