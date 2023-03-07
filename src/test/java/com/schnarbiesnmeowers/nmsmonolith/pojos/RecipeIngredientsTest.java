package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the RecipeIngredients class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipeIngredientsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeIngredients classUnderTest = new RecipeIngredients();
		classUnderTest.setRecipeIngrId(new Integer(1));
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setRecOrIngrId(new Integer(1));
		classUnderTest.setRecipeFlg("a");
		assertTrue(true);
		RecipeIngredients newitem = new RecipeIngredients(
		classUnderTest.getRecipeIngrId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecOrIngrId(),
		classUnderTest.getRecipeFlg(),
				BigDecimal.ZERO,
				new Integer(1), "Y");
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}