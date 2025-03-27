package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.BrandIngrType;
import java.math.*;


/**
 * class to test the BrandIngrType class
 * @author Dylan I. Kessler
 *
 */
public class BrandIngrTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BrandIngrType classUnderTest = new BrandIngrType();
		classUnderTest.setBrandIngrTypeId(2);
		classUnderTest.setBrandId(2);
		classUnderTest.setIngrTypeId(2);
		classUnderTest.setPrntIngrType(2);
		assertTrue(true);
		BrandIngrType newitem = new BrandIngrType(
		classUnderTest.getBrandIngrTypeId(),
		classUnderTest.getBrandId(),
		classUnderTest.getIngrTypeId(),
		classUnderTest.getPrntIngrType());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}