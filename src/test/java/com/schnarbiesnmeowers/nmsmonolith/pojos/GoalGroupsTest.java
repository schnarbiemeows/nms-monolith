package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GoalGroups;







/**
 * class to test the GoalGroups class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoalGroupsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalGroups classUnderTest = new GoalGroups();
		classUnderTest.setGoalGroupId(1);
		classUnderTest.setGoalId1(1);
		classUnderTest.setGoalId2(1);
		classUnderTest.setRelation("a");
		assertTrue(true);
		GoalGroups newitem = new GoalGroups(
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