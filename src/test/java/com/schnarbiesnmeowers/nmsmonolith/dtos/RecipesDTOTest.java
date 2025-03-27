package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipesDTO;
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
 * class to test the RecipesDTO class
 * @author Dylan I. Kessler
 *
 */
public class RecipesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipesDTO classUnderTest = new RecipesDTO();
		classUnderTest.setRecipeId(2);
		classUnderTest.setRecipeName("a");
		classUnderTest.setRecipeTypeId(2);
		classUnderTest.setIngrId(2);
		classUnderTest.setRecipeDesc("a");
		classUnderTest.setRecipeLink("a");
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipesDTO newitem = new RecipesDTO(
		classUnderTest.getRecipeId(),
		classUnderTest.getRecipeName(),
		classUnderTest.getRecipeTypeId(),
		classUnderTest.getIngrId(),
		classUnderTest.getRecipeDesc(),
		classUnderTest.getRecipeLink(),
		classUnderTest.getNumSrv(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}