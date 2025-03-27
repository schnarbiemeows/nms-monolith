package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.LiftSet;
import java.math.*;


/**
 * class to test the LiftSet class
 * @author Dylan I. Kessler
 *
 */
public class LiftSetTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftSet classUnderTest = new LiftSet();
		classUnderTest.setLiftSetId(2);
		classUnderTest.setWorkoutLiftId(2);
		classUnderTest.setWeight(new BigDecimal(1.00));
		classUnderTest.setReps(2);
		assertTrue(true);
		LiftSet newitem = new LiftSet(
		classUnderTest.getLiftSetId(),
		classUnderTest.getWorkoutLiftId(),
		classUnderTest.getWeight(),
		classUnderTest.getReps());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}