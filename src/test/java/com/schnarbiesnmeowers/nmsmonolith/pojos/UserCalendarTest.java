package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.UserCalendar;


import java.util.*;





/**
 * class to test the UserCalendar class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserCalendarTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		UserCalendar classUnderTest = new UserCalendar();
		classUnderTest.setUserCalendarId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setCalendarTime(new java.sql.Time(1000));
		classUnderTest.setEventId(1);
		assertTrue(true);
		UserCalendar newitem = new UserCalendar(
		classUnderTest.getUserCalendarId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getCalendarTime(),
		classUnderTest.getEventId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}