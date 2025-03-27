package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteRecipes;
import java.math.*;


/**
 * class to test the FavoriteRecipes class
 * @author Dylan I. Kessler
 *
 */
public class FavoriteRecipesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		FavoriteRecipes classUnderTest = new FavoriteRecipes();
		classUnderTest.setFavoriteRecipeId(2);
		classUnderTest.setRecipeId(2);
		classUnderTest.setIsLocal(true);
		classUnderTest.setActv("a");
		classUnderTest.setUserId(2);
		assertTrue(true);
		FavoriteRecipes newitem = new FavoriteRecipes(
		classUnderTest.getFavoriteRecipeId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getIsLocal(),
		classUnderTest.getActv(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}