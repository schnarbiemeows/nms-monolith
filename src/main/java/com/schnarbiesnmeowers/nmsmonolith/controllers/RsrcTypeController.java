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
@RequestMapping(path="/rsrctype")
public class RsrcTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RsrcTypeService businessService;

	/**
	 * get all RsrcType records
	 * @return Iterable<RsrcType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RsrcTypeDTO>> getAllRsrcType() throws Exception {
		List<RsrcTypeDTO> rsrctype = businessService.getAllRsrcType();
		return ResponseEntity.status(HttpStatus.OK).body(rsrctype);
	}

	/**
	 * get RsrcType by primary key
	 * @param id
	 * @return RsrcType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RsrcTypeDTO> findRsrcTypeById(@PathVariable int id) throws Exception {
		RsrcTypeDTO results = businessService.findRsrcTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RsrcType
	 * @param RsrcTypeDTO
	 * @return RsrcType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RsrcTypeDTO> createRsrcType(@Valid @RequestBody RsrcTypeDTO data) throws Exception {
		try {
		    RsrcTypeDTO createdData = businessService.createRsrcType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RsrcType
	 * @param RsrcTypeDTO
	 * @return RsrcType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RsrcTypeDTO> updateRsrcType(@Valid @RequestBody RsrcTypeDTO data) throws Exception {
		RsrcTypeDTO updatedData = businessService.updateRsrcType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RsrcType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRsrcType(@PathVariable int id) throws Exception {
		businessService.deleteRsrcType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
