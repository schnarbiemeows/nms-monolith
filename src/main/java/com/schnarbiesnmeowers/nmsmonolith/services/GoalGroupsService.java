package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalGroups;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalGroupsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalGroupsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalGroupsRepository goalGroupsRepository;

	/**
	 * get all GoalGroups records
	 * @return
	 * @throws Exception
	 */
	public List<GoalGroupsDTO> getAllGoalGroups() throws Exception {
		Iterable<GoalGroups> goalgroups = goalGroupsRepository.findAll();
		Iterator<GoalGroups> goalgroupss = goalgroups.iterator();
		List<GoalGroupsDTO> goalgroupsdto = new ArrayList();
		while(goalgroupss.hasNext()) {
			GoalGroups item = goalgroupss.next();
			goalgroupsdto.add(item.toDTO());
		}
		return goalgroupsdto;
	}

	/**
	 * get GoalGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalGroupsDTO findGoalGroupsById(int id) throws Exception {
		Optional<GoalGroups> goalgroupsOptional = goalGroupsRepository.findById(id);
		if(goalgroupsOptional.isPresent()) {
			GoalGroups results = goalgroupsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GoalGroups
	 * @param data
	 * @return
	 */
	public GoalGroupsDTO createGoalGroups(GoalGroupsDTO data) {
		try {
		    GoalGroups createdData = data.toEntity();
		    createdData = goalGroupsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalGroups
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalGroupsDTO updateGoalGroups(GoalGroupsDTO data) throws Exception {
		Optional<GoalGroups> goalgroupsOptional = goalGroupsRepository.findById(data.getGoalGroupId());
		if(goalgroupsOptional.isPresent()) {
		    GoalGroups updatedData = data.toEntity();
			updatedData = goalGroupsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGoalGroupId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GoalGroups by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalGroups(int id) throws Exception {
		Optional<GoalGroups> goalgroupsOptional = goalGroupsRepository.findById(id);
		if(goalgroupsOptional.isPresent()) {
			goalGroupsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : goalId1
	 * @param goalId1
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	public List<GoalGroupsDTO> findGoalGroupsByGoalId1(int id) throws Exception {
		Iterable<GoalGroups> results = goalGroupsRepository.findGoalGroupsByGoalId1(id);
		Iterator<GoalGroups> iter = results.iterator();
		List<GoalGroupsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalGroups item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : goalId2
	 * @param goalId2
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	public List<GoalGroupsDTO> findGoalGroupsByGoalId2(int id) throws Exception {
		Iterable<GoalGroups> results = goalGroupsRepository.findGoalGroupsByGoalId2(id);
		Iterator<GoalGroups> iter = results.iterator();
		List<GoalGroupsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalGroups item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<GoalGroupsDTO> by foreign key : GoalId1AndGoalId2
	 * @param GoalId1AndGoalId2
	 * @return List<GoalGroups>
	 * @throws Exception
	*/
	public List<GoalGroupsDTO> findGoalGroupsByGoalId1AndGoalId2(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<GoalGroups> results = goalGroupsRepository.findGoalGroupsByGoalId1AndGoalId2(id0, id1);
		Iterator<GoalGroups> iter = results.iterator();
		List<GoalGroupsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			GoalGroups item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
