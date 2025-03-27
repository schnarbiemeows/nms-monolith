package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.BloodPressure;
import java.math.*;


/**
 * class to test the BloodPressure class
 * @author Dylan I. Kessler
 *
 */
public class BloodPressureTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BloodPressure classUnderTest = new BloodPressure();
		classUnderTest.setBloodPressureId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setSystolic(2);
		classUnderTest.setDiastolic(2);
		classUnderTest.setPulse(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		BloodPressure newitem = new BloodPressure(
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