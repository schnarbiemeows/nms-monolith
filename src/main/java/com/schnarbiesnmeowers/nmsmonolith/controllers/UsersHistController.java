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

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/usershist")
public class UsersHistController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UsersHistService usersHistService;

	/**
	 * get all UsersHist records
	 * @return Iterable<UsersHist>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UsersHistDTO>> getAllUsersHist() throws Exception {
		List<UsersHistDTO> usershist = usersHistService.getAllUsersHist();
		return ResponseEntity.status(HttpStatus.OK).body(usershist);
	}

	/**
	 * get UsersHist by primary key
	 * @param id
	 * @return UsersHist
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UsersHistDTO> findUsersHistById(@PathVariable int id) throws Exception {
		UsersHistDTO results = usersHistService.findUsersHistById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new UsersHist
	 * @param UsersHistDTO
	 * @return UsersHist
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UsersHistDTO> createUsersHist(@Valid @RequestBody UsersHistDTO data) throws Exception {
		try {
		    UsersHistDTO createdData = usersHistService.createUsersHist(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UsersHist
	 * @param UsersHistDTO
	 * @return UsersHist
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UsersHistDTO> updateUsersHist(@Valid @RequestBody UsersHistDTO data) throws Exception {
		UsersHistDTO updatedData = usersHistService.updateUsersHist(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a UsersHist by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUsersHist(@PathVariable int id) throws Exception {
		usersHistService.deleteUsersHist(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<UsersHistDTO> by foreign key : userId
	 * @param userId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<UsersHistDTO>> findUsersHistByUserId(@PathVariable int id) throws Exception {
		List<UsersHistDTO> results = usersHistService.findUsersHistByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<UsersHistDTO> by foreign key : actionTypeId
	 * @param actionTypeId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByActionTypeId/{id}")
	public ResponseEntity<List<UsersHistDTO>> findUsersHistByActionTypeId(@PathVariable int id) throws Exception {
		List<UsersHistDTO> results = usersHistService.findUsersHistByActionTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<UsersHistDTO> by foreign key : evntOperId
	 * @param evntOperId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEvntOperId/{id}")
	public ResponseEntity<List<UsersHistDTO>> findUsersHistByEvntOperId(@PathVariable int id) throws Exception {
		List<UsersHistDTO> results = usersHistService.findUsersHistByEvntOperId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<UsersHistDTO> by foreign key : UserIdAndActionTypeIdAndEvntOperId
	 * @param UserIdAndActionTypeIdAndEvntOperId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndActionTypeIdAndEvntOperId/{id0}/{id1}/{id2}")
	public ResponseEntity<List<UsersHistDTO>> findUsersHistByUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<UsersHistDTO> results = usersHistService.findUsersHistByUserIdAndActionTypeIdAndEvntOperId(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
