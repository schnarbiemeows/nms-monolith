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

import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.LiftSetRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.LiftSetDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.workouts.LiftSetService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftSetController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LiftSetControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LiftSetController liftsetController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LiftSetService liftsetService;

    @Mock
    private LiftSetRepository liftsetRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(liftsetController).build();
    }

	/**
	 * test creating a new LiftSet
	 * @throws 
	 */
	@Test
	public void testA_CreateLiftSet() throws Exception
	{
	    LiftSetDTO liftset = generateRandomLiftSet();
        when(liftsetService.createLiftSet(any(LiftSetDTO.class))).thenReturn(liftset);

        mockMvc.perform(post("/liftset/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftset)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all LiftSet
	 * @throws 
	 */
	@Test
	public void testB_GetAllLiftSet() throws Exception
	{
		List<LiftSetDTO> liftsets = Arrays.asList(generateRandomLiftSet(), generateRandomLiftSet());
        when(liftsetService.getAllLiftSet()).thenReturn(liftsets);

        mockMvc.perform(get("/liftset/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single LiftSet by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLiftSet() throws Exception
	{
		LiftSetDTO liftset = generateRandomLiftSet();
        when(liftsetService.findLiftSetById(anyInt())).thenReturn(liftset);

        mockMvc.perform(get("/liftset/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a LiftSet
	 * @throws 
	 */
	@Test
	public void testD_UpdateLiftSet() throws Exception
	{
	    LiftSetDTO liftset = generateRandomLiftSet();
        when(liftsetService.updateLiftSet(any(LiftSetDTO.class))).thenReturn(liftset);

        mockMvc.perform(post("/liftset/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftset)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a LiftSet
	 * @throws 
	 */
	@Test
	public void testE_DeleteLiftSet() throws Exception
	{
		when(liftsetService.deleteLiftSet(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/liftset/delete/2"))
                .andExpect(status().isOk());
	}

	public static LiftSetDTO generateRandomLiftSet() {
		LiftSetDTO record = new LiftSetDTO();
		record.setWorkoutLiftId(Randomizer.randomInt(1000));
		record.setWeight(Randomizer.randomBigDecimal("1000"));
		record.setReps(Randomizer.randomInt(1000));
		return record;
	}
}