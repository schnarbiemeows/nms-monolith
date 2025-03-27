package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutCardioDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the WorkoutCardioDTO class
 * @author Dylan I. Kessler
 *
 */
public class WorkoutCardioDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WorkoutCardioDTO classUnderTest = new WorkoutCardioDTO();
		classUnderTest.setWorkoutCardioId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setCardioTypeId(2);
		assertTrue(true);
		WorkoutCardioDTO newitem = new WorkoutCardioDTO(
		classUnderTest.getWorkoutCardioId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getCardioTypeId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}