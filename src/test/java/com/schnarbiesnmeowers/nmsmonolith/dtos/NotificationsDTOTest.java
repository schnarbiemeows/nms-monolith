package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the NotificationsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class NotificationsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		NotificationsDTO classUnderTest = new NotificationsDTO();
		classUnderTest.setNotificationId(new Integer(1));
		classUnderTest.setEventId(new Integer(1));
		classUnderTest.setNotifTime(new java.sql.Time(1000));
		classUnderTest.setNextNotifDate(new Date());
		classUnderTest.setDelivered("a");
		assertTrue(true);
		NotificationsDTO newitem = new NotificationsDTO(
		classUnderTest.getNotificationId(),
		classUnderTest.getEventId(),
		classUnderTest.getNotifTime(),
		classUnderTest.getNextNotifDate(),
		classUnderTest.getDelivered());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}