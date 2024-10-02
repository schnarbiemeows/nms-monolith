package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Recipes;




import java.math.*;



/**
 * class to test the Recipes class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecipesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Recipes classUnderTest = new Recipes();
		classUnderTest.setRecipeId(1);
		classUnderTest.setRecipeName("a");
		classUnderTest.setIngrId(1);
		classUnderTest.setRecipeDesc("a");
		classUnderTest.setRecipeLink("a");
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setActv("a");
		assertTrue(true);
		Recipes newitem = new Recipes(
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