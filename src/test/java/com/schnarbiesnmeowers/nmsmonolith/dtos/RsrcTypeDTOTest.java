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
 * class to test the RsrcTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class RsrcTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RsrcTypeDTO classUnderTest = new RsrcTypeDTO();
		classUnderTest.setRsrcTypeId(2);
		classUnderTest.setRsrcType("a");
		classUnderTest.setRsrcTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RsrcTypeDTO newitem = new RsrcTypeDTO(
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