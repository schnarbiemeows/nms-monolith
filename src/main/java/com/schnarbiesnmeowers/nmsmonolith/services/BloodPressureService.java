package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BloodPressureDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.BloodPressure;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BloodPressureRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class BloodPressureService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private BloodPressureRepository service;

	/**
	 * get all BloodPressure records
	 * @return
	 * @throws Exception
	 */
	public List<BloodPressureDTO> getAllBloodPressure() throws Exception {
		Iterable<BloodPressure> bloodpressure = service.findAll();
		Iterator<BloodPressure> bloodpressures = bloodpressure.iterator();
		List<BloodPressureDTO> bloodpressuredto = new ArrayList();
		while(bloodpressures.hasNext()) {
			BloodPressure item = bloodpressures.next();
			bloodpressuredto.add(item.toDTO());
		}
		return bloodpressuredto;
	}

	/**
	 * get BloodPressure by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BloodPressureDTO findBloodPressureById(int id) throws Exception {
		Optional<BloodPressure> bloodpressureOptional = service.findById(id);
		if(bloodpressureOptional.isPresent()) {
			BloodPressure results = bloodpressureOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new BloodPressure
	 * @param data
	 * @return
	 */
	public BloodPressureDTO createBloodPressure(BloodPressureDTO data) {
		try {
		    BloodPressure createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a BloodPressure
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public BloodPressureDTO updateBloodPressure(BloodPressureDTO data) throws Exception {
		Optional<BloodPressure> bloodpressureOptional = service.findById(data.getBloodPressureId());
		if(bloodpressureOptional.isPresent()) {
		    BloodPressure updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getBloodPressureId() + NOT_FOUND);
		}
	}

	/**
	 * delete a BloodPressure by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteBloodPressure(int id) throws Exception {
		Optional<BloodPressure> bloodpressureOptional = service.findById(id);
		if(bloodpressureOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<BloodPressureDTO> by foreign key : userId
	 * @param id
	 * @return List<BloodPressure>
	 * @throws Exception
	*/
	public List<BloodPressureDTO> findBloodPressureByUserId(int id) throws Exception {
		Iterable<BloodPressure> results = service.findBloodPressureByUserId(id);
		Iterator<BloodPressure> iter = results.iterator();
		List<BloodPressureDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			BloodPressure item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
