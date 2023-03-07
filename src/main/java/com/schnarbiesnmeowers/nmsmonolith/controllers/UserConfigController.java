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
@RequestMapping(path="/userconfig")
public class UserConfigController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UserConfigService businessService;

	/**
	 * get all UserConfig records
	 * @return Iterable<UserConfig>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<UserConfigDTO>> getAllUserConfig() throws Exception {
		List<UserConfigDTO> userconfig = businessService.getAllUserConfig();
		return ResponseEntity.status(HttpStatus.OK).body(userconfig);
	}

	/**
	 * get UserConfig by primary key
	 * @param id
	 * @return UserConfig
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UserConfigDTO> findUserConfigById(@PathVariable int id) throws Exception {
		UserConfigDTO results = businessService.findUserConfigById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new UserConfig
	 * @param UserConfigDTO
	 * @return UserConfig
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<UserConfigDTO> createUserConfig(@Valid @RequestBody UserConfigDTO data) throws Exception {
		try {
		    UserConfigDTO createdData = businessService.createUserConfig(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UserConfig
	 * @param UserConfigDTO
	 * @return UserConfig
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<UserConfigDTO> updateUserConfig(@Valid @RequestBody UserConfigDTO data) throws Exception {
		UserConfigDTO updatedData = businessService.updateUserConfig(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a UserConfig by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteUserConfig(@PathVariable int id) throws Exception {
		businessService.deleteUserConfig(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<UserConfigDTO> by foreign key : userId
	 * @param userId
	 * @return List<UserConfig>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<UserConfigDTO>> findUserConfigByUserId(@PathVariable int id) throws Exception {
		List<UserConfigDTO> results = businessService.findUserConfigByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
