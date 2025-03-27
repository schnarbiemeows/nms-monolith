package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeOptions;
import java.math.*;


/**
 * class to test the ServingTypeOptions class
 * @author Dylan I. Kessler
 *
 */
public class ServingTypeOptionsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypeOptions classUnderTest = new ServingTypeOptions();
		classUnderTest.setServTypeOptId(2);
		classUnderTest.setServTypeId(2);
		classUnderTest.setMenuOption(2);
		assertTrue(true);
		ServingTypeOptions newitem = new ServingTypeOptions(
		classUnderTest.getServTypeOptId(),
		classUnderTest.getServTypeId(),
		classUnderTest.getMenuOption());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}