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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ManualFoodItems;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ManualFoodItemsRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ManualFoodItemsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ManualFoodItemsRepository service;

	/**
	 * get all ManualFoodItems records
	 * @return
	 * @throws Exception
	 */
	public List<ManualFoodItemsDTO> getAllManualFoodItems() throws Exception {
		Iterable<ManualFoodItems> manualfooditems = service.findAll();
		Iterator<ManualFoodItems> manualfooditemss = manualfooditems.iterator();
		List<ManualFoodItemsDTO> manualfooditemsdto = new ArrayList();
		while(manualfooditemss.hasNext()) {
			ManualFoodItems item = manualfooditemss.next();
			manualfooditemsdto.add(item.toDTO());
		}
		return manualfooditemsdto;
	}

	/**
	 * get ManualFoodItems by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ManualFoodItemsDTO findManualFoodItemsById(int id) throws Exception {
		Optional<ManualFoodItems> manualfooditemsOptional = service.findById(id);
		if(manualfooditemsOptional.isPresent()) {
			ManualFoodItems results = manualfooditemsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new ManualFoodItems
	 * @param data
	 * @return
	 */
	public ManualFoodItemsDTO createManualFoodItems(ManualFoodItemsDTO data) {
		try {
		    ManualFoodItems createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ManualFoodItems
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ManualFoodItemsDTO updateManualFoodItems(ManualFoodItemsDTO data) throws Exception {
		Optional<ManualFoodItems> manualfooditemsOptional = service.findById(data.getManualFoodItemId());
		if(manualfooditemsOptional.isPresent()) {
		    ManualFoodItems updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getManualFoodItemId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ManualFoodItems by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteManualFoodItems(int id) throws Exception {
		Optional<ManualFoodItems> manualfooditemsOptional = service.findById(id);
		if(manualfooditemsOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : userId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	public List<ManualFoodItemsDTO> findManualFoodItemsByUserId(int id) throws Exception {
		Iterable<ManualFoodItems> results = service.findManualFoodItemsByUserId(id);
		Iterator<ManualFoodItems> iter = results.iterator();
		List<ManualFoodItemsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ManualFoodItems item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : bldstId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	public List<ManualFoodItemsDTO> findManualFoodItemsByBldstId(int id) throws Exception {
		Iterable<ManualFoodItems> results = service.findManualFoodItemsByBldstId(id);
		Iterator<ManualFoodItems> iter = results.iterator();
		List<ManualFoodItemsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ManualFoodItems item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : servTypeId
	 * @param id
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	public List<ManualFoodItemsDTO> findManualFoodItemsByServTypeId(int id) throws Exception {
		Iterable<ManualFoodItems> results = service.findManualFoodItemsByServTypeId(id);
		Iterator<ManualFoodItems> iter = results.iterator();
		List<ManualFoodItemsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ManualFoodItems item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<ManualFoodItemsDTO> by foreign key : UserIdAndBldstIdAndServTypeId
	 * @param id0
	 * @return List<ManualFoodItems>
	 * @throws Exception
	*/
	public List<ManualFoodItemsDTO> findManualFoodItemsByUserIdAndBldstIdAndServTypeId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<ManualFoodItems> results = service.findManualFoodItemsByUserIdAndBldstIdAndServTypeId(id0, id1, id2);
		Iterator<ManualFoodItems> iter = results.iterator();
		List<ManualFoodItemsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			ManualFoodItems item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
