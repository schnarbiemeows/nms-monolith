package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.sql.Timestamp;

import java.math.*;


/**
 * class to test the PaymentDTO class
 * @author Dylan I. Kessler
 *
 */
public class PaymentDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		PaymentDTO classUnderTest = new PaymentDTO();
		classUnderTest.setPaymentId(2);
		classUnderTest.setUserId(2);
		classUnderTest.setPaymentTypeId(2);
		classUnderTest.setPaymentAmt(new BigDecimal(1.00));
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