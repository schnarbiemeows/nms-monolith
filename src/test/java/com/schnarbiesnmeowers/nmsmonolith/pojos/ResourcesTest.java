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
 * class to test the Resources class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ResourcesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Resources classUnderTest = new Resources();
		classUnderTest.setRsrcId(new Integer(1));
		classUnderTest.setRsrcTypeId(new Integer(1));
		classUnderTest.setRsrcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Resources newitem = new Resources(
		classUnderTest.getRsrcId(),
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}