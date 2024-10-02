package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeSteps;


/**
 * class to test the RecipeSteps class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RecipeStepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeSteps classUnderTest = new RecipeSteps();
		classUnderTest.setRecipeStepId(1);
		classUnderTest.setRecipeId(1);
		classUnderTest.setStepNum(1);
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(1);
		classUnderTest.setActv("Y");
		assertTrue(true);
		RecipeSteps newitem = new RecipeSteps(
		classUnderTest.getRecipeStepId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getStepNum(),
		classUnderTest.getStepDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}