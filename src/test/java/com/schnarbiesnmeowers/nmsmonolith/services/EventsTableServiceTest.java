package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.EventsTableDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class EventsTableServiceTest {


	/**
	 * get all EventsTable records
	 * @return
	 * @throws Exception
	 */
	public List<EventsTableDTO> getAllEventsTable() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<EventsTableDTO> eventstableDTO = new ArrayList<EventsTableDTO>();
		return eventstableDTO;
	}

	/**
	 * get EventsTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EventsTableDTO findEventsTableById(int id) throws Exception {
		return new EventsTableDTO();
	}

	/**
	 * create a new EventsTable
	 * @param data
	 * @return
	 */
	public EventsTableDTO createEventsTable(EventsTableDTO data) {
        data.setEventId(1);
        return data;
	}

	/**
	 * update a EventsTable
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public EventsTableDTO updateEventsTable(EventsTableDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a EventsTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteEventsTable(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<EventsTableDTO> by foreign key : userId
	 * @param userId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	public List<EventsTableDTO> findEventsTableByUserId(int id) throws Exception {
		List<EventsTableDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<EventsTableDTO> by foreign key : periodId
	 * @param periodId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	public List<EventsTableDTO> findEventsTableByPeriodId(int id) throws Exception {
		List<EventsTableDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<EventsTableDTO> by foreign key : UserIdAndPeriodId
	 * @param UserIdAndPeriodId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	public List<EventsTableDTO> findEventsTableByUserIdAndPeriodId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<EventsTableDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
