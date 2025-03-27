package com.schnarbiesnmeowers.nmsmonolith.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserCalendar;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface UserCalendarRepository extends JpaRepository<UserCalendar, Integer> {


	/**
	 * get Iterable<UserCalendar> by foreign key : userId
	 * @param userId
	 * @return Iterable<UserCalendar>
	*/
	public Iterable<UserCalendar> findUserCalendarByUserId(int userId);
	/**
	 * get Iterable<UserCalendar> by foreign key : eventId
	 * @param eventId
	 * @return Iterable<UserCalendar>
	*/
	public Iterable<UserCalendar> findUserCalendarByEventId(int eventId);
	/**
	 * get Iterable<UserCalendar> by all foreign keys
	 * @return Iterable<UserCalendar>
	*/
	public Iterable<UserCalendar> findUserCalendarByUserIdAndEventId(int userId,int eventId);
}
