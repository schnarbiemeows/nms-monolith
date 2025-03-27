package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Groups;
import java.math.*;


/**
 * class to test the Groups class
 * @author Dylan I. Kessler
 *
 */
public class GroupsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Groups classUnderTest = new Groups();
		classUnderTest.setGrpId(2);
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		assertTrue(true);
		Groups newitem = new Groups(
		classUnderTest.getGrpId(),
		classUnderTest.getGrpName(),
		classUnderTest.getGrpDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}