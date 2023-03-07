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
 * class to test the ActionType class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ActionTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ActionType classUnderTest = new ActionType();
		classUnderTest.setActionTypeId(new Integer(1));
		classUnderTest.setActionTypeCde("a");
		classUnderTest.setActionTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		ActionType newitem = new ActionType(
		classUnderTest.getActionTypeId(),
		classUnderTest.getActionTypeCde(),
		classUnderTest.getActionTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}