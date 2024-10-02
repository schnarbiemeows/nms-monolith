package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import com.schnarbiesnmeowers.nmsmonolith.entities.email.OutputMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;

import com.schnarbiesnmeowers.nmsmonolith.services.*;
import com.schnarbiesnmeowers.nmsmonolith.dtos.*;
import com.schnarbiesnmeowers.nmsmonolith.entities.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/messages")
public class MessagesController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private MessagesService messagesService;

	/**
	 * get all Messages records
	 * @return Iterable<Messages>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<MessagesDTO>> getAllMessages() throws Exception {
		List<MessagesDTO> messages = messagesService.getAllMessages();
		return ResponseEntity.status(HttpStatus.OK).body(messages);
	}

	/**
	 * get Messages by primary key
	 * @param id
	 * @return Messages
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<MessagesDTO> findMessagesById(@PathVariable int id) throws Exception {
		MessagesDTO results = messagesService.findMessagesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Messages
	 * @param data
	 * @return Messages
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<MessagesDTO> createMessages(@Valid @RequestBody MessagesDTO data) throws Exception {
		try {
		    MessagesDTO createdData = messagesService.createMessages(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Messages
	 * @param data
	 * @return Messages
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<MessagesDTO> updateMessages(@Valid @RequestBody MessagesDTO data) throws Exception {
		MessagesDTO updatedData = messagesService.updateMessages(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Messages by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteMessages(@PathVariable int id) throws Exception {
		messagesService.deleteMessages(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<MessagesDTO> by foreign key : eventId
	 * @param id
	 * @return List<Messages>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEventId/{id}")
	public ResponseEntity<List<MessagesDTO>> findMessagesByEventId(@PathVariable int id) throws Exception {
		List<MessagesDTO> results = messagesService.findMessagesByEventId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<MessagesDTO> by foreign key : messageTypeId
	 * @param id
	 * @return List<Messages>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByMessageTypeId/{id}")
	public ResponseEntity<List<MessagesDTO>> findMessagesByMessageTypeId(@PathVariable int id) throws Exception {
		List<MessagesDTO> results = messagesService.findMessagesByMessageTypeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * get List<MessagesDTO> by foreign key : EventIdAndMessageTypeId
	 * @param id0
	 * @return List<Messages>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEventIdAndMessageTypeId/{id0}/{id1}")
	public ResponseEntity<List<MessagesDTO>> findMessagesByEventIdAndMessageTypeId(@PathVariable int id0, @PathVariable int id1) throws Exception {
		List<MessagesDTO> results = messagesService.findMessagesByEventIdAndMessageTypeId(id0, id1);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	@GetMapping("/test-email")
	public ResponseEntity<String> testEmailMessage() {
		String message = messagesService.testEmailMessage();
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@GetMapping("/test-email2")
	public ResponseEntity<OutputMessage> testEmailMessageUsingTemplate() {
		OutputMessage message = messagesService.testEmailUsingRestTemplate();
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

}
