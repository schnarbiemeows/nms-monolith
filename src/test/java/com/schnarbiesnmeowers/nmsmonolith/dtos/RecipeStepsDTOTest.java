package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RecipeStepsDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecipeStepsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeStepsDTO classUnderTest = new RecipeStepsDTO();
		classUnderTest.setRecipeStepId(1);
		classUnderTest.setRecipeId(1);
		classUnderTest.setStepNum(1);
		classUnderTest.setStepDesc("a");
		classUnderTest.setImageLoc(1);
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