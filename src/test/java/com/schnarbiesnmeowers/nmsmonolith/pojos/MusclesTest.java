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
 * class to test the Muscles class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class MusclesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Muscles classUnderTest = new Muscles();
		classUnderTest.setMuscleId(new Integer(1));
		classUnderTest.setMuscleGroupId(new Integer(1));
		classUnderTest.setMuscleName("a");
		classUnderTest.setImageLoc(new Integer(1));
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