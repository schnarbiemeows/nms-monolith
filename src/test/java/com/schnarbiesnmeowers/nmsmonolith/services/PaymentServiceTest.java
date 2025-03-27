package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Payment;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PaymentRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    private Payment payment;
    private PaymentDTO paymentDTO;

    @BeforeEach
    void setUp() {
        payment = generateRandomPaymentEntity();
        paymentDTO = generateRandomPayment();
    }

    @Test
    void testGetAllPayment() throws Exception {
        when(paymentRepository.findAll()).thenReturn(Collections.singletonList(payment));

        List<PaymentDTO> result = paymentService.getAllPayment();

        assertEquals(1, result.size());
    }

    @Test
    void testFindPaymentById_Found() throws Exception {
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));

        PaymentDTO result = paymentService.findPaymentById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindPaymentById_NotFound() {
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            paymentService.findPaymentById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreatePayment() {
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDTO result = paymentService.createPayment(paymentDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePayment_Found() throws Exception {
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDTO result = paymentService.updatePayment(paymentDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePayment_NotFound() {
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            paymentService.updatePayment(paymentDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeletePayment_Found() throws Exception {
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
        doNothing().when(paymentRepository).deleteById(anyInt());

        String result = paymentService.deletePayment(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeletePayment_NotFound() {
        when(paymentRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            paymentService.deletePayment(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static PaymentDTO generateRandomPayment() {
		PaymentDTO record = new PaymentDTO();
		record.setPaymentId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setPaymentTypeId(Randomizer.randomInt(1000));
		record.setPaymentAmt(Randomizer.randomBigDecimal("1000"));
		record.setPaymentDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Payment generateRandomPaymentEntity() {
		Payment record = new Payment();
		record.setPaymentId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setPaymentTypeId(Randomizer.randomInt(1000));
		record.setPaymentAmt(Randomizer.randomBigDecimal("1000"));
		record.setPaymentDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
