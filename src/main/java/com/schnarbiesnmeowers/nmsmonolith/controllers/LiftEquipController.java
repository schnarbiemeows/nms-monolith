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
@RequestMapping(path="/liftequip")
public class LiftEquipController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LiftEquipService businessService;

	/**
	 * get all LiftEquip records
	 * @return Iterable<LiftEquip>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LiftEquipDTO>> getAllLiftEquip() throws Exception {
		List<LiftEquipDTO> liftequip = businessService.getAllLiftEquip();
		return ResponseEntity.status(HttpStatus.OK).body(liftequip);
	}

	/**
	 * get LiftEquip by primary key
	 * @param id
	 * @return LiftEquip
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LiftEquipDTO> findLiftEquipById(@PathVariable int id) throws Exception {
		LiftEquipDTO results = businessService.findLiftEquipById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LiftEquip
	 * @param LiftEquipDTO
	 * @return LiftEquip
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LiftEquipDTO> createLiftEquip(@Valid @RequestBody LiftEquipDTO data) throws Exception {
		try {
		    LiftEquipDTO createdData = businessService.createLiftEquip(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LiftEquip
	 * @param LiftEquipDTO
	 * @return LiftEquip
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LiftEquipDTO> updateLiftEquip(@Valid @RequestBody LiftEquipDTO data) throws Exception {
		LiftEquipDTO updatedData = businessService.updateLiftEquip(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LiftEquip by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLiftEquip(@PathVariable int id) throws Exception {
		businessService.deleteLiftEquip(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LiftEquipDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<LiftEquip>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LiftEquipDTO>> findLiftEquipByImageLoc(@PathVariable int id) throws Exception {
		List<LiftEquipDTO> results = businessService.findLiftEquipByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
