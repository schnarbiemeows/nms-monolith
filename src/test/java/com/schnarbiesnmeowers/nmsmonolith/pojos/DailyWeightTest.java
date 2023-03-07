package com.schnarbiesnmeowers.nmsmonolith.pojos;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the DailyWeight class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class DailyWeightTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		DailyWeight classUnderTest = new DailyWeight();
		classUnderTest.setDailyWeightId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setCalendarDate(LocalDate.now());
		classUnderTest.setWeight(new BigDecimal(1.00));
		assertTrue(true);
		DailyWeight newitem = new DailyWeight(
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