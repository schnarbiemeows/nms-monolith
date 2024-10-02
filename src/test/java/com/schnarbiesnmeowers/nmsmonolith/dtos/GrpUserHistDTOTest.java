package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GrpUserHistDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GrpUserHistDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GrpUserHistDTO classUnderTest = new GrpUserHistDTO();
		classUnderTest.setGrpUserHistId(1);
		classUnderTest.setGrpUserId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(1);
		assertTrue(true);
		GrpUserHistDTO newitem = new GrpUserHistDTO(
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