package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.EventsTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.EventsTable;
import com.schnarbiesnmeowers.nmsmonolith.repositories.EventsTableRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class EventsTableService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private EventsTableRepository eventsTableRepository;

	/**
	 * get all EventsTable records
	 * @return
	 * @throws Exception
	 */
	public List<EventsTableDTO> getAllEventsTable() throws Exception {
		Iterable<EventsTable> eventstable = eventsTableRepository.findAll();
		Iterator<EventsTable> eventstables = eventstable.iterator();
		List<EventsTableDTO> eventstabledto = new ArrayList();
		while(eventstables.hasNext()) {
			EventsTable item = eventstables.next();
			eventstabledto.add(item.toDTO());
		}
		return eventstabledto;
	}

	/**
	 * get EventsTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EventsTableDTO findEventsTableById(int id) throws Exception {
		Optional<EventsTable> eventstableOptional = eventsTableRepository.findById(id);
		if(eventstableOptional.isPresent()) {
			EventsTable results = eventstableOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new EventsTable
	 * @param data
	 * @return
	 */
	public EventsTableDTO createEventsTable(EventsTableDTO data) {
		try {
		    EventsTable createdData = data.toEntity();
		    createdData = eventsTableRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a EventsTable
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public EventsTableDTO updateEventsTable(EventsTableDTO data) throws Exception {
		Optional<EventsTable> eventstableOptional = eventsTableRepository.findById(data.getEventId());
		if(eventstableOptional.isPresent()) {
		    EventsTable updatedData = data.toEntity();
			updatedData = eventsTableRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getEventId() + NOT_FOUND);
		}
	}

	/**
	 * delete a EventsTable by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteEventsTable(int id) throws Exception {
		Optional<EventsTable> eventstableOptional = eventsTableRepository.findById(id);
		if(eventstableOptional.isPresent()) {
			eventsTableRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<EventsTableDTO> by foreign key : userId
	 * @param userId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	public List<EventsTableDTO> findEventsTableByUserId(int id) throws Exception {
		Iterable<EventsTable> results = eventsTableRepository.findEventsTableByUserId(id);
		Iterator<EventsTable> iter = results.iterator();
		List<EventsTableDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			EventsTable item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<EventsTableDTO> by foreign key : periodId
	 * @param periodId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	public List<EventsTableDTO> findEventsTableByPeriodId(int id) throws Exception {
		Iterable<EventsTable> results = eventsTableRepository.findEventsTableByPeriodId(id);
		Iterator<EventsTable> iter = results.iterator();
		List<EventsTableDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			EventsTable item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<EventsTableDTO> by foreign key : UserIdAndPeriodId
	 * @param UserIdAndPeriodId
	 * @return List<EventsTable>
	 * @throws Exception
	*/
	public List<EventsTableDTO> findEventsTableByUserIdAndPeriodId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<EventsTable> results = eventsTableRepository.findEventsTableByUserIdAndPeriodId(id0, id1);
		Iterator<EventsTable> iter = results.iterator();
		List<EventsTableDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			EventsTable item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
