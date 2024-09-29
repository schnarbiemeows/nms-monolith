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
 * class to test the RecipeEquip class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RecipeEquipTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RecipeEquip classUnderTest = new RecipeEquip();
		classUnderTest.setRecipeEquipId(new Integer(1));
		classUnderTest.setRecEqTypeId(new Integer(1));
		classUnderTest.setEquipDesc("a");
		classUnderTest.setEquipLongDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		RecipeEquip newitem = new RecipeEquip(
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