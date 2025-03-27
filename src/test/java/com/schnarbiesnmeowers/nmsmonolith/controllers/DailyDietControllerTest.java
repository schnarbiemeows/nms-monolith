package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietWrapper;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DailyDietControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DailyDietController dailydietController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DailyDietService dailydietService;

    @Mock
    private DailyDietRepository dailydietRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(dailydietController).build();
    }

	/**
	 * test creating a new DailyDiet
	 * @throws 
	 */
	@Test
	public void testA_CreateDailyDiet() throws Exception
	{
	    DailyDietWrapper dailydiet = generateRandomDailyDietWrapper();
        when(dailydietService.createDailyDiet(any(DailyDietDTO.class))).thenReturn(dailydiet);

        mockMvc.perform(post("/dailydiet/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydiet)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DailyDiet
	 * @throws 
	 */
	@Test
	public void testB_GetAllDailyDiet() throws Exception
	{
		List<DailyDietDTO> dailydiets = Arrays.asList(generateRandomDailyDiet(), generateRandomDailyDiet());
        when(dailydietService.getAllDailyDiet()).thenReturn(dailydiets);

        mockMvc.perform(get("/dailydiet/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DailyDiet by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDailyDiet() throws Exception
	{
		DailyDietDTO dailydiet = generateRandomDailyDiet();
        when(dailydietService.findDailyDietById(anyInt())).thenReturn(dailydiet);

        mockMvc.perform(get("/dailydiet/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DailyDiet
	 * @throws 
	 */
	@Test
	public void testD_UpdateDailyDiet() throws Exception
	{
		DailyDietWrapper dailydiet = generateRandomDailyDietWrapper();
        when(dailydietService.updateDailyDiet(any(DailyDietDTO.class))).thenReturn(dailydiet);

        mockMvc.perform(post("/dailydiet/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydiet)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DailyDiet
	 * @throws 
	 */
	@Test
	public void testE_DeleteDailyDiet() throws Exception
	{
		DailyDietWrapper dailydiet = generateRandomDailyDietWrapper();
		when(dailydietService.deleteDailyDiet(anyInt())).thenReturn(dailydiet);

        mockMvc.perform(delete("/dailydiet/delete/2"))
                .andExpect(status().isOk());
	}
	
	/**
	 * test getting a single DailyDiet by field UserId
	 * @throws
	 */
	@Test
	public void testC_findByUserId() throws Exception
	{
		List<DailyDietDTO> dailydiet = Arrays.asList(generateRandomDailyDiet());
		when(dailydietService.findDailyDietByUserId(anyInt())).thenReturn(dailydiet);
	
		mockMvc.perform(get("/dailydiet/findByUserId/2"))
				.andExpect(status().isOk());
	}/**
	 * test getting a single DailyDiet by field BldstId
	 * @throws
	 */
	@Test
	public void testC_findByBldstId() throws Exception
	{
		List<DailyDietDTO> dailydiet = Arrays.asList(generateRandomDailyDiet());
		when(dailydietService.findDailyDietByBldstId(anyInt())).thenReturn(dailydiet);
	
		mockMvc.perform(get("/dailydiet/findByBldstId/2"))
				.andExpect(status().isOk());
	}	

	public static DailyDietDTO generateRandomDailyDiet() {
		DailyDietDTO record = new DailyDietDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setIsLocal(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setTimeEaten(Randomizer.randomString(10));
		return record;
	}
	
	public static DailyDietWrapper generateRandomDailyDietWrapper() {
		DailyDietWrapper wrapper = new DailyDietWrapper();
		wrapper.setDailyTotals(new ArrayList<>());
		wrapper.setExclude(false);
		wrapper.setNotes(new DailyDietaryNotesDTO());
		wrapper.setSynced(true);
		wrapper.setUsername(Randomizer.randomString(10));
		wrapper.setUserId(Randomizer.randomInt(1000));
		wrapper.setDaysDate(Randomizer.randomDate());
		wrapper.setIngredients(new ArrayList<>());
		return wrapper;
	}
}