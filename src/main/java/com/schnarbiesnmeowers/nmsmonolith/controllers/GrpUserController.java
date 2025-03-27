package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
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
@RequestMapping(path="/grpuser")
public class GrpUserController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GrpUserService businessService;

	/**
	 * get all GrpUser records
	 * @return Iterable<GrpUser>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GrpUserDTO>> getAllGrpUser() throws Exception {
		List<GrpUserDTO> grpuser = businessService.getAllGrpUser();
		return ResponseEntity.status(HttpStatus.OK).body(grpuser);
	}

	/**
	 * get GrpUser by primary key
	 * @param id
	 * @return GrpUser
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GrpUserDTO> findGrpUserById(@PathVariable int id) throws Exception {
		GrpUserDTO results = businessService.findGrpUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GrpUser
	 * @param data
	 * @return GrpUser
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GrpUserDTO> createGrpUser(@Valid @RequestBody GrpUserDTO data) throws Exception {
		try {
		    GrpUserDTO createdData = businessService.createGrpUser(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GrpUser
	 * @param data
	 * @return GrpUser
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GrpUserDTO> updateGrpUser(@Valid @RequestBody GrpUserDTO data) throws Exception {
		GrpUserDTO updatedData = businessService.updateGrpUser(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GrpUser by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGrpUser(@PathVariable int id) throws Exception {
		businessService.deleteGrpUser(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GrpUserDTO> by foreign key : grpId
	 * @param id
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpId/{id}")
	public ResponseEntity<List<GrpUserDTO>> findGrpUserByGrpId(@PathVariable int id) throws Exception {
		List<GrpUserDTO> results = businessService.findGrpUserByGrpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserDTO> by foreign key : userId
	 * @param id
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<GrpUserDTO>> findGrpUserByUserId(@PathVariable int id) throws Exception {
		List<GrpUserDTO> results = businessService.findGrpUserByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserDTO> by foreign key : GrpIdAndUserId
	 * @param id0
	 * @return List<GrpUser>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpIdAndUserId/{id0}/{id1}")
	public ResponseEntity<List<GrpUserDTO>> findGrpUserByGrpIdAndUserId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<GrpUserDTO> results = businessService.findGrpUserByGrpIdAndUserId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
