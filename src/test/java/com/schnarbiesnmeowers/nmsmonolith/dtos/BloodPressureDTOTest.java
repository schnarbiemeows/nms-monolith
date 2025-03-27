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
 * class to test the BloodPressureDTO class
 * @author Dylan I. Kessler
 *
 */
public class BloodPressureDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BloodPressureDTO classUnderTest = new BloodPressureDTO();
		classUnderTest.setBloodPressureId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setSystolic(2);
		classUnderTest.setDiastolic(2);
		classUnderTest.setPulse(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		BloodPressureDTO newitem = new BloodPressureDTO(
		classUnderTest.getBloodPressureId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getSystolic(),
		classUnderTest.getDiastolic(),
		classUnderTest.getPulse(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}