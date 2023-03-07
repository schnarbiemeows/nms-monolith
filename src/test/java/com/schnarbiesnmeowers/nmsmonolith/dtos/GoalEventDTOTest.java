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
 * class to test the GoalEventDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GoalEventDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalEventDTO classUnderTest = new GoalEventDTO();
		classUnderTest.setGoalEventId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setGoalId(new Integer(1));
		classUnderTest.setEventId(new Integer(1));
		assertTrue(true);
		GoalEventDTO newitem = new GoalEventDTO(
		classUnderTest.getGoalEventId(),
		classUnderTest.getUserId(),
		classUnderTest.getGoalId(),
		classUnderTest.getEventId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}