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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeSpicesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeSpicesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeSpicesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecipeSpicesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecipeSpicesController recipespicesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecipeSpicesService recipespicesService;

    @Mock
    private RecipeSpicesRepository recipespicesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recipespicesController).build();
    }

	/**
	 * test creating a new RecipeSpices
	 * @throws 
	 */
	@Test
	public void testA_CreateRecipeSpices() throws Exception
	{
	    RecipeSpicesDTO recipespices = generateRandomRecipeSpices();
        when(recipespicesService.createRecipeSpices(any(RecipeSpicesDTO.class))).thenReturn(recipespices);

        mockMvc.perform(post("/recipespices/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipespices)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecipeSpices
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecipeSpices() throws Exception
	{
		List<RecipeSpicesDTO> recipespicess = Arrays.asList(generateRandomRecipeSpices(), generateRandomRecipeSpices());
        when(recipespicesService.getAllRecipeSpices()).thenReturn(recipespicess);

        mockMvc.perform(get("/recipespices/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecipeSpices by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecipeSpices() throws Exception
	{
		RecipeSpicesDTO recipespices = generateRandomRecipeSpices();
        when(recipespicesService.findRecipeSpicesById(anyInt())).thenReturn(recipespices);

        mockMvc.perform(get("/recipespices/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecipeSpices
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecipeSpices() throws Exception
	{
	    RecipeSpicesDTO recipespices = generateRandomRecipeSpices();
        when(recipespicesService.updateRecipeSpices(any(RecipeSpicesDTO.class))).thenReturn(recipespices);

        mockMvc.perform(post("/recipespices/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipespices)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecipeSpices
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecipeSpices() throws Exception
	{
		when(recipespicesService.deleteRecipeSpices(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recipespices/delete/2"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecipeSpices by field RecipeId
	 * @throws
	 */
	@Test
	public void testC_findByRecipeId() throws Exception
	{
		List<RecipeSpicesDTO> recipespices = Arrays.asList(generateRandomRecipeSpices());
		when(recipespicesService.findRecipeSpicesByRecipeId(anyInt())).thenReturn(recipespices);

		mockMvc.perform(get("/recipespices/findByRecipeId/2"))
				.andExpect(status().isOk());
	}
	/**
	 * test getting a single RecipeSpices by field SpiceId
	 * @throws
	 */
	@Test
	public void testC_findBySpiceId() throws Exception
	{
		List<RecipeSpicesDTO> recipespices = Arrays.asList(generateRandomRecipeSpices());
		when(recipespicesService.findRecipeSpicesBySpiceId(anyInt())).thenReturn(recipespices);

		mockMvc.perform(get("/recipespices/findBySpiceId/2"))
				.andExpect(status().isOk());
	}

	public static RecipeSpicesDTO generateRandomRecipeSpices() {
		RecipeSpicesDTO record = new RecipeSpicesDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setSpiceId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}