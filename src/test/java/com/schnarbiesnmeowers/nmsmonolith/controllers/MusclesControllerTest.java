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

import com.schnarbiesnmeowers.nmsmonolith.repositories.MusclesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MusclesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MusclesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MusclesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class MusclesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private MusclesController musclesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private MusclesService musclesService;

    @Mock
    private MusclesRepository musclesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(musclesController).build();
    }

	/**
	 * test creating a new Muscles
	 * @throws 
	 */
	@Test
	public void testA_CreateMuscles() throws Exception
	{
	    MusclesDTO muscles = generateRandomMuscles();
        when(musclesService.createMuscles(any(MusclesDTO.class))).thenReturn(muscles);

        mockMvc.perform(post("/muscles/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(muscles)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Muscles
	 * @throws 
	 */
	@Test
	public void testB_GetAllMuscles() throws Exception
	{
		List<MusclesDTO> muscless = Arrays.asList(generateRandomMuscles(), generateRandomMuscles());
        when(musclesService.getAllMuscles()).thenReturn(muscless);

        mockMvc.perform(get("/muscles/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Muscles by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetMuscles() throws Exception
	{
		MusclesDTO muscles = generateRandomMuscles();
        when(musclesService.findMusclesById(anyInt())).thenReturn(muscles);

        mockMvc.perform(get("/muscles/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Muscles
	 * @throws 
	 */
	@Test
	public void testD_UpdateMuscles() throws Exception
	{
	    MusclesDTO muscles = generateRandomMuscles();
        when(musclesService.updateMuscles(any(MusclesDTO.class))).thenReturn(muscles);

        mockMvc.perform(post("/muscles/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(muscles)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Muscles
	 * @throws 
	 */
	@Test
	public void testE_DeleteMuscles() throws Exception
	{
		when(musclesService.deleteMuscles(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/muscles/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Muscles by field MuscleGroupId
 * @throws
 */
@Test
public void testC_findByMuscleGroupId() throws Exception
{
    List<MusclesDTO> muscles = Arrays.asList(generateRandomMuscles());
    when(musclesService.findMusclesByMuscleGroupId(anyInt())).thenReturn(muscles);

    mockMvc.perform(get("/muscles/findByMuscleGroupId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Muscles by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<MusclesDTO> muscles = Arrays.asList(generateRandomMuscles());
    when(musclesService.findMusclesByImageLoc(anyInt())).thenReturn(muscles);

    mockMvc.perform(get("/muscles/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static MusclesDTO generateRandomMuscles() {
		MusclesDTO record = new MusclesDTO();
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		record.setMuscleName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}