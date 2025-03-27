package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the EventsTableDTO class
 * @author Dylan I. Kessler
 *
 */
public class EventsTableDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		EventsTableDTO classUnderTest = new EventsTableDTO();
		classUnderTest.setEventId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setEventName("a");
		classUnderTest.setEventDesc("a");
		classUnderTest.setPeriodId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		EventsTableDTO newitem = new EventsTableDTO(
		classUnderTest.getEventId(),
		classUnderTest.getUserId(),
		classUnderTest.getEventName(),
		classUnderTest.getEventDesc(),
		classUnderTest.getPeriodId(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}