package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WeightWorkoutTypeDTO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.jupiter.api.Test;


/**
 * class to test the WeightWorkoutTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class WeightWorkoutTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		WeightWorkoutTypeDTO classUnderTest = new WeightWorkoutTypeDTO();
		classUnderTest.setWeightWorkoutTypeId(2);
		classUnderTest.setWorkoutId(2);
		classUnderTest.setMuscleGroupId(2);
		assertTrue(true);
		WeightWorkoutTypeDTO newitem = new WeightWorkoutTypeDTO(
		classUnderTest.getWeightWorkoutTypeId(),
		classUnderTest.getWorkoutId(),
		classUnderTest.getMuscleGroupId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}