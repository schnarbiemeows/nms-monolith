package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutLift;
import java.math.*;


/**
 * class to test the WorkoutLift class
 * @author Dylan I. Kessler
 *
 */
public class WorkoutLiftTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WorkoutLift classUnderTest = new WorkoutLift();
		classUnderTest.setWorkoutLiftId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setLiftId(2);
		assertTrue(true);
		WorkoutLift newitem = new WorkoutLift(
		classUnderTest.getWorkoutLiftId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getLiftId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}