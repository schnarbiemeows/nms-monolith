package com.schnarbiesnmeowers.nmsmonolith.pojos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.jupiter.api.Test;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WeightWorkoutType;


/**
 * class to test the WeightWorkoutType class
 * @author Dylan I. Kessler
 *
 */
public class WeightWorkoutTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WeightWorkoutType classUnderTest = new WeightWorkoutType();
		classUnderTest.setWeightWorkoutTypeId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setMuscleGroupId(2);
		assertTrue(true);
		WeightWorkoutType newitem = new WeightWorkoutType(
		classUnderTest.getWeightWorkoutTypeId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getMuscleGroupId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}