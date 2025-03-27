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

import com.schnarbiesnmeowers.nmsmonolith.repositories.BloodPressureRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BloodPressureDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BloodPressureService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BloodPressureController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class BloodPressureControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private BloodPressureController bloodpressureController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private BloodPressureService bloodpressureService;

    @Mock
    private BloodPressureRepository bloodpressureRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(bloodpressureController).build();
    }

	/**
	 * test creating a new BloodPressure
	 * @throws 
	 */
	@Test
	public void testA_CreateBloodPressure() throws Exception
	{
	    BloodPressureDTO bloodpressure = generateRandomBloodPressure();
        when(bloodpressureService.createBloodPressure(any(BloodPressureDTO.class))).thenReturn(bloodpressure);

        mockMvc.perform(post("/bloodpressure/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bloodpressure)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all BloodPressure
	 * @throws 
	 */
	@Test
	public void testB_GetAllBloodPressure() throws Exception
	{
		List<BloodPressureDTO> bloodpressures = Arrays.asList(generateRandomBloodPressure(), generateRandomBloodPressure());
        when(bloodpressureService.getAllBloodPressure()).thenReturn(bloodpressures);

        mockMvc.perform(get("/bloodpressure/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single BloodPressure by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetBloodPressure() throws Exception
	{
		BloodPressureDTO bloodpressure = generateRandomBloodPressure();
        when(bloodpressureService.findBloodPressureById(anyInt())).thenReturn(bloodpressure);

        mockMvc.perform(get("/bloodpressure/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a BloodPressure
	 * @throws 
	 */
	@Test
	public void testD_UpdateBloodPressure() throws Exception
	{
	    BloodPressureDTO bloodpressure = generateRandomBloodPressure();
        when(bloodpressureService.updateBloodPressure(any(BloodPressureDTO.class))).thenReturn(bloodpressure);

        mockMvc.perform(post("/bloodpressure/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bloodpressure)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a BloodPressure
	 * @throws 
	 */
	@Test
	public void testE_DeleteBloodPressure() throws Exception
	{
		when(bloodpressureService.deleteBloodPressure(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/bloodpressure/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single BloodPressure by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<BloodPressureDTO> bloodpressure = Arrays.asList(generateRandomBloodPressure());
    when(bloodpressureService.findBloodPressureByUserId(anyInt())).thenReturn(bloodpressure);

    mockMvc.perform(get("/bloodpressure/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static BloodPressureDTO generateRandomBloodPressure() {
		BloodPressureDTO record = new BloodPressureDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setSystolic(Randomizer.randomInt(1000));
		record.setDiastolic(Randomizer.randomInt(1000));
		record.setPulse(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}