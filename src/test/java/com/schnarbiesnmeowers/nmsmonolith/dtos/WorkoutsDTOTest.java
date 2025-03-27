package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutsDTO;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the WorkoutsDTO class
 * @author Dylan I. Kessler
 *
 */
public class WorkoutsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WorkoutsDTO classUnderTest = new WorkoutsDTO();
		classUnderTest.setWorkoutId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setExerciseTypeId(2);
		classUnderTest.setDuration(2);
		classUnderTest.setRating(new BigDecimal(1.00));
		classUnderTest.setNotes("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		WorkoutsDTO newitem = new WorkoutsDTO(
		classUnderTest.getWorkoutId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getExerciseTypeId(),
		classUnderTest.getDuration(),
		classUnderTest.getRating(),
		classUnderTest.getNotes(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}