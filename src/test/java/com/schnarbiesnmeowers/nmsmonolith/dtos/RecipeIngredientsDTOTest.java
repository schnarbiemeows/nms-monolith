package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
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
 * class to test the RecipeIngredientsDTO class
 * @author Dylan I. Kessler
 *
 */
public class RecipeIngredientsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeIngredientsDTO classUnderTest = new RecipeIngredientsDTO();
		classUnderTest.setRecipeIngrId(2);
		classUnderTest.setRecipeId(2);
		classUnderTest.setRecOrIngrId(2);
		classUnderTest.setRecipeFlg("a");
		classUnderTest.setServSz(new BigDecimal(1.00));
		classUnderTest.setServTypeId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeIngredientsDTO newitem = new RecipeIngredientsDTO(
		classUnderTest.getRecipeIngrId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecOrIngrId(),
		classUnderTest.getRecipeFlg(),
		classUnderTest.getServSz(),
		classUnderTest.getServTypeId(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}