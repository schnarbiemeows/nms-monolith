package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the UserConfigDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserConfigDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		UserConfigDTO classUnderTest = new UserConfigDTO();
		classUnderTest.setUsersConfigId(1);
		classUnderTest.setUserId(1);
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