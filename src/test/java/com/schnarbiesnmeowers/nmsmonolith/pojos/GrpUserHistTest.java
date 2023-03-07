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
 * class to test the GrpUserHist class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GrpUserHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GrpUserHist classUnderTest = new GrpUserHist();
		classUnderTest.setGrpUserHistId(new Integer(1));
		classUnderTest.setGrpUserId(new Integer(1));
		classUnderTest.setGrpId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setActionTypeId(new Integer(1));
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(new Integer(1));
		assertTrue(true);
		GrpUserHist newitem = new GrpUserHist(
		classUnderTest.getGrpUserHistId(),
		classUnderTest.getGrpUserId(),
		classUnderTest.getGrpId(),
		classUnderTest.getUserId(),
		classUnderTest.getActionTypeId(),
		classUnderTest.getEvntTmestmp(),
		classUnderTest.getEvntOperId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}