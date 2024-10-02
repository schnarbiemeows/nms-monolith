package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.Notifications;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface NotificationsRepository extends JpaRepository<Notifications, Integer> {


	/**
	 * get Iterable<Notifications> by foreign key : eventId
	 * @param eventId
	 * @return Iterable<Notifications>
	*/
	public Iterable<Notifications> findNotificationsByEventId(int eventId);
}
