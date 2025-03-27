package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.CardioType;
import java.math.*;


/**
 * class to test the CardioType class
 * @author Dylan I. Kessler
 *
 */
public class CardioTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		CardioType classUnderTest = new CardioType();
		classUnderTest.setCardioTypeId(2);
		classUnderTest.setDescription("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		CardioType newitem = new CardioType(
		classUnderTest.getCardioTypeId(),
		classUnderTest.getDescription(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}
}