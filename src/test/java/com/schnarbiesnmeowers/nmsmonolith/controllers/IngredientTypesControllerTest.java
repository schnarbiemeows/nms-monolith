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

import com.schnarbiesnmeowers.nmsmonolith.repositories.IngredientTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.IngredientTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the IngredientTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class IngredientTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private IngredientTypesController ingredienttypesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private IngredientTypesService ingredienttypesService;

    @Mock
    private IngredientTypesRepository ingredienttypesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredienttypesController).build();
    }

	/**
	 * test creating a new IngredientTypes
	 * @throws 
	 */
	@Test
	public void testA_CreateIngredientTypes() throws Exception
	{
	    IngredientTypesDTO ingredienttypes = generateRandomIngredientTypes();
        when(ingredienttypesService.createIngredientTypes(any(IngredientTypesDTO.class))).thenReturn(ingredienttypes);

        mockMvc.perform(post("/ingredienttypes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingredienttypes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all IngredientTypes
	 * @throws 
	 */
	@Test
	public void testB_GetAllIngredientTypes() throws Exception
	{
		List<IngredientTypesDTO> ingredienttypess = Arrays.asList(generateRandomIngredientTypes(), generateRandomIngredientTypes());
        when(ingredienttypesService.getAllIngredientTypes()).thenReturn(ingredienttypess);

        mockMvc.perform(get("/ingredienttypes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single IngredientTypes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetIngredientTypes() throws Exception
	{
		IngredientTypesDTO ingredienttypes = generateRandomIngredientTypes();
        when(ingredienttypesService.findIngredientTypesById(anyInt())).thenReturn(ingredienttypes);

        mockMvc.perform(get("/ingredienttypes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a IngredientTypes
	 * @throws 
	 */
	@Test
	public void testD_UpdateIngredientTypes() throws Exception
	{
	    IngredientTypesDTO ingredienttypes = generateRandomIngredientTypes();
        when(ingredienttypesService.updateIngredientTypes(any(IngredientTypesDTO.class))).thenReturn(ingredienttypes);

        mockMvc.perform(post("/ingredienttypes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingredienttypes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a IngredientTypes
	 * @throws 
	 */
	@Test
	public void testE_DeleteIngredientTypes() throws Exception
	{
		when(ingredienttypesService.deleteIngredientTypes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/ingredienttypes/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single IngredientTypes by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<IngredientTypesDTO> ingredienttypes = Arrays.asList(generateRandomIngredientTypes());
    when(ingredienttypesService.findIngredientTypesByImageLoc(anyInt())).thenReturn(ingredienttypes);

    mockMvc.perform(get("/ingredienttypes/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static IngredientTypesDTO generateRandomIngredientTypes() {
		IngredientTypesDTO record = new IngredientTypesDTO();
		record.setPrntIngrType(Randomizer.randomInt(1000));
		record.setIngrTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}