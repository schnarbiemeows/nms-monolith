package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.FavoriteIngredientsDTO;
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
 * class to test the FavoriteIngredientsDTO class
 * @author Dylan I. Kessler
 *
 */
public class FavoriteIngredientsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		FavoriteIngredientsDTO classUnderTest = new FavoriteIngredientsDTO();
		classUnderTest.setFavoriteIngredientId(2);
		classUnderTest.setIngrId(2);
		classUnderTest.setLocal(true);
		classUnderTest.setActv("a");
		classUnderTest.setUserId(2);
		assertTrue(true);
		FavoriteIngredientsDTO newitem = new FavoriteIngredientsDTO(
		classUnderTest.getFavoriteIngredientId(),
		classUnderTest.getIngrId(),
		classUnderTest.isLocal(),
		classUnderTest.getActv(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}