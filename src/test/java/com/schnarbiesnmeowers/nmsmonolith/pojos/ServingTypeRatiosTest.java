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
 * class to test the ServingTypeRatios class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ServingTypeRatiosTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ServingTypeRatios classUnderTest = new ServingTypeRatios();
		classUnderTest.setServTypeRatioId(new Integer(1));
		classUnderTest.setServTypeId1(new Integer(1));
		classUnderTest.setServTypeId2(new Integer(1));
		classUnderTest.setRatio(new BigDecimal(1.00));
		assertTrue(true);
		ServingTypeRatios newitem = new ServingTypeRatios(
		classUnderTest.getServTypeRatioId(),
		classUnderTest.getServTypeId1(),
		classUnderTest.getServTypeId2(),
		classUnderTest.getRatio());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}