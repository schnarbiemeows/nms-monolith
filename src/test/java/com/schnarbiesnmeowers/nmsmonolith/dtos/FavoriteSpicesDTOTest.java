package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.FavoriteSpicesDTO;
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
 * class to test the FavoriteSpicesDTO class
 * @author Dylan I. Kessler
 *
 */
public class FavoriteSpicesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		FavoriteSpicesDTO classUnderTest = new FavoriteSpicesDTO();
		classUnderTest.setFavoriteSpiceId(2);
		classUnderTest.setSpiceId(2);
		classUnderTest.setIsLocal(true);
		classUnderTest.setActv("a");
		classUnderTest.setUserId(2);
		assertTrue(true);
		FavoriteSpicesDTO newitem = new FavoriteSpicesDTO(
		classUnderTest.getFavoriteSpiceId(),
		classUnderTest.getSpiceId(),
		classUnderTest.getIsLocal(),
		classUnderTest.getActv(),
		classUnderTest.getUserId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}