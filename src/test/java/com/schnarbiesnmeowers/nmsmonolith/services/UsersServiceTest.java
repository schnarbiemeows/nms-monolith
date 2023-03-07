package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UsersServiceTest {


	/**
	 * get all Users records
	 * @return
	 * @throws Exception
	 */
	public List<UsersDTO> getAllUsers() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<UsersDTO> usersDTO = new ArrayList<UsersDTO>();
		return usersDTO;
	}

	/**
	 * get Users by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UsersDTO findUsersById(int id) throws Exception {
		return new UsersDTO();
	}

	/**
	 * create a new Users
	 * @param data
	 * @return
	 */
	public UsersDTO createUsers(UsersDTO data) {
        data.setUserId(1);
        return data;
	}

	/**
	 * update a Users
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UsersDTO updateUsers(UsersDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Users by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUsers(int id) throws Exception {
		return "Successfully Deleted";
	}

}
