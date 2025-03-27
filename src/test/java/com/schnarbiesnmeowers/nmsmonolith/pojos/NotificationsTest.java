package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Notifications;
import java.math.*;


/**
 * class to test the Notifications class
 * @author Dylan I. Kessler
 *
 */
public class NotificationsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Notifications classUnderTest = new Notifications();
		classUnderTest.setNotificationId(2);
		classUnderTest.setEventId(2);
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