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
 * class to test the UserConfigDTO class
 * @author Dylan I. Kessler
 *
 */
public class UserConfigDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UserConfigDTO classUnderTest = new UserConfigDTO();
		classUnderTest.setUsersConfigId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setPropertyKey("a");
		classUnderTest.setPropertyValue("a");
		assertTrue(true);
		UserConfigDTO newitem = new UserConfigDTO(
		classUnderTest.getUsersConfigId(),
		classUnderTest.getUserId(),
		classUnderTest.getPropertyKey(),
		classUnderTest.getPropertyValue());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}