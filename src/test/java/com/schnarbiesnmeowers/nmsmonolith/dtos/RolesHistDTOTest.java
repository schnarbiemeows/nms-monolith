package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the RolesHistDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RolesHistDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		RolesHistDTO classUnderTest = new RolesHistDTO();
		classUnderTest.setRoleHistId(new Integer(1));
		classUnderTest.setRoleId(new Integer(1));
		classUnderTest.setGrpId(new Integer(1));
		classUnderTest.setRsrcId(new Integer(1));
		classUnderTest.setActionTypeId(new Integer(1));
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(new Integer(1));
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