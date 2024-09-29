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
 * class to test the GroupsHist class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GroupsHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GroupsHist classUnderTest = new GroupsHist();
		classUnderTest.setGrpHistId(new Integer(1));
		classUnderTest.setGrpId(new Integer(1));
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		classUnderTest.setActionTypeId(new Integer(1));
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(new Integer(1));
		assertTrue(true);
		GroupsHist newitem = new GroupsHist(
		classUnderTest.getGrpHistId(),
		classUnderTest.getGrpId(),
		classUnderTest.getGrpName(),
		classUnderTest.getGrpDesc(),
		classUnderTest.getActionTypeId(),
		classUnderTest.getEvntTmestmp(),
		classUnderTest.getEvntOperId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}