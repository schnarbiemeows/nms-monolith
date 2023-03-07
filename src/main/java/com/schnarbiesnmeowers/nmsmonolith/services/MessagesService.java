package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessagesDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Messages;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MessagesRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MessagesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MessagesRepository messagesRepository;

	/**
	 * get all Messages records
	 * @return
	 * @throws Exception
	 */
	public List<MessagesDTO> getAllMessages() throws Exception {
		Iterable<Messages> messages = messagesRepository.findAll();
		Iterator<Messages> messagess = messages.iterator();
		List<MessagesDTO> messagesdto = new ArrayList();
		while(messagess.hasNext()) {
			Messages item = messagess.next();
			messagesdto.add(item.toDTO());
		}
		return messagesdto;
	}

	/**
	 * get Messages by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MessagesDTO findMessagesById(int id) throws Exception {
		Optional<Messages> messagesOptional = messagesRepository.findById(id);
		if(messagesOptional.isPresent()) {
			Messages results = messagesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Messages
	 * @param data
	 * @return
	 */
	public MessagesDTO createMessages(MessagesDTO data) {
		try {
		    Messages createdData = data.toEntity();
		    createdData = messagesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Messages
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MessagesDTO updateMessages(MessagesDTO data) throws Exception {
		Optional<Messages> messagesOptional = messagesRepository.findById(data.getMessageId());
		if(messagesOptional.isPresent()) {
		    Messages updatedData = data.toEntity();
			updatedData = messagesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getMessageId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Messages by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMessages(int id) throws Exception {
		Optional<Messages> messagesOptional = messagesRepository.findById(id);
		if(messagesOptional.isPresent()) {
			messagesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<MessagesDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<Messages>
	 * @throws Exception
	*/
	public List<MessagesDTO> findMessagesByEventId(int id) throws Exception {
		Iterable<Messages> results = messagesRepository.findMessagesByEventId(id);
		Iterator<Messages> iter = results.iterator();
		List<MessagesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Messages item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<MessagesDTO> by foreign key : messageTypeId
	 * @param messageTypeId
	 * @return List<Messages>
	 * @throws Exception
	*/
	public List<MessagesDTO> findMessagesByMessageTypeId(int id) throws Exception {
		Iterable<Messages> results = messagesRepository.findMessagesByMessageTypeId(id);
		Iterator<Messages> iter = results.iterator();
		List<MessagesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Messages item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

	/**
	 * get List<MessagesDTO> by foreign key : EventIdAndMessageTypeId
	 * @param EventIdAndMessageTypeId
	 * @return List<Messages>
	 * @throws Exception
	*/
	public List<MessagesDTO> findMessagesByEventIdAndMessageTypeId(@PathVariable int id0,@PathVariable int id1) throws Exception {
		Iterable<Messages> results = messagesRepository.findMessagesByEventIdAndMessageTypeId(id0, id1);
		Iterator<Messages> iter = results.iterator();
		List<MessagesDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Messages item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
