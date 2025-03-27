package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Muscles;
import java.math.*;


/**
 * class to test the Muscles class
 * @author Dylan I. Kessler
 *
 */
public class MusclesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Muscles classUnderTest = new Muscles();
		classUnderTest.setMuscleId(2);
		classUnderTest.setMuscleGroupId(2);
		classUnderTest.setMuscleName("a");
		classUnderTest.setImageLoc(2);
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