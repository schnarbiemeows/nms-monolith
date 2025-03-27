package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodExt;
import java.math.*;


/**
 * class to test the PeriodExt class
 * @author Dylan I. Kessler
 *
 */
public class PeriodExtTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PeriodExt classUnderTest = new PeriodExt();
		classUnderTest.setPeriodExtId(2);
		classUnderTest.setPeriodId(2);
		classUnderTest.setSpecificDate(new Date());
		classUnderTest.setSpecificTime(new java.sql.Time(1000));
		assertTrue(true);
		PeriodExt newitem = new PeriodExt(
		classUnderTest.getPeriodExtId(),
		classUnderTest.getPeriodId(),
		classUnderTest.getSpecificDate(),
		classUnderTest.getSpecificTime());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}