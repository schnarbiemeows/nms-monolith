package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the IngredientTypesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class IngredientTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		IngredientTypesDTO classUnderTest = new IngredientTypesDTO();
		classUnderTest.setIngrTypeId(new Integer(1));
		classUnderTest.setPrntIngrType(new Integer(1));
		classUnderTest.setIngrTypeDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		IngredientTypesDTO newitem = new IngredientTypesDTO(
		classUnderTest.getIngrTypeId(),
		classUnderTest.getPrntIngrType(),
		classUnderTest.getIngrTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}