package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUserHist;


import java.util.*;





/**
 * class to test the GrpUserHist class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GrpUserHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GrpUserHist classUnderTest = new GrpUserHist();
		classUnderTest.setGrpUserHistId(1);
		classUnderTest.setGrpUserId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(1);
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