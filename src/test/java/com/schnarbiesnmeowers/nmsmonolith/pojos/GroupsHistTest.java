package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.GroupsHist;
import java.math.*;


/**
 * class to test the GroupsHist class
 * @author Dylan I. Kessler
 *
 */
public class GroupsHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		GroupsHist classUnderTest = new GroupsHist();
		classUnderTest.setGrpHistId(2);
		classUnderTest.setGrpId(2);
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		classUnderTest.setActionTypeId(2);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(2);
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