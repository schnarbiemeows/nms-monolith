package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeSpices;
import java.math.*;


/**
 * class to test the RecipeSpices class
 * @author Dylan I. Kessler
 *
 */
public class RecipeSpicesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeSpices classUnderTest = new RecipeSpices();
		classUnderTest.setRecipeSpiceId(2);
		classUnderTest.setRecipeId(2);
		classUnderTest.setSpiceId(2);
		classUnderTest.setServSz(new BigDecimal(1.00));
		classUnderTest.setServTypeId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeSpices newitem = new RecipeSpices(
		classUnderTest.getRecipeSpiceId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getSpiceId(),
		classUnderTest.getServSz(),
		classUnderTest.getServTypeId(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}