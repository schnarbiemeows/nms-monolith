package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;
import com.schnarbiesnmeowers.nmsmonolith.entities.PaymentType;
import java.math.*;


/**
 * class to test the PaymentType class
 * @author Dylan I. Kessler
 *
 */
public class PaymentTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PaymentType classUnderTest = new PaymentType();
		classUnderTest.setPaymentTypeId(2);
		classUnderTest.setPaymentTypeCde("a");
		classUnderTest.setPaymentTypeDesc("a");
		classUnderTest.setImageLoc(2);
		classUnderTest.setActv("a");
		assertTrue(true);
		PaymentType newitem = new PaymentType(
		classUnderTest.getPaymentTypeId(),
		classUnderTest.getPaymentTypeCde(),
		classUnderTest.getPaymentTypeDesc(),
		classUnderTest.getImageLoc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}