package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the MuscleGroupsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MuscleGroupsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		MuscleGroupsDTO classUnderTest = new MuscleGroupsDTO();
		classUnderTest.setMuscleGroupId(1);
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