package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.BodyMeasurements;
import java.math.*;


/**
 * class to test the BodyMeasurements class
 * @author Dylan I. Kessler
 *
 */
public class BodyMeasurementsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		BodyMeasurements classUnderTest = new BodyMeasurements();
		classUnderTest.setBodyMeasurementId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setLeftCalf(new BigDecimal(1.00));
		classUnderTest.setRightCalf(new BigDecimal(1.00));
		classUnderTest.setLeftThigh(new BigDecimal(1.00));
		classUnderTest.setRightThigh(new BigDecimal(1.00));
		classUnderTest.setWaist(new BigDecimal(1.00));
		classUnderTest.setChest(new BigDecimal(1.00));
		classUnderTest.setLeftBicep(new BigDecimal(1.00));
		classUnderTest.setRightBicep(new BigDecimal(1.00));
		classUnderTest.setLeftForearm(new BigDecimal(1.00));
		classUnderTest.setRightForearm(new BigDecimal(1.00));
		classUnderTest.setShoulders(new BigDecimal(1.00));
		classUnderTest.setActv("a");
		assertTrue(true);
		BodyMeasurements newitem = new BodyMeasurements(
		classUnderTest.getBodyMeasurementId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getLeftCalf(),
		classUnderTest.getRightCalf(),
		classUnderTest.getLeftThigh(),
		classUnderTest.getRightThigh(),
		classUnderTest.getWaist(),
		classUnderTest.getChest(),
		classUnderTest.getLeftBicep(),
		classUnderTest.getRightBicep(),
		classUnderTest.getLeftForearm(),
		classUnderTest.getRightForearm(),
		classUnderTest.getShoulders(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}