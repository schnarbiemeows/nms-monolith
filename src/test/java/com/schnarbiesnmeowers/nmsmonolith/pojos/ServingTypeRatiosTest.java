package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeRatios;
import java.math.*;


/**
 * class to test the ServingTypeRatios class
 * @author Dylan I. Kessler
 *
 */
public class ServingTypeRatiosTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypeRatios classUnderTest = new ServingTypeRatios();
		classUnderTest.setServTypeRatioId(2);
		classUnderTest.setServTypeId1(2);
		classUnderTest.setServTypeId2(2);
		classUnderTest.setRatio(new BigDecimal(1.00));
		assertTrue(true);
		ServingTypeRatios newitem = new ServingTypeRatios(
		classUnderTest.getServTypeRatioId(),
		classUnderTest.getServTypeId1(),
		classUnderTest.getServTypeId2(),
		classUnderTest.getRatio());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}