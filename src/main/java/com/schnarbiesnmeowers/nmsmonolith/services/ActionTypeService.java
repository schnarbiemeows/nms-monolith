package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ActionTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ActionType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ActionTypeRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ActionTypeService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private ActionTypeRepository actionTypeRepository;

	/**
	 * get all ActionType records
	 * @return
	 * @throws Exception
	 */
	public List<ActionTypeDTO> getAllActionType() throws Exception {
		Iterable<ActionType> actiontype = actionTypeRepository.findAll();
		Iterator<ActionType> actiontypes = actiontype.iterator();
		List<ActionTypeDTO> actiontypedto = new ArrayList();
		while(actiontypes.hasNext()) {
			ActionType item = actiontypes.next();
			actiontypedto.add(item.toDTO());
		}
		return actiontypedto;
	}

	/**
	 * get ActionType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ActionTypeDTO findActionTypeById(int id) throws Exception {
		Optional<ActionType> actiontypeOptional = actionTypeRepository.findById(id);
		if(actiontypeOptional.isPresent()) {
			ActionType results = actiontypeOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new ActionType
	 * @param data
	 * @return
	 */
	public ActionTypeDTO createActionType(ActionTypeDTO data) {
		try {
		    ActionType createdData = data.toEntity();
		    createdData = actionTypeRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a ActionType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ActionTypeDTO updateActionType(ActionTypeDTO data) throws Exception {
		Optional<ActionType> actiontypeOptional = actionTypeRepository.findById(data.getActionTypeId());
		if(actiontypeOptional.isPresent()) {
		    ActionType updatedData = data.toEntity();
			updatedData = actionTypeRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getActionTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a ActionType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteActionType(int id) throws Exception {
		Optional<ActionType> actiontypeOptional = actionTypeRepository.findById(id);
		if(actiontypeOptional.isPresent()) {
			actionTypeRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
