package com.schnarbiesnmeowers.nmsmonolith.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/periodtype")
public class PeriodTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PeriodTypeService businessService;

	/**
	 * get all PeriodType records
	 * @return Iterable<PeriodType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<PeriodTypeDTO>> getAllPeriodType() throws Exception {
		List<PeriodTypeDTO> periodtype = businessService.getAllPeriodType();
		return ResponseEntity.status(HttpStatus.OK).body(periodtype);
	}

	/**
	 * get PeriodType by primary key
	 * @param id
	 * @return PeriodType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<PeriodTypeDTO> findPeriodTypeById(@PathVariable int id) throws Exception {
		PeriodTypeDTO results = businessService.findPeriodTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new PeriodType
	 * @param PeriodTypeDTO
	 * @return PeriodType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<PeriodTypeDTO> createPeriodType(@Valid @RequestBody PeriodTypeDTO data) throws Exception {
		try {
		    PeriodTypeDTO createdData = businessService.createPeriodType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PeriodType
	 * @param PeriodTypeDTO
	 * @return PeriodType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<PeriodTypeDTO> updatePeriodType(@Valid @RequestBody PeriodTypeDTO data) throws Exception {
		PeriodTypeDTO updatedData = businessService.updatePeriodType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a PeriodType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePeriodType(@PathVariable int id) throws Exception {
		businessService.deletePeriodType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
