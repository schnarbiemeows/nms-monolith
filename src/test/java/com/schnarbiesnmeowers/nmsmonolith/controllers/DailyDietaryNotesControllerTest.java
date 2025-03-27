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

import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietaryNotesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietaryNotesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietaryNotesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DailyDietaryNotesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DailyDietaryNotesController dailydietarynotesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DailyDietaryNotesService dailydietarynotesService;

    @Mock
    private DailyDietaryNotesRepository dailydietarynotesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(dailydietarynotesController).build();
    }

	/**
	 * test creating a new DailyDietaryNotes
	 * @throws 
	 */
	@Test
	public void testA_CreateDailyDietaryNotes() throws Exception
	{
	    DailyDietaryNotesDTO dailydietarynotes = generateRandomDailyDietaryNotes();
        when(dailydietarynotesService.createDailyDietaryNotes(any(DailyDietaryNotesDTO.class))).thenReturn(dailydietarynotes);

        mockMvc.perform(post("/dailydietarynotes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydietarynotes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DailyDietaryNotes
	 * @throws 
	 */
	@Test
	public void testB_GetAllDailyDietaryNotes() throws Exception
	{
		List<DailyDietaryNotesDTO> dailydietarynotess = Arrays.asList(generateRandomDailyDietaryNotes(), generateRandomDailyDietaryNotes());
        when(dailydietarynotesService.getAllDailyDietaryNotes()).thenReturn(dailydietarynotess);

        mockMvc.perform(get("/dailydietarynotes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DailyDietaryNotes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDailyDietaryNotes() throws Exception
	{
		DailyDietaryNotesDTO dailydietarynotes = generateRandomDailyDietaryNotes();
        when(dailydietarynotesService.findDailyDietaryNotesById(anyInt())).thenReturn(dailydietarynotes);

        mockMvc.perform(get("/dailydietarynotes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DailyDietaryNotes
	 * @throws 
	 */
	@Test
	public void testD_UpdateDailyDietaryNotes() throws Exception
	{
	    DailyDietaryNotesDTO dailydietarynotes = generateRandomDailyDietaryNotes();
        when(dailydietarynotesService.updateDailyDietaryNotes(any(DailyDietaryNotesDTO.class))).thenReturn(dailydietarynotes);

        mockMvc.perform(post("/dailydietarynotes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dailydietarynotes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DailyDietaryNotes
	 * @throws 
	 */
	@Test
	public void testE_DeleteDailyDietaryNotes() throws Exception
	{
		when(dailydietarynotesService.deleteDailyDietaryNotes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/dailydietarynotes/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single DailyDietaryNotes by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<DailyDietaryNotesDTO> dailydietarynotes = Arrays.asList(generateRandomDailyDietaryNotes());
    when(dailydietarynotesService.findDailyDietaryNotesByUserId(anyInt())).thenReturn(dailydietarynotes);

    mockMvc.perform(get("/dailydietarynotes/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static DailyDietaryNotesDTO generateRandomDailyDietaryNotes() {
		DailyDietaryNotesDTO record = new DailyDietaryNotesDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setDailyNotes(Randomizer.randomString(20));
		return record;
	}
}