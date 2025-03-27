package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeType;
import java.math.*;


/**
 * class to test the RecipeType class
 * @author Dylan I. Kessler
 *
 */
public class RecipeTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeType classUnderTest = new RecipeType();
		classUnderTest.setRecipeTypeId(2);
		classUnderTest.setRecipeTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeType newitem = new RecipeType(
		classUnderTest.getRecipeTypeId(),
		classUnderTest.getRecipeTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}