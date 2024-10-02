package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.Steps;







/**
 * class to test the Steps class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Steps classUnderTest = new Steps();
		classUnderTest.setStepId(1);
		classUnderTest.setWorkoutId(1);
		classUnderTest.setSteps(1);
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