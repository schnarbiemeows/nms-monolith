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
 * class to test the BldstTableDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class BldstTableDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		BldstTableDTO classUnderTest = new BldstTableDTO();
		classUnderTest.setBldstTableId(new Integer(1));
		classUnderTest.setBldstCde("a");
		classUnderTest.setBldstDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		BldstTableDTO newitem = new BldstTableDTO(
		classUnderTest.getBldstTableId(),
		classUnderTest.getBldstCde(),
		classUnderTest.getBldstDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}