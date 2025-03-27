package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Unsynced;
import java.math.*;


/**
 * class to test the Unsynced class
 * @author Dylan I. Kessler
 *
 */
public class UnsyncedTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Unsynced classUnderTest = new Unsynced();
		classUnderTest.setUnsyncedId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		assertTrue(true);
		Unsynced newitem = new Unsynced(
		classUnderTest.getUnsyncedId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}