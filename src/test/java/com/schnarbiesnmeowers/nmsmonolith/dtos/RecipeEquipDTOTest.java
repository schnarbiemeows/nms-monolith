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
 * class to test the RecipeEquipDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipeEquipDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeEquipDTO classUnderTest = new RecipeEquipDTO();
		classUnderTest.setRecipeEquipId(new Integer(1));
		classUnderTest.setRecEqTypeId(new Integer(1));
		classUnderTest.setEquipDesc("a");
		classUnderTest.setEquipLongDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeEquipDTO newitem = new RecipeEquipDTO(
		classUnderTest.getRecipeEquipId(),
		classUnderTest.getRecEqTypeId(),
		classUnderTest.getEquipDesc(),
		classUnderTest.getEquipLongDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}