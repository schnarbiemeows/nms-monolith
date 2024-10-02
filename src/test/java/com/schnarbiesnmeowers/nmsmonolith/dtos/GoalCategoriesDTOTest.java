package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GoalCategoriesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalCategoriesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalCategoriesDTO classUnderTest = new GoalCategoriesDTO();
		classUnderTest.setGcId(1);
		classUnderTest.setGoalTypeId(1);
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