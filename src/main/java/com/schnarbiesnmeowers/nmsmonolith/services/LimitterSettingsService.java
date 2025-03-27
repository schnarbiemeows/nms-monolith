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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LimitterSettingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LimitterSettings;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LimitterSettingsRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class LimitterSettingsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private LimitterSettingsRepository service;

	/**
	 * get all LimitterSettings records
	 * @return
	 * @throws Exception
	 */
	public List<LimitterSettingsDTO> getAllLimitterSettings() throws Exception {
		Iterable<LimitterSettings> limittersettings = service.findAll();
		Iterator<LimitterSettings> limittersettingss = limittersettings.iterator();
		List<LimitterSettingsDTO> limittersettingsdto = new ArrayList();
		while(limittersettingss.hasNext()) {
			LimitterSettings item = limittersettingss.next();
			limittersettingsdto.add(item.toDTO());
		}
		return limittersettingsdto;
	}

	/**
	 * get LimitterSettings by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public LimitterSettingsDTO findLimitterSettingsById(int id) throws Exception {
		Optional<LimitterSettings> limittersettingsOptional = service.findById(id);
		if(limittersettingsOptional.isPresent()) {
			LimitterSettings results = limittersettingsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new LimitterSettings
	 * @param data
	 * @return
	 */
	public LimitterSettingsDTO createLimitterSettings(LimitterSettingsDTO data) {
		try {
		    LimitterSettings createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a LimitterSettings
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public LimitterSettingsDTO updateLimitterSettings(LimitterSettingsDTO data) throws Exception {
		Optional<LimitterSettings> limittersettingsOptional = service.findById(data.getSettingId());
		if(limittersettingsOptional.isPresent()) {
		    LimitterSettings updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getSettingId() + NOT_FOUND);
		}
	}

	/**
	 * delete a LimitterSettings by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteLimitterSettings(int id) throws Exception {
		Optional<LimitterSettings> limittersettingsOptional = service.findById(id);
		if(limittersettingsOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
