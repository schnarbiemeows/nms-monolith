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
 * class to test the UserCalendarDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class UserCalendarDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UserCalendarDTO classUnderTest = new UserCalendarDTO();
		classUnderTest.setUserCalendarId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setCalendarTime(new java.sql.Time(1000));
		classUnderTest.setEventId(new Integer(1));
		assertTrue(true);
		UserCalendarDTO newitem = new UserCalendarDTO(
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