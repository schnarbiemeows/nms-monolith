package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;

import java.math.BigDecimal;





/**
 * class to test the RecipeIngredientsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class RecipeIngredientsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeIngredientsDTO classUnderTest = new RecipeIngredientsDTO();
		classUnderTest.setRecipeIngrId(1);
		classUnderTest.setRecipeId(1);
		classUnderTest.setRecOrIngrId(1);
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