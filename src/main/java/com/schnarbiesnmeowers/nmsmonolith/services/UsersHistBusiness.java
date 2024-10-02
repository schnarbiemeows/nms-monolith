package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UsersHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersHistRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UsersHistBusiness {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UsersHistRepository usersHistRepository;

	/**
	 * get all UsersHist records
	 * @return
	 * @throws Exception
	 */
	public List<UsersHistDTO> getAllUsersHist() throws Exception {
		Iterable<UsersHist> usershist = usersHistRepository.findAll();
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
		Optional<UsersHist> usershistOptional = usersHistRepository.findById(id);
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
		    createdData = usersHistRepository.save(createdData);
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
		Optional<UsersHist> usershistOptional = usersHistRepository.findById(data.getUsersHistId());
		if(usershistOptional.isPresent()) {
		    UsersHist updatedData = data.toEntity();
			updatedData = usersHistRepository.save(updatedData);
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
		Optional<UsersHist> usershistOptional = usersHistRepository.findById(id);
		if(usershistOptional.isPresent()) {
			usersHistRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<UsersHistDTO> by foreign key : userId
	 * @param userId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByUserId(int id) throws Exception {
		Iterable<UsersHist> results = usersHistRepository.findUsersHistByUserId(id);
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
	 * @param actionTypeId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByActionTypeId(int id) throws Exception {
		Iterable<UsersHist> results = usersHistRepository.findUsersHistByActionTypeId(id);
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
	 * @param evntOperId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByEvntOperId(int id) throws Exception {
		Iterable<UsersHist> results = usersHistRepository.findUsersHistByEvntOperId(id);
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
	 * @param UserIdAndActionTypeIdAndEvntOperId
	 * @return List<UsersHist>
	 * @throws Exception
	*/
	public List<UsersHistDTO> findUsersHistByUserIdAndActionTypeIdAndEvntOperId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<UsersHist> results = usersHistRepository.findUsersHistByUserIdAndActionTypeIdAndEvntOperId(id0, id1, id2);
		Iterator<UsersHist> iter = results.iterator();
		List<UsersHistDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UsersHist item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
