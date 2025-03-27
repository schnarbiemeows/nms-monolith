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

import com.schnarbiesnmeowers.nmsmonolith.repositories.UnsyncedRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.UnsyncedDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UnsyncedService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UnsyncedController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class UnsyncedControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private UnsyncedController unsyncedController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private UnsyncedService unsyncedService;

    @Mock
    private UnsyncedRepository unsyncedRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(unsyncedController).build();
    }

	/**
	 * test creating a new Unsynced
	 * @throws 
	 */
	@Test
	public void testA_CreateUnsynced() throws Exception
	{
	    UnsyncedDTO unsynced = generateRandomUnsynced();
        when(unsyncedService.createUnsynced(any(UnsyncedDTO.class))).thenReturn(unsynced);

        mockMvc.perform(post("/unsynced/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(unsynced)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Unsynced
	 * @throws 
	 */
	@Test
	public void testB_GetAllUnsynced() throws Exception
	{
		List<UnsyncedDTO> unsynceds = Arrays.asList(generateRandomUnsynced(), generateRandomUnsynced());
        when(unsyncedService.getAllUnsynced()).thenReturn(unsynceds);

        mockMvc.perform(get("/unsynced/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Unsynced by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetUnsynced() throws Exception
	{
		UnsyncedDTO unsynced = generateRandomUnsynced();
        when(unsyncedService.findUnsyncedById(anyInt())).thenReturn(unsynced);

        mockMvc.perform(get("/unsynced/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Unsynced
	 * @throws 
	 */
	@Test
	public void testD_UpdateUnsynced() throws Exception
	{
	    UnsyncedDTO unsynced = generateRandomUnsynced();
        when(unsyncedService.updateUnsynced(any(UnsyncedDTO.class))).thenReturn(unsynced);

        mockMvc.perform(post("/unsynced/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(unsynced)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Unsynced
	 * @throws 
	 */
	@Test
	public void testE_DeleteUnsynced() throws Exception
	{
		when(unsyncedService.deleteUnsynced(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/unsynced/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Unsynced by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<UnsyncedDTO> unsynced = Arrays.asList(generateRandomUnsynced());
    when(unsyncedService.findUnsyncedByUserId(anyInt())).thenReturn(unsynced);

    mockMvc.perform(get("/unsynced/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static UnsyncedDTO generateRandomUnsynced() {
		UnsyncedDTO record = new UnsyncedDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		return record;
	}
}