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
 * class to test the ResourcesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ResourcesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ResourcesDTO classUnderTest = new ResourcesDTO();
		classUnderTest.setRsrcId(new Integer(1));
		classUnderTest.setRsrcTypeId(new Integer(1));
		classUnderTest.setRsrcDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		ResourcesDTO newitem = new ResourcesDTO(
		classUnderTest.getRsrcId(),
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}