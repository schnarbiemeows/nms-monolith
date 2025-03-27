package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecEqType;
import java.math.*;


/**
 * class to test the RecEqType class
 * @author Dylan I. Kessler
 *
 */
public class RecEqTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecEqType classUnderTest = new RecEqType();
		classUnderTest.setRecEqTypeId(2);
		classUnderTest.setRecEqCde("a");
		classUnderTest.setRecEqDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RecEqType newitem = new RecEqType(
		classUnderTest.getRecEqTypeId(),
		classUnderTest.getRecEqCde(),
		classUnderTest.getRecEqDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}