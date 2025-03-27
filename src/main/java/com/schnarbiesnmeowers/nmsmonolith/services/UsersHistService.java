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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UsersHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersHistRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UsersHistService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UsersHistRepository service;

	/**
	 * get all UsersHist records
	 * @return
	 * @throws Exception
	 */
	public List<UsersHistDTO> getAllUsersHist() throws Exception {
		Iterable<UsersHist> usershist = service.findAll();
		Iterator<UsersHist> usershists = usershist.iterator();
		List<UsersHistDTO> usershistdto = new ArrayList();
		while(usershists.hasNext()) {
			UsersHist item = usershists.next();
			usershistdto.add(item.toDTO());
		}
		return usershistdto;
	}

	/**
	 * get UsersHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UsersHistDTO findUsersHistById(int id) throws Exception {
		Optional<UsersHist> usershistOptional = service.findById(id);
		if(usershistOptional.isPresent()) {
			UsersHist results = usershistOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new UsersHist
	 * @param data
	 * @return
	 */
	public UsersHistDTO createUsersHist(UsersHistDTO data) {
		try {
		    UsersHist createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UsersHist
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UsersHistDTO updateUsersHist(UsersHistDTO data) throws Exception {
		Optional<UsersHist> usershistOptional = service.findById(data.getUsersHistId());
		if(usershistOptional.isPresent()) {
		    UsersHist updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getUsersHistId() + NOT_FOUND);
		}
	}

	/**
	 * delete a UsersHist by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUsersHist(int id) throws Exception {
		Optional<UsersHist> usershistOptional = service.findById(id);
		if(usershistOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<UsersHistDTO> by foreign key : userId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByUserId(int id) throws Exception {
		Iterable<UsersHist> results = service.findUsersHistByUserId(id);
		Iterator<UsersHist> iter = results.iterator();
		List<UsersHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UsersHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<UsersHistDTO> by foreign key : actionTypeId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByActionTypeId(int id) throws Exception {
		Iterable<UsersHist> results = service.findUsersHistByActionTypeId(id);
		Iterator<UsersHist> iter = results.iterator();
		List<UsersHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UsersHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<UsersHistDTO> by foreign key : evntOperId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByEvntOperId(int id) throws Exception {
		Iterable<UsersHist> results = service.findUsersHistByEvntOperId(id);
		Iterator<UsersHist> iter = results.iterator();
		List<UsersHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UsersHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<UsersHistDTO> by foreign key : UserIdAndActionTypeIdAndEvntOperId
	 * @param id
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<UsersHist> results = service.findUsersHistByUserIdAndActionTypeIdAndEvntOperId(id0, id1, id2);
		Iterator<UsersHist> iter = results.iterator();
		List<UsersHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UsersHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
