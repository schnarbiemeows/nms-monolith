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
 * class to test the BrandIngrTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class BrandIngrTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BrandIngrTypeDTO classUnderTest = new BrandIngrTypeDTO();
		classUnderTest.setBrandIngrTypeId(2);
		classUnderTest.setBrandId(2);
		classUnderTest.setIngrTypeId(2);
		classUnderTest.setPrntIngrType(2);
		assertTrue(true);
		BrandIngrTypeDTO newitem = new BrandIngrTypeDTO(
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