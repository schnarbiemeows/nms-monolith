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
 * class to test the PeriodExtDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PeriodExtDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PeriodExtDTO classUnderTest = new PeriodExtDTO();
		classUnderTest.setPeriodExtId(new Integer(1));
		classUnderTest.setPeriodId(new Integer(1));
		classUnderTest.setSpecificDate(new Date());
		classUnderTest.setSpecificTime(new java.sql.Time(1000));
		assertTrue(true);
		PeriodExtDTO newitem = new PeriodExtDTO(
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