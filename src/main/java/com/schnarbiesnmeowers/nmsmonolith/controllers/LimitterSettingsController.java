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
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/limittersettings")
public class LimitterSettingsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LimitterSettingsService service;

	/**
	 * get all LimitterSettings records
	 * @return Iterable<LimitterSettings>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LimitterSettingsDTO>> getAllLimitterSettings() throws Exception {
		List<LimitterSettingsDTO> limittersettings = service.getAllLimitterSettings();
		return ResponseEntity.status(HttpStatus.OK).body(limittersettings);
	}

	/**
	 * get LimitterSettings by primary key
	 * @param id
	 * @return LimitterSettings
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LimitterSettingsDTO> findLimitterSettingsById(@PathVariable int id) throws Exception {
		LimitterSettingsDTO results = service.findLimitterSettingsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LimitterSettings
	 * @param data
	 * @return LimitterSettings
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LimitterSettingsDTO> createLimitterSettings(@Valid @RequestBody LimitterSettingsDTO data) throws Exception {
		try {
		    LimitterSettingsDTO createdData = service.createLimitterSettings(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LimitterSettings
	 * @param data
	 * @return LimitterSettings
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LimitterSettingsDTO> updateLimitterSettings(@Valid @RequestBody LimitterSettingsDTO data) throws Exception {
		LimitterSettingsDTO updatedData = service.updateLimitterSettings(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LimitterSettings by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLimitterSettings(@PathVariable int id) throws Exception {
		service.deleteLimitterSettings(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
