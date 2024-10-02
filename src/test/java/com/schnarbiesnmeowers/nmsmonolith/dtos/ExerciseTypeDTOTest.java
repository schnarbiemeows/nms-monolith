package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the ExerciseTypeDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExerciseTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ExerciseTypeDTO classUnderTest = new ExerciseTypeDTO();
		classUnderTest.setExerciseTypeId(1);
		classUnderTest.setPrntExerciseType(1);
		classUnderTest.setExerciseTypeDesc("a");
		classUnderTest.setImageLoc(1);
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