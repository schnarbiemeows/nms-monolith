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
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeOptionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeOptions;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeOptionsRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ServingTypeOptionsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ServingTypeOptionsRepository service;

	/**
	 * get all ServingTypeOptions records
	 * @return
	 * @throws Exception
	 */
	public List<ServingTypeOptionsDTO> getAllServingTypeOptions() throws Exception {
		Iterable<ServingTypeOptions> servingtypeoptions = service.findAll();
		Iterator<ServingTypeOptions> servingtypeoptionss = servingtypeoptions.iterator();
		List<ServingTypeOptionsDTO> servingtypeoptionsdto = new ArrayList();
		while(servingtypeoptionss.hasNext()) {
			ServingTypeOptions item = servingtypeoptionss.next();
			servingtypeoptionsdto.add(item.toDTO());
		}
		return servingtypeoptionsdto;
	}

	/**
	 * get ServingTypeOptions by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ServingTypeOptionsDTO findServingTypeOptionsById(int id) throws Exception {
		Optional<ServingTypeOptions> servingtypeoptionsOptional = service.findById(id);
		if(servingtypeoptionsOptional.isPresent()) {
			ServingTypeOptions results = servingtypeoptionsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new ServingTypeOptions
	 * @param data
	 * @return
	 */
	public ServingTypeOptionsDTO createServingTypeOptions(ServingTypeOptionsDTO data) {
		try {
		    ServingTypeOptions createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ServingTypeOptions
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ServingTypeOptionsDTO updateServingTypeOptions(ServingTypeOptionsDTO data) throws Exception {
		Optional<ServingTypeOptions> servingtypeoptionsOptional = service.findById(data.getServTypeOptId());
		if(servingtypeoptionsOptional.isPresent()) {
		    ServingTypeOptions updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getServTypeOptId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ServingTypeOptions by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteServingTypeOptions(int id) throws Exception {
		Optional<ServingTypeOptions> servingtypeoptionsOptional = service.findById(id);
		if(servingtypeoptionsOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<ServingTypeOptionsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<ServingTypeOptions>
	 * @throws Exception
	*/
	public List<ServingTypeOptionsDTO> findServingTypeOptionsByServTypeId(int id) throws Exception {
		Iterable<ServingTypeOptions> results = service.findServingTypeOptionsByServTypeId(id);
		Iterator<ServingTypeOptions> iter = results.iterator();
		List<ServingTypeOptionsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypeOptions item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ServingTypeOptionsDTO> by foreign key : menuOption
	 * @param id
	 * @return List<ServingTypeOptions>
	 * @throws Exception
	*/
	public List<ServingTypeOptionsDTO> findServingTypeOptionsByMenuOption(int id) throws Exception {
		Iterable<ServingTypeOptions> results = service.findServingTypeOptionsByMenuOption(id);
		Iterator<ServingTypeOptions> iter = results.iterator();
		List<ServingTypeOptionsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypeOptions item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ServingTypeOptionsDTO> by foreign key : ServTypeIdAndMenuOption
	 * @param id
	 * @return List<ServingTypeOptions>
	 * @throws Exception
	*/
	public List<ServingTypeOptionsDTO> findServingTypeOptionsByServTypeIdAndMenuOption(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<ServingTypeOptions> results = service.findServingTypeOptionsByServTypeIdAndMenuOption(id0, id1);
		Iterator<ServingTypeOptions> iter = results.iterator();
		List<ServingTypeOptionsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypeOptions item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
