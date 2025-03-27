package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelations;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GraphRelationsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GraphRelationsServiceTest {

    @Mock
    private GraphRelationsRepository graphrelationsRepository;

    @InjectMocks
    private GraphRelationsService graphrelationsService;

    private GraphRelations graphrelations;
    private GraphRelationsDTO graphrelationsDTO;

    @BeforeEach
    void setUp() {
        graphrelations = generateRandomGraphRelationsEntity();
        graphrelationsDTO = generateRandomGraphRelations();
    }

    @Test
    void testGetAllGraphRelations() throws Exception {
        when(graphrelationsRepository.findAll()).thenReturn(Collections.singletonList(graphrelations));

        List<GraphRelationsDTO> result = graphrelationsService.getAllGraphRelations();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGraphRelationsById_Found() throws Exception {
        when(graphrelationsRepository.findById(anyInt())).thenReturn(Optional.of(graphrelations));

        GraphRelationsDTO result = graphrelationsService.findGraphRelationsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGraphRelationsById_NotFound() {
        when(graphrelationsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            graphrelationsService.findGraphRelationsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGraphRelations() {
        when(graphrelationsRepository.save(any(GraphRelations.class))).thenReturn(graphrelations);

        GraphRelationsDTO result = graphrelationsService.createGraphRelations(graphrelationsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGraphRelations_Found() throws Exception {
        when(graphrelationsRepository.findById(anyInt())).thenReturn(Optional.of(graphrelations));
        when(graphrelationsRepository.save(any(GraphRelations.class))).thenReturn(graphrelations);

        GraphRelationsDTO result = graphrelationsService.updateGraphRelations(graphrelationsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGraphRelations_NotFound() {
        when(graphrelationsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            graphrelationsService.updateGraphRelations(graphrelationsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteGraphRelations_Found() throws Exception {
        when(graphrelationsRepository.findById(anyInt())).thenReturn(Optional.of(graphrelations));
        doNothing().when(graphrelationsRepository).deleteById(anyInt());

        String result = graphrelationsService.deleteGraphRelations(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGraphRelations_NotFound() {
        when(graphrelationsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            graphrelationsService.deleteGraphRelations(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GraphRelationsDTO generateRandomGraphRelations() {
		GraphRelationsDTO record = new GraphRelationsDTO();
		record.setGraphRelationsId(2);
		record.setParentNode(Randomizer.randomInt(1000));
		record.setChildNode(Randomizer.randomInt(1000));
		record.setEdgeVal(Randomizer.randomString(20));
		record.setEdgeFk(Randomizer.randomInt(1000));
		record.setGraphRelationIndexId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static GraphRelations generateRandomGraphRelationsEntity() {
		GraphRelations record = new GraphRelations();
		record.setGraphRelationsId(2);
		record.setParentNode(Randomizer.randomInt(1000));
		record.setChildNode(Randomizer.randomInt(1000));
		record.setEdgeVal(Randomizer.randomString(20));
		record.setEdgeFk(Randomizer.randomInt(1000));
		record.setGraphRelationIndexId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
