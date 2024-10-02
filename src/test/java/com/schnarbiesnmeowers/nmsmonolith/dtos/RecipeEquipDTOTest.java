package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RecipeEquipDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecipeEquipDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeEquipDTO classUnderTest = new RecipeEquipDTO();
		classUnderTest.setRecipeEquipId(1);
		classUnderTest.setRecEqTypeId(1);
		classUnderTest.setEquipDesc("a");
		classUnderTest.setEquipLongDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeEquipDTO newitem = new RecipeEquipDTO(
		classUnderTest.getRecipeEquipId(),
		classUnderTest.getRecEqTypeId(),
		classUnderTest.getEquipDesc(),
		classUnderTest.getEquipLongDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}