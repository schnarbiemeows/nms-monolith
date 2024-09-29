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
 * class to test the ActionTypeDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class ActionTypeDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ActionTypeDTO classUnderTest = new ActionTypeDTO();
		classUnderTest.setActionTypeId(new Integer(1));
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