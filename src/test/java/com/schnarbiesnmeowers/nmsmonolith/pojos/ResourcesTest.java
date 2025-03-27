package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Resources;
import java.math.*;


/**
 * class to test the Resources class
 * @author Dylan I. Kessler
 *
 */
public class ResourcesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Resources classUnderTest = new Resources();
		classUnderTest.setRsrcId(2);
		classUnderTest.setRsrcTypeId(2);
		classUnderTest.setRsrcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Resources newitem = new Resources(
		classUnderTest.getRsrcId(),
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}