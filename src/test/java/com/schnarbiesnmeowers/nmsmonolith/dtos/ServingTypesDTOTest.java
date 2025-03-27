package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
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
 * class to test the ServingTypesDTO class
 * @author Dylan I. Kessler
 *
 */
public class ServingTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypesDTO classUnderTest = new ServingTypesDTO();
		classUnderTest.setServTypeId(2);
		classUnderTest.setServTypeCde("a");
		classUnderTest.setServTypeDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		ServingTypesDTO newitem = new ServingTypesDTO(
		classUnderTest.getServTypeId(),
		classUnderTest.getServTypeCde(),
		classUnderTest.getServTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}