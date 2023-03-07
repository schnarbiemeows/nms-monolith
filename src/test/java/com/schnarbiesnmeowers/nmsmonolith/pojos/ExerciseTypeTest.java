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
 * class to test the ExerciseType class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ExerciseTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ExerciseType classUnderTest = new ExerciseType();
		classUnderTest.setExerciseTypeId(new Integer(1));
		classUnderTest.setPrntExerciseType(new Integer(1));
		classUnderTest.setExerciseTypeDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
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