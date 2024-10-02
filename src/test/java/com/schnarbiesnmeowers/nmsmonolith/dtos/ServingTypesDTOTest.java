package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;

import java.math.BigDecimal;





/**
 * class to test the ServingTypesDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class ServingTypesDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ServingTypesDTO classUnderTest = new ServingTypesDTO();
		classUnderTest.setServTypeId(1);
		classUnderTest.setServTypeCde("a");
		classUnderTest.setServTypeDesc("a");
		classUnderTest.setImageLoc(1);
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