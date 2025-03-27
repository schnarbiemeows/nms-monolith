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
 * class to test the PeriodExtDTO class
 * @author Dylan I. Kessler
 *
 */
public class PeriodExtDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PeriodExtDTO classUnderTest = new PeriodExtDTO();
		classUnderTest.setPeriodExtId(2);
		classUnderTest.setPeriodId(2);
		classUnderTest.setSpecificDate(new Date());
		classUnderTest.setSpecificTime(new java.sql.Time(1000));
		assertTrue(true);
		PeriodExtDTO newitem = new PeriodExtDTO(
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