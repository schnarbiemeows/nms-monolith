package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUser;
import java.math.*;


/**
 * class to test the GrpUser class
 * @author Dylan I. Kessler
 *
 */
public class GrpUserTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GrpUser classUnderTest = new GrpUser();
		classUnderTest.setGrpUserId(2);
		classUnderTest.setGrpId(2);
		classUnderTest.setUserId(2);
		assertTrue(true);
		GrpUser newitem = new GrpUser(
		classUnderTest.getGrpUserId(),
		classUnderTest.getGrpId(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}