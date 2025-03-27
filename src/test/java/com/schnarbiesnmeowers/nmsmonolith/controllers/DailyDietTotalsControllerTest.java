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

import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietTotalsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietTotalsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietTotalsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DailyDietTotalsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DailyDietTotalsController dailydiettotalsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DailyDietTotalsService dailydiettotalsService;

    @Mock
    private DailyDietTotalsRepository dailydiettotalsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(dailydiettotalsController).build();
    }

	/**
	 * test creating a new DailyDietTotals
	 * @throws 
	 */
	@Test
	public void testA_CreateDailyDietTotals() throws Exception
	{
	    DailyDietTotalsDTO dailydiettotals = generateRandomDailyDietTotals();
        when(dailydiettotalsService.createDailyDietTotals(any(DailyDietTotalsDTO.class))).thenReturn(dailydiettotals);

        mockMvc.perform(post("/dailydiettotals/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydiettotals)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DailyDietTotals
	 * @throws 
	 */
	@Test
	public void testB_GetAllDailyDietTotals() throws Exception
	{
		List<DailyDietTotalsDTO> dailydiettotalss = Arrays.asList(generateRandomDailyDietTotals(), generateRandomDailyDietTotals());
        when(dailydiettotalsService.getAllDailyDietTotals()).thenReturn(dailydiettotalss);

        mockMvc.perform(get("/dailydiettotals/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DailyDietTotals by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDailyDietTotals() throws Exception
	{
		DailyDietTotalsDTO dailydiettotals = generateRandomDailyDietTotals();
        when(dailydiettotalsService.findDailyDietTotalsById(anyInt())).thenReturn(dailydiettotals);

        mockMvc.perform(get("/dailydiettotals/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DailyDietTotals
	 * @throws 
	 */
	@Test
	public void testD_UpdateDailyDietTotals() throws Exception
	{
	    DailyDietTotalsDTO dailydiettotals = generateRandomDailyDietTotals();
        when(dailydiettotalsService.updateDailyDietTotals(any(DailyDietTotalsDTO.class))).thenReturn(dailydiettotals);

        mockMvc.perform(post("/dailydiettotals/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydiettotals)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DailyDietTotals
	 * @throws 
	 */
	@Test
	public void testE_DeleteDailyDietTotals() throws Exception
	{
		when(dailydiettotalsService.deleteDailyDietTotals(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/dailydiettotals/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single DailyDietTotals by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<DailyDietTotalsDTO> dailydiettotals = Arrays.asList(generateRandomDailyDietTotals());
    when(dailydiettotalsService.findDailyDietTotalsByUserId(anyInt())).thenReturn(dailydiettotals);

    mockMvc.perform(get("/dailydiettotals/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single DailyDietTotals by field BldstId
 * @throws
 */
@Test
public void testC_findByBldstId() throws Exception
{
    List<DailyDietTotalsDTO> dailydiettotals = Arrays.asList(generateRandomDailyDietTotals());
    when(dailydiettotalsService.findDailyDietTotalsByBldstId(anyInt())).thenReturn(dailydiettotals);

    mockMvc.perform(get("/dailydiettotals/findByBldstId/2"))
            .andExpect(status().isOk());
}

	public static DailyDietTotalsDTO generateRandomDailyDietTotals() {
		DailyDietTotalsDTO record = new DailyDietTotalsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}