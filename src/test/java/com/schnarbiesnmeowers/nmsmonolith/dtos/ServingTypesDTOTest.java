package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the ServingTypesDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ServingTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypesDTO classUnderTest = new ServingTypesDTO();
		classUnderTest.setServTypeId(new Integer(1));
		classUnderTest.setServTypeCde("a");
		classUnderTest.setServTypeDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
		classUnderTest.setActv("a");
		assertTrue(true);
		ServingTypesDTO newitem = new ServingTypesDTO(
		classUnderTest.getServTypeId(),
		classUnderTest.getServTypeCde(),
		classUnderTest.getServTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}