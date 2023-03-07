package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserCalendarDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class UserCalendarServiceTest {


	/**
	 * get all UserCalendar records
	 * @return
	 * @throws Exception
	 */
	public List<UserCalendarDTO> getAllUserCalendar() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<UserCalendarDTO> usercalendarDTO = new ArrayList<UserCalendarDTO>();
		return usercalendarDTO;
	}

	/**
	 * get UserCalendar by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserCalendarDTO findUserCalendarById(int id) throws Exception {
		return new UserCalendarDTO();
	}

	/**
	 * create a new UserCalendar
	 * @param data
	 * @return
	 */
	public UserCalendarDTO createUserCalendar(UserCalendarDTO data) {
        data.setUserCalendarId(1);
        return data;
	}

	/**
	 * update a UserCalendar
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public UserCalendarDTO updateUserCalendar(UserCalendarDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a UserCalendar by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteUserCalendar(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : userId
	 * @param id
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	public List<UserCalendarDTO> findUserCalendarByUserId(int id) throws Exception {
		List<UserCalendarDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : eventId
	 * @param id
	 * @return List<UserCalendar>
	 * @throws Exception
	*/
	public List<UserCalendarDTO> findUserCalendarByEventId(int id) throws Exception {
		List<UserCalendarDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<UserCalendarDTO> by foreign key : UserIdAndEventId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<UserCalendarDTO> findUserCalendarByUserIdAndEventId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<UserCalendarDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
