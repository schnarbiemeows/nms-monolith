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
 * class to test the Steps class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class StepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Steps classUnderTest = new Steps();
		classUnderTest.setStepId(new Integer(1));
		classUnderTest.setWorkoutId(new Integer(1));
		classUnderTest.setSteps(new Integer(1));
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