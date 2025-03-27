package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutCardio;
import java.math.*;


/**
 * class to test the WorkoutCardio class
 * @author Dylan I. Kessler
 *
 */
public class WorkoutCardioTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WorkoutCardio classUnderTest = new WorkoutCardio();
		classUnderTest.setWorkoutCardioId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setCardioTypeId(2);
		assertTrue(true);
		WorkoutCardio newitem = new WorkoutCardio(
		classUnderTest.getWorkoutCardioId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getCardioTypeId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}