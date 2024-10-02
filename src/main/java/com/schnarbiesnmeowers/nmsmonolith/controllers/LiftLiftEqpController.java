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
@RequestMapping(path="/liftlifteqp")
public class LiftLiftEqpController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftLiftEqpService businessService;

	/**
	 * get all LiftLiftEqp records
	 * @return Iterable<LiftLiftEqp>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LiftLiftEqpDTO>> getAllLiftLiftEqp() throws Exception {
		List<LiftLiftEqpDTO> liftlifteqp = businessService.getAllLiftLiftEqp();
		return ResponseEntity.status(HttpStatus.OK).body(liftlifteqp);
	}

	/**
	 * get LiftLiftEqp by primary key
	 * @param id
	 * @return LiftLiftEqp
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LiftLiftEqpDTO> findLiftLiftEqpById(@PathVariable int id) throws Exception {
		LiftLiftEqpDTO results = businessService.findLiftLiftEqpById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LiftLiftEqp
	 * @param LiftLiftEqpDTO
	 * @return LiftLiftEqp
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LiftLiftEqpDTO> createLiftLiftEqp(@Valid @RequestBody LiftLiftEqpDTO data) throws Exception {
		try {
		    LiftLiftEqpDTO createdData = businessService.createLiftLiftEqp(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftLiftEqp
	 * @param LiftLiftEqpDTO
	 * @return LiftLiftEqp
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LiftLiftEqpDTO> updateLiftLiftEqp(@Valid @RequestBody LiftLiftEqpDTO data) throws Exception {
		LiftLiftEqpDTO updatedData = businessService.updateLiftLiftEqp(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LiftLiftEqp by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLiftLiftEqp(@PathVariable int id) throws Exception {
		businessService.deleteLiftLiftEqp(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : liftId
	 * @param liftId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftId/{id}")
	public ResponseEntity<List<LiftLiftEqpDTO>> findLiftLiftEqpByLiftId(@PathVariable int id) throws Exception {
		List<LiftLiftEqpDTO> results = businessService.findLiftLiftEqpByLiftId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : liftEquipId
	 * @param liftEquipId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftEquipId/{id}")
	public ResponseEntity<List<LiftLiftEqpDTO>> findLiftLiftEqpByLiftEquipId(@PathVariable int id) throws Exception {
		List<LiftLiftEqpDTO> results = businessService.findLiftLiftEqpByLiftEquipId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LiftLiftEqpDTO> by foreign key : LiftIdAndLiftEquipId
	 * @param LiftIdAndLiftEquipId
	 * @return List<LiftLiftEqp>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByLiftIdAndLiftEquipId/{id0}/{id1}")
	public ResponseEntity<List<LiftLiftEqpDTO>> findLiftLiftEqpByLiftIdAndLiftEquipId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<LiftLiftEqpDTO> results = businessService.findLiftLiftEqpByLiftIdAndLiftEquipId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
