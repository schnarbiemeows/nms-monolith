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
@RequestMapping(path="/actiontype")
public class ActionTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ActionTypeService businessService;

	/**
	 * get all ActionType records
	 * @return Iterable<ActionType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ActionTypeDTO>> getAllActionType() throws Exception {
		List<ActionTypeDTO> actiontype = businessService.getAllActionType();
		return ResponseEntity.status(HttpStatus.OK).body(actiontype);
	}

	/**
	 * get ActionType by primary key
	 * @param id
	 * @return ActionType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ActionTypeDTO> findActionTypeById(@PathVariable int id) throws Exception {
		ActionTypeDTO results = businessService.findActionTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ActionType
	 * @param data
	 * @return ActionType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ActionTypeDTO> createActionType(@Valid @RequestBody ActionTypeDTO data) throws Exception {
		try {
		    ActionTypeDTO createdData = businessService.createActionType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ActionType
	 * @param data
	 * @return ActionType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ActionTypeDTO> updateActionType(@Valid @RequestBody ActionTypeDTO data) throws Exception {
		ActionTypeDTO updatedData = businessService.updateActionType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ActionType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteActionType(@PathVariable int id) throws Exception {
		businessService.deleteActionType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
