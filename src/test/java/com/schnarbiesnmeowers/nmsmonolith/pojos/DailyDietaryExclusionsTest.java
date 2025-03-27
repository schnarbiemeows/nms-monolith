package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryExclusions;
import java.math.*;


/**
 * class to test the DailyDietaryExclusions class
 * @author Dylan I. Kessler
 *
 */
public class DailyDietaryExclusionsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDietaryExclusions classUnderTest = new DailyDietaryExclusions();
		classUnderTest.setDailyDietaryExclusionId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		assertTrue(true);
		DailyDietaryExclusions newitem = new DailyDietaryExclusions(
		classUnderTest.getDailyDietaryExclusionId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}