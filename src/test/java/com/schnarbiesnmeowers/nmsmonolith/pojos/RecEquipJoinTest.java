package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecEquipJoin;
import java.math.*;


/**
 * class to test the RecEquipJoin class
 * @author Dylan I. Kessler
 *
 */
public class RecEquipJoinTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecEquipJoin classUnderTest = new RecEquipJoin();
		classUnderTest.setRecEquipJoinId(2);
		classUnderTest.setRecipeId(2);
		classUnderTest.setRecipeEquipId(2);
		assertTrue(true);
		RecEquipJoin newitem = new RecEquipJoin(
		classUnderTest.getRecEquipJoinId(),
		classUnderTest.getRecipeId(),
		classUnderTest.getRecipeEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}