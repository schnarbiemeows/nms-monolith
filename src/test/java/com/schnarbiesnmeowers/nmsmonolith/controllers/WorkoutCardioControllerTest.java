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

import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutCardioRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutCardioDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutCardioService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the WorkoutCardioController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class WorkoutCardioControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private WorkoutCardioController workoutcardioController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private WorkoutCardioService workoutcardioService;

    @Mock
    private WorkoutCardioRepository workoutcardioRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(workoutcardioController).build();
    }

	/**
	 * test creating a new WorkoutCardio
	 * @throws 
	 */
	@Test
	public void testA_CreateWorkoutCardio() throws Exception
	{
	    WorkoutCardioDTO workoutcardio = generateRandomWorkoutCardio();
        when(workoutcardioService.createWorkoutCardio(any(WorkoutCardioDTO.class))).thenReturn(workoutcardio);

        mockMvc.perform(post("/workoutcardio/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workoutcardio)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all WorkoutCardio
	 * @throws 
	 */
	@Test
	public void testB_GetAllWorkoutCardio() throws Exception
	{
		List<WorkoutCardioDTO> workoutcardios = Arrays.asList(generateRandomWorkoutCardio(), generateRandomWorkoutCardio());
        when(workoutcardioService.getAllWorkoutCardio()).thenReturn(workoutcardios);

        mockMvc.perform(get("/workoutcardio/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single WorkoutCardio by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetWorkoutCardio() throws Exception
	{
		WorkoutCardioDTO workoutcardio = generateRandomWorkoutCardio();
        when(workoutcardioService.findWorkoutCardioById(anyInt())).thenReturn(workoutcardio);

        mockMvc.perform(get("/workoutcardio/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a WorkoutCardio
	 * @throws 
	 */
	@Test
	public void testD_UpdateWorkoutCardio() throws Exception
	{
	    WorkoutCardioDTO workoutcardio = generateRandomWorkoutCardio();
        when(workoutcardioService.updateWorkoutCardio(any(WorkoutCardioDTO.class))).thenReturn(workoutcardio);

        mockMvc.perform(post("/workoutcardio/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workoutcardio)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a WorkoutCardio
	 * @throws 
	 */
	@Test
	public void testE_DeleteWorkoutCardio() throws Exception
	{
		when(workoutcardioService.deleteWorkoutCardio(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/workoutcardio/delete/2"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single WorkoutCardio by field WorkoutId
	 * @throws
	 */
	@Test
	public void testC_findByWorkoutId() throws Exception
	{
		WorkoutCardioDTO workoutcardio = generateRandomWorkoutCardio();
		when(workoutcardioService.findWorkoutCardioByWorkoutId(anyInt())).thenReturn(workoutcardio);

		mockMvc.perform(get("/workoutcardio/findByWorkoutId/2"))
				.andExpect(status().isOk());
	}

	public static WorkoutCardioDTO generateRandomWorkoutCardio() {
		WorkoutCardioDTO record = new WorkoutCardioDTO();
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setCardioTypeId(Randomizer.randomInt(1000));
		return record;
	}
}