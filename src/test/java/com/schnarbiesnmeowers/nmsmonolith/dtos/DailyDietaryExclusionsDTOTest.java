package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the DailyDietaryExclusionsDTO class
 * @author Dylan I. Kessler
 *
 */
public class DailyDietaryExclusionsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyDietaryExclusionsDTO classUnderTest = new DailyDietaryExclusionsDTO();
		classUnderTest.setDailyDietaryExclusionId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		assertTrue(true);
		DailyDietaryExclusionsDTO newitem = new DailyDietaryExclusionsDTO(
		classUnderTest.getDailyDietaryExclusionId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}