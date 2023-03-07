package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipeSpiceDisplay;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalSpicesDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.pojos.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/localspices")
public class LocalSpicesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalSpicesService localSpicesService;

	/**
	 * get all LocalSpices records
	 * @return Iterable<LocalSpices>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalSpicesDTO>> getAllLocalSpices() throws Exception {
		List<LocalSpicesDTO> localspices = localSpicesService.getAllLocalSpices();
		return ResponseEntity.status(HttpStatus.OK).body(localspices);
	}

	/**
	 * get LocalSpices by primary key
	 * @param id
	 * @return LocalSpices
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LocalSpicesDTO> findLocalSpicesById(@PathVariable int id) throws Exception {
		LocalSpicesDTO results = localSpicesService.findLocalSpicesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get LocalIngredients by primary key
	 * @param id
	 * @return LocalIngredients
	 */
	@GetMapping(path = "/display/{id}")
	public ResponseEntity<RecipeSpiceDisplay> findLocalIngredientDisplayById(@PathVariable int id) throws Exception {
		RecipeSpiceDisplay results = localSpicesService.findLocalSpiceDisplayById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}
	/**
	 * create a new LocalSpices
	 * @param data
	 * @return LocalSpices
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalSpicesDTO> createLocalSpices(@Valid @RequestBody LocalSpicesDTO data) throws Exception {
		try {
		    LocalSpicesDTO createdData = localSpicesService.createLocalSpices(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalSpices
	 * @param data
	 * @return LocalSpices
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LocalSpicesDTO> updateLocalSpices(@Valid @RequestBody LocalSpicesDTO data) throws Exception {
		LocalSpicesDTO updatedData = localSpicesService.updateLocalSpices(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LocalSpices by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}/{userId}")
	public ResponseEntity<ResponseMessage> deleteLocalSpices(@PathVariable int id, @PathVariable int userId) throws Exception {
		localSpicesService.deleteLocalSpices(id,userId);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LocalSpicesDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalSpices>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LocalSpicesDTO>> findLocalSpicesByImageLoc(@PathVariable int id) throws Exception {
		List<LocalSpicesDTO> results = localSpicesService.findLocalSpicesByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
