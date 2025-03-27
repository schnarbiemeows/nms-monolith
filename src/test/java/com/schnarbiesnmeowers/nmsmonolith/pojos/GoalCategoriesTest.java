package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalCategories;
import java.math.*;


/**
 * class to test the GoalCategories class
 * @author Dylan I. Kessler
 *
 */
public class GoalCategoriesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalCategories classUnderTest = new GoalCategories();
		classUnderTest.setGcId(2);
		classUnderTest.setGoalTypeId(2);
		classUnderTest.setGcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		GoalCategories newitem = new GoalCategories(
		classUnderTest.getGcId(),
		classUnderTest.getGoalTypeId(),
		classUnderTest.getGcDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}