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

import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftMuscleRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftMuscleDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftMuscleService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftMuscleController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LiftMuscleControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LiftMuscleController liftmuscleController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LiftMuscleService liftmuscleService;

    @Mock
    private LiftMuscleRepository liftmuscleRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(liftmuscleController).build();
    }

	/**
	 * test creating a new LiftMuscle
	 * @throws 
	 */
	@Test
	public void testA_CreateLiftMuscle() throws Exception
	{
	    LiftMuscleDTO liftmuscle = generateRandomLiftMuscle();
        when(liftmuscleService.createLiftMuscle(any(LiftMuscleDTO.class))).thenReturn(liftmuscle);

        mockMvc.perform(post("/liftmuscle/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftmuscle)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all LiftMuscle
	 * @throws 
	 */
	@Test
	public void testB_GetAllLiftMuscle() throws Exception
	{
		List<LiftMuscleDTO> liftmuscles = Arrays.asList(generateRandomLiftMuscle(), generateRandomLiftMuscle());
        when(liftmuscleService.getAllLiftMuscle()).thenReturn(liftmuscles);

        mockMvc.perform(get("/liftmuscle/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single LiftMuscle by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLiftMuscle() throws Exception
	{
		LiftMuscleDTO liftmuscle = generateRandomLiftMuscle();
        when(liftmuscleService.findLiftMuscleById(anyInt())).thenReturn(liftmuscle);

        mockMvc.perform(get("/liftmuscle/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a LiftMuscle
	 * @throws 
	 */
	@Test
	public void testD_UpdateLiftMuscle() throws Exception
	{
	    LiftMuscleDTO liftmuscle = generateRandomLiftMuscle();
        when(liftmuscleService.updateLiftMuscle(any(LiftMuscleDTO.class))).thenReturn(liftmuscle);

        mockMvc.perform(post("/liftmuscle/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftmuscle)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a LiftMuscle
	 * @throws 
	 */
	@Test
	public void testE_DeleteLiftMuscle() throws Exception
	{
		when(liftmuscleService.deleteLiftMuscle(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/liftmuscle/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single LiftMuscle by field LiftId
 * @throws
 */
@Test
public void testC_findByLiftId() throws Exception
{
    List<LiftMuscleDTO> liftmuscle = Arrays.asList(generateRandomLiftMuscle());
    when(liftmuscleService.findLiftMuscleByLiftId(anyInt())).thenReturn(liftmuscle);

    mockMvc.perform(get("/liftmuscle/findByLiftId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single LiftMuscle by field MuscleId
 * @throws
 */
@Test
public void testC_findByMuscleId() throws Exception
{
    List<LiftMuscleDTO> liftmuscle = Arrays.asList(generateRandomLiftMuscle());
    when(liftmuscleService.findLiftMuscleByMuscleId(anyInt())).thenReturn(liftmuscle);

    mockMvc.perform(get("/liftmuscle/findByMuscleId/2"))
            .andExpect(status().isOk());
}

	public static LiftMuscleDTO generateRandomLiftMuscle() {
		LiftMuscleDTO record = new LiftMuscleDTO();
		record.setLiftId(Randomizer.randomInt(1000));
		record.setMuscleId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}