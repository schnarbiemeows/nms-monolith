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

import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutLiftRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutLiftDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutLiftService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the WorkoutLiftController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class WorkoutLiftControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private WorkoutLiftController workoutliftController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private WorkoutLiftService workoutliftService;

    @Mock
    private WorkoutLiftRepository workoutliftRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(workoutliftController).build();
    }

	/**
	 * test creating a new WorkoutLift
	 * @throws 
	 */
	@Test
	public void testA_CreateWorkoutLift() throws Exception
	{
	    WorkoutLiftDTO workoutlift = generateRandomWorkoutLift();
        when(workoutliftService.createWorkoutLift(any(WorkoutLiftDTO.class))).thenReturn(workoutlift);

        mockMvc.perform(post("/workoutlift/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workoutlift)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all WorkoutLift
	 * @throws 
	 */
	@Test
	public void testB_GetAllWorkoutLift() throws Exception
	{
		List<WorkoutLiftDTO> workoutlifts = Arrays.asList(generateRandomWorkoutLift(), generateRandomWorkoutLift());
        when(workoutliftService.getAllWorkoutLift()).thenReturn(workoutlifts);

        mockMvc.perform(get("/workoutlift/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single WorkoutLift by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetWorkoutLift() throws Exception
	{
		WorkoutLiftDTO workoutlift = generateRandomWorkoutLift();
        when(workoutliftService.findWorkoutLiftById(anyInt())).thenReturn(workoutlift);

        mockMvc.perform(get("/workoutlift/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a WorkoutLift
	 * @throws 
	 */
	@Test
	public void testD_UpdateWorkoutLift() throws Exception
	{
	    WorkoutLiftDTO workoutlift = generateRandomWorkoutLift();
        when(workoutliftService.updateWorkoutLift(any(WorkoutLiftDTO.class))).thenReturn(workoutlift);

        mockMvc.perform(post("/workoutlift/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workoutlift)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a WorkoutLift
	 * @throws 
	 */
	@Test
	public void testE_DeleteWorkoutLift() throws Exception
	{
		when(workoutliftService.deleteWorkoutLift(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/workoutlift/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single WorkoutLift by field WorkoutId
 * @throws
 */
@Test
public void testC_findByWorkoutId() throws Exception
{
    List<WorkoutLiftDTO> workoutlift = Arrays.asList(generateRandomWorkoutLift());
    when(workoutliftService.findWorkoutLiftByWorkoutId(anyInt())).thenReturn(workoutlift);

    mockMvc.perform(get("/workoutlift/findByWorkoutId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single WorkoutLift by field LiftId
 * @throws
 */
@Test
public void testC_findByLiftId() throws Exception
{
    List<WorkoutLiftDTO> workoutlift = Arrays.asList(generateRandomWorkoutLift());
    when(workoutliftService.findWorkoutLiftByLiftId(anyInt())).thenReturn(workoutlift);

    mockMvc.perform(get("/workoutlift/findByLiftId/2"))
            .andExpect(status().isOk());
}

	public static WorkoutLiftDTO generateRandomWorkoutLift() {
		WorkoutLiftDTO record = new WorkoutLiftDTO();
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setLiftId(Randomizer.randomInt(1000));
		return record;
	}
}