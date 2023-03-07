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
 * class to test the PeriodType class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PeriodTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PeriodType classUnderTest = new PeriodType();
		classUnderTest.setPeriodTypeId(new Integer(1));
		classUnderTest.setPeriodTypeCde("a");
		classUnderTest.setPeriodTypeDesc("a");
		assertTrue(true);
		PeriodType newitem = new PeriodType(
		classUnderTest.getPeriodTypeId(),
		classUnderTest.getPeriodTypeCde(),
		classUnderTest.getPeriodTypeDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}