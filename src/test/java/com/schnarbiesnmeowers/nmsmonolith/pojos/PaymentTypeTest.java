package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the PaymentType class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PaymentTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PaymentType classUnderTest = new PaymentType();
		classUnderTest.setPaymentTypeId(new Integer(1));
		classUnderTest.setPaymentTypeCde("a");
		classUnderTest.setPaymentTypeDesc("a");
		classUnderTest.setImageLoc(new Integer(1));
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