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

import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.StepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.StepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.StepsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the StepsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class StepsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private StepsController stepsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private StepsService stepsService;

    @Mock
    private StepsRepository stepsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(stepsController).build();
    }

	/**
	 * test creating a new Steps
	 * @throws 
	 */
	@Test
	public void testA_CreateSteps() throws Exception
	{
	    StepsDTO steps = generateRandomSteps();
        when(stepsService.createSteps(any(StepsDTO.class))).thenReturn(steps);

        mockMvc.perform(post("/steps/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(steps)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Steps
	 * @throws 
	 */
	@Test
	public void testB_GetAllSteps() throws Exception
	{
		List<StepsDTO> stepss = Arrays.asList(generateRandomSteps(), generateRandomSteps());
        when(stepsService.getAllSteps()).thenReturn(stepss);

        mockMvc.perform(get("/steps/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Steps by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetSteps() throws Exception
	{
		StepsDTO steps = generateRandomSteps();
        when(stepsService.findStepsById(anyInt())).thenReturn(steps);

        mockMvc.perform(get("/steps/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Steps
	 * @throws 
	 */
	@Test
	public void testD_UpdateSteps() throws Exception
	{
	    StepsDTO steps = generateRandomSteps();
        when(stepsService.updateSteps(any(StepsDTO.class))).thenReturn(steps);

        mockMvc.perform(post("/steps/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(steps)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Steps
	 * @throws 
	 */
	@Test
	public void testE_DeleteSteps() throws Exception
	{
		when(stepsService.deleteSteps(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/steps/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Steps by field WorkoutId
 * @throws
 */
@Test
public void testC_findByWorkoutId() throws Exception
{
    StepsDTO steps = generateRandomSteps();
    when(stepsService.findStepsByWorkoutId(anyInt())).thenReturn(steps);

    mockMvc.perform(get("/steps/findByWorkoutId/2"))
            .andExpect(status().isOk());
}

	public static StepsDTO generateRandomSteps() {
		StepsDTO record = new StepsDTO();
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setSteps(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}