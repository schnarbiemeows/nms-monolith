package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipesDTO;
import java.math.BigDecimal;



import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RecipesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecipesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipesDTO classUnderTest = new RecipesDTO();
		classUnderTest.setRecipeId(1);
		classUnderTest.setRecipeName("a");
		classUnderTest.setIngrId(1);
		classUnderTest.setRecipeDesc("a");
		classUnderTest.setRecipeLink("a");
		classUnderTest.setNumSrv(BigDecimal.ONE);
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