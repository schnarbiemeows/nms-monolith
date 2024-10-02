package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.math.BigDecimal;
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
@RequestMapping(path="/rda")
public class RdaController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RdaService rdaService;

	/**
	 * get all Rda records
	 * @return Iterable<Rda>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RdaDTO>> getAllRda() throws Exception {
		List<RdaDTO> rda = rdaService.getAllRda();
		return ResponseEntity.status(HttpStatus.OK).body(rda);
	}

	@GetMapping(path = "/defaults")
	public ResponseEntity<List<RdaDTO>> getRdaDefaults() throws Exception {
		List<RdaDTO> rda = rdaService.findDefaults();
		return ResponseEntity.status(HttpStatus.OK).body(rda);
	}

	@GetMapping(path = "/all/{id}")
	public ResponseEntity<Map<String, BigDecimal>> getRdasForAGivenUserId(@PathVariable int id) throws Exception {
		Map<String, BigDecimal> rdas = rdaService.findRdasForAGivenUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(rdas);
	}

	/**
	 * get Rda by primary key
	 * @param id
	 * @return Rda
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RdaDTO> findRdaById(@PathVariable int id) throws Exception {
		RdaDTO results = rdaService.findRdaById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Rda
	 * @param data
	 * @return Rda
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RdaDTO> createRda(@Valid @RequestBody RdaDTO data) throws Exception {
		try {
		    RdaDTO createdData = rdaService.createRda(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Rda
	 * @param data
	 * @return Rda
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RdaDTO> updateRda(@Valid @RequestBody RdaDTO data) throws Exception {
		RdaDTO updatedData = rdaService.updateRda(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Rda by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRda(@PathVariable int id) throws Exception {
		rdaService.deleteRda(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RdaDTO> by foreign key : userId
	 * @param id
	 * @return List<Rda>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<RdaDTO>> findRdaByUserId(@PathVariable int id) throws Exception {
		List<RdaDTO> results = rdaService.findRdaByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
