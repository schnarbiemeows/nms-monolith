package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandMinDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.LocalBrandsDTO;
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
@RequestMapping(path="/localbrands")
public class LocalBrandsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LocalBrandsService localBrandsService;

	/**
	 * get all LocalBrands records
	 * @return Iterable<LocalBrands>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<LocalBrandsDTO>> getAllLocalBrands() throws Exception {
		List<LocalBrandsDTO> localbrands = localBrandsService.getAllLocalBrands();
		return ResponseEntity.status(HttpStatus.OK).body(localbrands);
	}

	/**
	 * get LocalBrands by primary key
	 * @param id
	 * @return LocalBrands
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<LocalBrandsDTO> findLocalBrandsById(@PathVariable int id) throws Exception {
		LocalBrandsDTO results = localBrandsService.findLocalBrandsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping(path = "/getminimumbranddata/{userId}")
	public ResponseEntity<List<BrandMinDTO>> getMinimumLocalBrandData(@PathVariable int userId) throws Exception {
		List<BrandMinDTO> results = localBrandsService.getMinimumBrandData(userId);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new LocalBrands
	 * @param data
	 * @return LocalBrands
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<LocalBrandsDTO> createLocalBrands(@Valid @RequestBody LocalBrandsDTO data) throws Exception {
		try {
		    LocalBrandsDTO createdData = localBrandsService.createLocalBrands(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LocalBrands
	 * @param data
	 * @return LocalBrands
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<LocalBrandsDTO> updateLocalBrands(@Valid @RequestBody LocalBrandsDTO data) throws Exception {
		LocalBrandsDTO updatedData = localBrandsService.updateLocalBrands(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a LocalBrands by primary key
	 * need the userId in order to check for dependencies
	 * @param id
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(path = "/delete/{id}/{userId}")
	public ResponseEntity<ResponseMessage> deleteLocalBrands(@PathVariable int id, @PathVariable int userId) throws Exception {
		localBrandsService.deleteLocalBrands(id,userId);
		ResponseMessage rb = new ResponseMessage("Brand successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<LocalBrandsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<LocalBrands>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<LocalBrandsDTO>> findLocalBrandsByImageLoc(@PathVariable int id) throws Exception {
		List<LocalBrandsDTO> results = localBrandsService.findLocalBrandsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
