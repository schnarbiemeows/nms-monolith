package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeOptionsDTO;
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
 * class to test the ServingTypeOptionsDTO class
 * @author Dylan I. Kessler
 *
 */
public class ServingTypeOptionsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypeOptionsDTO classUnderTest = new ServingTypeOptionsDTO();
		classUnderTest.setServTypeOptId(2);
		classUnderTest.setServTypeId(2);
		classUnderTest.setMenuOption(2);
		assertTrue(true);
		ServingTypeOptionsDTO newitem = new ServingTypeOptionsDTO(
		classUnderTest.getServTypeOptId(),
		classUnderTest.getServTypeId(),
		classUnderTest.getMenuOption());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}