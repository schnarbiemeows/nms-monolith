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
 * class to test the Lifts class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class LiftsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Lifts classUnderTest = new Lifts();
		classUnderTest.setLiftId(new Integer(1));
		classUnderTest.setMuscleId(new Integer(1));
		classUnderTest.setLiftDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		Lifts newitem = new Lifts(
		classUnderTest.getLiftId(),
		classUnderTest.getMuscleId(),
		classUnderTest.getLiftDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}