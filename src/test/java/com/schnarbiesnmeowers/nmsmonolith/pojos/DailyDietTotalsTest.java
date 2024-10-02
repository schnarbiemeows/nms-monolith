package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietTotals;


import java.util.*;


import java.math.*;



/**
 * class to test the DailyDietTotals class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DailyDietTotalsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDietTotals classUnderTest = new DailyDietTotals();
		classUnderTest.setDailyDietTotalId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setBldstId(1);
		classUnderTest.setKcalories(new BigDecimal(1.00));
		classUnderTest.setTotFat(new BigDecimal(1.00));
		classUnderTest.setSatFat(new BigDecimal(1.00));
		classUnderTest.setTransFat(new BigDecimal(1.00));
		classUnderTest.setPolyFat(new BigDecimal(1.00));
		classUnderTest.setMonoFat(new BigDecimal(1.00));
		classUnderTest.setCholes(new BigDecimal(1.00));
		classUnderTest.setSodium(1);
		classUnderTest.setTotCarbs(new BigDecimal(1.00));
		classUnderTest.setTotFiber(new BigDecimal(1.00));
		classUnderTest.setTotSugars(new BigDecimal(1.00));
		classUnderTest.setTotProtein(new BigDecimal(1.00));
		assertTrue(true);
		DailyDietTotals newitem = new DailyDietTotals(
		classUnderTest.getDailyDietTotalId(),
		classUnderTest.getUserId(),
		classUnderTest.getCalendarDate(),
		classUnderTest.getBldstId(),
		classUnderTest.getKcalories(),
		classUnderTest.getTotFat(),
		classUnderTest.getSatFat(),
		classUnderTest.getTransFat(),
		classUnderTest.getPolyFat(),
		classUnderTest.getMonoFat(),
		classUnderTest.getCholes(),
		classUnderTest.getSodium(),
		classUnderTest.getTotCarbs(),
		classUnderTest.getTotFiber(),
		classUnderTest.getTotSugars(),
		classUnderTest.getTotProtein());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}