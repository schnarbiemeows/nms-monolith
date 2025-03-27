package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
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
 * class to test the ServingTypeRatiosDTO class
 * @author Dylan I. Kessler
 *
 */
public class ServingTypeRatiosDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypeRatiosDTO classUnderTest = new ServingTypeRatiosDTO();
		classUnderTest.setServTypeRatioId(2);
		classUnderTest.setServTypeId1(2);
		classUnderTest.setServTypeId2(2);
		classUnderTest.setRatio(new BigDecimal(1.00));
		assertTrue(true);
		ServingTypeRatiosDTO newitem = new ServingTypeRatiosDTO(
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