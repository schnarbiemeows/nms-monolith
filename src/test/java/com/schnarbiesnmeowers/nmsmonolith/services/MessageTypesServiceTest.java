package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessageTypesDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MessageTypesServiceTest {


	/**
	 * get all MessageTypes records
	 * @return
	 * @throws Exception
	 */
	public List<MessageTypesDTO> getAllMessageTypes() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<MessageTypesDTO> messagetypesDTO = new ArrayList<MessageTypesDTO>();
		return messagetypesDTO;
	}

	/**
	 * get MessageTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MessageTypesDTO findMessageTypesById(int id) throws Exception {
		return new MessageTypesDTO();
	}

	/**
	 * create a new MessageTypes
	 * @param data
	 * @return
	 */
	public MessageTypesDTO createMessageTypes(MessageTypesDTO data) {
        data.setMessageTypeId(1);
        return data;
	}

	/**
	 * update a MessageTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MessageTypesDTO updateMessageTypes(MessageTypesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a MessageTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMessageTypes(int id) throws Exception {
		return "Successfully Deleted";
	}

}
