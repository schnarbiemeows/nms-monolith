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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GraphRelationIndexesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GraphRelationIndexes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GraphRelationIndexesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GraphRelationIndexesServiceTest {

    @Mock
    private GraphRelationIndexesRepository graphrelationindexesRepository;

    @InjectMocks
    private GraphRelationIndexesService graphrelationindexesService;

    private GraphRelationIndexes graphrelationindexes;
    private GraphRelationIndexesDTO graphrelationindexesDTO;

    @BeforeEach
    void setUp() {
        graphrelationindexes = generateRandomGraphRelationIndexesEntity();
        graphrelationindexesDTO = generateRandomGraphRelationIndexes();
    }

    @Test
    void testGetAllGraphRelationIndexes() throws Exception {
        when(graphrelationindexesRepository.findAll()).thenReturn(Collections.singletonList(graphrelationindexes));

        List<GraphRelationIndexesDTO> result = graphrelationindexesService.getAllGraphRelationIndexes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGraphRelationIndexesById_Found() throws Exception {
        when(graphrelationindexesRepository.findById(anyInt())).thenReturn(Optional.of(graphrelationindexes));

        GraphRelationIndexesDTO result = graphrelationindexesService.findGraphRelationIndexesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGraphRelationIndexesById_NotFound() {
        when(graphrelationindexesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            graphrelationindexesService.findGraphRelationIndexesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGraphRelationIndexes() {
        when(graphrelationindexesRepository.save(any(GraphRelationIndexes.class))).thenReturn(graphrelationindexes);

        GraphRelationIndexesDTO result = graphrelationindexesService.createGraphRelationIndexes(graphrelationindexesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGraphRelationIndexes_Found() throws Exception {
        when(graphrelationindexesRepository.findById(anyInt())).thenReturn(Optional.of(graphrelationindexes));
        when(graphrelationindexesRepository.save(any(GraphRelationIndexes.class))).thenReturn(graphrelationindexes);

        GraphRelationIndexesDTO result = graphrelationindexesService.updateGraphRelationIndexes(graphrelationindexesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGraphRelationIndexes_NotFound() {
        when(graphrelationindexesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            graphrelationindexesService.updateGraphRelationIndexes(graphrelationindexesDTO);
        });

        assertEquals("id = " + graphrelationindexesDTO.getGraphRelationIndexId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGraphRelationIndexes_Found() throws Exception {
        when(graphrelationindexesRepository.findById(anyInt())).thenReturn(Optional.of(graphrelationindexes));
        doNothing().when(graphrelationindexesRepository).deleteById(anyInt());

        String result = graphrelationindexesService.deleteGraphRelationIndexes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGraphRelationIndexes_NotFound() {
        when(graphrelationindexesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            graphrelationindexesService.deleteGraphRelationIndexes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GraphRelationIndexesDTO generateRandomGraphRelationIndexes() {
		GraphRelationIndexesDTO record = new GraphRelationIndexesDTO();
		record.setGraphRelationIndexId(2);
		record.setIndexDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static GraphRelationIndexes generateRandomGraphRelationIndexesEntity() {
		GraphRelationIndexes record = new GraphRelationIndexes();
		record.setGraphRelationIndexId(2);
		record.setIndexDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
