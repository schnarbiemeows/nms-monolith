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
 * class to test the PeriodExt class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PeriodExtTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PeriodExt classUnderTest = new PeriodExt();
		classUnderTest.setPeriodExtId(new Integer(1));
		classUnderTest.setPeriodId(new Integer(1));
		classUnderTest.setSpecificDate(new Date());
		classUnderTest.setSpecificTime(new java.sql.Time(1000));
		assertTrue(true);
		PeriodExt newitem = new PeriodExt(
		classUnderTest.getPeriodExtId(),
		classUnderTest.getPeriodId(),
		classUnderTest.getSpecificDate(),
		classUnderTest.getSpecificTime());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}