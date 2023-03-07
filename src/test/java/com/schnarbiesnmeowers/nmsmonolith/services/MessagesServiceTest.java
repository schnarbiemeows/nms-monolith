package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessagesDTO;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MessagesServiceTest {


	/**
	 * get all Messages records
	 * @return
	 * @throws Exception
	 */
	public List<MessagesDTO> getAllMessages() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<MessagesDTO> messagesDTO = new ArrayList<MessagesDTO>();
		return messagesDTO;
	}

	/**
	 * get Messages by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MessagesDTO findMessagesById(int id) throws Exception {
		return new MessagesDTO();
	}

	/**
	 * create a new Messages
	 * @param data
	 * @return
	 */
	public MessagesDTO createMessages(MessagesDTO data) {
        data.setMessageId(1);
        return data;
	}

	/**
	 * update a Messages
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MessagesDTO updateMessages(MessagesDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Messages by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMessages(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<MessagesDTO> by foreign key : eventId
	 * @param id
	 * @return List<Messages>
	 * @throws Exception
	*/
	public List<MessagesDTO> findMessagesByEventId(int id) throws Exception {
		List<MessagesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<MessagesDTO> by foreign key : messageTypeId
	 * @param id
	 * @return List<Messages>
	 * @throws Exception
	*/
	public List<MessagesDTO> findMessagesByMessageTypeId(int id) throws Exception {
		List<MessagesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

	/**
	 * get List<MessagesDTO> by foreign key : EventIdAndMessageTypeId
	 * @param id0
	 * @param id1
	 * @return
	 * @throws Exception
	 */
	public List<MessagesDTO> findMessagesByEventIdAndMessageTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		List<MessagesDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
