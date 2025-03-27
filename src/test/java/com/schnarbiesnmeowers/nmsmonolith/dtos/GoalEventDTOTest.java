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
 * class to test the GoalEventDTO class
 * @author Dylan I. Kessler
 *
 */
public class GoalEventDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalEventDTO classUnderTest = new GoalEventDTO();
		classUnderTest.setGoalEventId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setGoalId(2);
		classUnderTest.setEventId(2);
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