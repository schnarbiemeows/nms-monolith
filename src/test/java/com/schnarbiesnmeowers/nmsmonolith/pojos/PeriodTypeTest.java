package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodType;
import java.math.*;


/**
 * class to test the PeriodType class
 * @author Dylan I. Kessler
 *
 */
public class PeriodTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PeriodType classUnderTest = new PeriodType();
		classUnderTest.setPeriodTypeId(2);
		classUnderTest.setPeriodTypeCde("a");
		classUnderTest.setPeriodTypeDesc("a");
		assertTrue(true);
		PeriodType newitem = new PeriodType(
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getPeriodTypeCde(),
		classUnderTest.getPeriodTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}