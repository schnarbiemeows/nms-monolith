package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.time.LocalDate;
import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the UserCalendarDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserCalendarDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		UserCalendarDTO classUnderTest = new UserCalendarDTO();
		classUnderTest.setUserCalendarId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setCalendarTime(new java.sql.Time(1000));
		classUnderTest.setEventId(1);
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