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

import com.schnarbiesnmeowers.nmsmonolith.repositories.RecipeEquipRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeEquipService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeEquipController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class RecipeEquipControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private RecipeEquipController recipeequipController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private RecipeEquipService recipeequipService;

    @Mock
    private RecipeEquipRepository recipeequipRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(recipeequipController).build();
    }

	/**
	 * test creating a new RecipeEquip
	 * @throws 
	 */
	@Test
	public void testA_CreateRecipeEquip() throws Exception
	{
	    RecipeEquipDTO recipeequip = generateRandomRecipeEquip();
        when(recipeequipService.createRecipeEquip(any(RecipeEquipDTO.class))).thenReturn(recipeequip);

        mockMvc.perform(post("/recipeequip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipeequip)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all RecipeEquip
	 * @throws 
	 */
	@Test
	public void testB_GetAllRecipeEquip() throws Exception
	{
		List<RecipeEquipDTO> recipeequips = Arrays.asList(generateRandomRecipeEquip(), generateRandomRecipeEquip());
        when(recipeequipService.getAllRecipeEquip()).thenReturn(recipeequips);

        mockMvc.perform(get("/recipeequip/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single RecipeEquip by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetRecipeEquip() throws Exception
	{
		RecipeEquipDTO recipeequip = generateRandomRecipeEquip();
        when(recipeequipService.findRecipeEquipById(anyInt())).thenReturn(recipeequip);

        mockMvc.perform(get("/recipeequip/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a RecipeEquip
	 * @throws 
	 */
	@Test
	public void testD_UpdateRecipeEquip() throws Exception
	{
	    RecipeEquipDTO recipeequip = generateRandomRecipeEquip();
        when(recipeequipService.updateRecipeEquip(any(RecipeEquipDTO.class))).thenReturn(recipeequip);

        mockMvc.perform(post("/recipeequip/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recipeequip)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a RecipeEquip
	 * @throws 
	 */
	@Test
	public void testE_DeleteRecipeEquip() throws Exception
	{
		when(recipeequipService.deleteRecipeEquip(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/recipeequip/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single RecipeEquip by field RecEqTypeId
 * @throws
 */
@Test
public void testC_findByRecEqTypeId() throws Exception
{
    List<RecipeEquipDTO> recipeequip = Arrays.asList(generateRandomRecipeEquip());
    when(recipeequipService.findRecipeEquipByRecEqTypeId(anyInt())).thenReturn(recipeequip);

    mockMvc.perform(get("/recipeequip/findByRecEqTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single RecipeEquip by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<RecipeEquipDTO> recipeequip = Arrays.asList(generateRandomRecipeEquip());
    when(recipeequipService.findRecipeEquipByImageLoc(anyInt())).thenReturn(recipeequip);

    mockMvc.perform(get("/recipeequip/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static RecipeEquipDTO generateRandomRecipeEquip() {
		RecipeEquipDTO record = new RecipeEquipDTO();
		record.setRecEqTypeId(Randomizer.randomInt(1000));
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}