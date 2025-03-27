package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalRecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/localrecipespices")
public class LocalRecipeSpicesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalRecipeSpicesService localRecipeSpicesService;

	/**
	 * get all LocalRecipeSpices records
	 * @return Iterable<LocalRecipeSpices>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalRecipeSpicesDTO>> getAllLocalRecipeSpices() throws Exception {
		List<LocalRecipeSpicesDTO> localrecipespices = localRecipeSpicesService.getAllLocalRecipeSpices();
		return ResponseEntity.status(HttpStatus.OK).body(localrecipespices);
	}

	/**
	 * get LocalRecipeSpices by primary key
	 * @param id
	 * @return LocalRecipeSpices
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LocalRecipeSpicesDTO> findLocalRecipeSpicesById(@PathVariable int id) throws Exception {
		LocalRecipeSpicesDTO results = localRecipeSpicesService.findLocalRecipeSpicesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LocalRecipeSpices
	 * @param LocalRecipeSpicesDTO
	 * @return LocalRecipeSpices
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalRecipeSpicesDTO> createLocalRecipeSpices(@Valid @RequestBody LocalRecipeSpicesDTO data) throws Exception {
		try {
		    LocalRecipeSpicesDTO createdData = localRecipeSpicesService.createLocalRecipeSpices(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalRecipeSpices
	 * @param data
	 * @return LocalRecipeSpices
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LocalRecipeSpicesDTO> updateLocalRecipeSpices(@Valid @RequestBody LocalRecipeSpicesDTO data) throws Exception {
		LocalRecipeSpicesDTO updatedData = localRecipeSpicesService.updateLocalRecipeSpices(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LocalRecipeSpices by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteLocalRecipeSpices(@PathVariable int id) throws Exception {
		localRecipeSpicesService.deleteLocalRecipeSpices(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LocalRecipeSpicesDTO> by foreign key : recipeId
	 * @param recipeId
	 * @return List<LocalRecipeSpices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeId/{id}")
	public ResponseEntity<List<LocalRecipeSpicesDTO>> findLocalRecipeSpicesByRecipeId(@PathVariable int id) throws Exception {
		List<LocalRecipeSpicesDTO> results = localRecipeSpicesService.findLocalRecipeSpicesByRecipeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalRecipeSpicesDTO> by foreign key : servTypeId
	 * @param servTypeId
	 * @return List<LocalRecipeSpices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByServTypeId/{id}")
	public ResponseEntity<List<LocalRecipeSpicesDTO>> findLocalRecipeSpicesByServTypeId(@PathVariable int id) throws Exception {
		List<LocalRecipeSpicesDTO> results = localRecipeSpicesService.findLocalRecipeSpicesByServTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<LocalRecipeSpicesDTO> by foreign key : RecipeIdAndServTypeId
	 * @param RecipeIdAndServTypeId
	 * @return List<LocalRecipeSpices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByRecipeIdAndServTypeId/{id0}/{id1}")
	public ResponseEntity<List<LocalRecipeSpicesDTO>> findLocalRecipeSpicesByRecipeIdAndServTypeId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<LocalRecipeSpicesDTO> results = localRecipeSpicesService.findLocalRecipeSpicesByRecipeIdAndServTypeId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
