package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/dailydietarynotes")
public class DailyDietaryNotesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private DailyDietaryNotesService dailyDietaryNotesService;

	/**
	 * get all DailyDietaryNotes records
	 * @return Iterable<DailyDietaryNotes>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<DailyDietaryNotesDTO>> getAllDailyDietaryNotes() throws Exception {
		List<DailyDietaryNotesDTO> dailydietarynotes = dailyDietaryNotesService.getAllDailyDietaryNotes();
		return ResponseEntity.status(HttpStatus.OK).body(dailydietarynotes);
	}

	/**
	 * get DailyDietaryNotes by primary key
	 * @param id
	 * @return DailyDietaryNotes
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<DailyDietaryNotesDTO> findDailyDietaryNotesById(@PathVariable int id) throws Exception {
		DailyDietaryNotesDTO results = dailyDietaryNotesService.findDailyDietaryNotesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new DailyDietaryNotes
	 * @param data
	 * @return DailyDietaryNotes
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<DailyDietaryNotesDTO> createDailyDietaryNotes(@Valid @RequestBody DailyDietaryNotesDTO data) throws Exception {
		try {
		    DailyDietaryNotesDTO createdData = dailyDietaryNotesService.createDailyDietaryNotes(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a DailyDietaryNotes
	 * @param data
	 * @return DailyDietaryNotes
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<DailyDietaryNotesDTO> updateDailyDietaryNotes(@Valid @RequestBody DailyDietaryNotesDTO data) throws Exception {
		DailyDietaryNotesDTO updatedData = dailyDietaryNotesService.updateDailyDietaryNotes(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a DailyDietaryNotes by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteDailyDietaryNotes(@PathVariable int id) throws Exception {
		dailyDietaryNotesService.deleteDailyDietaryNotes(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<DailyDietaryNotesDTO> by foreign key : userId
	 * @param id
	 * @return List<DailyDietaryNotes>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<DailyDietaryNotesDTO>> findDailyDietaryNotesByUserId(@PathVariable int id) throws Exception {
		List<DailyDietaryNotesDTO> results = dailyDietaryNotesService.findDailyDietaryNotesByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
