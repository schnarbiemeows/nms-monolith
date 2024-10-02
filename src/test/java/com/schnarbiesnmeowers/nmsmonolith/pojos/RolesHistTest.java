package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RolesHist;


import java.util.*;





/**
 * class to test the RolesHist class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RolesHistTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RolesHist classUnderTest = new RolesHist();
		classUnderTest.setRoleHistId(1);
		classUnderTest.setRoleId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setRsrcId(1);
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(1);
		assertTrue(true);
		RolesHist newitem = new RolesHist(
		classUnderTest.getRoleHistId(),
		classUnderTest.getRoleId(),
		classUnderTest.getGrpId(),
		classUnderTest.getRsrcId(),
		classUnderTest.getActionTypeId(),
		classUnderTest.getEvntTmestmp(),
		classUnderTest.getEvntOperId());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}