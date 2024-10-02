package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeRatios;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeRatiosRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ServingTypeRatiosService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ServingTypeRatiosRepository servingTypeRatiosRepository;

	/**
	 * get all ServingTypeRatios records
	 * @return
	 * @throws Exception
	 */
	public List<ServingTypeRatiosDTO> getAllServingTypeRatios() throws Exception {
		Iterable<ServingTypeRatios> servingtyperatios = servingTypeRatiosRepository.findAll();
		Iterator<ServingTypeRatios> servingtyperatioss = servingtyperatios.iterator();
		List<ServingTypeRatiosDTO> servingtyperatiosdto = new ArrayList();
		while(servingtyperatioss.hasNext()) {
			ServingTypeRatios item = servingtyperatioss.next();
			servingtyperatiosdto.add(item.toDTO());
		}
		return servingtyperatiosdto;
	}

	/**
	 * get ServingTypeRatios by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ServingTypeRatiosDTO findServingTypeRatiosById(int id) throws Exception {
		Optional<ServingTypeRatios> servingtyperatiosOptional = servingTypeRatiosRepository.findById(id);
		if(servingtyperatiosOptional.isPresent()) {
			ServingTypeRatios results = servingtyperatiosOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new ServingTypeRatios
	 * @param data
	 * @return
	 */
	public ServingTypeRatiosDTO createServingTypeRatios(ServingTypeRatiosDTO data) {
		try {
		    ServingTypeRatios createdData = data.toEntity();
		    createdData = servingTypeRatiosRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ServingTypeRatios
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ServingTypeRatiosDTO updateServingTypeRatios(ServingTypeRatiosDTO data) throws Exception {
		Optional<ServingTypeRatios> servingtyperatiosOptional = servingTypeRatiosRepository.findById(data.getServTypeRatioId());
		if(servingtyperatiosOptional.isPresent()) {
		    ServingTypeRatios updatedData = data.toEntity();
			updatedData = servingTypeRatiosRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getServTypeRatioId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ServingTypeRatios by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteServingTypeRatios(int id) throws Exception {
		Optional<ServingTypeRatios> servingtyperatiosOptional = servingTypeRatiosRepository.findById(id);
		if(servingtyperatiosOptional.isPresent()) {
			servingTypeRatiosRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : servTypeId1
	 * @param servTypeId1
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	public List<ServingTypeRatiosDTO> findServingTypeRatiosByServTypeId1(int id) throws Exception {
		Iterable<ServingTypeRatios> results = servingTypeRatiosRepository.findServingTypeRatiosByServTypeId1(id);
		Iterator<ServingTypeRatios> iter = results.iterator();
		List<ServingTypeRatiosDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypeRatios item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : servTypeId2
	 * @param servTypeId2
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	public List<ServingTypeRatiosDTO> findServingTypeRatiosByServTypeId2(int id) throws Exception {
		Iterable<ServingTypeRatios> results = servingTypeRatiosRepository.findServingTypeRatiosByServTypeId2(id);
		Iterator<ServingTypeRatios> iter = results.iterator();
		List<ServingTypeRatiosDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypeRatios item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ServingTypeRatiosDTO> by foreign key : ServTypeId1AndServTypeId2
	 * @param ServTypeId1AndServTypeId2
	 * @return List<ServingTypeRatios>
	 * @throws Exception
	*/
	public List<ServingTypeRatiosDTO> findServingTypeRatiosByServTypeId1AndServTypeId2(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<ServingTypeRatios> results = servingTypeRatiosRepository.findServingTypeRatiosByServTypeId1AndServTypeId2(id0, id1);
		Iterator<ServingTypeRatios> iter = results.iterator();
		List<ServingTypeRatiosDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ServingTypeRatios item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
