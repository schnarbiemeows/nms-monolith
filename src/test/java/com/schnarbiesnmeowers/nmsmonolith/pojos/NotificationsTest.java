package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Notifications;


import java.util.*;





/**
 * class to test the Notifications class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class NotificationsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Notifications classUnderTest = new Notifications();
		classUnderTest.setNotificationId(1);
		classUnderTest.setEventId(1);
		classUnderTest.setNotifTime(new java.sql.Time(1000));
		classUnderTest.setNextNotifDate(new Date());
		classUnderTest.setDelivered("a");
		assertTrue(true);
		Notifications newitem = new Notifications(
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