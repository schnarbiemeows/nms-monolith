package com.schnarbiesnmeowers.nmsmonolith.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.dtos.NotificationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.pojos.Notifications;
import com.schnarbiesnmeowers.nmsmonolith.repositories.NotificationsRepository;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class NotificationsService {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");
    public static final String ID_EQUALS = "id = ";
    public static final String NOT_FOUND = " not found";
	/**
	 * JPA Repository handle
	 */
	@Autowired
	private NotificationsRepository notificationsRepository;

	/**
	 * get all Notifications records
	 * @return
	 * @throws Exception
	 */
	public List<NotificationsDTO> getAllNotifications() throws Exception {
		Iterable<Notifications> notifications = notificationsRepository.findAll();
		Iterator<Notifications> notificationss = notifications.iterator();
		List<NotificationsDTO> notificationsdto = new ArrayList();
		while(notificationss.hasNext()) {
			Notifications item = notificationss.next();
			notificationsdto.add(item.toDTO());
		}
		return notificationsdto;
	}

	/**
	 * get Notifications by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NotificationsDTO findNotificationsById(int id) throws Exception {
		Optional<Notifications> notificationsOptional = notificationsRepository.findById(id);
		if(notificationsOptional.isPresent()) {
			Notifications results = notificationsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * create a new Notifications
	 * @param data
	 * @return
	 */
	public NotificationsDTO createNotifications(NotificationsDTO data) {
		try {
		    Notifications createdData = data.toEntity();
		    createdData = notificationsRepository.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Notifications
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public NotificationsDTO updateNotifications(NotificationsDTO data) throws Exception {
		Optional<Notifications> notificationsOptional = notificationsRepository.findById(data.getNotificationId());
		if(notificationsOptional.isPresent()) {
		    Notifications updatedData = data.toEntity();
			updatedData = notificationsRepository.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + data.getNotificationId() + NOT_FOUND);
		}
	}

	/**
	 * delete a Notifications by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteNotifications(int id) throws Exception {
		Optional<Notifications> notificationsOptional = notificationsRepository.findById(id);
		if(notificationsOptional.isPresent()) {
			notificationsRepository.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException(ID_EQUALS + id + NOT_FOUND);
		}
	}

	/**
	 * get List<NotificationsDTO> by foreign key : eventId
	 * @param eventId
	 * @return List<Notifications>
	 * @throws Exception
	*/
	public List<NotificationsDTO> findNotificationsByEventId(int id) throws Exception {
		Iterable<Notifications> results = notificationsRepository.findNotificationsByEventId(id);
		Iterator<Notifications> iter = results.iterator();
		List<NotificationsDTO> resultsdto = new ArrayList();
		while(iter.hasNext()) {
			Notifications item = iter.next();
			resultsdto.add(item.toDTO());
		}
		return resultsdto;
	}

}
