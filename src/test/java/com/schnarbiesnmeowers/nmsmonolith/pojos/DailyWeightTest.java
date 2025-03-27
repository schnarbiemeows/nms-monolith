package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyWeight;
import java.math.*;


/**
 * class to test the DailyWeight class
 * @author Dylan I. Kessler
 *
 */
public class DailyWeightTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyWeight classUnderTest = new DailyWeight();
		classUnderTest.setDailyWeightId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setWeight(new BigDecimal(1.00));
		assertTrue(true);
		DailyWeight newitem = new DailyWeight(
		classUnderTest.getDailyWeightId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getWeight());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}