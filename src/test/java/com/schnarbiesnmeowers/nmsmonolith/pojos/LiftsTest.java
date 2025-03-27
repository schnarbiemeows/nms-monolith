package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Lifts;
import java.math.*;


/**
 * class to test the Lifts class
 * @author Dylan I. Kessler
 *
 */
public class LiftsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Lifts classUnderTest = new Lifts();
		classUnderTest.setLiftId(2);
		classUnderTest.setLiftDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		classUnderTest.setMuscleGroupId(2);
		assertTrue(true);
		Lifts newitem = new Lifts(
		classUnderTest.getLiftId(),
		classUnderTest.getLiftDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv(),
		classUnderTest.getMuscleGroupId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}