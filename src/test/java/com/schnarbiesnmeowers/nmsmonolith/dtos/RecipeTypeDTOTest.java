package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeDTO;
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
 * class to test the RecipeTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class RecipeTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeTypeDTO classUnderTest = new RecipeTypeDTO();
		classUnderTest.setRecipeTypeId(2);
		classUnderTest.setRecipeTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeTypeDTO newitem = new RecipeTypeDTO(
		classUnderTest.getRecipeTypeId(),
		classUnderTest.getRecipeTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}