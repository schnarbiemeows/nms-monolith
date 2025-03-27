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

import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyJournalRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyJournalDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyJournalService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyJournalController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DailyJournalControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DailyJournalController dailyjournalController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DailyJournalService dailyjournalService;

    @Mock
    private DailyJournalRepository dailyjournalRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(dailyjournalController).build();
    }

	/**
	 * test creating a new DailyJournal
	 * @throws 
	 */
	@Test
	public void testA_CreateDailyJournal() throws Exception
	{
	    DailyJournalDTO dailyjournal = generateRandomDailyJournal();
        when(dailyjournalService.createDailyJournal(any(DailyJournalDTO.class))).thenReturn(dailyjournal);

        mockMvc.perform(post("/dailyjournal/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailyjournal)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DailyJournal
	 * @throws 
	 */
	@Test
	public void testB_GetAllDailyJournal() throws Exception
	{
		List<DailyJournalDTO> dailyjournals = Arrays.asList(generateRandomDailyJournal(), generateRandomDailyJournal());
        when(dailyjournalService.getAllDailyJournal()).thenReturn(dailyjournals);

        mockMvc.perform(get("/dailyjournal/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DailyJournal by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDailyJournal() throws Exception
	{
		DailyJournalDTO dailyjournal = generateRandomDailyJournal();
        when(dailyjournalService.findDailyJournalById(anyInt())).thenReturn(dailyjournal);

        mockMvc.perform(get("/dailyjournal/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DailyJournal
	 * @throws 
	 */
	@Test
	public void testD_UpdateDailyJournal() throws Exception
	{
	    DailyJournalDTO dailyjournal = generateRandomDailyJournal();
        when(dailyjournalService.updateDailyJournal(any(DailyJournalDTO.class))).thenReturn(dailyjournal);

        mockMvc.perform(post("/dailyjournal/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailyjournal)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DailyJournal
	 * @throws 
	 */
	@Test
	public void testE_DeleteDailyJournal() throws Exception
	{
		when(dailyjournalService.deleteDailyJournal(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/dailyjournal/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single DailyJournal by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<DailyJournalDTO> dailyjournal = Arrays.asList(generateRandomDailyJournal());
    when(dailyjournalService.findDailyJournalByUserId(anyInt())).thenReturn(dailyjournal);

    mockMvc.perform(get("/dailyjournal/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static DailyJournalDTO generateRandomDailyJournal() {
		DailyJournalDTO record = new DailyJournalDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setNote(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}