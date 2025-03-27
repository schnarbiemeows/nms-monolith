package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.ManualFoodItems;
import java.math.*;


/**
 * class to test the ManualFoodItems class
 * @author Dylan I. Kessler
 *
 */
public class ManualFoodItemsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ManualFoodItems classUnderTest = new ManualFoodItems();
		classUnderTest.setManualFoodItemId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setIngrId(2);
		classUnderTest.setIsRecipe(true);
		classUnderTest.setIsLocal(true);
		classUnderTest.setBldstId(2);
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setServTypeId(2);
		assertTrue(true);
		ManualFoodItems newitem = new ManualFoodItems(
		classUnderTest.getManualFoodItemId(),
		classUnderTest.getUserId(),
		classUnderTest.getIngrId(),
		classUnderTest.getIsRecipe(),
		classUnderTest.getIsLocal(),
		classUnderTest.getBldstId(),
		classUnderTest.getNumSrv(),
		classUnderTest.getServTypeId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}