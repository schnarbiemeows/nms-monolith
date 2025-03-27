package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDTO;
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
 * class to test the DailyWeightDTO class
 * @author Dylan I. Kessler
 *
 */
public class DailyWeightDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyWeightDTO classUnderTest = generateRandomDailyWeight();
		assertTrue(true);
		DailyWeightDTO newitem = new DailyWeightDTO(
		classUnderTest.getData(),
		classUnderTest.getMissingData(),
		classUnderTest.getMin(),
		classUnderTest.getMax(),
				classUnderTest.getAverage(),
				classUnderTest.getDayRange(),
				classUnderTest.getMissingDates());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

	public static DailyWeightDTO generateRandomDailyWeight() {
		DailyWeightDTO record = new DailyWeightDTO();
		record.setMissingDates(new ArrayList<>());
		record.setDayRange(10);
		record.setMin(Randomizer.randomBigDecimal("3"));
		record.setMax(Randomizer.randomBigDecimal("3"));
		record.setData(new ArrayList<>());
		record.setAverage(Randomizer.randomBigDecimal("3"));
		record.setMissingData(new ArrayList<>());
		return record;
	}
}