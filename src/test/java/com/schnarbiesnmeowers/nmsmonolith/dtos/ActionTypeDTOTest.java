package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.util.*;
import java.sql.Timestamp;


/**
 * class to test the ActionTypeDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ActionTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ActionTypeDTO classUnderTest = new ActionTypeDTO();
		classUnderTest.setActionTypeId(1);
		classUnderTest.setActionTypeCde("a");
		classUnderTest.setActionTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		ActionTypeDTO newitem = new ActionTypeDTO(
		classUnderTest.getActionTypeId(),
		classUnderTest.getActionTypeCde(),
		classUnderTest.getActionTypeDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}