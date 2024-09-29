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
 * class to test the GoalTypes class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GoalTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalTypes classUnderTest = new GoalTypes();
		classUnderTest.setGoalTypeId(new Integer(1));
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