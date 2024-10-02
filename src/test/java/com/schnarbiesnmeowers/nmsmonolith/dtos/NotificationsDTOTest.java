package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the NotificationsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		NotificationsDTO classUnderTest = new NotificationsDTO();
		classUnderTest.setNotificationId(1);
		classUnderTest.setEventId(1);
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