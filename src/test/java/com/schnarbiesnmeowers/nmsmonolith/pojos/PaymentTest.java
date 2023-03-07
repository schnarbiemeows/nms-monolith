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
 * class to test the Payment class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class PaymentTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Payment classUnderTest = new Payment();
		classUnderTest.setPaymentId(new Integer(1));
		classUnderTest.setUserId(new Integer(1));
		classUnderTest.setPaymentTypeId(new Integer(1));
		classUnderTest.setPaymentAmt(new BigDecimal(1.00));
		classUnderTest.setPaymentDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Payment newitem = new Payment(
		classUnderTest.getPaymentId(),
		classUnderTest.getUserId(),
		classUnderTest.getPaymentTypeId(),
		classUnderTest.getPaymentAmt(),
		classUnderTest.getPaymentDesc(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}