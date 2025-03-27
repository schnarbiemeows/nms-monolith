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
 * class to test the CardioTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class CardioTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		CardioTypeDTO classUnderTest = new CardioTypeDTO();
		classUnderTest.setCardioTypeId(2);
		classUnderTest.setDescription("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		CardioTypeDTO newitem = new CardioTypeDTO(
		classUnderTest.getCardioTypeId(),
		classUnderTest.getDescription(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}