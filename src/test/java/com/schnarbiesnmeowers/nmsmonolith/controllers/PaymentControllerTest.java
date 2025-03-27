package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.repositories.PaymentRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PaymentService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PaymentController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private PaymentController paymentController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

	/**
	 * test creating a new Payment
	 * @throws 
	 */
	@Test
	public void testA_CreatePayment() throws Exception
	{
	    PaymentDTO payment = generateRandomPayment();
        when(paymentService.createPayment(any(PaymentDTO.class))).thenReturn(payment);

        mockMvc.perform(post("/payment/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payment)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Payment
	 * @throws 
	 */
	@Test
	public void testB_GetAllPayment() throws Exception
	{
		List<PaymentDTO> payments = Arrays.asList(generateRandomPayment(), generateRandomPayment());
        when(paymentService.getAllPayment()).thenReturn(payments);

        mockMvc.perform(get("/payment/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Payment by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetPayment() throws Exception
	{
		PaymentDTO payment = generateRandomPayment();
        when(paymentService.findPaymentById(anyInt())).thenReturn(payment);

        mockMvc.perform(get("/payment/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Payment
	 * @throws 
	 */
	@Test
	public void testD_UpdatePayment() throws Exception
	{
	    PaymentDTO payment = generateRandomPayment();
        when(paymentService.updatePayment(any(PaymentDTO.class))).thenReturn(payment);

        mockMvc.perform(post("/payment/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(payment)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Payment
	 * @throws 
	 */
	@Test
	public void testE_DeletePayment() throws Exception
	{
		when(paymentService.deletePayment(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/payment/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Payment by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<PaymentDTO> payment = Arrays.asList(generateRandomPayment());
    when(paymentService.findPaymentByUserId(anyInt())).thenReturn(payment);

    mockMvc.perform(get("/payment/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Payment by field PaymentTypeId
 * @throws
 */
@Test
public void testC_findByPaymentTypeId() throws Exception
{
    List<PaymentDTO> payment = Arrays.asList(generateRandomPayment());
    when(paymentService.findPaymentByPaymentTypeId(anyInt())).thenReturn(payment);

    mockMvc.perform(get("/payment/findByPaymentTypeId/2"))
            .andExpect(status().isOk());
}

	public static PaymentDTO generateRandomPayment() {
		PaymentDTO record = new PaymentDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setPaymentTypeId(Randomizer.randomInt(1000));
		record.setPaymentAmt(Randomizer.randomBigDecimal("1000"));
		record.setPaymentDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}