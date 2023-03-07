package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserConfigDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UserConfigServiceTest {


	/**
	 * get all UserConfig records
	 * @return
	 * @throws Exception
	 */
	public List<UserConfigDTO> getAllUserConfig() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<UserConfigDTO> userconfigDTO = new ArrayList<UserConfigDTO>();
		return userconfigDTO;
	}

	/**
	 * get UserConfig by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserConfigDTO findUserConfigById(int id) throws Exception {
		return new UserConfigDTO();
	}

	/**
	 * create a new UserConfig
	 * @param data
	 * @return
	 */
	public UserConfigDTO createUserConfig(UserConfigDTO data) {
        data.setUsersConfigId(1);
        return data;
	}

	/**
	 * update a UserConfig
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UserConfigDTO updateUserConfig(UserConfigDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a UserConfig by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUserConfig(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<UserConfigDTO> by foreign key : userId
	 * @param id
	 * @return List<UserConfig>
	 * @throws Exception
	*/
	public List<UserConfigDTO> findUserConfigByUserId(int id) throws Exception {
		List<UserConfigDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
