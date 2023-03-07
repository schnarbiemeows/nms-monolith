package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
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
@RequestMapping(path="/favoritespices")
public class FavoriteSpicesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteSpicesService service;

	/**
	 * get all FavoriteSpices records
	 * @return Iterable<FavoriteSpices>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<FavoriteSpicesDTO>> getAllFavoriteSpices() throws Exception {
		List<FavoriteSpicesDTO> favoritespices = service.getAllFavoriteSpices();
		return ResponseEntity.status(HttpStatus.OK).body(favoritespices);
	}

	/**
	 * get FavoriteSpices by primary key
	 * @param id
	 * @return FavoriteSpices
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<FavoriteSpicesDTO> findFavoriteSpicesById(@PathVariable int id) throws Exception {
		FavoriteSpicesDTO results = service.findFavoriteSpicesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new FavoriteSpices
	 * @param data
	 * @return FavoriteSpices
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<FavoriteSpicesDTO> createFavoriteSpices(@Valid @RequestBody FavoriteSpicesDTO data) throws Exception {
		try {
		    FavoriteSpicesDTO createdData = service.createFavoriteSpices(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteSpices
	 * @param data
	 * @return FavoriteSpices
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<FavoriteSpicesDTO> updateFavoriteSpices(@Valid @RequestBody FavoriteSpicesDTO data) throws Exception {
		FavoriteSpicesDTO updatedData = service.updateFavoriteSpices(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a FavoriteSpices by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteFavoriteSpices(@PathVariable int id) throws Exception {
		service.deleteFavoriteSpices(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
