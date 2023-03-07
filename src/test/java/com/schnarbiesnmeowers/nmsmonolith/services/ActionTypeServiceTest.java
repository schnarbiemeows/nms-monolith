package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ActionTypeDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class ActionTypeServiceTest {


	/**
	 * get all ActionType records
	 * @return
	 * @throws Exception
	 */
	public List<ActionTypeDTO> getAllActionType() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<ActionTypeDTO> actiontypeDTO = new ArrayList<ActionTypeDTO>();
		return actiontypeDTO;
	}

	/**
	 * get ActionType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ActionTypeDTO findActionTypeById(int id) throws Exception {
		return new ActionTypeDTO();
	}

	/**
	 * create a new ActionType
	 * @param data
	 * @return
	 */
	public ActionTypeDTO createActionType(ActionTypeDTO data) {
        data.setActionTypeId(1);
        return data;
	}

	/**
	 * update a ActionType
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public ActionTypeDTO updateActionType(ActionTypeDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a ActionType by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteActionType(int id) throws Exception {
		return "Successfully Deleted";
	}

}
