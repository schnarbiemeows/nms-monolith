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
 * class to test the BrandIngrType class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class BrandIngrTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BrandIngrType classUnderTest = new BrandIngrType();
		classUnderTest.setBrandIngrTypeId(new Integer(1));
		classUnderTest.setBrandId(new Integer(1));
		classUnderTest.setIngrTypeId(new Integer(1));
		classUnderTest.setPrntIngrType(new Integer(1));
		assertTrue(true);
		BrandIngrType newitem = new BrandIngrType(
		classUnderTest.getBrandIngrTypeId(),
		classUnderTest.getBrandId(),
		classUnderTest.getIngrTypeId(),
		classUnderTest.getPrntIngrType());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}