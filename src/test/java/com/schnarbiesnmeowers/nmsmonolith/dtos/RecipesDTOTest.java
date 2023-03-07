package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipesDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the RecipesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipesDTO classUnderTest = new RecipesDTO();
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setRecipeName("a");
		classUnderTest.setIngrId(new Integer(1));
		classUnderTest.setRecipeDesc("a");
		classUnderTest.setRecipeLink("a");
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipesDTO newitem = new RecipesDTO(
		classUnderTest.getRecipeId(),
		classUnderTest.getRecipeName(),
		classUnderTest.getIngrId(),
		classUnderTest.getIngrId(),
		classUnderTest.getRecipeDesc(),
		classUnderTest.getRecipeLink(),
		classUnderTest.getNumSrv(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}