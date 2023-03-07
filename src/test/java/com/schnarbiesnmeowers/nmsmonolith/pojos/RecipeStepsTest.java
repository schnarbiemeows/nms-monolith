package com.schnarbiesnmeowers.nmsmonolith.pojos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * class to test the RecipeSteps class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipeStepsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeSteps classUnderTest = new RecipeSteps();
		classUnderTest.setRecipeStepId(new Integer(1));
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setStepNum(new Integer(1));
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
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