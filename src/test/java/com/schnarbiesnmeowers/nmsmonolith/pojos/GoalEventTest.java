package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalEvent;
import java.math.*;


/**
 * class to test the GoalEvent class
 * @author Dylan I. Kessler
 *
 */
public class GoalEventTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalEvent classUnderTest = new GoalEvent();
		classUnderTest.setGoalEventId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setGoalId(2);
		classUnderTest.setEventId(2);
		assertTrue(true);
		GoalEvent newitem = new GoalEvent(
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