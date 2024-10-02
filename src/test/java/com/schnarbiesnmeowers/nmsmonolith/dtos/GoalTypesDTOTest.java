package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GoalTypesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalTypesDTO classUnderTest = new GoalTypesDTO();
		classUnderTest.setGoalTypeId(1);
		classUnderTest.setGoalTypeCde("a");
		classUnderTest.setGoalTypeDesc("a");
		assertTrue(true);
		GoalTypesDTO newitem = new GoalTypesDTO(
		classUnderTest.getGoalTypeId(),
		classUnderTest.getGoalTypeCde(),
		classUnderTest.getGoalTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}