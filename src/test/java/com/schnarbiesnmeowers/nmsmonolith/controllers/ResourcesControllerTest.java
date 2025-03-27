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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ResourcesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ResourcesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ResourcesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ResourcesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ResourcesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ResourcesController resourcesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ResourcesService resourcesService;

    @Mock
    private ResourcesRepository resourcesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(resourcesController).build();
    }

	/**
	 * test creating a new Resources
	 * @throws 
	 */
	@Test
	public void testA_CreateResources() throws Exception
	{
	    ResourcesDTO resources = generateRandomResources();
        when(resourcesService.createResources(any(ResourcesDTO.class))).thenReturn(resources);

        mockMvc.perform(post("/resources/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(resources)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Resources
	 * @throws 
	 */
	@Test
	public void testB_GetAllResources() throws Exception
	{
		List<ResourcesDTO> resourcess = Arrays.asList(generateRandomResources(), generateRandomResources());
        when(resourcesService.getAllResources()).thenReturn(resourcess);

        mockMvc.perform(get("/resources/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Resources by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetResources() throws Exception
	{
		ResourcesDTO resources = generateRandomResources();
        when(resourcesService.findResourcesById(anyInt())).thenReturn(resources);

        mockMvc.perform(get("/resources/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Resources
	 * @throws 
	 */
	@Test
	public void testD_UpdateResources() throws Exception
	{
	    ResourcesDTO resources = generateRandomResources();
        when(resourcesService.updateResources(any(ResourcesDTO.class))).thenReturn(resources);

        mockMvc.perform(post("/resources/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(resources)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Resources
	 * @throws 
	 */
	@Test
	public void testE_DeleteResources() throws Exception
	{
		when(resourcesService.deleteResources(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/resources/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Resources by field RsrcTypeId
 * @throws
 */
@Test
public void testC_findByRsrcTypeId() throws Exception
{
    List<ResourcesDTO> resources = Arrays.asList(generateRandomResources());
    when(resourcesService.findResourcesByRsrcTypeId(anyInt())).thenReturn(resources);

    mockMvc.perform(get("/resources/findByRsrcTypeId/2"))
            .andExpect(status().isOk());
}

	public static ResourcesDTO generateRandomResources() {
		ResourcesDTO record = new ResourcesDTO();
		record.setRsrcTypeId(Randomizer.randomInt(1000));
		record.setRsrcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}