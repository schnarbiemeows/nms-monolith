package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Goals;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalsRepository goalsRepository;

	/**
	 * get all Goals records
	 * @return
	 * @throws Exception
	 */
	public List<GoalsDTO> getAllGoals() throws Exception {
		Iterable<Goals> goals = goalsRepository.findAll();
		Iterator<Goals> goalss = goals.iterator();
		List<GoalsDTO> goalsdto = new ArrayList();
		while(goalss.hasNext()) {
			Goals item = goalss.next();
			goalsdto.add(item.toDTO());
		}
		return goalsdto;
	}

	/**
	 * get Goals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalsDTO findGoalsById(int id) throws Exception {
		Optional<Goals> goalsOptional = goalsRepository.findById(id);
		if(goalsOptional.isPresent()) {
			Goals results = goalsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Goals
	 * @param data
	 * @return
	 */
	public GoalsDTO createGoals(GoalsDTO data) {
		try {
		    Goals createdData = data.toEntity();
		    createdData = goalsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Goals
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalsDTO updateGoals(GoalsDTO data) throws Exception {
		Optional<Goals> goalsOptional = goalsRepository.findById(data.getGoalId());
		if(goalsOptional.isPresent()) {
		    Goals updatedData = data.toEntity();
			updatedData = goalsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGoalId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Goals by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoals(int id) throws Exception {
		Optional<Goals> goalsOptional = goalsRepository.findById(id);
		if(goalsOptional.isPresent()) {
			goalsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GoalsDTO> by foreign key : userId
	 * @param userId
	 * @return List<Goals>
	 * @throws Exception
	*/
	public List<GoalsDTO> findGoalsByUserId(int id) throws Exception {
		Iterable<Goals> results = goalsRepository.findGoalsByUserId(id);
		Iterator<Goals> iter = results.iterator();
		List<GoalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Goals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalsDTO> by foreign key : gcId
	 * @param gcId
	 * @return List<Goals>
	 * @throws Exception
	*/
	public List<GoalsDTO> findGoalsByGcId(int id) throws Exception {
		Iterable<Goals> results = goalsRepository.findGoalsByGcId(id);
		Iterator<Goals> iter = results.iterator();
		List<GoalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Goals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalsDTO> by foreign key : UserIdAndGcId
	 * @param UserIdAndGcId
	 * @return List<Goals>
	 * @throws Exception
	*/
	public List<GoalsDTO> findGoalsByUserIdAndGcId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<Goals> results = goalsRepository.findGoalsByUserIdAndGcId(id0, id1);
		Iterator<Goals> iter = results.iterator();
		List<GoalsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Goals item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
