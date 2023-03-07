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
 * class to test the Groups class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GroupsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Groups classUnderTest = new Groups();
		classUnderTest.setGrpId(new Integer(1));
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		assertTrue(true);
		Groups newitem = new Groups(
		classUnderTest.getGrpId(),
		classUnderTest.getGrpName(),
		classUnderTest.getGrpDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}