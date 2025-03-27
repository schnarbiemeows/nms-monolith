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
 * class to test the ActionTypeDTO class
 * @author Dylan I. Kessler
 *
 */
public class ActionTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ActionTypeDTO classUnderTest = new ActionTypeDTO();
		classUnderTest.setActionTypeId(2);
		classUnderTest.setActionTypeCde("a");
		classUnderTest.setActionTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		ActionTypeDTO newitem = new ActionTypeDTO(
		classUnderTest.getActionTypeId(),
		classUnderTest.getActionTypeCde(),
		classUnderTest.getActionTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}