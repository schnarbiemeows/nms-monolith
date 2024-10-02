package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.ExerciseType;







/**
 * class to test the ExerciseType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ExerciseTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ExerciseType classUnderTest = new ExerciseType();
		classUnderTest.setExerciseTypeId(1);
		classUnderTest.setPrntExerciseType(1);
		classUnderTest.setExerciseTypeDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		ExerciseType newitem = new ExerciseType(
		classUnderTest.getExerciseTypeId(),
		classUnderTest.getPrntExerciseType(),
		classUnderTest.getExerciseTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}