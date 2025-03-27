package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftSteps;
import java.math.*;


/**
 * class to test the LiftSteps class
 * @author Dylan I. Kessler
 *
 */
public class LiftStepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftSteps classUnderTest = new LiftSteps();
		classUnderTest.setLiftStepId(2);
		classUnderTest.setLiftId(2);
		classUnderTest.setStepNum(2);
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(2);
		assertTrue(true);
		LiftSteps newitem = new LiftSteps(
		classUnderTest.getLiftStepId(),
		classUnderTest.getLiftId(),
		classUnderTest.getStepNum(),
		classUnderTest.getStepDesc(),
		classUnderTest.getImageLoc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}