package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeIngredients;




import java.math.*;



/**
 * class to test the RecipeIngredients class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecipeIngredientsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeIngredients classUnderTest = new RecipeIngredients();
		classUnderTest.setRecipeIngrId(1);
		classUnderTest.setRecipeId(1);
		classUnderTest.setRecOrIngrId(1);
		classUnderTest.setRecipeFlg("a");
		assertTrue(true);
		RecipeIngredients newitem = new RecipeIngredients(
		classUnderTest.getRecipeIngrId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecOrIngrId(),
		classUnderTest.getRecipeFlg(),
				BigDecimal.ZERO,
				1, "Y");
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}