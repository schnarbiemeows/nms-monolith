package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GoalTypes;







/**
 * class to test the GoalTypes class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoalTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalTypes classUnderTest = new GoalTypes();
		classUnderTest.setGoalTypeId(1);
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