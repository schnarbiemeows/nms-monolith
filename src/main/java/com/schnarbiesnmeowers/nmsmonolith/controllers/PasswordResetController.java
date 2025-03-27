package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/passwordreset")
public class PasswordResetController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PasswordResetService service;

	/**
	 * get all PasswordReset records
	 * @return Iterable<PasswordReset>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<PasswordResetDTO>> getAllPasswordReset() throws Exception {
		List<PasswordResetDTO> passwordreset = service.getAllPasswordReset();
		return ResponseEntity.status(HttpStatus.OK).body(passwordreset);
	}

	/**
	 * get PasswordReset by primary key
	 * @param id
	 * @return PasswordReset
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<PasswordResetDTO> findPasswordResetById(@PathVariable int id) throws Exception {
		PasswordResetDTO results = service.findPasswordResetById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new PasswordReset
	 * @param data
	 * @return PasswordReset
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<PasswordResetDTO> createPasswordReset(@Valid @RequestBody PasswordResetDTO data) throws Exception {
		try {
		    PasswordResetDTO createdData = service.createPasswordReset(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PasswordReset
	 * @param data
	 * @return PasswordReset
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<PasswordResetDTO> updatePasswordReset(@Valid @RequestBody PasswordResetDTO data) throws Exception {
		PasswordResetDTO updatedData = service.updatePasswordReset(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a PasswordReset by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePasswordReset(@PathVariable int id) throws Exception {
		service.deletePasswordReset(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
