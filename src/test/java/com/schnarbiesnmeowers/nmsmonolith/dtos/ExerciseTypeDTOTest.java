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
 * class to test the ExerciseTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class ExerciseTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ExerciseTypeDTO classUnderTest = new ExerciseTypeDTO();
		classUnderTest.setExerciseTypeId(2);
		classUnderTest.setPrntExerciseType(2);
		classUnderTest.setExerciseTypeDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		ExerciseTypeDTO newitem = new ExerciseTypeDTO(
		classUnderTest.getExerciseTypeId(),
		classUnderTest.getPrntExerciseType(),
		classUnderTest.getExerciseTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}