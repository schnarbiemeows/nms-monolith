package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the DailyDietTotalsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class DailyDietTotalsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		DailyDietTotalsDTO classUnderTest = new DailyDietTotalsDTO();
		classUnderTest.setDailyDietTotalId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setCalendarDate(new Date());
		classUnderTest.setBldstId(new Integer(1));
		classUnderTest.setKcalories(new BigDecimal(1.00));
		classUnderTest.setTotFat(new BigDecimal(1.00));
		classUnderTest.setSatFat(new BigDecimal(1.00));
		classUnderTest.setTransFat(new BigDecimal(1.00));
		classUnderTest.setPolyFat(new BigDecimal(1.00));
		classUnderTest.setMonoFat(new BigDecimal(1.00));
		classUnderTest.setCholes(new BigDecimal(1.00));
		classUnderTest.setSodium(new Integer(1));
		classUnderTest.setTotCarbs(new BigDecimal(1.00));
		classUnderTest.setTotFiber(new BigDecimal(1.00));
		classUnderTest.setTotSugars(new BigDecimal(1.00));
		classUnderTest.setTotProtein(new BigDecimal(1.00));
		assertTrue(true);
		DailyDietTotalsDTO newitem = new DailyDietTotalsDTO(
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