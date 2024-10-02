package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandMinDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsWrapper;
import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
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
@RequestMapping(path="/brands")
public class BrandsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BrandsService brandsService;

	/**
	 * get all Brands records
	 * @return Iterable<Brands>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<BrandsDTO>> getAllBrands() throws Exception {
		List<BrandsDTO> brands = brandsService.getAllBrands();
		return ResponseEntity.status(HttpStatus.OK).body(brands);
	}

	@GetMapping(path = "/getminimumbranddata")
	public ResponseEntity<List<BrandMinDTO>> getMinimumBrandData() throws Exception {
		List<BrandMinDTO> brands = brandsService.getMinimumBrandData();
		return ResponseEntity.status(HttpStatus.OK).body(brands);
	}

	/**
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/all-displays/{id}")
	public ResponseEntity<BrandsWrapper> getAllBrandDisplays(@PathVariable int id) throws Exception {
		BrandsWrapper results = brandsService.getAllBrandDisplays(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get Brand by primary key
	 * @param id
	 * @return Brands
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<BrandsDTO> findBrandsById(@PathVariable int id) throws Exception {
		BrandsDTO results = brandsService.findBrandsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Brands
	 * @param data
	 * @return Brands
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<BrandsDTO> createBrands(@Valid @RequestBody BrandsDTO data) throws Exception {
		try {
		    BrandsDTO createdData = brandsService.createBrands(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Brands
	 * @param data
	 * @return Brands
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<BrandsDTO> updateBrands(@Valid @RequestBody BrandsDTO data) throws Exception {
		BrandsDTO updatedData = brandsService.updateBrands(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Brands by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteBrands(@PathVariable int id) throws Exception {
		brandsService.deleteBrands(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<BrandsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Brands>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<BrandsDTO>> findBrandsByImageLoc(@PathVariable int id) throws Exception {
		List<BrandsDTO> results = brandsService.findBrandsByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
