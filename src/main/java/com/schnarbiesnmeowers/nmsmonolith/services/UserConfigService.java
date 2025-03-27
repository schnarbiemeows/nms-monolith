package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserConfigDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserConfig;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UserConfigRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UserConfigService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UserConfigRepository userConfigRepository;

	/**
	 * get all UserConfig records
	 * @return
	 * @throws Exception
	 */
	public List<UserConfigDTO> getAllUserConfig() throws Exception {
		Iterable<UserConfig> userconfig = userConfigRepository.findAll();
		Iterator<UserConfig> userconfigs = userconfig.iterator();
		List<UserConfigDTO> userconfigdto = new ArrayList();
		while(userconfigs.hasNext()) {
			UserConfig item = userconfigs.next();
			userconfigdto.add(item.toDTO());
		}
		return userconfigdto;
	}

	/**
	 * get UserConfig by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserConfigDTO findUserConfigById(int id) throws Exception {
		Optional<UserConfig> userconfigOptional = userConfigRepository.findById(id);
		if(userconfigOptional.isPresent()) {
			UserConfig results = userconfigOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new UserConfig
	 * @param data
	 * @return
	 */
	public UserConfigDTO createUserConfig(UserConfigDTO data) {
		try {
		    UserConfig createdData = data.toEntity();
		    createdData = userConfigRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UserConfig
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UserConfigDTO updateUserConfig(UserConfigDTO data) throws Exception {
		Optional<UserConfig> userconfigOptional = userConfigRepository.findById(data.getUsersConfigId());
		if(userconfigOptional.isPresent()) {
		    UserConfig updatedData = data.toEntity();
			updatedData = userConfigRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getUsersConfigId() + NOT_FOUND);
		}
	}

	/**
	 * delete a UserConfig by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUserConfig(int id) throws Exception {
		Optional<UserConfig> userconfigOptional = userConfigRepository.findById(id);
		if(userconfigOptional.isPresent()) {
			userConfigRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<UserConfigDTO> by foreign key : userId
	 * @param userId
	 * @return List<UserConfig>
	 * @throws Exception
	*/
	public List<UserConfigDTO> findUserConfigByUserId(int id) throws Exception {
		Iterable<UserConfig> results = userConfigRepository.findUserConfigByUserId(id);
		Iterator<UserConfig> iter = results.iterator();
		List<UserConfigDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UserConfig item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
