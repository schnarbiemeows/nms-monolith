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
@RequestMapping(path="/wrktrecs")
public class WrktRecsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private WrktRecsService businessService;

	/**
	 * get all WrktRecs records
	 * @return Iterable<WrktRecs>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<WrktRecsDTO>> getAllWrktRecs() throws Exception {
		List<WrktRecsDTO> wrktrecs = businessService.getAllWrktRecs();
		return ResponseEntity.status(HttpStatus.OK).body(wrktrecs);
	}

	/**
	 * get WrktRecs by primary key
	 * @param id
	 * @return WrktRecs
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<WrktRecsDTO> findWrktRecsById(@PathVariable int id) throws Exception {
		WrktRecsDTO results = businessService.findWrktRecsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new WrktRecs
	 * @param WrktRecsDTO
	 * @return WrktRecs
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<WrktRecsDTO> createWrktRecs(@Valid @RequestBody WrktRecsDTO data) throws Exception {
		try {
		    WrktRecsDTO createdData = businessService.createWrktRecs(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a WrktRecs
	 * @param WrktRecsDTO
	 * @return WrktRecs
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<WrktRecsDTO> updateWrktRecs(@Valid @RequestBody WrktRecsDTO data) throws Exception {
		WrktRecsDTO updatedData = businessService.updateWrktRecs(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a WrktRecs by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteWrktRecs(@PathVariable int id) throws Exception {
		businessService.deleteWrktRecs(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : workoutId
	 * @param workoutId
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByWorkoutId/{id}")
	public ResponseEntity<List<WrktRecsDTO>> findWrktRecsByWorkoutId(@PathVariable int id) throws Exception {
		List<WrktRecsDTO> results = businessService.findWrktRecsByWorkoutId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftId/{id}")
	public ResponseEntity<List<WrktRecsDTO>> findWrktRecsByLiftId(@PathVariable int id) throws Exception {
		List<WrktRecsDTO> results = businessService.findWrktRecsByLiftId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<WrktRecsDTO> by foreign key : WorkoutIdAndLiftId
	 * @param WorkoutIdAndLiftId
	 * @return List<WrktRecs>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByWorkoutIdAndLiftId/{id0}/{id1}")
	public ResponseEntity<List<WrktRecsDTO>> findWrktRecsByWorkoutIdAndLiftId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<WrktRecsDTO> results = businessService.findWrktRecsByWorkoutIdAndLiftId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
