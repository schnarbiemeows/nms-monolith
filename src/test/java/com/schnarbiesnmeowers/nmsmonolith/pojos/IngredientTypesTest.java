package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.IngredientTypes;
import java.math.*;


/**
 * class to test the IngredientTypes class
 * @author Dylan I. Kessler
 *
 */
public class IngredientTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		IngredientTypes classUnderTest = new IngredientTypes();
		classUnderTest.setIngrTypeId(2);
		classUnderTest.setPrntIngrType(2);
		classUnderTest.setIngrTypeDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		IngredientTypes newitem = new IngredientTypes(
		classUnderTest.getIngrTypeId(),
		classUnderTest.getPrntIngrType(),
		classUnderTest.getIngrTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}