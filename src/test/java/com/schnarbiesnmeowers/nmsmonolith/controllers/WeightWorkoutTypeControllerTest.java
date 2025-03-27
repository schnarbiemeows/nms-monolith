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

import com.schnarbiesnmeowers.nmsmonolith.repositories.WeightWorkoutTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WeightWorkoutTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WeightWorkoutTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the WeightWorkoutTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class WeightWorkoutTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private WeightWorkoutTypeController weightworkouttypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private WeightWorkoutTypeService weightworkouttypeService;

    @Mock
    private WeightWorkoutTypeRepository weightworkouttypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(weightworkouttypeController).build();
    }

	/**
	 * test creating a new WeightWorkoutType
	 * @throws 
	 */
	@Test
	public void testA_CreateWeightWorkoutType() throws Exception
	{
	    WeightWorkoutTypeDTO weightworkouttype = generateRandomWeightWorkoutType();
        when(weightworkouttypeService.createWeightWorkoutType(any(WeightWorkoutTypeDTO.class))).thenReturn(weightworkouttype);

        mockMvc.perform(post("/weightworkouttype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weightworkouttype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all WeightWorkoutType
	 * @throws 
	 */
	@Test
	public void testB_GetAllWeightWorkoutType() throws Exception
	{
		List<WeightWorkoutTypeDTO> weightworkouttypes = Arrays.asList(generateRandomWeightWorkoutType(), generateRandomWeightWorkoutType());
        when(weightworkouttypeService.getAllWeightWorkoutType()).thenReturn(weightworkouttypes);

        mockMvc.perform(get("/weightworkouttype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single WeightWorkoutType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetWeightWorkoutType() throws Exception
	{
		WeightWorkoutTypeDTO weightworkouttype = generateRandomWeightWorkoutType();
        when(weightworkouttypeService.findWeightWorkoutTypeById(anyInt())).thenReturn(weightworkouttype);

        mockMvc.perform(get("/weightworkouttype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a WeightWorkoutType
	 * @throws 
	 */
	@Test
	public void testD_UpdateWeightWorkoutType() throws Exception
	{
	    WeightWorkoutTypeDTO weightworkouttype = generateRandomWeightWorkoutType();
        when(weightworkouttypeService.updateWeightWorkoutType(any(WeightWorkoutTypeDTO.class))).thenReturn(weightworkouttype);

        mockMvc.perform(post("/weightworkouttype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(weightworkouttype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a WeightWorkoutType
	 * @throws 
	 */
	@Test
	public void testE_DeleteWeightWorkoutType() throws Exception
	{
		when(weightworkouttypeService.deleteWeightWorkoutType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/weightworkouttype/delete/2"))
                .andExpect(status().isOk());
	}

	public static WeightWorkoutTypeDTO generateRandomWeightWorkoutType() {
		WeightWorkoutTypeDTO record = new WeightWorkoutTypeDTO();
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		return record;
	}
}