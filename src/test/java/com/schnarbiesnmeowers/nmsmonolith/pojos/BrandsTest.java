package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Brands;
import java.math.*;


/**
 * class to test the Brands class
 * @author Dylan I. Kessler
 *
 */
public class BrandsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Brands classUnderTest = new Brands();
		classUnderTest.setBrandId(2);
		classUnderTest.setBrandType("a");
		classUnderTest.setBrandName("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		Brands newitem = new Brands(
		classUnderTest.getBrandId(),
		classUnderTest.getBrandType(),
		classUnderTest.getBrandName(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}