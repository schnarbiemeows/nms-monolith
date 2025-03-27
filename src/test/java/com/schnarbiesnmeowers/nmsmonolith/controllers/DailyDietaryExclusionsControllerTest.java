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

import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietaryExclusionsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietaryExclusionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietaryExclusionsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietaryExclusionsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DailyDietaryExclusionsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DailyDietaryExclusionsController dailydietaryexclusionsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DailyDietaryExclusionsService dailydietaryexclusionsService;

    @Mock
    private DailyDietaryExclusionsRepository dailydietaryexclusionsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(dailydietaryexclusionsController).build();
    }

	/**
	 * test creating a new DailyDietaryExclusions
	 * @throws 
	 */
	@Test
	public void testA_CreateDailyDietaryExclusions() throws Exception
	{
	    DailyDietaryExclusionsDTO dailydietaryexclusions = generateRandomDailyDietaryExclusions();
        when(dailydietaryexclusionsService.createDailyDietaryExclusions(any(DailyDietaryExclusionsDTO.class))).thenReturn(dailydietaryexclusions);

        mockMvc.perform(post("/dailydietaryexclusions/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydietaryexclusions)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DailyDietaryExclusions
	 * @throws 
	 */
	@Test
	public void testB_GetAllDailyDietaryExclusions() throws Exception
	{
		List<DailyDietaryExclusionsDTO> dailydietaryexclusionss = Arrays.asList(generateRandomDailyDietaryExclusions(), generateRandomDailyDietaryExclusions());
        when(dailydietaryexclusionsService.getAllDailyDietaryExclusions()).thenReturn(dailydietaryexclusionss);

        mockMvc.perform(get("/dailydietaryexclusions/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DailyDietaryExclusions by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDailyDietaryExclusions() throws Exception
	{
		DailyDietaryExclusionsDTO dailydietaryexclusions = generateRandomDailyDietaryExclusions();
        when(dailydietaryexclusionsService.findDailyDietaryExclusionsById(anyInt())).thenReturn(dailydietaryexclusions);

        mockMvc.perform(get("/dailydietaryexclusions/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DailyDietaryExclusions
	 * @throws 
	 */
	@Test
	public void testD_UpdateDailyDietaryExclusions() throws Exception
	{
	    DailyDietaryExclusionsDTO dailydietaryexclusions = generateRandomDailyDietaryExclusions();
        when(dailydietaryexclusionsService.updateDailyDietaryExclusions(any(DailyDietaryExclusionsDTO.class))).thenReturn(dailydietaryexclusions);

        mockMvc.perform(post("/dailydietaryexclusions/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydietaryexclusions)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DailyDietaryExclusions
	 * @throws 
	 */
	@Test
	public void testE_DeleteDailyDietaryExclusions() throws Exception
	{
		when(dailydietaryexclusionsService.deleteDailyDietaryExclusions(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/dailydietaryexclusions/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single DailyDietaryExclusions by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<DailyDietaryExclusionsDTO> dailydietaryexclusions = Arrays.asList(generateRandomDailyDietaryExclusions());
    when(dailydietaryexclusionsService.findDailyDietaryExclusionsByUserId(anyInt())).thenReturn(dailydietaryexclusions);

    mockMvc.perform(get("/dailydietaryexclusions/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static DailyDietaryExclusionsDTO generateRandomDailyDietaryExclusions() {
		DailyDietaryExclusionsDTO record = new DailyDietaryExclusionsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		return record;
	}
}