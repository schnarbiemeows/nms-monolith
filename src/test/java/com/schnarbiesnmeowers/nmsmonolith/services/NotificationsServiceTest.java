package com.schnarbiesnmeowers.nmsmonolith.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.nmsmonolith.dtos.NotificationsDTO;
import org.springframework.stereotype.Service;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Service
public class NotificationsServiceTest {


	/**
	 * get all Notifications records
	 * @return
	 * @throws Exception
	 */
	public List<NotificationsDTO> getAllNotifications() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<NotificationsDTO> notificationsDTO = new ArrayList<NotificationsDTO>();
		return notificationsDTO;
	}

	/**
	 * get Notifications by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public NotificationsDTO findNotificationsById(int id) throws Exception {
		return new NotificationsDTO();
	}

	/**
	 * create a new Notifications
	 * @param data
	 * @return
	 */
	public NotificationsDTO createNotifications(NotificationsDTO data) {
        data.setNotificationId(1);
        return data;
	}

	/**
	 * update a Notifications
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public NotificationsDTO updateNotifications(NotificationsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Notifications by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteNotifications(int id) throws Exception {
		return "Successfully Deleted";
	}

	/**
	 * get List<NotificationsDTO> by foreign key : eventId
	 * @param id
	 * @return List<Notifications>
	 * @throws Exception
	*/
	public List<NotificationsDTO> findNotificationsByEventId(int id) throws Exception {
		List<NotificationsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
