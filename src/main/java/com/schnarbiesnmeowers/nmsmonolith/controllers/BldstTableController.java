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
@RequestMapping(path="/bldsttable")
public class BldstTableController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BldstTableService bldstTableService;

	/**
	 * get all BldstTable records
	 * @return Iterable<BldstTable>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<BldstTableDTO>> getAllBldstTable() throws Exception {
		List<BldstTableDTO> bldsttable = bldstTableService.getAllBldstTable();
		return ResponseEntity.status(HttpStatus.OK).body(bldsttable);
	}

	@GetMapping(path = "/user")
	public ResponseEntity<List<BldstTableDTO>> getAllBldstTableForUser() throws Exception {
		List<BldstTableDTO> bldsttable = bldstTableService.getAllBldstTableForUser();
		return ResponseEntity.status(HttpStatus.OK).body(bldsttable);
	}

	/**
	 * get BldstTable by primary key
	 * @param id
	 * @return BldstTable
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<BldstTableDTO> findBldstTableById(@PathVariable int id) throws Exception {
		BldstTableDTO results = bldstTableService.findBldstTableById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new BldstTable
	 * @param data
	 * @return BldstTable
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<BldstTableDTO> createBldstTable(@Valid @RequestBody BldstTableDTO data) throws Exception {
		try {
		    BldstTableDTO createdData = bldstTableService.createBldstTable(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a BldstTable
	 * @param data
	 * @return BldstTable
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<BldstTableDTO> updateBldstTable(@Valid @RequestBody BldstTableDTO data) throws Exception {
		BldstTableDTO updatedData = bldstTableService.updateBldstTable(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a BldstTable by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteBldstTable(@PathVariable int id) throws Exception {
		bldstTableService.deleteBldstTable(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
