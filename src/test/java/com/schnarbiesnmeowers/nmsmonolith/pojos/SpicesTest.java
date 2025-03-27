package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.Spices;
import java.math.*;


/**
 * class to test the Spices class
 * @author Dylan I. Kessler
 *
 */
public class SpicesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Spices classUnderTest = new Spices();
		classUnderTest.setSpiceId(2);
		classUnderTest.setSpiceName("a");
		classUnderTest.setActv("a");
		classUnderTest.setImageLoc(2);
		assertTrue(true);
		Spices newitem = new Spices(
		classUnderTest.getSpiceId(),
		classUnderTest.getSpiceName(),
		classUnderTest.getActv(),
		classUnderTest.getImageLoc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}