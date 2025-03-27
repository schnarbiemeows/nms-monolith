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
 * class to test the MusclesDTO class
 * @author Dylan I. Kessler
 *
 */
public class MusclesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		MusclesDTO classUnderTest = new MusclesDTO();
		classUnderTest.setMuscleId(2);
		classUnderTest.setMuscleGroupId(2);
		classUnderTest.setMuscleName("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		MusclesDTO newitem = new MusclesDTO(
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