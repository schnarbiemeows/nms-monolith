package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Periods;
import java.math.*;


/**
 * class to test the Periods class
 * @author Dylan I. Kessler
 *
 */
public class PeriodsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Periods classUnderTest = new Periods();
		classUnderTest.setPeriodId(2);
		classUnderTest.setPeriodTypeId(2);
		classUnderTest.setOneTimeDate(new Date());
		classUnderTest.setDayOfWeek("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Periods newitem = new Periods(
		classUnderTest.getPeriodId(),
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getOneTimeDate(),
		classUnderTest.getDayOfWeek(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}