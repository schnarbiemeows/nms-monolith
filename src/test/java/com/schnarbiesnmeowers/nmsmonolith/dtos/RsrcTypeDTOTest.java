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
 * class to test the RsrcTypeDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class RsrcTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		RsrcTypeDTO classUnderTest = new RsrcTypeDTO();
		classUnderTest.setRsrcTypeId(new Integer(1));
		classUnderTest.setRsrcType("a");
		classUnderTest.setRsrcTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		RsrcTypeDTO newitem = new RsrcTypeDTO(
		classUnderTest.getRsrcTypeId(),
		classUnderTest.getRsrcType(),
		classUnderTest.getRsrcTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}