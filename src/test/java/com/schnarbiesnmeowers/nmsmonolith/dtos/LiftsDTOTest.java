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
 * class to test the LiftsDTO class
 * @author Dylan I. Kessler
 *
 */
public class LiftsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftsDTO classUnderTest = new LiftsDTO();
		classUnderTest.setLiftId(2);
		classUnderTest.setLiftDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		classUnderTest.setMuscleGroupId(2);
		assertTrue(true);
		LiftsDTO newitem = new LiftsDTO(
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