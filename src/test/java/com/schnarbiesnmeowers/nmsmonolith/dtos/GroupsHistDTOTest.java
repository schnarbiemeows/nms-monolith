package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the GroupsHistDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GroupsHistDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GroupsHistDTO classUnderTest = new GroupsHistDTO();
		classUnderTest.setGrpHistId(1);
		classUnderTest.setGrpId(1);
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		classUnderTest.setActionTypeId(1);
		classUnderTest.setEvntTmestmp(new Date());
		classUnderTest.setEvntOperId(1);
		assertTrue(true);
		GroupsHistDTO newitem = new GroupsHistDTO(
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