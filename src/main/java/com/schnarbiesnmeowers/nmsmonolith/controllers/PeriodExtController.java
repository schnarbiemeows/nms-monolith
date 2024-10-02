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
@RequestMapping(path="/periodext")
public class PeriodExtController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PeriodExtService businessService;

	/**
	 * get all PeriodExt records
	 * @return Iterable<PeriodExt>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<PeriodExtDTO>> getAllPeriodExt() throws Exception {
		List<PeriodExtDTO> periodext = businessService.getAllPeriodExt();
		return ResponseEntity.status(HttpStatus.OK).body(periodext);
	}

	/**
	 * get PeriodExt by primary key
	 * @param id
	 * @return PeriodExt
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<PeriodExtDTO> findPeriodExtById(@PathVariable int id) throws Exception {
		PeriodExtDTO results = businessService.findPeriodExtById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new PeriodExt
	 * @param PeriodExtDTO
	 * @return PeriodExt
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<PeriodExtDTO> createPeriodExt(@Valid @RequestBody PeriodExtDTO data) throws Exception {
		try {
		    PeriodExtDTO createdData = businessService.createPeriodExt(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PeriodExt
	 * @param PeriodExtDTO
	 * @return PeriodExt
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<PeriodExtDTO> updatePeriodExt(@Valid @RequestBody PeriodExtDTO data) throws Exception {
		PeriodExtDTO updatedData = businessService.updatePeriodExt(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a PeriodExt by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePeriodExt(@PathVariable int id) throws Exception {
		businessService.deletePeriodExt(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<PeriodExtDTO> by foreign key : periodId
	 * @param periodId
	 * @return List<PeriodExt>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByPeriodId/{id}")
	public ResponseEntity<List<PeriodExtDTO>> findPeriodExtByPeriodId(@PathVariable int id) throws Exception {
		List<PeriodExtDTO> results = businessService.findPeriodExtByPeriodId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
