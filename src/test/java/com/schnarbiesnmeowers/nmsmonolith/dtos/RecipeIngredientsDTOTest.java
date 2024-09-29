package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the RecipeIngredientsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipeIngredientsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeIngredientsDTO classUnderTest = new RecipeIngredientsDTO();
		classUnderTest.setRecipeIngrId(new Integer(1));
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setRecOrIngrId(new Integer(1));
		classUnderTest.setRecipeFlg("a");
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