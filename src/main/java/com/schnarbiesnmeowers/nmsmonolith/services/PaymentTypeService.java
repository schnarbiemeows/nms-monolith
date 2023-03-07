package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.PaymentType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PaymentTypeRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PaymentTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PaymentTypeRepository paymentTypeRepository;

	/**
	 * get all PaymentType records
	 * @return
	 * @throws Exception
	 */
	public List<PaymentTypeDTO> getAllPaymentType() throws Exception {
		Iterable<PaymentType> paymenttype = paymentTypeRepository.findAll();
		Iterator<PaymentType> paymenttypes = paymenttype.iterator();
		List<PaymentTypeDTO> paymenttypedto = new ArrayList();
		while(paymenttypes.hasNext()) {
			PaymentType item = paymenttypes.next();
			paymenttypedto.add(item.toDTO());
		}
		return paymenttypedto;
	}

	/**
	 * get PaymentType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PaymentTypeDTO findPaymentTypeById(int id) throws Exception {
		Optional<PaymentType> paymenttypeOptional = paymentTypeRepository.findById(id);
		if(paymenttypeOptional.isPresent()) {
			PaymentType results = paymenttypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new PaymentType
	 * @param data
	 * @return
	 */
	public PaymentTypeDTO createPaymentType(PaymentTypeDTO data) {
		try {
		    PaymentType createdData = data.toEntity();
		    createdData = paymentTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PaymentType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PaymentTypeDTO updatePaymentType(PaymentTypeDTO data) throws Exception {
		Optional<PaymentType> paymenttypeOptional = paymentTypeRepository.findById(data.getPaymentTypeId());
		if(paymenttypeOptional.isPresent()) {
		    PaymentType updatedData = data.toEntity();
			updatedData = paymentTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getPaymentTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a PaymentType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePaymentType(int id) throws Exception {
		Optional<PaymentType> paymenttypeOptional = paymentTypeRepository.findById(id);
		if(paymenttypeOptional.isPresent()) {
			paymentTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<PaymentTypeDTO> by foreign key : imageLoc
	 * @param imageLoc
	 * @return List<PaymentType>
	 * @throws Exception
	*/
	public List<PaymentTypeDTO> findPaymentTypeByImageLoc(int id) throws Exception {
		Iterable<PaymentType> results = paymentTypeRepository.findPaymentTypeByImageLoc(id);
		Iterator<PaymentType> iter = results.iterator();
		List<PaymentTypeDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			PaymentType item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
