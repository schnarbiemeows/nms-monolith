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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeOptionsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeOptionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ServingTypeOptionsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ServingTypeOptionsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ServingTypeOptionsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ServingTypeOptionsController servingtypeoptionsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ServingTypeOptionsService servingtypeoptionsService;

    @Mock
    private ServingTypeOptionsRepository servingtypeoptionsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(servingtypeoptionsController).build();
    }

	/**
	 * test creating a new ServingTypeOptions
	 * @throws 
	 */
	@Test
	public void testA_CreateServingTypeOptions() throws Exception
	{
	    ServingTypeOptionsDTO servingtypeoptions = generateRandomServingTypeOptions();
        when(servingtypeoptionsService.createServingTypeOptions(any(ServingTypeOptionsDTO.class))).thenReturn(servingtypeoptions);

        mockMvc.perform(post("/servingtypeoptions/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servingtypeoptions)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ServingTypeOptions
	 * @throws 
	 */
	@Test
	public void testB_GetAllServingTypeOptions() throws Exception
	{
		List<ServingTypeOptionsDTO> servingtypeoptionss = Arrays.asList(generateRandomServingTypeOptions(), generateRandomServingTypeOptions());
        when(servingtypeoptionsService.getAllServingTypeOptions()).thenReturn(servingtypeoptionss);

        mockMvc.perform(get("/servingtypeoptions/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ServingTypeOptions by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetServingTypeOptions() throws Exception
	{
		ServingTypeOptionsDTO servingtypeoptions = generateRandomServingTypeOptions();
        when(servingtypeoptionsService.findServingTypeOptionsById(anyInt())).thenReturn(servingtypeoptions);

        mockMvc.perform(get("/servingtypeoptions/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ServingTypeOptions
	 * @throws 
	 */
	@Test
	public void testD_UpdateServingTypeOptions() throws Exception
	{
	    ServingTypeOptionsDTO servingtypeoptions = generateRandomServingTypeOptions();
        when(servingtypeoptionsService.updateServingTypeOptions(any(ServingTypeOptionsDTO.class))).thenReturn(servingtypeoptions);

        mockMvc.perform(post("/servingtypeoptions/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servingtypeoptions)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ServingTypeOptions
	 * @throws 
	 */
	@Test
	public void testE_DeleteServingTypeOptions() throws Exception
	{
		when(servingtypeoptionsService.deleteServingTypeOptions(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/servingtypeoptions/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single ServingTypeOptions by field ServTypeId
 * @throws
 */
@Test
public void testC_findByServTypeId() throws Exception
{
    List<ServingTypeOptionsDTO> servingtypeoptions = Arrays.asList(generateRandomServingTypeOptions());
    when(servingtypeoptionsService.findServingTypeOptionsByServTypeId(anyInt())).thenReturn(servingtypeoptions);

    mockMvc.perform(get("/servingtypeoptions/findByServTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single ServingTypeOptions by field MenuOption
 * @throws
 */
@Test
public void testC_findByMenuOption() throws Exception
{
    List<ServingTypeOptionsDTO> servingtypeoptions = Arrays.asList(generateRandomServingTypeOptions());
    when(servingtypeoptionsService.findServingTypeOptionsByMenuOption(anyInt())).thenReturn(servingtypeoptions);

    mockMvc.perform(get("/servingtypeoptions/findByMenuOption/2"))
            .andExpect(status().isOk());
}

	public static ServingTypeOptionsDTO generateRandomServingTypeOptions() {
		ServingTypeOptionsDTO record = new ServingTypeOptionsDTO();
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setMenuOption(Randomizer.randomInt(1000));
		return record;
	}
}