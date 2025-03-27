package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserConfig;
import java.math.*;


/**
 * class to test the UserConfig class
 * @author Dylan I. Kessler
 *
 */
public class UserConfigTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		UserConfig classUnderTest = new UserConfig();
		classUnderTest.setUsersConfigId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setPropertyKey("a");
		classUnderTest.setPropertyValue("a");
		assertTrue(true);
		UserConfig newitem = new UserConfig(
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