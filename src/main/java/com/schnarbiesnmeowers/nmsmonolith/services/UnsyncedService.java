package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UnsyncedDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Unsynced;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UnsyncedRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UnsyncedService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UnsyncedRepository unsyncedRepository;

	/**
	 * get all Unsynced records
	 * @return
	 * @throws Exception
	 */
	public List<UnsyncedDTO> getAllUnsynced() throws Exception {
		Iterable<Unsynced> unsynced = unsyncedRepository.findAll();
		Iterator<Unsynced> unsynceds = unsynced.iterator();
		List<UnsyncedDTO> unsynceddto = new ArrayList();
		while(unsynceds.hasNext()) {
			Unsynced item = unsynceds.next();
			unsynceddto.add(item.toDTO());
		}
		return unsynceddto;
	}

	/**
	 * get Unsynced by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UnsyncedDTO findUnsyncedById(int id) throws Exception {
		Optional<Unsynced> unsyncedOptional = unsyncedRepository.findById(id);
		if(unsyncedOptional.isPresent()) {
			Unsynced results = unsyncedOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Unsynced
	 * @param data
	 * @return
	 */
	public UnsyncedDTO createUnsynced(UnsyncedDTO data) {
		try {
		    Unsynced createdData = data.toEntity();
		    createdData = unsyncedRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Unsynced
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UnsyncedDTO updateUnsynced(UnsyncedDTO data) throws Exception {
		Optional<Unsynced> unsyncedOptional = unsyncedRepository.findById(data.getUnsyncedId());
		if(unsyncedOptional.isPresent()) {
		    Unsynced updatedData = data.toEntity();
			updatedData = unsyncedRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getUnsyncedId() + NOT_FOUND);
		}
	}

	public String upSertUnsynced(int userId, Date calendarDate) throws Exception {
		Optional<Unsynced> unsyncedOptional =
				unsyncedRepository.findUnsynchedRecordByUserIdAndCalendarDate(userId,calendarDate);
		if(!unsyncedOptional.isPresent()) {
			Unsynced updatedData = new Unsynced(null,userId,calendarDate);
			updatedData = unsyncedRepository.save(updatedData);
			return "new record for userId = " + userId + " and calnedarDate = " + calendarDate + " created";
		}
		return "rrecord for userId = " + userId + " and calnedarDate = " + calendarDate + " already exists";
	}

	/**
	 * delete a Unsynced by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUnsynced(int id) throws Exception {
		Optional<Unsynced> unsyncedOptional = unsyncedRepository.findById(id);
		if(unsyncedOptional.isPresent()) {
			unsyncedRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<UnsyncedDTO> by foreign key : userId
	 * @param id
	 * @return List<Unsynced>
	 * @throws Exception
	*/
	public List<UnsyncedDTO> findUnsyncedByUserId(int id) throws Exception {
		Iterable<Unsynced> results = unsyncedRepository.findUnsyncedByUserId(id);
		Iterator<Unsynced> iter = results.iterator();
		List<UnsyncedDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Unsynced item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	public boolean hasUnsyncedRecord(Integer userId, Date date) {
		Optional<Unsynced> unsyncedOptional =
				unsyncedRepository.findUnsynchedRecordByUserIdAndCalendarDate(userId,date);
		if(unsyncedOptional.isPresent()) {
			return true;
		}
		return false;
	}
}
