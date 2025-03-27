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
 * class to test the LiftEquipDTO class
 * @author Dylan I. Kessler
 *
 */
public class LiftEquipDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftEquipDTO classUnderTest = new LiftEquipDTO();
		classUnderTest.setLiftEquipId(2);
		classUnderTest.setEquipDesc("a");
		classUnderTest.setEquipLongDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		LiftEquipDTO newitem = new LiftEquipDTO(
		classUnderTest.getLiftEquipId(),
		classUnderTest.getEquipDesc(),
		classUnderTest.getEquipLongDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}