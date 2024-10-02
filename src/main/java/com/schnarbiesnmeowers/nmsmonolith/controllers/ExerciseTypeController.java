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
@RequestMapping(path="/exercisetype")
public class ExerciseTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ExerciseTypeService businessService;

	/**
	 * get all ExerciseType records
	 * @return Iterable<ExerciseType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ExerciseTypeDTO>> getAllExerciseType() throws Exception {
		List<ExerciseTypeDTO> exercisetype = businessService.getAllExerciseType();
		return ResponseEntity.status(HttpStatus.OK).body(exercisetype);
	}

	/**
	 * get ExerciseType by primary key
	 * @param id
	 * @return ExerciseType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ExerciseTypeDTO> findExerciseTypeById(@PathVariable int id) throws Exception {
		ExerciseTypeDTO results = businessService.findExerciseTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ExerciseType
	 * @param ExerciseTypeDTO
	 * @return ExerciseType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ExerciseTypeDTO> createExerciseType(@Valid @RequestBody ExerciseTypeDTO data) throws Exception {
		try {
		    ExerciseTypeDTO createdData = businessService.createExerciseType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ExerciseType
	 * @param ExerciseTypeDTO
	 * @return ExerciseType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ExerciseTypeDTO> updateExerciseType(@Valid @RequestBody ExerciseTypeDTO data) throws Exception {
		ExerciseTypeDTO updatedData = businessService.updateExerciseType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ExerciseType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteExerciseType(@PathVariable int id) throws Exception {
		businessService.deleteExerciseType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<ExerciseTypeDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<ExerciseType>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<ExerciseTypeDTO>> findExerciseTypeByImageLoc(@PathVariable int id) throws Exception {
		List<ExerciseTypeDTO> results = businessService.findExerciseTypeByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
