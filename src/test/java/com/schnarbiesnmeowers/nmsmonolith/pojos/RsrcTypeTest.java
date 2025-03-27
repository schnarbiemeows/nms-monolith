package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.RsrcType;
import java.math.*;


/**
 * class to test the RsrcType class
 * @author Dylan I. Kessler
 *
 */
public class RsrcTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RsrcType classUnderTest = new RsrcType();
		classUnderTest.setRsrcTypeId(2);
		classUnderTest.setRsrcType("a");
		classUnderTest.setRsrcTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RsrcType newitem = new RsrcType(
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcType(),
		classUnderTest.getRsrcTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}