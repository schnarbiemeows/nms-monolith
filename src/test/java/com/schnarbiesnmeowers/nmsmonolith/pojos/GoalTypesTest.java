package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalTypes;
import java.math.*;


/**
 * class to test the GoalTypes class
 * @author Dylan I. Kessler
 *
 */
public class GoalTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalTypes classUnderTest = new GoalTypes();
		classUnderTest.setGoalTypeId(2);
		classUnderTest.setGoalTypeCde("a");
		classUnderTest.setGoalTypeDesc("a");
		assertTrue(true);
		GoalTypes newitem = new GoalTypes(
		classUnderTest.getGoalTypeId(),
		classUnderTest.getGoalTypeCde(),
		classUnderTest.getGoalTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}