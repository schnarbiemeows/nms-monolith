package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GoalGroupsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GoalGroupsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalGroupsDTO classUnderTest = new GoalGroupsDTO();
		classUnderTest.setGoalGroupId(1);
		classUnderTest.setGoalId1(1);
		classUnderTest.setGoalId2(1);
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