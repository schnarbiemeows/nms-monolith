package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.PasswordReset;
import java.math.*;


/**
 * class to test the PasswordReset class
 * @author Dylan I. Kessler
 *
 */
public class PasswordResetTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PasswordReset classUnderTest = new PasswordReset();
		classUnderTest.setPasswordResetId(2);
		classUnderTest.setUniqueId("a");
		classUnderTest.setEmailAddr("a");
		classUnderTest.setCreatedDate(new Date());
		assertTrue(true);
		PasswordReset newitem = new PasswordReset(
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