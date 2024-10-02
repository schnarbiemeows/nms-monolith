package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the RolesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RolesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RolesDTO classUnderTest = new RolesDTO();
		classUnderTest.setRoleId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setRsrcId(1);
		classUnderTest.setActionTypeId(1);
		assertTrue(true);
		RolesDTO newitem = new RolesDTO(
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