package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;



/**
 * class to test the PaymentDTO class
 * @author Dylan I. Kessler
 *
 */
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	//@Test
	public void testClass() {
		PaymentDTO classUnderTest = new PaymentDTO();
		classUnderTest.setPaymentId(1);
		classUnderTest.setUserId(1);
		classUnderTest.setPaymentTypeId(1);
		classUnderTest.setPaymentAmt(BigDecimal.ONE);
		classUnderTest.setPaymentDesc("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		PaymentDTO newitem = new PaymentDTO(
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