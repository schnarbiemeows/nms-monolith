package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
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
@RequestMapping(path="/servingtyperatios")
public class ServingTypeRatiosController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ServingTypeRatiosService businessService;

	/**
	 * get all ServingTypeRatios records
	 * @return Iterable<ServingTypeRatios>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ServingTypeRatiosDTO>> getAllServingTypeRatios() throws Exception {
		List<ServingTypeRatiosDTO> servingtyperatios = businessService.getAllServingTypeRatios();
		return ResponseEntity.status(HttpStatus.OK).body(servingtyperatios);
	}

	/**
	 * get ServingTypeRatios by primary key
	 * @param id
	 * @return ServingTypeRatios
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ServingTypeRatiosDTO> findServingTypeRatiosById(@PathVariable int id) throws Exception {
		ServingTypeRatiosDTO results = businessService.findServingTypeRatiosById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ServingTypeRatios
	 * @param ServingTypeRatiosDTO
	 * @return ServingTypeRatios
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ServingTypeRatiosDTO> createServingTypeRatios(@Valid @RequestBody ServingTypeRatiosDTO data) throws Exception {
		try {
		    ServingTypeRatiosDTO createdData = businessService.createServingTypeRatios(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ServingTypeRatios
	 * @param ServingTypeRatiosDTO
	 * @return ServingTypeRatios
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ServingTypeRatiosDTO> updateServingTypeRatios(@Valid @RequestBody ServingTypeRatiosDTO data) throws Exception {
		ServingTypeRatiosDTO updatedData = businessService.updateServingTypeRatios(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ServingTypeRatios by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteServingTypeRatios(@PathVariable int id) throws Exception {
		businessService.deleteServingTypeRatios(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : servTypeId1
	 * @param servTypeId1
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId1/{id}")
	public ResponseEntity<List<ServingTypeRatiosDTO>> findServingTypeRatiosByServTypeId1(@PathVariable int id) throws Exception {
		List<ServingTypeRatiosDTO> results = businessService.findServingTypeRatiosByServTypeId1(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : servTypeId2
	 * @param servTypeId2
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId2/{id}")
	public ResponseEntity<List<ServingTypeRatiosDTO>> findServingTypeRatiosByServTypeId2(@PathVariable int id) throws Exception {
		List<ServingTypeRatiosDTO> results = businessService.findServingTypeRatiosByServTypeId2(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : ServTypeId1AndServTypeId2
	 * @param ServTypeId1AndServTypeId2
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId1AndServTypeId2/{id0}/{id1}")
	public ResponseEntity<List<ServingTypeRatiosDTO>> findServingTypeRatiosByServTypeId1AndServTypeId2(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<ServingTypeRatiosDTO> results = businessService.findServingTypeRatiosByServTypeId1AndServTypeId2(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
