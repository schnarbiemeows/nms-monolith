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

import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PeriodsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PeriodsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class PeriodsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private PeriodsController periodsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private PeriodsService periodsService;

    @Mock
    private PeriodsRepository periodsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(periodsController).build();
    }

	/**
	 * test creating a new Periods
	 * @throws 
	 */
	@Test
	public void testA_CreatePeriods() throws Exception
	{
	    PeriodsDTO periods = generateRandomPeriods();
        when(periodsService.createPeriods(any(PeriodsDTO.class))).thenReturn(periods);

        mockMvc.perform(post("/periods/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(periods)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Periods
	 * @throws 
	 */
	@Test
	public void testB_GetAllPeriods() throws Exception
	{
		List<PeriodsDTO> periodss = Arrays.asList(generateRandomPeriods(), generateRandomPeriods());
        when(periodsService.getAllPeriods()).thenReturn(periodss);

        mockMvc.perform(get("/periods/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Periods by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetPeriods() throws Exception
	{
		PeriodsDTO periods = generateRandomPeriods();
        when(periodsService.findPeriodsById(anyInt())).thenReturn(periods);

        mockMvc.perform(get("/periods/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Periods
	 * @throws 
	 */
	@Test
	public void testD_UpdatePeriods() throws Exception
	{
	    PeriodsDTO periods = generateRandomPeriods();
        when(periodsService.updatePeriods(any(PeriodsDTO.class))).thenReturn(periods);

        mockMvc.perform(post("/periods/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(periods)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Periods
	 * @throws 
	 */
	@Test
	public void testE_DeletePeriods() throws Exception
	{
		when(periodsService.deletePeriods(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/periods/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Periods by field PeriodTypeId
 * @throws
 */
@Test
public void testC_findByPeriodTypeId() throws Exception
{
    List<PeriodsDTO> periods = Arrays.asList(generateRandomPeriods());
    when(periodsService.findPeriodsByPeriodTypeId(anyInt())).thenReturn(periods);

    mockMvc.perform(get("/periods/findByPeriodTypeId/2"))
            .andExpect(status().isOk());
}

	public static PeriodsDTO generateRandomPeriods() {
		PeriodsDTO record = new PeriodsDTO();
		record.setPeriodTypeId(Randomizer.randomInt(1000));
		record.setOneTimeDate(Randomizer.randomDate());
		record.setDayOfWeek(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}