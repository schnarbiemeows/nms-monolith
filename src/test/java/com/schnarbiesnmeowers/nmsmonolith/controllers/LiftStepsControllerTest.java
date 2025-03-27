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

import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftStepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftStepsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftStepsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LiftStepsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LiftStepsController liftstepsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LiftStepsService liftstepsService;

    @Mock
    private LiftStepsRepository liftstepsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(liftstepsController).build();
    }

	/**
	 * test creating a new LiftSteps
	 * @throws 
	 */
	@Test
	public void testA_CreateLiftSteps() throws Exception
	{
	    LiftStepsDTO liftsteps = generateRandomLiftSteps();
        when(liftstepsService.createLiftSteps(any(LiftStepsDTO.class))).thenReturn(liftsteps);

        mockMvc.perform(post("/liftsteps/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftsteps)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all LiftSteps
	 * @throws 
	 */
	@Test
	public void testB_GetAllLiftSteps() throws Exception
	{
		List<LiftStepsDTO> liftstepss = Arrays.asList(generateRandomLiftSteps(), generateRandomLiftSteps());
        when(liftstepsService.getAllLiftSteps()).thenReturn(liftstepss);

        mockMvc.perform(get("/liftsteps/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single LiftSteps by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLiftSteps() throws Exception
	{
		LiftStepsDTO liftsteps = generateRandomLiftSteps();
        when(liftstepsService.findLiftStepsById(anyInt())).thenReturn(liftsteps);

        mockMvc.perform(get("/liftsteps/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a LiftSteps
	 * @throws 
	 */
	@Test
	public void testD_UpdateLiftSteps() throws Exception
	{
	    LiftStepsDTO liftsteps = generateRandomLiftSteps();
        when(liftstepsService.updateLiftSteps(any(LiftStepsDTO.class))).thenReturn(liftsteps);

        mockMvc.perform(post("/liftsteps/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(liftsteps)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a LiftSteps
	 * @throws 
	 */
	@Test
	public void testE_DeleteLiftSteps() throws Exception
	{
		when(liftstepsService.deleteLiftSteps(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/liftsteps/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single LiftSteps by field LiftId
 * @throws
 */
@Test
public void testC_findByLiftId() throws Exception
{
    List<LiftStepsDTO> liftsteps = Arrays.asList(generateRandomLiftSteps());
    when(liftstepsService.findLiftStepsByLiftId(anyInt())).thenReturn(liftsteps);

    mockMvc.perform(get("/liftsteps/findByLiftId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single LiftSteps by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<LiftStepsDTO> liftsteps = Arrays.asList(generateRandomLiftSteps());
    when(liftstepsService.findLiftStepsByImageLoc(anyInt())).thenReturn(liftsteps);

    mockMvc.perform(get("/liftsteps/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static LiftStepsDTO generateRandomLiftSteps() {
		LiftStepsDTO record = new LiftStepsDTO();
		record.setLiftId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
}