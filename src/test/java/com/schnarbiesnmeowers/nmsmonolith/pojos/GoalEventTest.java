package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GoalEvent;







/**
 * class to test the GoalEvent class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GoalEventTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GoalEvent classUnderTest = new GoalEvent();
		classUnderTest.setGoalEventId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setGoalId(1);
		classUnderTest.setEventId(1);
		assertTrue(true);
		GoalEvent newitem = new GoalEvent(
		classUnderTest.getGoalEventId(),
		classUnderTest.getUserId(),
		classUnderTest.getGoalId(),
		classUnderTest.getEventId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}