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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserTempDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserTemp;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UserTempRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UserTempService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UserTempRepository service;

	/**
	 * get all UserTemp records
	 * @return
	 * @throws Exception
	 */
	public List<UserTempDTO> getAllUserTemp() throws Exception {
		Iterable<UserTemp> usertemp = service.findAll();
		Iterator<UserTemp> usertemps = usertemp.iterator();
		List<UserTempDTO> usertempdto = new ArrayList();
		while(usertemps.hasNext()) {
			UserTemp item = usertemps.next();
			usertempdto.add(item.toDTO());
		}
		return usertempdto;
	}

	/**
	 * get UserTemp by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserTempDTO findUserTempById(int id) throws Exception {
		Optional<UserTemp> usertempOptional = service.findById(id);
		if(usertempOptional.isPresent()) {
			UserTemp results = usertempOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new UserTemp
	 * @param data
	 * @return
	 */
	public UserTempDTO createUserTemp(UserTempDTO data) {
		try {
		    UserTemp createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UserTemp
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UserTempDTO updateUserTemp(UserTempDTO data) throws Exception {
		Optional<UserTemp> usertempOptional = service.findById(data.getUserTempId());
		if(usertempOptional.isPresent()) {
		    UserTemp updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getUserTempId() + NOT_FOUND);
		}
	}

	/**
	 * delete a UserTemp by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUserTemp(int id) throws Exception {
		Optional<UserTemp> usertempOptional = service.findById(id);
		if(usertempOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
