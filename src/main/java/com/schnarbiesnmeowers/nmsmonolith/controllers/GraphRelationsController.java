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
@RequestMapping(path="/graphrelations")
public class GraphRelationsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GraphRelationsService service;

	/**
	 * get all GraphRelations records
	 * @return Iterable<GraphRelations>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GraphRelationsDTO>> getAllGraphRelations() throws Exception {
		List<GraphRelationsDTO> graphrelations = service.getAllGraphRelations();
		return ResponseEntity.status(HttpStatus.OK).body(graphrelations);
	}

	/**
	 * get GraphRelations by primary key
	 * @param id
	 * @return GraphRelations
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GraphRelationsDTO> findGraphRelationsById(@PathVariable int id) throws Exception {
		GraphRelationsDTO results = service.findGraphRelationsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GraphRelations
	 * @param data
	 * @return GraphRelations
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GraphRelationsDTO> createGraphRelations(@Valid @RequestBody GraphRelationsDTO data) throws Exception {
		try {
		    GraphRelationsDTO createdData = service.createGraphRelations(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GraphRelations
	 * @param data
	 * @return GraphRelations
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GraphRelationsDTO> updateGraphRelations(@Valid @RequestBody GraphRelationsDTO data) throws Exception {
		GraphRelationsDTO updatedData = service.updateGraphRelations(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GraphRelations by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGraphRelations(@PathVariable int id) throws Exception {
		service.deleteGraphRelations(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GraphRelationsDTO> by foreign key : graphRelationIndexId
	 * @param id
	 * @return List<GraphRelations>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGraphRelationIndexId/{id}")
	public ResponseEntity<List<GraphRelationsDTO>> findGraphRelationsByGraphRelationIndexId(@PathVariable int id) throws Exception {
		List<GraphRelationsDTO> results = service.findGraphRelationsByGraphRelationIndexId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}


}
