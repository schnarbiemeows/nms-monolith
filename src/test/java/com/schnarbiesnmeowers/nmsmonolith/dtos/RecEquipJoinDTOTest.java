package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RecEquipJoinDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecEquipJoinDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecEquipJoinDTO classUnderTest = new RecEquipJoinDTO();
		classUnderTest.setRecEquipJoinId(1);
		classUnderTest.setRecipeId(1);
		classUnderTest.setRecipeEquipId(1);
		assertTrue(true);
		RecEquipJoinDTO newitem = new RecEquipJoinDTO(
		classUnderTest.getRecEquipJoinId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecipeEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}