package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GroupsHist;


import java.util.*;





/**
 * class to test the GroupsHist class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GroupsHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GroupsHist classUnderTest = new GroupsHist();
		classUnderTest.setGrpHistId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(1);
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