package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUserHist;
import java.math.*;


/**
 * class to test the GrpUserHist class
 * @author Dylan I. Kessler
 *
 */
public class GrpUserHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GrpUserHist classUnderTest = new GrpUserHist();
		classUnderTest.setGrpUserHistId(2);
		classUnderTest.setGrpUserId(2);
		classUnderTest.setGrpId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setActionTypeId(2);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(2);
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