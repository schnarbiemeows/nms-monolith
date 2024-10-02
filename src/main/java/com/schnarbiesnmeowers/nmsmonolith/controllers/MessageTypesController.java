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
@RequestMapping(path="/messagetypes")
public class MessageTypesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MessageTypesService businessService;

	/**
	 * get all MessageTypes records
	 * @return Iterable<MessageTypes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<MessageTypesDTO>> getAllMessageTypes() throws Exception {
		List<MessageTypesDTO> messagetypes = businessService.getAllMessageTypes();
		return ResponseEntity.status(HttpStatus.OK).body(messagetypes);
	}

	/**
	 * get MessageTypes by primary key
	 * @param id
	 * @return MessageTypes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<MessageTypesDTO> findMessageTypesById(@PathVariable int id) throws Exception {
		MessageTypesDTO results = businessService.findMessageTypesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new MessageTypes
	 * @param MessageTypesDTO
	 * @return MessageTypes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<MessageTypesDTO> createMessageTypes(@Valid @RequestBody MessageTypesDTO data) throws Exception {
		try {
		    MessageTypesDTO createdData = businessService.createMessageTypes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a MessageTypes
	 * @param MessageTypesDTO
	 * @return MessageTypes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<MessageTypesDTO> updateMessageTypes(@Valid @RequestBody MessageTypesDTO data) throws Exception {
		MessageTypesDTO updatedData = businessService.updateMessageTypes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a MessageTypes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteMessageTypes(@PathVariable int id) throws Exception {
		businessService.deleteMessageTypes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
