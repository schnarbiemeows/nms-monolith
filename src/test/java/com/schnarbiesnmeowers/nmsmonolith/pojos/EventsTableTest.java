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
 * class to test the EventsTable class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class EventsTableTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		EventsTable classUnderTest = new EventsTable();
		classUnderTest.setEventId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setEventName("a");
		classUnderTest.setEventDesc("a");
		classUnderTest.setPeriodId(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		EventsTable newitem = new EventsTable(
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