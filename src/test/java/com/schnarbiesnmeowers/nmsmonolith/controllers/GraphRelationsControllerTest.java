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

import com.schnarbiesnmeowers.nmsmonolith.repositories.GraphRelationsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GraphRelationsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GraphRelationsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class GraphRelationsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private GraphRelationsController graphrelationsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private GraphRelationsService graphrelationsService;

    @Mock
    private GraphRelationsRepository graphrelationsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(graphrelationsController).build();
    }

	/**
	 * test creating a new GraphRelations
	 * @throws 
	 */
	@Test
	public void testA_CreateGraphRelations() throws Exception
	{
	    GraphRelationsDTO graphrelations = generateRandomGraphRelations();
        when(graphrelationsService.createGraphRelations(any(GraphRelationsDTO.class))).thenReturn(graphrelations);

        mockMvc.perform(post("/graphrelations/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(graphrelations)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all GraphRelations
	 * @throws 
	 */
	@Test
	public void testB_GetAllGraphRelations() throws Exception
	{
		List<GraphRelationsDTO> graphrelationss = Arrays.asList(generateRandomGraphRelations(), generateRandomGraphRelations());
        when(graphrelationsService.getAllGraphRelations()).thenReturn(graphrelationss);

        mockMvc.perform(get("/graphrelations/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single GraphRelations by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetGraphRelations() throws Exception
	{
		GraphRelationsDTO graphrelations = generateRandomGraphRelations();
        when(graphrelationsService.findGraphRelationsById(anyInt())).thenReturn(graphrelations);

        mockMvc.perform(get("/graphrelations/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a GraphRelations
	 * @throws 
	 */
	@Test
	public void testD_UpdateGraphRelations() throws Exception
	{
	    GraphRelationsDTO graphrelations = generateRandomGraphRelations();
        when(graphrelationsService.updateGraphRelations(any(GraphRelationsDTO.class))).thenReturn(graphrelations);

        mockMvc.perform(post("/graphrelations/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(graphrelations)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a GraphRelations
	 * @throws 
	 */
	@Test
	public void testE_DeleteGraphRelations() throws Exception
	{
		when(graphrelationsService.deleteGraphRelations(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/graphrelations/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single GraphRelations by field GraphRelationIndexId
 * @throws
 */
@Test
public void testC_findByGraphRelationIndexId() throws Exception
{
    List<GraphRelationsDTO> graphrelations = Arrays.asList(generateRandomGraphRelations());
    when(graphrelationsService.findGraphRelationsByGraphRelationIndexId(anyInt())).thenReturn(graphrelations);

    mockMvc.perform(get("/graphrelations/findByGraphRelationIndexId/2"))
            .andExpect(status().isOk());
}

	public static GraphRelationsDTO generateRandomGraphRelations() {
		GraphRelationsDTO record = new GraphRelationsDTO();
		record.setParentNode(Randomizer.randomInt(1000));
		record.setChildNode(Randomizer.randomInt(1000));
		record.setEdgeVal(Randomizer.randomString(20));
		record.setEdgeFk(Randomizer.randomInt(1000));
		record.setGraphRelationIndexId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}