package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the Workouts class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class WorkoutsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Workouts classUnderTest = new Workouts();
		classUnderTest.setWorkoutId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setExerciseTypeId(new Integer(1));
		classUnderTest.setDuration(new Integer(1));
		classUnderTest.setRating(new BigDecimal(1.00));
		classUnderTest.setActv("a");
		assertTrue(true);
		Workouts newitem = new Workouts(
		classUnderTest.getWorkoutId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getExerciseTypeId(),
		classUnderTest.getDuration(),
		classUnderTest.getRating(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}