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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GraphRelationIndexesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationIndexesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GraphRelationIndexesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GraphRelationIndexesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GraphRelationIndexesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GraphRelationIndexesController graphrelationindexesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GraphRelationIndexesService graphrelationindexesService;

    @Mock
    private GraphRelationIndexesRepository graphrelationindexesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(graphrelationindexesController).build();
    }

	/**
	 * test creating a new GraphRelationIndexes
	 * @throws 
	 */
	@Test
	public void testA_CreateGraphRelationIndexes() throws Exception
	{
	    GraphRelationIndexesDTO graphrelationindexes = generateRandomGraphRelationIndexes();
        when(graphrelationindexesService.createGraphRelationIndexes(any(GraphRelationIndexesDTO.class))).thenReturn(graphrelationindexes);

        mockMvc.perform(post("/graphrelationindexes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(graphrelationindexes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GraphRelationIndexes
	 * @throws 
	 */
	@Test
	public void testB_GetAllGraphRelationIndexes() throws Exception
	{
		List<GraphRelationIndexesDTO> graphrelationindexess = Arrays.asList(generateRandomGraphRelationIndexes(), generateRandomGraphRelationIndexes());
        when(graphrelationindexesService.getAllGraphRelationIndexes()).thenReturn(graphrelationindexess);

        mockMvc.perform(get("/graphrelationindexes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GraphRelationIndexes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGraphRelationIndexes() throws Exception
	{
		GraphRelationIndexesDTO graphrelationindexes = generateRandomGraphRelationIndexes();
        when(graphrelationindexesService.findGraphRelationIndexesById(anyInt())).thenReturn(graphrelationindexes);

        mockMvc.perform(get("/graphrelationindexes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GraphRelationIndexes
	 * @throws 
	 */
	@Test
	public void testD_UpdateGraphRelationIndexes() throws Exception
	{
	    GraphRelationIndexesDTO graphrelationindexes = generateRandomGraphRelationIndexes();
        when(graphrelationindexesService.updateGraphRelationIndexes(any(GraphRelationIndexesDTO.class))).thenReturn(graphrelationindexes);

        mockMvc.perform(post("/graphrelationindexes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(graphrelationindexes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GraphRelationIndexes
	 * @throws 
	 */
	@Test
	public void testE_DeleteGraphRelationIndexes() throws Exception
	{
		when(graphrelationindexesService.deleteGraphRelationIndexes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/graphrelationindexes/delete/2"))
                .andExpect(status().isOk());
	}



	public static GraphRelationIndexesDTO generateRandomGraphRelationIndexes() {
		GraphRelationIndexesDTO record = new GraphRelationIndexesDTO();
		record.setIndexDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}