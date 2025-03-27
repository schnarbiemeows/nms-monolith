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

import com.schnarbiesnmeowers.nmsmonolith.repositories.PaymentTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PaymentTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PaymentTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class PaymentTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private PaymentTypeController paymenttypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private PaymentTypeService paymenttypeService;

    @Mock
    private PaymentTypeRepository paymenttypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(paymenttypeController).build();
    }

	/**
	 * test creating a new PaymentType
	 * @throws 
	 */
	@Test
	public void testA_CreatePaymentType() throws Exception
	{
	    PaymentTypeDTO paymenttype = generateRandomPaymentType();
        when(paymenttypeService.createPaymentType(any(PaymentTypeDTO.class))).thenReturn(paymenttype);

        mockMvc.perform(post("/paymenttype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paymenttype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all PaymentType
	 * @throws 
	 */
	@Test
	public void testB_GetAllPaymentType() throws Exception
	{
		List<PaymentTypeDTO> paymenttypes = Arrays.asList(generateRandomPaymentType(), generateRandomPaymentType());
        when(paymenttypeService.getAllPaymentType()).thenReturn(paymenttypes);

        mockMvc.perform(get("/paymenttype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single PaymentType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetPaymentType() throws Exception
	{
		PaymentTypeDTO paymenttype = generateRandomPaymentType();
        when(paymenttypeService.findPaymentTypeById(anyInt())).thenReturn(paymenttype);

        mockMvc.perform(get("/paymenttype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a PaymentType
	 * @throws 
	 */
	@Test
	public void testD_UpdatePaymentType() throws Exception
	{
	    PaymentTypeDTO paymenttype = generateRandomPaymentType();
        when(paymenttypeService.updatePaymentType(any(PaymentTypeDTO.class))).thenReturn(paymenttype);

        mockMvc.perform(post("/paymenttype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paymenttype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a PaymentType
	 * @throws 
	 */
	@Test
	public void testE_DeletePaymentType() throws Exception
	{
		when(paymenttypeService.deletePaymentType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/paymenttype/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single PaymentType by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<PaymentTypeDTO> paymenttype = Arrays.asList(generateRandomPaymentType());
    when(paymenttypeService.findPaymentTypeByImageLoc(anyInt())).thenReturn(paymenttype);

    mockMvc.perform(get("/paymenttype/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static PaymentTypeDTO generateRandomPaymentType() {
		PaymentTypeDTO record = new PaymentTypeDTO();
		record.setPaymentTypeCde(Randomizer.randomString(10));
		record.setPaymentTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}