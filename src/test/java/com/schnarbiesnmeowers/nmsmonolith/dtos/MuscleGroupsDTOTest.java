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
 * class to test the MuscleGroupsDTO class
 * @author Dylan I. Kessler
 *
 */
public class MuscleGroupsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		MuscleGroupsDTO classUnderTest = new MuscleGroupsDTO();
		classUnderTest.setMuscleGroupId(2);
		classUnderTest.setMuscleGrpName("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		MuscleGroupsDTO newitem = new MuscleGroupsDTO(
		classUnderTest.getMuscleGroupId(),
		classUnderTest.getMuscleGrpName(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}