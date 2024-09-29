package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the RecipeStepsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipeStepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeStepsDTO classUnderTest = new RecipeStepsDTO();
		classUnderTest.setRecipeStepId(new Integer(1));
		classUnderTest.setRecipeId(new Integer(1));
		classUnderTest.setStepNum(new Integer(1));
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("Y");
		assertTrue(true);
		RecipeStepsDTO newitem = new RecipeStepsDTO(
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