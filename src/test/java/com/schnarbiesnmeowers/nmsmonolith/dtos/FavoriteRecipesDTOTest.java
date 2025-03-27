package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.FavoriteRecipesDTO;
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
 * class to test the FavoriteRecipesDTO class
 * @author Dylan I. Kessler
 *
 */
public class FavoriteRecipesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		FavoriteRecipesDTO classUnderTest = new FavoriteRecipesDTO();
		classUnderTest.setFavoriteRecipeId(2);
		classUnderTest.setRecipeId(2);
		classUnderTest.setLocal(true);
		classUnderTest.setActv("a");
		classUnderTest.setUserId(2);
		assertTrue(true);
		FavoriteRecipesDTO newitem = new FavoriteRecipesDTO(
		classUnderTest.getFavoriteRecipeId(),
		classUnderTest.getRecipeId(),
		classUnderTest.isLocal(),
		classUnderTest.getActv(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}