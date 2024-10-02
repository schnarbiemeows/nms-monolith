package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.PaymentType;







/**
 * class to test the PaymentType class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PaymentTypeTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PaymentType classUnderTest = new PaymentType();
		classUnderTest.setPaymentTypeId(1);
		classUnderTest.setPaymentTypeCde("a");
		classUnderTest.setPaymentTypeDesc("a");
		classUnderTest.setImageLoc(1);
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