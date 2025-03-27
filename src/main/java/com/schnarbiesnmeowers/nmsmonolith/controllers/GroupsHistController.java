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
@RequestMapping(path="/groupshist")
public class GroupsHistController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GroupsHistService businessService;

	/**
	 * get all GroupsHist records
	 * @return Iterable<GroupsHist>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GroupsHistDTO>> getAllGroupsHist() throws Exception {
		List<GroupsHistDTO> groupshist = businessService.getAllGroupsHist();
		return ResponseEntity.status(HttpStatus.OK).body(groupshist);
	}

	/**
	 * get GroupsHist by primary key
	 * @param id
	 * @return GroupsHist
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GroupsHistDTO> findGroupsHistById(@PathVariable int id) throws Exception {
		GroupsHistDTO results = businessService.findGroupsHistById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GroupsHist
	 * @param data
	 * @return GroupsHist
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GroupsHistDTO> createGroupsHist(@Valid @RequestBody GroupsHistDTO data) throws Exception {
		try {
		    GroupsHistDTO createdData = businessService.createGroupsHist(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GroupsHist
	 * @param data
	 * @return GroupsHist
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GroupsHistDTO> updateGroupsHist(@Valid @RequestBody GroupsHistDTO data) throws Exception {
		GroupsHistDTO updatedData = businessService.updateGroupsHist(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GroupsHist by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGroupsHist(@PathVariable int id) throws Exception {
		businessService.deleteGroupsHist(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : grpId
	 * @param id
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpId/{id}")
	public ResponseEntity<List<GroupsHistDTO>> findGroupsHistByGrpId(@PathVariable int id) throws Exception {
		List<GroupsHistDTO> results = businessService.findGroupsHistByGrpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByActionTypeId/{id}")
	public ResponseEntity<List<GroupsHistDTO>> findGroupsHistByActionTypeId(@PathVariable int id) throws Exception {
		List<GroupsHistDTO> results = businessService.findGroupsHistByActionTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : evntOperId
	 * @param id
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEvntOperId/{id}")
	public ResponseEntity<List<GroupsHistDTO>> findGroupsHistByEvntOperId(@PathVariable int id) throws Exception {
		List<GroupsHistDTO> results = businessService.findGroupsHistByEvntOperId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GroupsHistDTO> by foreign key : GrpIdAndActionTypeIdAndEvntOperId
	 * @param id0
	 * @return List<GroupsHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpIdAndActionTypeIdAndEvntOperId/{id0}/{id1}/{id2}")
	public ResponseEntity<List<GroupsHistDTO>> findGroupsHistByGrpIdAndActionTypeIdAndEvntOperId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<GroupsHistDTO> results = businessService.findGroupsHistByGrpIdAndActionTypeIdAndEvntOperId(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
