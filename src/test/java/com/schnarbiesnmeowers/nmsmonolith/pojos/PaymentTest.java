package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Payment;




import java.math.*;



/**
 * class to test the Payment class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PaymentTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		Payment classUnderTest = new Payment();
		classUnderTest.setPaymentId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setPaymentTypeId(1);
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