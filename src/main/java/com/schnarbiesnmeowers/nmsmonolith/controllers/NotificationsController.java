package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.entities.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
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
@RequestMapping(path="/notifications")
public class NotificationsController {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private NotificationsService businessService;

	/**
	 * get all Notifications records
	 * @return Iterable<Notifications>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<NotificationsDTO>> getAllNotifications() throws Exception {
		List<NotificationsDTO> notifications = businessService.getAllNotifications();
		return ResponseEntity.status(HttpStatus.OK).body(notifications);
	}

	/**
	 * get Notifications by primary key
	 * @param id
	 * @return Notifications
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<NotificationsDTO> findNotificationsById(@PathVariable int id) throws Exception {
		NotificationsDTO results = businessService.findNotificationsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Notifications
	 * @param NotificationsDTO
	 * @return Notifications
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<NotificationsDTO> createNotifications(@Valid @RequestBody NotificationsDTO data) throws Exception {
		try {
		    NotificationsDTO createdData = businessService.createNotifications(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Notifications
	 * @param NotificationsDTO
	 * @return Notifications
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<NotificationsDTO> updateNotifications(@Valid @RequestBody NotificationsDTO data) throws Exception {
		NotificationsDTO updatedData = businessService.updateNotifications(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Notifications by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteNotifications(@PathVariable int id) throws Exception {
		businessService.deleteNotifications(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

	/**
	 * get List<NotificationsDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<Notifications>
	 * @throws Exception
	*/
	@GetMapping(path = "/findByEventId/{id}")
	public ResponseEntity<List<NotificationsDTO>> findNotificationsByEventId(@PathVariable int id) throws Exception {
		List<NotificationsDTO> results = businessService.findNotificationsByEventId(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

}
