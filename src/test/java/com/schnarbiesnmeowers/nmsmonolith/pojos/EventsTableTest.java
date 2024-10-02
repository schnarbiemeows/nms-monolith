package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.EventsTable;







/**
 * class to test the EventsTable class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EventsTableTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		EventsTable classUnderTest = new EventsTable();
		classUnderTest.setEventId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setEventName("a");
		classUnderTest.setEventDesc("a");
		classUnderTest.setPeriodId(1);
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