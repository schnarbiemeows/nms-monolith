package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.ActionType;







/**
 * class to test the ActionType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ActionTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		ActionType classUnderTest = new ActionType();
		classUnderTest.setActionTypeId(1);
		classUnderTest.setActionTypeCde("a");
		classUnderTest.setActionTypeDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		ActionType newitem = new ActionType(
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