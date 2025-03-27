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

import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class LiftsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private LiftsController liftsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private LiftsService liftsService;

    @Mock
    private LiftsRepository liftsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(liftsController).build();
    }

	/**
	 * test creating a new Lifts
	 * @throws 
	 */
	@Test
	public void testA_CreateLifts() throws Exception
	{
	    LiftsDTO lifts = generateRandomLifts();
        when(liftsService.createLifts(any(LiftsDTO.class))).thenReturn(lifts);

        mockMvc.perform(post("/lifts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lifts)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Lifts
	 * @throws 
	 */
	@Test
	public void testB_GetAllLifts() throws Exception
	{
		List<LiftsDTO> liftss = Arrays.asList(generateRandomLifts(), generateRandomLifts());
        when(liftsService.getAllLifts()).thenReturn(liftss);

        mockMvc.perform(get("/lifts/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Lifts by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetLifts() throws Exception
	{
		LiftsDTO lifts = generateRandomLifts();
        when(liftsService.findLiftsById(anyInt())).thenReturn(lifts);

        mockMvc.perform(get("/lifts/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Lifts
	 * @throws 
	 */
	@Test
	public void testD_UpdateLifts() throws Exception
	{
	    LiftsDTO lifts = generateRandomLifts();
        when(liftsService.updateLifts(any(LiftsDTO.class))).thenReturn(lifts);

        mockMvc.perform(post("/lifts/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(lifts)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Lifts
	 * @throws 
	 */
	@Test
	public void testE_DeleteLifts() throws Exception
	{
		when(liftsService.deleteLifts(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/lifts/delete/2"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Lifts by field ImageLoc
	 * @throws
	 */
	@Test
	public void testC_findByImageLoc() throws Exception
	{
		List<LiftsDTO> lifts = Arrays.asList(generateRandomLifts());
		when(liftsService.findLiftsByImageLoc(anyInt())).thenReturn(lifts);

		mockMvc.perform(get("/lifts/findByImageLoc/2"))
				.andExpect(status().isOk());
	}

	public static LiftsDTO generateRandomLifts() {
		LiftsDTO record = new LiftsDTO();
		record.setLiftDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		return record;
	}
}