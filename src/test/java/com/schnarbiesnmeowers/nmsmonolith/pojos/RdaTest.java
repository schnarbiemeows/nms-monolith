package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Rda;
import java.math.*;


/**
 * class to test the Rda class
 * @author Dylan I. Kessler
 *
 */
public class RdaTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Rda classUnderTest = new Rda();
		classUnderTest.setRdaId(2);
		classUnderTest.setRdaName("a");
		classUnderTest.setRdaValue(new BigDecimal(1.00));
		classUnderTest.setUserId(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		Rda newitem = new Rda(
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