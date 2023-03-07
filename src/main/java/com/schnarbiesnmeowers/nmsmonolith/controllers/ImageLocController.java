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
@RequestMapping(path="/imageloc")
public class ImageLocController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ImageLocService businessService;

	/**
	 * get all ImageLoc records
	 * @return Iterable<ImageLoc>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<ImageLocDTO>> getAllImageLoc() throws Exception {
		List<ImageLocDTO> imageloc = businessService.getAllImageLoc();
		return ResponseEntity.status(HttpStatus.OK).body(imageloc);
	}

	/**
	 * get ImageLoc by primary key
	 * @param id
	 * @return ImageLoc
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<ImageLocDTO> findImageLocById(@PathVariable int id) throws Exception {
		ImageLocDTO results = businessService.findImageLocById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new ImageLoc
	 * @param ImageLocDTO
	 * @return ImageLoc
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<ImageLocDTO> createImageLoc(@Valid @RequestBody ImageLocDTO data) throws Exception {
		try {
		    ImageLocDTO createdData = businessService.createImageLoc(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ImageLoc
	 * @param ImageLocDTO
	 * @return ImageLoc
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<ImageLocDTO> updateImageLoc(@Valid @RequestBody ImageLocDTO data) throws Exception {
		ImageLocDTO updatedData = businessService.updateImageLoc(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a ImageLoc by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteImageLoc(@PathVariable int id) throws Exception {
		businessService.deleteImageLoc(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
