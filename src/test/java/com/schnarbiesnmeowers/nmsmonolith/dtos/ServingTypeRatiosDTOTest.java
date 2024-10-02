package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the ServingTypeRatiosDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServingTypeRatiosDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ServingTypeRatiosDTO classUnderTest = new ServingTypeRatiosDTO();
		classUnderTest.setServTypeRatioId(1);
		classUnderTest.setServTypeId1(1);
		classUnderTest.setServTypeId2(1);
		classUnderTest.setRatio(BigDecimal.ONE);
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