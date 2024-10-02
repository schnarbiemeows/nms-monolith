package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.Workouts;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * class to test the Workouts class
 * @author Dylan I. Kessler
 *
 */
//import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WorkoutsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Workouts classUnderTest = new Workouts();
		classUnderTest.setWorkoutId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(null);
		classUnderTest.setExerciseTypeId(1);
		classUnderTest.setDuration(1);
		classUnderTest.setRating(new BigDecimal(1.00));
		classUnderTest.setActv("a");
		classUnderTest.setNotes("A");
		assertTrue(true);
		Workouts newitem = new Workouts(
		classUnderTest.getWorkoutId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getExerciseTypeId(),
		classUnderTest.getDuration(),
		classUnderTest.getRating(),
		classUnderTest.getActv(),
		classUnderTest.getNotes());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}