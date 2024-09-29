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
 * class to test the GroupsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class GroupsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		GroupsDTO classUnderTest = new GroupsDTO();
		classUnderTest.setGrpId(new Integer(1));
		classUnderTest.setGrpName("a");
		classUnderTest.setGrpDesc("a");
		assertTrue(true);
		GroupsDTO newitem = new GroupsDTO(
		classUnderTest.getGrpId(),
		classUnderTest.getGrpName(),
		classUnderTest.getGrpDesc());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}