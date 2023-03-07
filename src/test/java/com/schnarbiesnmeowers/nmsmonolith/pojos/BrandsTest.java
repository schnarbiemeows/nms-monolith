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
 * class to test the Brands class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class BrandsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Brands classUnderTest = new Brands();
		classUnderTest.setBrandId(new Integer(1));
		classUnderTest.setBrandType("a");
		classUnderTest.setBrandName("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		Brands newitem = new Brands(
		classUnderTest.getBrandId(),
		classUnderTest.getBrandType(),
		classUnderTest.getBrandName(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}