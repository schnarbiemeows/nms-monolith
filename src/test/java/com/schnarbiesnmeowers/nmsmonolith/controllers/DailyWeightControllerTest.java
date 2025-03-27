package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyWeightRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyWeightService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyWeightController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DailyWeightControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DailyWeightController dailyweightController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DailyWeightService dailyweightService;

    @Mock
    private DailyWeightRepository dailyweightRepository;

	private ObjectMapper objectMapper = new ObjectMapper();


	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		mockMvc = MockMvcBuilders.standaloneSetup(dailyweightController).build();
    }

	/**
	 * test creating a new DailyWeight
	 * @throws 
	 */
	@Test
	public void testA_CreateDailyWeight() throws Exception
	{
	    DailyWeightDataPoint dailyweight = createRandomDailyDietDataPoint();
        when(dailyweightService.createDailyWeight(any(DailyWeightDataPoint.class))).thenReturn(dailyweight);

        mockMvc.perform(post("/dailyweight/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailyweight)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DailyWeight
	 * @throws 
	 */
	@Test
	public void testB_GetAllDailyWeight() throws Exception
	{
		List<DailyWeightDataPoint> dailyweights = Arrays.asList(createRandomDailyDietDataPoint(), createRandomDailyDietDataPoint());
        when(dailyweightService.getAllDailyWeight()).thenReturn(dailyweights);

        mockMvc.perform(get("/dailyweight/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DailyWeight by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDailyWeight() throws Exception
	{
		DailyWeightDataPoint dailyweight = createRandomDailyDietDataPoint();
        when(dailyweightService.findDailyWeightById(anyInt())).thenReturn(dailyweight);

        mockMvc.perform(get("/dailyweight/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DailyWeight
	 * @throws 
	 */
	@Test
	public void testD_UpdateDailyWeight() throws Exception
	{
	    DailyWeightDataPoint dailyweight = createRandomDailyDietDataPoint();
        when(dailyweightService.updateDailyWeight(any(DailyWeightDataPoint.class))).thenReturn(dailyweight);

        mockMvc.perform(post("/dailyweight/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailyweight)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DailyWeight
	 * @throws 
	 */
	@Test
	public void testE_DeleteDailyWeight() throws Exception
	{
		when(dailyweightService.deleteDailyWeight(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/dailyweight/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single DailyWeight by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<DailyWeightDataPoint> dailyweight = Arrays.asList(createRandomDailyDietDataPoint());
    when(dailyweightService.findDailyWeightByUserId(anyInt())).thenReturn(dailyweight);

    mockMvc.perform(get("/dailyweight/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static DailyWeightDTO generateRandomDailyWeight() {
		DailyWeightDTO record = new DailyWeightDTO();
		record.setMissingDates(new ArrayList<>());
		record.setDayRange(10);
		record.setMin(Randomizer.randomBigDecimal("3"));
		record.setMax(Randomizer.randomBigDecimal("3"));
		record.setData(new ArrayList<>());
		record.setAverage(Randomizer.randomBigDecimal("3"));
		record.setMissingData(new ArrayList<>());
		return record;
	}

	public static DailyWeightDataPoint createRandomDailyDietDataPoint() {
		DailyWeightDataPoint dto = new DailyWeightDataPoint();
		dto.setCalendarDate(Randomizer.randomLocalDate());
		dto.setWeight(Randomizer.randomBigDecimal("3"));
		dto.setDailyWeightId(Randomizer.randomInt(2));
		dto.setUserId(Randomizer.randomInt(9));
		return dto;
	}
}