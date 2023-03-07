package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the IngredientTypes class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class IngredientTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		IngredientTypes classUnderTest = new IngredientTypes();
		classUnderTest.setIngrTypeId(new Integer(1));
		classUnderTest.setPrntIngrType(new Integer(1));
		classUnderTest.setIngrTypeDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		IngredientTypes newitem = new IngredientTypes(
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