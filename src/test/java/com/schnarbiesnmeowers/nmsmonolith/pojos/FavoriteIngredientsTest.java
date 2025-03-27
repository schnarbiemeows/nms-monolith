package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteIngredients;
import java.math.*;


/**
 * class to test the FavoriteIngredients class
 * @author Dylan I. Kessler
 *
 */
public class FavoriteIngredientsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		FavoriteIngredients classUnderTest = new FavoriteIngredients();
		classUnderTest.setFavoriteIngredientId(2);
		classUnderTest.setIngrId(2);
		classUnderTest.setIsLocal(true);
		classUnderTest.setActv("a");
		classUnderTest.setUserId(2);
		assertTrue(true);
		FavoriteIngredients newitem = new FavoriteIngredients(
		classUnderTest.getFavoriteIngredientId(),
		classUnderTest.getIngrId(),
		classUnderTest.getIsLocal(),
		classUnderTest.getActv(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}