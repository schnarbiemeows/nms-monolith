package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
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
@RequestMapping(path="/paymenttype")
public class PaymentTypeController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PaymentTypeService businessService;

	/**
	 * get all PaymentType records
	 * @return Iterable<PaymentType>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<PaymentTypeDTO>> getAllPaymentType() throws Exception {
		List<PaymentTypeDTO> paymenttype = businessService.getAllPaymentType();
		return ResponseEntity.status(HttpStatus.OK).body(paymenttype);
	}

	/**
	 * get PaymentType by primary key
	 * @param id
	 * @return PaymentType
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<PaymentTypeDTO> findPaymentTypeById(@PathVariable int id) throws Exception {
		PaymentTypeDTO results = businessService.findPaymentTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new PaymentType
	 * @param PaymentTypeDTO
	 * @return PaymentType
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<PaymentTypeDTO> createPaymentType(@Valid @RequestBody PaymentTypeDTO data) throws Exception {
		try {
		    PaymentTypeDTO createdData = businessService.createPaymentType(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PaymentType
	 * @param PaymentTypeDTO
	 * @return PaymentType
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<PaymentTypeDTO> updatePaymentType(@Valid @RequestBody PaymentTypeDTO data) throws Exception {
		PaymentTypeDTO updatedData = businessService.updatePaymentType(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a PaymentType by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePaymentType(@PathVariable int id) throws Exception {
		businessService.deletePaymentType(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<PaymentTypeDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<PaymentType>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByImageLoc/{id}")
	public ResponseEntity<List<PaymentTypeDTO>> findPaymentTypeByImageLoc(@PathVariable int id) throws Exception {
		List<PaymentTypeDTO> results = businessService.findPaymentTypeByImageLoc(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
