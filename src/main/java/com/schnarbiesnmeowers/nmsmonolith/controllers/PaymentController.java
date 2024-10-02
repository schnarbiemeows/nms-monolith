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
@RequestMapping(path="/payment")
public class PaymentController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PaymentService businessService;

	/**
	 * get all Payment records
	 * @return Iterable<Payment>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<PaymentDTO>> getAllPayment() throws Exception {
		List<PaymentDTO> payment = businessService.getAllPayment();
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}

	/**
	 * get Payment by primary key
	 * @param id
	 * @return Payment
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<PaymentDTO> findPaymentById(@PathVariable int id) throws Exception {
		PaymentDTO results = businessService.findPaymentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Payment
	 * @param PaymentDTO
	 * @return Payment
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<PaymentDTO> createPayment(@Valid @RequestBody PaymentDTO data) throws Exception {
		try {
		    PaymentDTO createdData = businessService.createPayment(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Payment
	 * @param PaymentDTO
	 * @return Payment
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<PaymentDTO> updatePayment(@Valid @RequestBody PaymentDTO data) throws Exception {
		PaymentDTO updatedData = businessService.updatePayment(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Payment by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deletePayment(@PathVariable int id) throws Exception {
		businessService.deletePayment(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<PaymentDTO> by foreign key : userId
	 * @param userId
	 * @return List<Payment>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserId/{id}")
	public ResponseEntity<List<PaymentDTO>> findPaymentByUserId(@PathVariable int id) throws Exception {
		List<PaymentDTO> results = businessService.findPaymentByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<PaymentDTO> by foreign key : paymentTypeId
	 * @param paymentTypeId
	 * @return List<Payment>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByPaymentTypeId/{id}")
	public ResponseEntity<List<PaymentDTO>> findPaymentByPaymentTypeId(@PathVariable int id) throws Exception {
		List<PaymentDTO> results = businessService.findPaymentByPaymentTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<PaymentDTO> by foreign key : UserIdAndPaymentTypeId
	 * @param UserIdAndPaymentTypeId
	 * @return List<Payment>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByUserIdAndPaymentTypeId/{id0}/{id1}")
	public ResponseEntity<List<PaymentDTO>> findPaymentByUserIdAndPaymentTypeId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<PaymentDTO> results = businessService.findPaymentByUserIdAndPaymentTypeId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
