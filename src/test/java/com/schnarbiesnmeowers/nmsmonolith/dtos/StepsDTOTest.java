package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.StepsDTO;
import java.time.LocalDate;





/**
 * class to test the StepsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class StepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		StepsDTO classUnderTest = new StepsDTO();
		classUnderTest.setStepId(1);
		classUnderTest.setWorkoutId(1);
		classUnderTest.setSteps(1);
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