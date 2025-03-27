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

import com.schnarbiesnmeowers.nmsmonolith.repositories.EventsTableRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.EventsTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.EventsTableService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the EventsTableController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class EventsTableControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private EventsTableController eventstableController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private EventsTableService eventstableService;

    @Mock
    private EventsTableRepository eventstableRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(eventstableController).build();
    }

	/**
	 * test creating a new EventsTable
	 * @throws 
	 */
	@Test
	public void testA_CreateEventsTable() throws Exception
	{
	    EventsTableDTO eventstable = generateRandomEventsTable();
        when(eventstableService.createEventsTable(any(EventsTableDTO.class))).thenReturn(eventstable);

        mockMvc.perform(post("/eventstable/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(eventstable)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all EventsTable
	 * @throws 
	 */
	@Test
	public void testB_GetAllEventsTable() throws Exception
	{
		List<EventsTableDTO> eventstables = Arrays.asList(generateRandomEventsTable(), generateRandomEventsTable());
        when(eventstableService.getAllEventsTable()).thenReturn(eventstables);

        mockMvc.perform(get("/eventstable/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single EventsTable by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetEventsTable() throws Exception
	{
		EventsTableDTO eventstable = generateRandomEventsTable();
        when(eventstableService.findEventsTableById(anyInt())).thenReturn(eventstable);

        mockMvc.perform(get("/eventstable/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a EventsTable
	 * @throws 
	 */
	@Test
	public void testD_UpdateEventsTable() throws Exception
	{
	    EventsTableDTO eventstable = generateRandomEventsTable();
        when(eventstableService.updateEventsTable(any(EventsTableDTO.class))).thenReturn(eventstable);

        mockMvc.perform(post("/eventstable/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(eventstable)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a EventsTable
	 * @throws 
	 */
	@Test
	public void testE_DeleteEventsTable() throws Exception
	{
		when(eventstableService.deleteEventsTable(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/eventstable/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single EventsTable by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<EventsTableDTO> eventstable = Arrays.asList(generateRandomEventsTable());
    when(eventstableService.findEventsTableByUserId(anyInt())).thenReturn(eventstable);

    mockMvc.perform(get("/eventstable/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single EventsTable by field PeriodId
 * @throws
 */
@Test
public void testC_findByPeriodId() throws Exception
{
    List<EventsTableDTO> eventstable = Arrays.asList(generateRandomEventsTable());
    when(eventstableService.findEventsTableByPeriodId(anyInt())).thenReturn(eventstable);

    mockMvc.perform(get("/eventstable/findByPeriodId/2"))
            .andExpect(status().isOk());
}

	public static EventsTableDTO generateRandomEventsTable() {
		EventsTableDTO record = new EventsTableDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setEventName(Randomizer.randomString(20));
		record.setEventDesc(Randomizer.randomString(20));
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}