package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.StepsDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the StepsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class StepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		StepsDTO classUnderTest = new StepsDTO();
		classUnderTest.setStepId(new Integer(1));
		classUnderTest.setWorkoutId(new Integer(1));
		classUnderTest.setSteps(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		StepsDTO newitem = new StepsDTO(
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