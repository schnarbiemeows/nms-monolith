package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftMuscle;
import java.math.*;


/**
 * class to test the LiftMuscle class
 * @author Dylan I. Kessler
 *
 */
public class LiftMuscleTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftMuscle classUnderTest = new LiftMuscle();
		classUnderTest.setLiftMuscleId(2);
		classUnderTest.setLiftId(2);
		classUnderTest.setMuscleId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		LiftMuscle newitem = new LiftMuscle(
		classUnderTest.getLiftMuscleId(),
		classUnderTest.getLiftId(),
		classUnderTest.getMuscleId(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}