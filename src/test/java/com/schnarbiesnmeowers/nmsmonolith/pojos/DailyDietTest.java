package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDiet;
import java.math.*;


/**
 * class to test the DailyDiet class
 * @author Dylan I. Kessler
 *
 */
public class DailyDietTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDiet classUnderTest = new DailyDiet();
		classUnderTest.setDailyTotalId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setIngrId(2);
		classUnderTest.setIsRecipe(true);
		classUnderTest.setIsLocal(true);
		classUnderTest.setBldstId(2);
		classUnderTest.setNumSrv(new BigDecimal(1.00));
		classUnderTest.setServTypeId(2);
		classUnderTest.setTimeEaten(String.valueOf(new java.sql.Time(1000)));
		assertTrue(true);
		DailyDiet newitem = new DailyDiet(
		classUnderTest.getDailyTotalId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getIngrId(),
		classUnderTest.getIsRecipe(),
		classUnderTest.getIsLocal(),
		classUnderTest.getBldstId(),
		classUnderTest.getNumSrv(),
		classUnderTest.getServTypeId(),
		classUnderTest.getTimeEaten());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}