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
 * class to test the Roles class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RolesTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Roles classUnderTest = new Roles();
		classUnderTest.setRoleId(new Integer(1));
		classUnderTest.setGrpId(new Integer(1));
		classUnderTest.setRsrcId(new Integer(1));
		classUnderTest.setActionTypeId(new Integer(1));
		assertTrue(true);
		Roles newitem = new Roles(
		classUnderTest.getRoleId(),
		classUnderTest.getGrpId(),
		classUnderTest.getRsrcId(),
		classUnderTest.getActionTypeId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}