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
 * class to test the PasswordResetDTO class
 * @author Dylan I. Kessler
 *
 */
public class PasswordResetDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PasswordResetDTO classUnderTest = new PasswordResetDTO();
		classUnderTest.setPasswordResetId(2);
		classUnderTest.setUniqueId("a");
		classUnderTest.setEmailAddr("a");
		classUnderTest.setCreatedDate(new Date());
		assertTrue(true);
		PasswordResetDTO newitem = new PasswordResetDTO(
		classUnderTest.getPasswordResetId(),
		classUnderTest.getUniqueId(),
		classUnderTest.getEmailAddr(),
		classUnderTest.getCreatedDate());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}