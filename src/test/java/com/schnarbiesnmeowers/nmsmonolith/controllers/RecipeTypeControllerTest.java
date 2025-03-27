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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecipeTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecipeTypeController recipetypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecipeTypeService recipetypeService;

    @Mock
    private RecipeTypeRepository recipetypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recipetypeController).build();
    }

	/**
	 * test creating a new RecipeType
	 * @throws 
	 */
	@Test
	public void testA_CreateRecipeType() throws Exception
	{
	    RecipeTypeDTO recipetype = generateRandomRecipeType();
        when(recipetypeService.createRecipeType(any(RecipeTypeDTO.class))).thenReturn(recipetype);

        mockMvc.perform(post("/recipetype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipetype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecipeType
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecipeType() throws Exception
	{
		List<RecipeTypeDTO> recipetypes = Arrays.asList(generateRandomRecipeType(), generateRandomRecipeType());
        when(recipetypeService.getAllRecipeType()).thenReturn(recipetypes);

        mockMvc.perform(get("/recipetype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecipeType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecipeType() throws Exception
	{
		RecipeTypeDTO recipetype = generateRandomRecipeType();
        when(recipetypeService.findRecipeTypeById(anyInt())).thenReturn(recipetype);

        mockMvc.perform(get("/recipetype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecipeType
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecipeType() throws Exception
	{
	    RecipeTypeDTO recipetype = generateRandomRecipeType();
        when(recipetypeService.updateRecipeType(any(RecipeTypeDTO.class))).thenReturn(recipetype);

        mockMvc.perform(post("/recipetype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipetype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecipeType
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecipeType() throws Exception
	{
		when(recipetypeService.deleteRecipeType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recipetype/delete/2"))
                .andExpect(status().isOk());
	}



	public static RecipeTypeDTO generateRandomRecipeType() {
		RecipeTypeDTO record = new RecipeTypeDTO();
		record.setRecipeTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}