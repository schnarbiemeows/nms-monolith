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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalEventRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalEventDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalEventService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalEventController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GoalEventControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GoalEventController goaleventController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GoalEventService goaleventService;

    @Mock
    private GoalEventRepository goaleventRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(goaleventController).build();
    }

	/**
	 * test creating a new GoalEvent
	 * @throws 
	 */
	@Test
	public void testA_CreateGoalEvent() throws Exception
	{
	    GoalEventDTO goalevent = generateRandomGoalEvent();
        when(goaleventService.createGoalEvent(any(GoalEventDTO.class))).thenReturn(goalevent);

        mockMvc.perform(post("/goalevent/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goalevent)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GoalEvent
	 * @throws 
	 */
	@Test
	public void testB_GetAllGoalEvent() throws Exception
	{
		List<GoalEventDTO> goalevents = Arrays.asList(generateRandomGoalEvent(), generateRandomGoalEvent());
        when(goaleventService.getAllGoalEvent()).thenReturn(goalevents);

        mockMvc.perform(get("/goalevent/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GoalEvent by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGoalEvent() throws Exception
	{
		GoalEventDTO goalevent = generateRandomGoalEvent();
        when(goaleventService.findGoalEventById(anyInt())).thenReturn(goalevent);

        mockMvc.perform(get("/goalevent/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GoalEvent
	 * @throws 
	 */
	@Test
	public void testD_UpdateGoalEvent() throws Exception
	{
	    GoalEventDTO goalevent = generateRandomGoalEvent();
        when(goaleventService.updateGoalEvent(any(GoalEventDTO.class))).thenReturn(goalevent);

        mockMvc.perform(post("/goalevent/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goalevent)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GoalEvent
	 * @throws 
	 */
	@Test
	public void testE_DeleteGoalEvent() throws Exception
	{
		when(goaleventService.deleteGoalEvent(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/goalevent/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GoalEvent by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<GoalEventDTO> goalevent = Arrays.asList(generateRandomGoalEvent());
    when(goaleventService.findGoalEventByUserId(anyInt())).thenReturn(goalevent);

    mockMvc.perform(get("/goalevent/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GoalEvent by field GoalId
 * @throws
 */
@Test
public void testC_findByGoalId() throws Exception
{
    List<GoalEventDTO> goalevent = Arrays.asList(generateRandomGoalEvent());
    when(goaleventService.findGoalEventByGoalId(anyInt())).thenReturn(goalevent);

    mockMvc.perform(get("/goalevent/findByGoalId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single GoalEvent by field EventId
 * @throws
 */
@Test
public void testC_findByEventId() throws Exception
{
    List<GoalEventDTO> goalevent = Arrays.asList(generateRandomGoalEvent());
    when(goaleventService.findGoalEventByEventId(anyInt())).thenReturn(goalevent);

    mockMvc.perform(get("/goalevent/findByEventId/2"))
            .andExpect(status().isOk());
}

	public static GoalEventDTO generateRandomGoalEvent() {
		GoalEventDTO record = new GoalEventDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalId(Randomizer.randomInt(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
}