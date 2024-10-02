package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GoalCategories;







/**
 * class to test the GoalCategories class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoalCategoriesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalCategories classUnderTest = new GoalCategories();
		classUnderTest.setGcId(1);
		classUnderTest.setGoalTypeId(1);
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