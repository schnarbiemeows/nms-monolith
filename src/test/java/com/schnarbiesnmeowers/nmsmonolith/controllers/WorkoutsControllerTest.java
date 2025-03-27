package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.*;
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

import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutsRepository;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the WorkoutsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class WorkoutsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private WorkoutsController workoutsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private WorkoutsService workoutsService;

    @Mock
    private WorkoutsRepository workoutsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(workoutsController).build();
    }

	/**
	 * test creating a new Workouts
	 * @throws 
	 */
	@Test
	public void testA_CreateWorkouts() throws Exception
	{
	    WorkoutsDTO workouts = generateRandomWorkouts();
        when(workoutsService.createWorkouts(any(WorkoutsDTO.class))).thenReturn(workouts);

        mockMvc.perform(post("/workouts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workouts)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Workouts
	 * @throws 
	 */
	@Test
	public void testB_GetAllWorkouts() throws Exception
	{
		List<WorkoutsDTO> workoutss = Arrays.asList(generateRandomWorkouts(), generateRandomWorkouts());
        when(workoutsService.getAllWorkouts()).thenReturn(workoutss);

        mockMvc.perform(get("/workouts/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Workouts by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetWorkouts() throws Exception
	{
		WorkoutWrapperDTO workouts = generateRandomWorkoutWrapper();
        when(workoutsService.findWorkoutsById(anyInt())).thenReturn(workouts);

        mockMvc.perform(get("/workouts/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Workouts
	 * @throws 
	 */
	@Test
	public void testD_UpdateWorkouts() throws Exception
	{
	    WorkoutsDTO workouts = generateRandomWorkouts();
        when(workoutsService.updateWorkouts(any(WorkoutsDTO.class))).thenReturn(workouts);

        mockMvc.perform(post("/workouts/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workouts)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Workouts
	 * @throws 
	 */
	@Test
	public void testE_DeleteWorkouts() throws Exception
	{
		when(workoutsService.deleteWorkouts(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/workouts/delete/2"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Workouts by field UserId
	 * @throws
	 */
	@Test
	public void testC_findByUserId() throws Exception
	{
		List<WorkoutsDTO> workouts = Arrays.asList(generateRandomWorkouts());
		when(workoutsService.findWorkoutsByUserId(anyInt())).thenReturn(workouts);

		mockMvc.perform(get("/workouts/findByUserId/2"))
				.andExpect(status().isOk());
	}
	public static WorkoutsDTO generateRandomWorkouts() {
		WorkoutsDTO record = new WorkoutsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomLocalDate());
		record.setExerciseTypeId(Randomizer.randomInt(1000));
		record.setDuration(Randomizer.randomInt(1000));
		record.setRating(Randomizer.randomBigDecimal("1000"));
		record.setNotes(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

	private static WorkoutWrapperDTO generateRandomWorkoutWrapper() {
		WorkoutWrapperDTO wrapper = new WorkoutWrapperDTO();
		wrapper.setWorkoutType(Randomizer.randomInt(2));
		wrapper.setWorkoutCardioFormDTO(new WorkoutCardioFormDTO());
		wrapper.setWorkoutStepsFormDTO(new WorkoutStepsFormDTO());
		wrapper.setWorkoutWeightsFormDTO(new WorkoutWeightsFormDTO());
		return wrapper;
	}
}