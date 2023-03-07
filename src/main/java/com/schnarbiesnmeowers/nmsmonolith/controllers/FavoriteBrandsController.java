package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.FavoriteBrandsDTO;
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
@RequestMapping(path="/favoritebrands")
public class FavoriteBrandsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private FavoriteBrandsService favoriteBrandsService;

	/**
	 * get all FavoriteBrands records
	 * @return Iterable<FavoriteBrands>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<FavoriteBrandsDTO>> getAllFavoriteBrands() throws Exception {
		List<FavoriteBrandsDTO> favoritebrands = favoriteBrandsService.getAllFavoriteBrands();
		return ResponseEntity.status(HttpStatus.OK).body(favoritebrands);
	}

	/**
	 * get FavoriteBrands by primary key
	 * @param id
	 * @return FavoriteBrands
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<FavoriteBrandsDTO> findFavoriteBrandsById(@PathVariable int id) throws Exception {
		FavoriteBrandsDTO results = favoriteBrandsService.findFavoriteBrandsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new FavoriteBrands
	 * @param data
	 * @return FavoriteBrands
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<FavoriteBrandsDTO> createFavoriteBrands(@Valid @RequestBody FavoriteBrandsDTO data) throws Exception {
		try {
		    FavoriteBrandsDTO createdData = favoriteBrandsService.createFavoriteBrands(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a FavoriteBrands
	 * @param data
	 * @return FavoriteBrands
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<FavoriteBrandsDTO> updateFavoriteBrands(@Valid @RequestBody FavoriteBrandsDTO data) throws Exception {
		FavoriteBrandsDTO updatedData = favoriteBrandsService.updateFavoriteBrands(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a FavoriteBrands by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteFavoriteBrands(@PathVariable int id) throws Exception {
		favoriteBrandsService.deleteFavoriteBrands(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * delete a FavoriteBrands by userId and brandId(* note, does not actually delete the record
	 * just sets actv="N")
	 * @param data
	 * @return FavoriteBrands
	 */
	@PostMapping(path = "/deletebyuseridandbrandid")
	public ResponseEntity<String> deleteFavoriteBrandByUserIdAndBrandId(@Valid @RequestBody FavoriteBrandsDTO data) throws Exception {
		String result = favoriteBrandsService.deleteFavoriteByUserIdandBrandId(data.getUserId(),data.getBrandId());
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
