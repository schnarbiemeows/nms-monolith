package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutLiftDTO;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the WorkoutLiftDTO class
 * @author Dylan I. Kessler
 *
 */
public class WorkoutLiftDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WorkoutLiftDTO classUnderTest = new WorkoutLiftDTO();
		classUnderTest.setWorkoutLiftId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setLiftId(2);
		assertTrue(true);
		WorkoutLiftDTO newitem = new WorkoutLiftDTO(
		classUnderTest.getWorkoutLiftId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getLiftId(),
				classUnderTest.getLiftSetDTO());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}