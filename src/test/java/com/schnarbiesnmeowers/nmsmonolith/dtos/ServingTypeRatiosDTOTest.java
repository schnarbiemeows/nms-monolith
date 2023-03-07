package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the ServingTypeRatiosDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ServingTypeRatiosDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		ServingTypeRatiosDTO classUnderTest = new ServingTypeRatiosDTO();
		classUnderTest.setServTypeRatioId(new Integer(1));
		classUnderTest.setServTypeId1(new Integer(1));
		classUnderTest.setServTypeId2(new Integer(1));
		classUnderTest.setRatio(new BigDecimal(1.00));
		assertTrue(true);
		ServingTypeRatiosDTO newitem = new ServingTypeRatiosDTO(
		classUnderTest.getServTypeRatioId(),
		classUnderTest.getServTypeId1(),
		classUnderTest.getServTypeId2(),
		classUnderTest.getRatio());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}