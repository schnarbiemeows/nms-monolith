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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Users;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UsersService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UsersRepository service;

	/**
	 * get all Users records
	 * @return
	 * @throws Exception
	 */
	public List<UsersDTO> getAllUsers() throws Exception {
		Iterable<Users> users = service.findAll();
		Iterator<Users> userss = users.iterator();
		List<UsersDTO> usersdto = new ArrayList();
		while(userss.hasNext()) {
			Users item = userss.next();
			usersdto.add(item.toDTO());
		}
		return usersdto;
	}

	/**
	 * get Users by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UsersDTO findUsersById(int id) throws Exception {
		Optional<Users> usersOptional = service.findById(id);
		if(usersOptional.isPresent()) {
			Users results = usersOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Users
	 * @param data
	 * @return
	 */
	public UsersDTO createUsers(UsersDTO data) {
		try {
		    Users createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Users
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UsersDTO updateUsers(UsersDTO data) throws Exception {
		Optional<Users> usersOptional = service.findById(data.getUserId());
		if(usersOptional.isPresent()) {
		    Users updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getUserId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Users by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUsers(int id) throws Exception {
		Optional<Users> usersOptional = service.findById(id);
		if(usersOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
