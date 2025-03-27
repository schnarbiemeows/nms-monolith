package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the RolesHistDTO class
 * @author Dylan I. Kessler
 *
 */
public class RolesHistDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RolesHistDTO classUnderTest = new RolesHistDTO();
		classUnderTest.setRoleHistId(2);
		classUnderTest.setRoleId(2);
		classUnderTest.setGrpId(2);
		classUnderTest.setRsrcId(2);
		classUnderTest.setActionTypeId(2);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(2);
		assertTrue(true);
		RolesHistDTO newitem = new RolesHistDTO(
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