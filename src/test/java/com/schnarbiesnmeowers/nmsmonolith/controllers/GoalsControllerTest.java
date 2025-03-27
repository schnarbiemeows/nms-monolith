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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GoalsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GoalsController goalsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GoalsService goalsService;

    @Mock
    private GoalsRepository goalsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(goalsController).build();
    }

	/**
	 * test creating a new Goals
	 * @throws 
	 */
	@Test
	public void testA_CreateGoals() throws Exception
	{
	    GoalsDTO goals = generateRandomGoals();
        when(goalsService.createGoals(any(GoalsDTO.class))).thenReturn(goals);

        mockMvc.perform(post("/goals/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goals)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Goals
	 * @throws 
	 */
	@Test
	public void testB_GetAllGoals() throws Exception
	{
		List<GoalsDTO> goalss = Arrays.asList(generateRandomGoals(), generateRandomGoals());
        when(goalsService.getAllGoals()).thenReturn(goalss);

        mockMvc.perform(get("/goals/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Goals by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGoals() throws Exception
	{
		GoalsDTO goals = generateRandomGoals();
        when(goalsService.findGoalsById(anyInt())).thenReturn(goals);

        mockMvc.perform(get("/goals/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Goals
	 * @throws 
	 */
	@Test
	public void testD_UpdateGoals() throws Exception
	{
	    GoalsDTO goals = generateRandomGoals();
        when(goalsService.updateGoals(any(GoalsDTO.class))).thenReturn(goals);

        mockMvc.perform(post("/goals/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(goals)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Goals
	 * @throws 
	 */
	@Test
	public void testE_DeleteGoals() throws Exception
	{
		when(goalsService.deleteGoals(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/goals/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Goals by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<GoalsDTO> goals = Arrays.asList(generateRandomGoals());
    when(goalsService.findGoalsByUserId(anyInt())).thenReturn(goals);

    mockMvc.perform(get("/goals/findByUserId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Goals by field GcId
 * @throws
 */
@Test
public void testC_findByGcId() throws Exception
{
    List<GoalsDTO> goals = Arrays.asList(generateRandomGoals());
    when(goalsService.findGoalsByGcId(anyInt())).thenReturn(goals);

    mockMvc.perform(get("/goals/findByGcId/2"))
            .andExpect(status().isOk());
}

	public static GoalsDTO generateRandomGoals() {
		GoalsDTO record = new GoalsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalName(Randomizer.randomString(20));
		record.setGcId(Randomizer.randomInt(1000));
		record.setComparator(Randomizer.randomString(3));
		record.setCompFld(Randomizer.randomString(20));
		record.setNumTimes(Randomizer.randomInt(1000));
		record.setTimesMet(Randomizer.randomInt(1000));
		record.setConseq(Randomizer.randomString(2));
		record.setRenew(Randomizer.randomString(2));
		record.setAchieved(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}