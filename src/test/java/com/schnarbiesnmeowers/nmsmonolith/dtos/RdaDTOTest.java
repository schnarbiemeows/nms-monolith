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
 * class to test the RdaDTO class
 * @author Dylan I. Kessler
 *
 */
public class RdaDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RdaDTO classUnderTest = new RdaDTO();
		classUnderTest.setRdaId(2);
		classUnderTest.setRdaName("a");
		classUnderTest.setRdaValue(new BigDecimal(1.00));
		classUnderTest.setUserId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		RdaDTO newitem = new RdaDTO(
		classUnderTest.getRdaId(),
		classUnderTest.getRdaName(),
		classUnderTest.getRdaValue(),
		classUnderTest.getUserId(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}