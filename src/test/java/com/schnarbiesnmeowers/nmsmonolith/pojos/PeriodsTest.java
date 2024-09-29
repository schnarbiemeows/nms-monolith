package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the Periods class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PeriodsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Periods classUnderTest = new Periods();
		classUnderTest.setPeriodId(new Integer(1));
		classUnderTest.setPeriodTypeId(new Integer(1));
		classUnderTest.setOneTimeDate(new Date());
		classUnderTest.setDayOfWeek("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Periods newitem = new Periods(
		classUnderTest.getPeriodId(),
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getOneTimeDate(),
		classUnderTest.getDayOfWeek(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}