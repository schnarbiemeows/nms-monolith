package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalTypesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class GoalTypesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private GoalTypesRepository goalTypesRepository;

	/**
	 * get all GoalTypes records
	 * @return
	 * @throws Exception
	 */
	public List<GoalTypesDTO> getAllGoalTypes() throws Exception {
		Iterable<GoalTypes> goaltypes = goalTypesRepository.findAll();
		Iterator<GoalTypes> goaltypess = goaltypes.iterator();
		List<GoalTypesDTO> goaltypesdto = new ArrayList();
		while(goaltypess.hasNext()) {
			GoalTypes item = goaltypess.next();
			goaltypesdto.add(item.toDTO());
		}
		return goaltypesdto;
	}

	/**
	 * get GoalTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public GoalTypesDTO findGoalTypesById(int id) throws Exception {
		Optional<GoalTypes> goaltypesOptional = goalTypesRepository.findById(id);
		if(goaltypesOptional.isPresent()) {
			GoalTypes results = goaltypesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new GoalTypes
	 * @param data
	 * @return
	 */
	public GoalTypesDTO createGoalTypes(GoalTypesDTO data) {
		try {
		    GoalTypes createdData = data.toEntity();
		    createdData = goalTypesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a GoalTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public GoalTypesDTO updateGoalTypes(GoalTypesDTO data) throws Exception {
		Optional<GoalTypes> goaltypesOptional = goalTypesRepository.findById(data.getGoalTypeId());
		if(goaltypesOptional.isPresent()) {
		    GoalTypes updatedData = data.toEntity();
			updatedData = goalTypesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getGoalTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a GoalTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteGoalTypes(int id) throws Exception {
		Optional<GoalTypes> goaltypesOptional = goalTypesRepository.findById(id);
		if(goaltypesOptional.isPresent()) {
			goalTypesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
