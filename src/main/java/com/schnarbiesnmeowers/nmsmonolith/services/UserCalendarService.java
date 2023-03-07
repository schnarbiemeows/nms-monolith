package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserCalendarDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.UserCalendar;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UserCalendarRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UserCalendarService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private UserCalendarRepository userCalendarRepository;

	/**
	 * get all UserCalendar records
	 * @return
	 * @throws Exception
	 */
	public List<UserCalendarDTO> getAllUserCalendar() throws Exception {
		Iterable<UserCalendar> usercalendar = userCalendarRepository.findAll();
		Iterator<UserCalendar> usercalendars = usercalendar.iterator();
		List<UserCalendarDTO> usercalendardto = new ArrayList();
		while(usercalendars.hasNext()) {
			UserCalendar item = usercalendars.next();
			usercalendardto.add(item.toDTO());
		}
		return usercalendardto;
	}

	/**
	 * get UserCalendar by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserCalendarDTO findUserCalendarById(int id) throws Exception {
		Optional<UserCalendar> usercalendarOptional = userCalendarRepository.findById(id);
		if(usercalendarOptional.isPresent()) {
			UserCalendar results = usercalendarOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new UserCalendar
	 * @param data
	 * @return
	 */
	public UserCalendarDTO createUserCalendar(UserCalendarDTO data) {
		try {
		    UserCalendar createdData = data.toEntity();
		    createdData = userCalendarRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a UserCalendar
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UserCalendarDTO updateUserCalendar(UserCalendarDTO data) throws Exception {
		Optional<UserCalendar> usercalendarOptional = userCalendarRepository.findById(data.getUserCalendarId());
		if(usercalendarOptional.isPresent()) {
		    UserCalendar updatedData = data.toEntity();
			updatedData = userCalendarRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getUserCalendarId() + NOT_FOUND);
		}
	}

	/**
	 * delete a UserCalendar by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUserCalendar(int id) throws Exception {
		Optional<UserCalendar> usercalendarOptional = userCalendarRepository.findById(id);
		if(usercalendarOptional.isPresent()) {
			userCalendarRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : userId
	 * @param userId
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	public List<UserCalendarDTO> findUserCalendarByUserId(int id) throws Exception {
		Iterable<UserCalendar> results = userCalendarRepository.findUserCalendarByUserId(id);
		Iterator<UserCalendar> iter = results.iterator();
		List<UserCalendarDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UserCalendar item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	public List<UserCalendarDTO> findUserCalendarByEventId(int id) throws Exception {
		Iterable<UserCalendar> results = userCalendarRepository.findUserCalendarByEventId(id);
		Iterator<UserCalendar> iter = results.iterator();
		List<UserCalendarDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UserCalendar item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : UserIdAndEventId
	 * @param UserIdAndEventId
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	public List<UserCalendarDTO> findUserCalendarByUserIdAndEventId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<UserCalendar> results = userCalendarRepository.findUserCalendarByUserIdAndEventId(id0, id1);
		Iterator<UserCalendar> iter = results.iterator();
		List<UserCalendarDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			UserCalendar item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
