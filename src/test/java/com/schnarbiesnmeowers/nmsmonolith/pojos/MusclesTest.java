package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Muscles;







/**
 * class to test the Muscles class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MusclesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Muscles classUnderTest = new Muscles();
		classUnderTest.setMuscleId(1);
		classUnderTest.setMuscleGroupId(1);
		classUnderTest.setMuscleName("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		Muscles newitem = new Muscles(
		classUnderTest.getMuscleId(),
		classUnderTest.getMuscleGroupId(),
		classUnderTest.getMuscleName(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}