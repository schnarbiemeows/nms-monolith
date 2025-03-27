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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeStepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeStepsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeStepsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecipeStepsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecipeStepsController recipestepsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecipeStepsService recipestepsService;

    @Mock
    private RecipeStepsRepository recipestepsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recipestepsController).build();
    }

	/**
	 * test creating a new RecipeSteps
	 * @throws 
	 */
	@Test
	public void testA_CreateRecipeSteps() throws Exception
	{
	    RecipeStepsDTO recipesteps = generateRandomRecipeSteps();
        when(recipestepsService.createRecipeSteps(any(RecipeStepsDTO.class))).thenReturn(recipesteps);

        mockMvc.perform(post("/recipesteps/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipesteps)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecipeSteps
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecipeSteps() throws Exception
	{
		List<RecipeStepsDTO> recipestepss = Arrays.asList(generateRandomRecipeSteps(), generateRandomRecipeSteps());
        when(recipestepsService.getAllRecipeSteps()).thenReturn(recipestepss);

        mockMvc.perform(get("/recipesteps/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecipeSteps by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecipeSteps() throws Exception
	{
		RecipeStepsDTO recipesteps = generateRandomRecipeSteps();
        when(recipestepsService.findRecipeStepsById(anyInt())).thenReturn(recipesteps);

        mockMvc.perform(get("/recipesteps/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecipeSteps
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecipeSteps() throws Exception
	{
	    RecipeStepsDTO recipesteps = generateRandomRecipeSteps();
        when(recipestepsService.updateRecipeSteps(any(RecipeStepsDTO.class))).thenReturn(recipesteps);

        mockMvc.perform(post("/recipesteps/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipesteps)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecipeSteps
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecipeSteps() throws Exception
	{
		when(recipestepsService.deleteRecipeSteps(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recipesteps/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single RecipeSteps by field RecipeId
 * @throws
 */
@Test
public void testC_findByRecipeId() throws Exception
{
    List<RecipeStepsDTO> recipesteps = Arrays.asList(generateRandomRecipeSteps());
    when(recipestepsService.findRecipeStepsByRecipeId(anyInt())).thenReturn(recipesteps);

    mockMvc.perform(get("/recipesteps/findByRecipeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RecipeSteps by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<RecipeStepsDTO> recipesteps = Arrays.asList(generateRandomRecipeSteps());
    when(recipestepsService.findRecipeStepsByImageLoc(anyInt())).thenReturn(recipesteps);

    mockMvc.perform(get("/recipesteps/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static RecipeStepsDTO generateRandomRecipeSteps() {
		RecipeStepsDTO record = new RecipeStepsDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}