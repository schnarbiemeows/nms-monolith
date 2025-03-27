package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.LiftSetDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the LiftSetDTO class
 * @author Dylan I. Kessler
 *
 */
public class LiftSetDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		LiftSetDTO classUnderTest = new LiftSetDTO();
		classUnderTest.setLiftSetId(2);
		classUnderTest.setWorkoutLiftId(2);
		classUnderTest.setWeight(new BigDecimal(1.00));
		classUnderTest.setReps(2);
		assertTrue(true);
		LiftSetDTO newitem = new LiftSetDTO(
		classUnderTest.getLiftSetId(),
		classUnderTest.getWorkoutLiftId(),
		classUnderTest.getWeight(),
		classUnderTest.getReps());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}