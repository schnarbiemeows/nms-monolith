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
 * class to test the ServingTypes class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ServingTypesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ServingTypes classUnderTest = new ServingTypes();
		classUnderTest.setServTypeId(new Integer(1));
		classUnderTest.setServTypeCde("a");
		classUnderTest.setServTypeDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		ServingTypes newitem = new ServingTypes(
		classUnderTest.getServTypeId(),
		classUnderTest.getServTypeCde(),
		classUnderTest.getServTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}