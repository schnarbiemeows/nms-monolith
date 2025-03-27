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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ServingTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ServingTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ServingTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ServingTypesController servingtypesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ServingTypesService servingtypesService;

    @Mock
    private ServingTypesRepository servingtypesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(servingtypesController).build();
    }

	/**
	 * test creating a new ServingTypes
	 * @throws 
	 */
	@Test
	public void testA_CreateServingTypes() throws Exception
	{
	    ServingTypesDTO servingtypes = generateRandomServingTypes();
        when(servingtypesService.createServingTypes(any(ServingTypesDTO.class))).thenReturn(servingtypes);

        mockMvc.perform(post("/servingtypes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servingtypes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ServingTypes
	 * @throws 
	 */
	@Test
	public void testB_GetAllServingTypes() throws Exception
	{
		List<ServingTypesDTO> servingtypess = Arrays.asList(generateRandomServingTypes(), generateRandomServingTypes());
        when(servingtypesService.getAllServingTypes()).thenReturn(servingtypess);

        mockMvc.perform(get("/servingtypes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ServingTypes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetServingTypes() throws Exception
	{
		ServingTypesDTO servingtypes = generateRandomServingTypes();
        when(servingtypesService.findServingTypesById(anyInt())).thenReturn(servingtypes);

        mockMvc.perform(get("/servingtypes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ServingTypes
	 * @throws 
	 */
	@Test
	public void testD_UpdateServingTypes() throws Exception
	{
	    ServingTypesDTO servingtypes = generateRandomServingTypes();
        when(servingtypesService.updateServingTypes(any(ServingTypesDTO.class))).thenReturn(servingtypes);

        mockMvc.perform(post("/servingtypes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(servingtypes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ServingTypes
	 * @throws 
	 */
	@Test
	public void testE_DeleteServingTypes() throws Exception
	{
		when(servingtypesService.deleteServingTypes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/servingtypes/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single ServingTypes by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<ServingTypesDTO> servingtypes = Arrays.asList(generateRandomServingTypes());
    when(servingtypesService.findServingTypesByImageLoc(anyInt())).thenReturn(servingtypes);

    mockMvc.perform(get("/servingtypes/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static ServingTypesDTO generateRandomServingTypes() {
		ServingTypesDTO record = new ServingTypesDTO();
		record.setServTypeCde(Randomizer.randomString(10));
		record.setServTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}