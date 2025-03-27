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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.PaymentType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PaymentTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class PaymentTypeServiceTest {

    @Mock
    private PaymentTypeRepository paymenttypeRepository;

    @InjectMocks
    private PaymentTypeService paymenttypeService;

    private PaymentType paymenttype;
    private PaymentTypeDTO paymenttypeDTO;

    @BeforeEach
    void setUp() {
        paymenttype = generateRandomPaymentTypeEntity();
        paymenttypeDTO = generateRandomPaymentType();
    }

    @Test
    void testGetAllPaymentType() throws Exception {
        when(paymenttypeRepository.findAll()).thenReturn(Collections.singletonList(paymenttype));

        List<PaymentTypeDTO> result = paymenttypeService.getAllPaymentType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindPaymentTypeById_Found() throws Exception {
        when(paymenttypeRepository.findById(anyInt())).thenReturn(Optional.of(paymenttype));

        PaymentTypeDTO result = paymenttypeService.findPaymentTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindPaymentTypeById_NotFound() {
        when(paymenttypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            paymenttypeService.findPaymentTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreatePaymentType() {
        when(paymenttypeRepository.save(any(PaymentType.class))).thenReturn(paymenttype);

        PaymentTypeDTO result = paymenttypeService.createPaymentType(paymenttypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePaymentType_Found() throws Exception {
        when(paymenttypeRepository.findById(anyInt())).thenReturn(Optional.of(paymenttype));
        when(paymenttypeRepository.save(any(PaymentType.class))).thenReturn(paymenttype);

        PaymentTypeDTO result = paymenttypeService.updatePaymentType(paymenttypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePaymentType_NotFound() {
        when(paymenttypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            paymenttypeService.updatePaymentType(paymenttypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeletePaymentType_Found() throws Exception {
        when(paymenttypeRepository.findById(anyInt())).thenReturn(Optional.of(paymenttype));
        doNothing().when(paymenttypeRepository).deleteById(anyInt());

        String result = paymenttypeService.deletePaymentType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeletePaymentType_NotFound() {
        when(paymenttypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            paymenttypeService.deletePaymentType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static PaymentTypeDTO generateRandomPaymentType() {
		PaymentTypeDTO record = new PaymentTypeDTO();
		record.setPaymentTypeId(2);
		record.setPaymentTypeCde(Randomizer.randomString(10));
		record.setPaymentTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static PaymentType generateRandomPaymentTypeEntity() {
		PaymentType record = new PaymentType();
		record.setPaymentTypeId(2);
		record.setPaymentTypeCde(Randomizer.randomString(10));
		record.setPaymentTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
