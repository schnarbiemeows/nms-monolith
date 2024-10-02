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
@RequestMapping(path="/graphrelationindexes")
public class GraphRelationIndexesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GraphRelationIndexesService service;

	/**
	 * get all GraphRelationIndexes records
	 * @return Iterable<GraphRelationIndexes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GraphRelationIndexesDTO>> getAllGraphRelationIndexes() throws Exception {
		List<GraphRelationIndexesDTO> graphrelationindexes = service.getAllGraphRelationIndexes();
		return ResponseEntity.status(HttpStatus.OK).body(graphrelationindexes);
	}

	/**
	 * get GraphRelationIndexes by primary key
	 * @param id
	 * @return GraphRelationIndexes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GraphRelationIndexesDTO> findGraphRelationIndexesById(@PathVariable int id) throws Exception {
		GraphRelationIndexesDTO results = service.findGraphRelationIndexesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GraphRelationIndexes
	 * @param data
	 * @return GraphRelationIndexes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GraphRelationIndexesDTO> createGraphRelationIndexes(@Valid @RequestBody GraphRelationIndexesDTO data) throws Exception {
		try {
		    GraphRelationIndexesDTO createdData = service.createGraphRelationIndexes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GraphRelationIndexes
	 * @param data
	 * @return GraphRelationIndexes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GraphRelationIndexesDTO> updateGraphRelationIndexes(@Valid @RequestBody GraphRelationIndexesDTO data) throws Exception {
		GraphRelationIndexesDTO updatedData = service.updateGraphRelationIndexes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GraphRelationIndexes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGraphRelationIndexes(@PathVariable int id) throws Exception {
		service.deleteGraphRelationIndexes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
