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
 * class to test the RecEqTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class RecEqTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RecEqTypeDTO classUnderTest = new RecEqTypeDTO();
		classUnderTest.setRecEqTypeId(2);
		classUnderTest.setRecEqCde("a");
		classUnderTest.setRecEqDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RecEqTypeDTO newitem = new RecEqTypeDTO(
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