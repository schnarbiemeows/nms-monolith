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
@RequestMapping(path="/roleshist")
public class RolesHistController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private RolesHistBusiness businessService;

	/**
	 * get all RolesHist records
	 * @return Iterable<RolesHist>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<RolesHistDTO>> getAllRolesHist() throws Exception {
		List<RolesHistDTO> roleshist = businessService.getAllRolesHist();
		return ResponseEntity.status(HttpStatus.OK).body(roleshist);
	}

	/**
	 * get RolesHist by primary key
	 * @param id
	 * @return RolesHist
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<RolesHistDTO> findRolesHistById(@PathVariable int id) throws Exception {
		RolesHistDTO results = businessService.findRolesHistById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new RolesHist
	 * @param RolesHistDTO
	 * @return RolesHist
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<RolesHistDTO> createRolesHist(@Valid @RequestBody RolesHistDTO data) throws Exception {
		try {
		    RolesHistDTO createdData = businessService.createRolesHist(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a RolesHist
	 * @param RolesHistDTO
	 * @return RolesHist
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<RolesHistDTO> updateRolesHist(@Valid @RequestBody RolesHistDTO data) throws Exception {
		RolesHistDTO updatedData = businessService.updateRolesHist(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a RolesHist by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteRolesHist(@PathVariable int id) throws Exception {
		businessService.deleteRolesHist(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<RolesHistDTO> by foreign key : roleId
	 * @param roleId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRoleId/{id}")
	public ResponseEntity<List<RolesHistDTO>> findRolesHistByRoleId(@PathVariable int id) throws Exception {
		List<RolesHistDTO> results = businessService.findRolesHistByRoleId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesHistDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpId/{id}")
	public ResponseEntity<List<RolesHistDTO>> findRolesHistByGrpId(@PathVariable int id) throws Exception {
		List<RolesHistDTO> results = businessService.findRolesHistByGrpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesHistDTO> by foreign key : rsrcId
	 * @param rsrcId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRsrcId/{id}")
	public ResponseEntity<List<RolesHistDTO>> findRolesHistByRsrcId(@PathVariable int id) throws Exception {
		List<RolesHistDTO> results = businessService.findRolesHistByRsrcId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByActionTypeId/{id}")
	public ResponseEntity<List<RolesHistDTO>> findRolesHistByActionTypeId(@PathVariable int id) throws Exception {
		List<RolesHistDTO> results = businessService.findRolesHistByActionTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEvntOperId/{id}")
	public ResponseEntity<List<RolesHistDTO>> findRolesHistByEvntOperId(@PathVariable int id) throws Exception {
		List<RolesHistDTO> results = businessService.findRolesHistByEvntOperId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<RolesHistDTO> by foreign key : RoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId
	 * @param RoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId
	 * @return List<RolesHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId/{id0}/{id1}/{id2}/{id3}/{id4}")
	public ResponseEntity<List<RolesHistDTO>> findRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2, @PathVariable int id3, @PathVariable int id4) throws Exception {
		List<RolesHistDTO> results = businessService.findRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId(id0, id1, id2, id3, id4);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
