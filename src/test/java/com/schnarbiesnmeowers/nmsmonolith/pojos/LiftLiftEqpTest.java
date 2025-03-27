package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftLiftEqp;
import java.math.*;


/**
 * class to test the LiftLiftEqp class
 * @author Dylan I. Kessler
 *
 */
public class LiftLiftEqpTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftLiftEqp classUnderTest = new LiftLiftEqp();
		classUnderTest.setLiftLiftEqpId(2);
		classUnderTest.setLiftId(2);
		classUnderTest.setLiftEquipId(2);
		assertTrue(true);
		LiftLiftEqp newitem = new LiftLiftEqp(
		classUnderTest.getLiftLiftEqpId(),
		classUnderTest.getLiftId(),
		classUnderTest.getLiftEquipId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}