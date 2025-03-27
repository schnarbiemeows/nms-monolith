package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
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
 * class to test the SpicesDTO class
 * @author Dylan I. Kessler
 *
 */
public class SpicesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		SpicesDTO classUnderTest = new SpicesDTO();
		classUnderTest.setSpiceId(2);
		classUnderTest.setSpiceName("a");
		classUnderTest.setActv("a");
		classUnderTest.setImageLoc(2);
		assertTrue(true);
		SpicesDTO newitem = new SpicesDTO(
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