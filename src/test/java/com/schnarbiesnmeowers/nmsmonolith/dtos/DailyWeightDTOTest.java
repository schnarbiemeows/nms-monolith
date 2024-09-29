package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the DailyWeightDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class DailyWeightDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyWeightDataPoint classUnderTest = new DailyWeightDataPoint();
		classUnderTest.setDailyWeightId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setWeight(new BigDecimal(1.00));
		assertTrue(true);
		DailyWeightDataPoint newitem = new DailyWeightDataPoint(
		classUnderTest.getDailyWeightId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getWeight());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}