package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeEquip;
import java.math.*;


/**
 * class to test the RecipeEquip class
 * @author Dylan I. Kessler
 *
 */
public class RecipeEquipTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecipeEquip classUnderTest = new RecipeEquip();
		classUnderTest.setRecipeEquipId(2);
		classUnderTest.setRecEqTypeId(2);
		classUnderTest.setEquipDesc("a");
		classUnderTest.setEquipLongDesc("a");
		classUnderTest.setImageLoc(2);
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