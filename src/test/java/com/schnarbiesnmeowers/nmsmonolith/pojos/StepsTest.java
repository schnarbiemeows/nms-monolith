package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.Steps;
import java.math.*;


/**
 * class to test the Steps class
 * @author Dylan I. Kessler
 *
 */
public class StepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Steps classUnderTest = new Steps();
		classUnderTest.setStepId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setSteps(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		Steps newitem = new Steps(
		classUnderTest.getStepId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getSteps(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}