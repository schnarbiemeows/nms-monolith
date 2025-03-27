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
 * class to test the RecipeStepsDTO class
 * @author Dylan I. Kessler
 *
 */
public class RecipeStepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeStepsDTO classUnderTest = new RecipeStepsDTO();
		classUnderTest.setRecipeStepId(2);
		classUnderTest.setRecipeId(2);
		classUnderTest.setStepNum(2);
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeStepsDTO newitem = new RecipeStepsDTO(
		classUnderTest.getRecipeStepId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getStepNum(),
		classUnderTest.getStepDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}