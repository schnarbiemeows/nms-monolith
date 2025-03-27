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
 * class to test the GrpUserDTO class
 * @author Dylan I. Kessler
 *
 */
public class GrpUserDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GrpUserDTO classUnderTest = new GrpUserDTO();
		classUnderTest.setGrpUserId(2);
		classUnderTest.setGrpId(2);
		classUnderTest.setUserId(2);
		assertTrue(true);
		GrpUserDTO newitem = new GrpUserDTO(
		classUnderTest.getGrpUserId(),
		classUnderTest.getGrpId(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}