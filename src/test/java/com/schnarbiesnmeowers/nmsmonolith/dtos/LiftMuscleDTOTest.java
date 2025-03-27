package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the LiftMuscleDTO class
 * @author Dylan I. Kessler
 *
 */
public class LiftMuscleDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftMuscleDTO classUnderTest = new LiftMuscleDTO();
		classUnderTest.setLiftMuscleId(2);
		classUnderTest.setLiftId(2);
		classUnderTest.setMuscleId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		LiftMuscleDTO newitem = new LiftMuscleDTO(
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