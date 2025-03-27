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
@RequestMapping(path="/brandingrtype")
public class BrandIngrTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BrandIngrTypeService businessService;

	/**
	 * get all BrandIngrType records
	 * @return Iterable<BrandIngrType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<BrandIngrTypeDTO>> getAllBrandIngrType() throws Exception {
		List<BrandIngrTypeDTO> brandingrtype = businessService.getAllBrandIngrType();
		return ResponseEntity.status(HttpStatus.OK).body(brandingrtype);
	}

	/**
	 * get BrandIngrType by primary key
	 * @param id
	 * @return BrandIngrType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<BrandIngrTypeDTO> findBrandIngrTypeById(@PathVariable int id) throws Exception {
		BrandIngrTypeDTO results = businessService.findBrandIngrTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new BrandIngrType
	 * @param data
	 * @return BrandIngrType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<BrandIngrTypeDTO> createBrandIngrType(@Valid @RequestBody BrandIngrTypeDTO data) throws Exception {
		try {
		    BrandIngrTypeDTO createdData = businessService.createBrandIngrType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a BrandIngrType
	 * @param data
	 * @return BrandIngrType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<BrandIngrTypeDTO> updateBrandIngrType(@Valid @RequestBody BrandIngrTypeDTO data) throws Exception {
		BrandIngrTypeDTO updatedData = businessService.updateBrandIngrType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a BrandIngrType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteBrandIngrType(@PathVariable int id) throws Exception {
		businessService.deleteBrandIngrType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : brandId
	 * @param id
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByBrandId/{id}")
	public ResponseEntity<List<BrandIngrTypeDTO>> findBrandIngrTypeByBrandId(@PathVariable int id) throws Exception {
		List<BrandIngrTypeDTO> results = businessService.findBrandIngrTypeByBrandId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : ingrTypeId
	 * @param id
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByIngrTypeId/{id}")
	public ResponseEntity<List<BrandIngrTypeDTO>> findBrandIngrTypeByIngrTypeId(@PathVariable int id) throws Exception {
		List<BrandIngrTypeDTO> results = businessService.findBrandIngrTypeByIngrTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : prntIngrType
	 * @param id
	 * @return List<BrandIngrType>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByPrntIngrType/{id}")
	public ResponseEntity<List<BrandIngrTypeDTO>> findBrandIngrTypeByPrntIngrType(@PathVariable int id) throws Exception {
		List<BrandIngrTypeDTO> results = businessService.findBrandIngrTypeByPrntIngrType(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<BrandIngrTypeDTO> by foreign key : BrandIdAndIngrTypeIdAndPrntIngrType
	 * @param id0
	 * @param id1
	 * @param id2
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/findByBrandIdAndIngrTypeIdAndPrntIngrType/{id0}/{id1}/{id2}")
	public ResponseEntity<List<BrandIngrTypeDTO>> findBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType(
			@PathVariable int id0, @PathVariable int id1, @PathVariable int id2) throws Exception {
		List<BrandIngrTypeDTO> results = businessService
				.findBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType(id0, id1, id2);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
