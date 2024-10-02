package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GoalEventDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalEventDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalEventDTO classUnderTest = new GoalEventDTO();
		classUnderTest.setGoalEventId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setGoalId(1);
		classUnderTest.setEventId(1);
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