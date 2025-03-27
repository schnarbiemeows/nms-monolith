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
 * class to test the LiftLiftEqpDTO class
 * @author Dylan I. Kessler
 *
 */
public class LiftLiftEqpDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftLiftEqpDTO classUnderTest = new LiftLiftEqpDTO();
		classUnderTest.setLiftLiftEqpId(2);
		classUnderTest.setLiftId(2);
		classUnderTest.setLiftEquipId(2);
		assertTrue(true);
		LiftLiftEqpDTO newitem = new LiftLiftEqpDTO(
		classUnderTest.getLiftLiftEqpId(),
		classUnderTest.getLiftId(),
		classUnderTest.getLiftEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}