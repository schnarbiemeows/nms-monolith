package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessageTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.MessageTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MessageTypesRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class MessageTypesService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MessageTypesRepository messageTypesRepository;

	/**
	 * get all MessageTypes records
	 * @return
	 * @throws Exception
	 */
	public List<MessageTypesDTO> getAllMessageTypes() throws Exception {
		Iterable<MessageTypes> messagetypes = messageTypesRepository.findAll();
		Iterator<MessageTypes> messagetypess = messagetypes.iterator();
		List<MessageTypesDTO> messagetypesdto = new ArrayList();
		while(messagetypess.hasNext()) {
			MessageTypes item = messagetypess.next();
			messagetypesdto.add(item.toDTO());
		}
		return messagetypesdto;
	}

	/**
	 * get MessageTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MessageTypesDTO findMessageTypesById(int id) throws Exception {
		Optional<MessageTypes> messagetypesOptional = messageTypesRepository.findById(id);
		if(messagetypesOptional.isPresent()) {
			MessageTypes results = messagetypesOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new MessageTypes
	 * @param data
	 * @return
	 */
	public MessageTypesDTO createMessageTypes(MessageTypesDTO data) {
		try {
		    MessageTypes createdData = data.toEntity();
		    createdData = messageTypesRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a MessageTypes
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public MessageTypesDTO updateMessageTypes(MessageTypesDTO data) throws Exception {
		Optional<MessageTypes> messagetypesOptional = messageTypesRepository.findById(data.getMessageTypeId());
		if(messagetypesOptional.isPresent()) {
		    MessageTypes updatedData = data.toEntity();
			updatedData = messageTypesRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getMessageTypeId() + NOT_FOUND);
		}
	}

	/**
	 * delete a MessageTypes by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteMessageTypes(int id) throws Exception {
		Optional<MessageTypes> messagetypesOptional = messageTypesRepository.findById(id);
		if(messagetypesOptional.isPresent()) {
			messageTypesRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

}
