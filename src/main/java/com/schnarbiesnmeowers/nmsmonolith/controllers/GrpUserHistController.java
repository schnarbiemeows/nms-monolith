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
@RequestMapping(path="/grpuserhist")
public class GrpUserHistController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GrpUserHistService businessService;

	/**
	 * get all GrpUserHist records
	 * @return Iterable<GrpUserHist>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<GrpUserHistDTO>> getAllGrpUserHist() throws Exception {
		List<GrpUserHistDTO> grpuserhist = businessService.getAllGrpUserHist();
		return ResponseEntity.status(HttpStatus.OK).body(grpuserhist);
	}

	/**
	 * get GrpUserHist by primary key
	 * @param id
	 * @return GrpUserHist
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<GrpUserHistDTO> findGrpUserHistById(@PathVariable int id) throws Exception {
		GrpUserHistDTO results = businessService.findGrpUserHistById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new GrpUserHist
	 * @param GrpUserHistDTO
	 * @return GrpUserHist
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<GrpUserHistDTO> createGrpUserHist(@Valid @RequestBody GrpUserHistDTO data) throws Exception {
		try {
		    GrpUserHistDTO createdData = businessService.createGrpUserHist(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GrpUserHist
	 * @param GrpUserHistDTO
	 * @return GrpUserHist
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<GrpUserHistDTO> updateGrpUserHist(@Valid @RequestBody GrpUserHistDTO data) throws Exception {
		GrpUserHistDTO updatedData = businessService.updateGrpUserHist(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a GrpUserHist by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteGrpUserHist(@PathVariable int id) throws Exception {
		businessService.deleteGrpUserHist(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : grpUserId
	 * @param grpUserId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpUserId/{id}")
	public ResponseEntity<List<GrpUserHistDTO>> findGrpUserHistByGrpUserId(@PathVariable int id) throws Exception {
		List<GrpUserHistDTO> results = businessService.findGrpUserHistByGrpUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : grpId
	 * @param grpId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpId/{id}")
	public ResponseEntity<List<GrpUserHistDTO>> findGrpUserHistByGrpId(@PathVariable int id) throws Exception {
		List<GrpUserHistDTO> results = businessService.findGrpUserHistByGrpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : userId
	 * @param userId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<GrpUserHistDTO>> findGrpUserHistByUserId(@PathVariable int id) throws Exception {
		List<GrpUserHistDTO> results = businessService.findGrpUserHistByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByActionTypeId/{id}")
	public ResponseEntity<List<GrpUserHistDTO>> findGrpUserHistByActionTypeId(@PathVariable int id) throws Exception {
		List<GrpUserHistDTO> results = businessService.findGrpUserHistByActionTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEvntOperId/{id}")
	public ResponseEntity<List<GrpUserHistDTO>> findGrpUserHistByEvntOperId(@PathVariable int id) throws Exception {
		List<GrpUserHistDTO> results = businessService.findGrpUserHistByEvntOperId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<GrpUserHistDTO> by foreign key : GrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId
	 * @param GrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId
	 * @return List<GrpUserHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId/{id0}/{id1}/{id2}/{id3}/{id4}")
	public ResponseEntity<List<GrpUserHistDTO>> findGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2, @PathVariable int id3, @PathVariable int id4) throws Exception {
		List<GrpUserHistDTO> results = businessService.findGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId(id0, id1, id2, id3, id4);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
