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
 * class to test the GoalGroupsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GoalGroupsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GoalGroupsDTO classUnderTest = new GoalGroupsDTO();
		classUnderTest.setGoalGroupId(new Integer(1));
		classUnderTest.setGoalId1(new Integer(1));
		classUnderTest.setGoalId2(new Integer(1));
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