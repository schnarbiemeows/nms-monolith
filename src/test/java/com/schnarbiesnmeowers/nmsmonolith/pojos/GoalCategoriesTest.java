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
 * class to test the GoalCategories class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GoalCategoriesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalCategories classUnderTest = new GoalCategories();
		classUnderTest.setGcId(new Integer(1));
		classUnderTest.setGoalTypeId(new Integer(1));
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