package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentTypeDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PaymentTypeServiceTest {


	/**
	 * get all PaymentType records
	 * @return
	 * @throws Exception
	 */
	public List<PaymentTypeDTO> getAllPaymentType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<PaymentTypeDTO> paymenttypeDTO = new ArrayList<PaymentTypeDTO>();
		return paymenttypeDTO;
	}

	/**
	 * get PaymentType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PaymentTypeDTO findPaymentTypeById(int id) throws Exception {
		return new PaymentTypeDTO();
	}

	/**
	 * create a new PaymentType
	 * @param data
	 * @return
	 */
	public PaymentTypeDTO createPaymentType(PaymentTypeDTO data) {
        data.setPaymentTypeId(1);
        return data;
	}

	/**
	 * update a PaymentType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PaymentTypeDTO updatePaymentType(PaymentTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a PaymentType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePaymentType(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<PaymentTypeDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<PaymentType>
	 * @throws Exception
	*/
	public List<PaymentTypeDTO> findPaymentTypeByImageLoc(int id) throws Exception {
		List<PaymentTypeDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
