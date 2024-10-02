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
@RequestMapping(path="/roles")
public class RolesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RolesService businessService;

	/**
	 * get all Roles records
	 * @return Iterable<Roles>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RolesDTO>> getAllRoles() throws Exception {
		List<RolesDTO> roles = businessService.getAllRoles();
		return ResponseEntity.status(HttpStatus.OK).body(roles);
	}

	/**
	 * get Roles by primary key
	 * @param id
	 * @return Roles
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RolesDTO> findRolesById(@PathVariable int id) throws Exception {
		RolesDTO results = businessService.findRolesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Roles
	 * @param data
	 * @return Roles
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RolesDTO> createRoles(@Valid @RequestBody RolesDTO data) throws Exception {
		try {
		    RolesDTO createdData = businessService.createRoles(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Roles
	 * @param data
	 * @return Roles
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RolesDTO> updateRoles(@Valid @RequestBody RolesDTO data) throws Exception {
		RolesDTO updatedData = businessService.updateRoles(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Roles by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRoles(@PathVariable int id) throws Exception {
		businessService.deleteRoles(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RolesDTO> by foreign key : grpId
	 * @param id
	 * @return List<Roles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpId/{id}")
	public ResponseEntity<List<RolesDTO>> findRolesByGrpId(@PathVariable int id) throws Exception {
		List<RolesDTO> results = businessService.findRolesByGrpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesDTO> by foreign key : rsrcId
	 * @param id
	 * @return List<Roles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRsrcId/{id}")
	public ResponseEntity<List<RolesDTO>> findRolesByRsrcId(@PathVariable int id) throws Exception {
		List<RolesDTO> results = businessService.findRolesByRsrcId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<Roles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByActionTypeId/{id}")
	public ResponseEntity<List<RolesDTO>> findRolesByActionTypeId(@PathVariable int id) throws Exception {
		List<RolesDTO> results = businessService.findRolesByActionTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesDTO> by foreign key : GrpIdAndRsrcIdAndActionTypeId
	 * @param id0
	 * @return List<Roles>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpIdAndRsrcIdAndActionTypeId/{id0}/{id1}/{id2}")
	public ResponseEntity<List<RolesDTO>> findRolesByGrpIdAndRsrcIdAndActionTypeId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<RolesDTO> results = businessService.findRolesByGrpIdAndRsrcIdAndActionTypeId(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
