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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PasswordResetDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.PasswordReset;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PasswordResetRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class PasswordResetService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private PasswordResetRepository service;

	/**
	 * get all PasswordReset records
	 * @return
	 * @throws Exception
	 */
	public List<PasswordResetDTO> getAllPasswordReset() throws Exception {
		Iterable<PasswordReset> passwordreset = service.findAll();
		Iterator<PasswordReset> passwordresets = passwordreset.iterator();
		List<PasswordResetDTO> passwordresetdto = new ArrayList();
		while(passwordresets.hasNext()) {
			PasswordReset item = passwordresets.next();
			passwordresetdto.add(item.toDTO());
		}
		return passwordresetdto;
	}

	/**
	 * get PasswordReset by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PasswordResetDTO findPasswordResetById(int id) throws Exception {
		Optional<PasswordReset> passwordresetOptional = service.findById(id);
		if(passwordresetOptional.isPresent()) {
			PasswordReset results = passwordresetOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new PasswordReset
	 * @param data
	 * @return
	 */
	public PasswordResetDTO createPasswordReset(PasswordResetDTO data) {
		try {
		    PasswordReset createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a PasswordReset
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public PasswordResetDTO updatePasswordReset(PasswordResetDTO data) throws Exception {
		Optional<PasswordReset> passwordresetOptional = service.findById(data.getPasswordResetId());
		if(passwordresetOptional.isPresent()) {
		    PasswordReset updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getPasswordResetId() + NOT_FOUND);
		}
	}

	/**
	 * delete a PasswordReset by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deletePasswordReset(int id) throws Exception {
		Optional<PasswordReset> passwordresetOptional = service.findById(id);
		if(passwordresetOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
