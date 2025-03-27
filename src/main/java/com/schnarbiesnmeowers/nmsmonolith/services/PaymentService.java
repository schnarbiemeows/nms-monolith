package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Payment;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PaymentRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PaymentService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PaymentRepository paymentRepository;

	/**
	 * get all Payment records
	 * @return
	 * @throws Exception
	 */
	public List<PaymentDTO> getAllPayment() throws Exception {
		Iterable<Payment> payment = paymentRepository.findAll();
		Iterator<Payment> payments = payment.iterator();
		List<PaymentDTO> paymentdto = new ArrayList();
		while(payments.hasNext()) {
			Payment item = payments.next();
			paymentdto.add(item.toDTO());
		}
		return paymentdto;
	}

	/**
	 * get Payment by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PaymentDTO findPaymentById(int id) throws Exception {
		Optional<Payment> paymentOptional = paymentRepository.findById(id);
		if(paymentOptional.isPresent()) {
			Payment results = paymentOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Payment
	 * @param data
	 * @return
	 */
	public PaymentDTO createPayment(PaymentDTO data) {
		try {
		    Payment createdData = data.toEntity();
		    createdData = paymentRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Payment
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PaymentDTO updatePayment(PaymentDTO data) throws Exception {
		Optional<Payment> paymentOptional = paymentRepository.findById(data.getPaymentId());
		if(paymentOptional.isPresent()) {
		    Payment updatedData = data.toEntity();
			updatedData = paymentRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getPaymentId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Payment by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePayment(int id) throws Exception {
		Optional<Payment> paymentOptional = paymentRepository.findById(id);
		if(paymentOptional.isPresent()) {
			paymentRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<PaymentDTO> by foreign key : userId
	 * @param userId
	 * @return List<Payment>
	 * @throws Exception
	*/
	public List<PaymentDTO> findPaymentByUserId(int id) throws Exception {
		Iterable<Payment> results = paymentRepository.findPaymentByUserId(id);
		Iterator<Payment> iter = results.iterator();
		List<PaymentDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Payment item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<PaymentDTO> by foreign key : paymentTypeId
	 * @param paymentTypeId
	 * @return List<Payment>
	 * @throws Exception
	*/
	public List<PaymentDTO> findPaymentByPaymentTypeId(int id) throws Exception {
		Iterable<Payment> results = paymentRepository.findPaymentByPaymentTypeId(id);
		Iterator<Payment> iter = results.iterator();
		List<PaymentDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Payment item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<PaymentDTO> by foreign key : UserIdAndPaymentTypeId
	 * @param UserIdAndPaymentTypeId
	 * @return List<Payment>
	 * @throws Exception
	*/
	public List<PaymentDTO> findPaymentByUserIdAndPaymentTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<Payment> results = paymentRepository.findPaymentByUserIdAndPaymentTypeId(id0, id1);
		Iterator<Payment> iter = results.iterator();
		List<PaymentDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Payment item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
