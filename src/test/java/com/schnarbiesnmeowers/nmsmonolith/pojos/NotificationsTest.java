package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the Notifications class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class NotificationsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Notifications classUnderTest = new Notifications();
		classUnderTest.setNotificationId(new Integer(1));
		classUnderTest.setEventId(new Integer(1));
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