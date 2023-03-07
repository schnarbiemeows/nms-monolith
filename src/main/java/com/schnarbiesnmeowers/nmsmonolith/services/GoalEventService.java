package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalEventDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalEvent;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalEventRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalEventService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalEventRepository goalEventRepository;

	/**
	 * get all GoalEvent records
	 * @return
	 * @throws Exception
	 */
	public List<GoalEventDTO> getAllGoalEvent() throws Exception {
		Iterable<GoalEvent> goalevent = goalEventRepository.findAll();
		Iterator<GoalEvent> goalevents = goalevent.iterator();
		List<GoalEventDTO> goaleventdto = new ArrayList();
		while(goalevents.hasNext()) {
			GoalEvent item = goalevents.next();
			goaleventdto.add(item.toDTO());
		}
		return goaleventdto;
	}

	/**
	 * get GoalEvent by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalEventDTO findGoalEventById(int id) throws Exception {
		Optional<GoalEvent> goaleventOptional = goalEventRepository.findById(id);
		if(goaleventOptional.isPresent()) {
			GoalEvent results = goaleventOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GoalEvent
	 * @param data
	 * @return
	 */
	public GoalEventDTO createGoalEvent(GoalEventDTO data) {
		try {
		    GoalEvent createdData = data.toEntity();
		    createdData = goalEventRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalEvent
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalEventDTO updateGoalEvent(GoalEventDTO data) throws Exception {
		Optional<GoalEvent> goaleventOptional = goalEventRepository.findById(data.getGoalEventId());
		if(goaleventOptional.isPresent()) {
		    GoalEvent updatedData = data.toEntity();
			updatedData = goalEventRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGoalEventId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GoalEvent by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalEvent(int id) throws Exception {
		Optional<GoalEvent> goaleventOptional = goalEventRepository.findById(id);
		if(goaleventOptional.isPresent()) {
			goalEventRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GoalEventDTO> by foreign key : userId
	 * @param userId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByUserId(int id) throws Exception {
		Iterable<GoalEvent> results = goalEventRepository.findGoalEventByUserId(id);
		Iterator<GoalEvent> iter = results.iterator();
		List<GoalEventDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalEvent item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalEventDTO> by foreign key : goalId
	 * @param goalId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByGoalId(int id) throws Exception {
		Iterable<GoalEvent> results = goalEventRepository.findGoalEventByGoalId(id);
		Iterator<GoalEvent> iter = results.iterator();
		List<GoalEventDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalEvent item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalEventDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByEventId(int id) throws Exception {
		Iterable<GoalEvent> results = goalEventRepository.findGoalEventByEventId(id);
		Iterator<GoalEvent> iter = results.iterator();
		List<GoalEventDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalEvent item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalEventDTO> by foreign key : UserIdAndGoalIdAndEventId
	 * @param UserIdAndGoalIdAndEventId
	 * @return List<GoalEvent>
	 * @throws Exception
	*/
	public List<GoalEventDTO> findGoalEventByUserIdAndGoalIdAndEventId(@PathVariable int id0,@PathVariable int id1,@PathVariable int id2) throws Exception {
		Iterable<GoalEvent> results = goalEventRepository.findGoalEventByUserIdAndGoalIdAndEventId(id0, id1, id2);
		Iterator<GoalEvent> iter = results.iterator();
		List<GoalEventDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalEvent item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
