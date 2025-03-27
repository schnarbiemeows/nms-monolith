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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ExerciseTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ExerciseTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ExerciseTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ExerciseTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ExerciseTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ExerciseTypeController exercisetypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ExerciseTypeService exercisetypeService;

    @Mock
    private ExerciseTypeRepository exercisetypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(exercisetypeController).build();
    }

	/**
	 * test creating a new ExerciseType
	 * @throws 
	 */
	@Test
	public void testA_CreateExerciseType() throws Exception
	{
	    ExerciseTypeDTO exercisetype = generateRandomExerciseType();
        when(exercisetypeService.createExerciseType(any(ExerciseTypeDTO.class))).thenReturn(exercisetype);

        mockMvc.perform(post("/exercisetype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(exercisetype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ExerciseType
	 * @throws 
	 */
	@Test
	public void testB_GetAllExerciseType() throws Exception
	{
		List<ExerciseTypeDTO> exercisetypes = Arrays.asList(generateRandomExerciseType(), generateRandomExerciseType());
        when(exercisetypeService.getAllExerciseType()).thenReturn(exercisetypes);

        mockMvc.perform(get("/exercisetype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ExerciseType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetExerciseType() throws Exception
	{
		ExerciseTypeDTO exercisetype = generateRandomExerciseType();
        when(exercisetypeService.findExerciseTypeById(anyInt())).thenReturn(exercisetype);

        mockMvc.perform(get("/exercisetype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ExerciseType
	 * @throws 
	 */
	@Test
	public void testD_UpdateExerciseType() throws Exception
	{
	    ExerciseTypeDTO exercisetype = generateRandomExerciseType();
        when(exercisetypeService.updateExerciseType(any(ExerciseTypeDTO.class))).thenReturn(exercisetype);

        mockMvc.perform(post("/exercisetype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(exercisetype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ExerciseType
	 * @throws 
	 */
	@Test
	public void testE_DeleteExerciseType() throws Exception
	{
		when(exercisetypeService.deleteExerciseType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/exercisetype/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single ExerciseType by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<ExerciseTypeDTO> exercisetype = Arrays.asList(generateRandomExerciseType());
    when(exercisetypeService.findExerciseTypeByImageLoc(anyInt())).thenReturn(exercisetype);

    mockMvc.perform(get("/exercisetype/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static ExerciseTypeDTO generateRandomExerciseType() {
		ExerciseTypeDTO record = new ExerciseTypeDTO();
		record.setPrntExerciseType(Randomizer.randomInt(1000));
		record.setExerciseTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}