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
 * class to test the EventsTableDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class EventsTableDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		EventsTableDTO classUnderTest = new EventsTableDTO();
		classUnderTest.setEventId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setEventName("a");
		classUnderTest.setEventDesc("a");
		classUnderTest.setPeriodId(new Integer(1));
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