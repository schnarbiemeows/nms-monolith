package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PaymentServiceTest {


	/**
	 * get all Payment records
	 * @return
	 * @throws Exception
	 */
	public List<PaymentDTO> getAllPayment() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<PaymentDTO> paymentDTO = new ArrayList<PaymentDTO>();
		return paymentDTO;
	}

	/**
	 * get Payment by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PaymentDTO findPaymentById(int id) throws Exception {
		return new PaymentDTO();
	}

	/**
	 * create a new Payment
	 * @param data
	 * @return
	 */
	public PaymentDTO createPayment(PaymentDTO data) {
        data.setPaymentId(1);
        return data;
	}

	/**
	 * update a Payment
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PaymentDTO updatePayment(PaymentDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Payment by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePayment(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<PaymentDTO> by foreign key : userId
	 * @param id
	 * @return List<Payment>
	 * @throws Exception
	*/
	public List<PaymentDTO> findPaymentByUserId(int id) throws Exception {
		List<PaymentDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<PaymentDTO> by foreign key : paymentTypeId
	 * @param id
	 * @return List<Payment>
	 * @throws Exception
	*/
	public List<PaymentDTO> findPaymentByPaymentTypeId(int id) throws Exception {
		List<PaymentDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<PaymentDTO> by foreign key : UserIdAndPaymentTypeId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<PaymentDTO> findPaymentByUserIdAndPaymentTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<PaymentDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
