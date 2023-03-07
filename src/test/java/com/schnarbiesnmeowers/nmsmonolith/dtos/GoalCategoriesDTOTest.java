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
 * class to test the GoalCategoriesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GoalCategoriesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalCategoriesDTO classUnderTest = new GoalCategoriesDTO();
		classUnderTest.setGcId(new Integer(1));
		classUnderTest.setGoalTypeId(new Integer(1));
		classUnderTest.setGcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		GoalCategoriesDTO newitem = new GoalCategoriesDTO(
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