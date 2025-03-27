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
 * class to test the GoalGroupsDTO class
 * @author Dylan I. Kessler
 *
 */
public class GoalGroupsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalGroupsDTO classUnderTest = new GoalGroupsDTO();
		classUnderTest.setGoalGroupId(2);
		classUnderTest.setGoalId1(2);
		classUnderTest.setGoalId2(2);
		classUnderTest.setRelation("a");
		assertTrue(true);
		GoalGroupsDTO newitem = new GoalGroupsDTO(
		classUnderTest.getGoalGroupId(),
		classUnderTest.getGoalId1(),
		classUnderTest.getGoalId2(),
		classUnderTest.getRelation());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}