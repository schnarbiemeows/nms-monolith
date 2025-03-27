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

import com.schnarbiesnmeowers.nmsmonolith.repositories.DietaryTemplatesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DietaryTemplatesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DietaryTemplatesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DietaryTemplatesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class DietaryTemplatesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private DietaryTemplatesController dietarytemplatesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private DietaryTemplatesService dietarytemplatesService;

    @Mock
    private DietaryTemplatesRepository dietarytemplatesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(dietarytemplatesController).build();
    }

	/**
	 * test creating a new DietaryTemplates
	 * @throws 
	 */
	@Test
	public void testA_CreateDietaryTemplates() throws Exception
	{
	    DietaryTemplatesDTO dietarytemplates = generateRandomDietaryTemplates();
        when(dietarytemplatesService.createDietaryTemplates(any(DietaryTemplatesDTO.class))).thenReturn(dietarytemplates);

        mockMvc.perform(post("/dietarytemplates/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dietarytemplates)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all DietaryTemplates
	 * @throws 
	 */
	@Test
	public void testB_GetAllDietaryTemplates() throws Exception
	{
		List<DietaryTemplatesDTO> dietarytemplatess = Arrays.asList(generateRandomDietaryTemplates(), generateRandomDietaryTemplates());
        when(dietarytemplatesService.getAllDietaryTemplates()).thenReturn(dietarytemplatess);

        mockMvc.perform(get("/dietarytemplates/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single DietaryTemplates by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetDietaryTemplates() throws Exception
	{
		DietaryTemplatesDTO dietarytemplates = generateRandomDietaryTemplates();
        when(dietarytemplatesService.findDietaryTemplatesById(anyInt())).thenReturn(dietarytemplates);

        mockMvc.perform(get("/dietarytemplates/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a DietaryTemplates
	 * @throws 
	 */
	@Test
	public void testD_UpdateDietaryTemplates() throws Exception
	{
	    DietaryTemplatesDTO dietarytemplates = generateRandomDietaryTemplates();
        when(dietarytemplatesService.updateDietaryTemplates(any(DietaryTemplatesDTO.class))).thenReturn(dietarytemplates);

        mockMvc.perform(post("/dietarytemplates/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dietarytemplates)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a DietaryTemplates
	 * @throws 
	 */
	@Test
	public void testE_DeleteDietaryTemplates() throws Exception
	{
		when(dietarytemplatesService.deleteDietaryTemplates(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/dietarytemplates/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single DietaryTemplates by field UserId
 * @throws
 */
@Test
public void testC_findByUserId() throws Exception
{
    List<DietaryTemplatesDTO> dietarytemplates = Arrays.asList(generateRandomDietaryTemplates());
    when(dietarytemplatesService.findDietaryTemplatesByUserId(anyInt())).thenReturn(dietarytemplates);

    mockMvc.perform(get("/dietarytemplates/findByUserId/2"))
            .andExpect(status().isOk());
}

	public static DietaryTemplatesDTO generateRandomDietaryTemplates() {
		DietaryTemplatesDTO record = new DietaryTemplatesDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setTemplateName(Randomizer.randomString(20));
		return record;
	}
}