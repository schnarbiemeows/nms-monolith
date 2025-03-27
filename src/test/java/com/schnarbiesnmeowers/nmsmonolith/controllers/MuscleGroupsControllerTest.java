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

import com.schnarbiesnmeowers.nmsmonolith.repositories.MuscleGroupsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MuscleGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MuscleGroupsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MuscleGroupsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class MuscleGroupsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private MuscleGroupsController musclegroupsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private MuscleGroupsService musclegroupsService;

    @Mock
    private MuscleGroupsRepository musclegroupsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(musclegroupsController).build();
    }

	/**
	 * test creating a new MuscleGroups
	 * @throws 
	 */
	@Test
	public void testA_CreateMuscleGroups() throws Exception
	{
	    MuscleGroupsDTO musclegroups = generateRandomMuscleGroups();
        when(musclegroupsService.createMuscleGroups(any(MuscleGroupsDTO.class))).thenReturn(musclegroups);

        mockMvc.perform(post("/musclegroups/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(musclegroups)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all MuscleGroups
	 * @throws 
	 */
	@Test
	public void testB_GetAllMuscleGroups() throws Exception
	{
		List<MuscleGroupsDTO> musclegroupss = Arrays.asList(generateRandomMuscleGroups(), generateRandomMuscleGroups());
        when(musclegroupsService.getAllMuscleGroups()).thenReturn(musclegroupss);

        mockMvc.perform(get("/musclegroups/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single MuscleGroups by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetMuscleGroups() throws Exception
	{
		MuscleGroupsDTO musclegroups = generateRandomMuscleGroups();
        when(musclegroupsService.findMuscleGroupsById(anyInt())).thenReturn(musclegroups);

        mockMvc.perform(get("/musclegroups/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a MuscleGroups
	 * @throws 
	 */
	@Test
	public void testD_UpdateMuscleGroups() throws Exception
	{
	    MuscleGroupsDTO musclegroups = generateRandomMuscleGroups();
        when(musclegroupsService.updateMuscleGroups(any(MuscleGroupsDTO.class))).thenReturn(musclegroups);

        mockMvc.perform(post("/musclegroups/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(musclegroups)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a MuscleGroups
	 * @throws 
	 */
	@Test
	public void testE_DeleteMuscleGroups() throws Exception
	{
		when(musclegroupsService.deleteMuscleGroups(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/musclegroups/delete/2"))
                .andExpect(status().isOk());
	}



	public static MuscleGroupsDTO generateRandomMuscleGroups() {
		MuscleGroupsDTO record = new MuscleGroupsDTO();
		record.setMuscleGrpName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}