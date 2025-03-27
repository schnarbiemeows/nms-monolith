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
import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.BldstTable;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BldstTableRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class BldstTableServiceTest {

    @Mock
    private BldstTableRepository bldsttableRepository;

    @InjectMocks
    private BldstTableService bldsttableService;

    private BldstTable bldsttable;
    private BldstTableDTO bldsttableDTO;

    @BeforeEach
    void setUp() {
        bldsttable = generateRandomBldstTableEntity();
        bldsttableDTO = generateRandomBldstTable();
    }

    @Test
    void testGetAllBldstTable() throws Exception {
        when(bldsttableRepository.getAllActiveBDLST())
                .thenReturn(Collections.singletonList(bldsttable));
        List<BldstTableDTO> result = bldsttableService.getAllBldstTable();
        assertEquals(1, result.size());
    }

    @Test
    void testFindBldstTableById_Found() throws Exception {
        when(bldsttableRepository.findById(anyInt())).thenReturn(Optional.of(bldsttable));

        BldstTableDTO result = bldsttableService.findBldstTableById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindBldstTableById_NotFound() {
        when(bldsttableRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bldsttableService.findBldstTableById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateBldstTable() {
        when(bldsttableRepository.save(any(BldstTable.class))).thenReturn(bldsttable);

        BldstTableDTO result = bldsttableService.createBldstTable(bldsttableDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBldstTable_Found() throws Exception {
        when(bldsttableRepository.findById(anyInt())).thenReturn(Optional.of(bldsttable));
        when(bldsttableRepository.save(any(BldstTable.class))).thenReturn(bldsttable);

        BldstTableDTO result = bldsttableService.updateBldstTable(bldsttableDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBldstTable_NotFound() {
        when(bldsttableRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bldsttableService.updateBldstTable(bldsttableDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteBldstTable_Found() throws Exception {
        when(bldsttableRepository.findById(anyInt())).thenReturn(Optional.of(bldsttable));
        doNothing().when(bldsttableRepository).deleteById(anyInt());

        String result = bldsttableService.deleteBldstTable(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteBldstTable_NotFound() {
        when(bldsttableRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bldsttableService.deleteBldstTable(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static BldstTableDTO generateRandomBldstTable() {
		BldstTableDTO record = new BldstTableDTO();
		record.setBldstTableId(2);
		record.setBldstCde(Randomizer.randomString(3));
		record.setBldstDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static BldstTable generateRandomBldstTableEntity() {
		BldstTable record = new BldstTable();
		record.setBldstTableId(2);
		record.setBldstCde(Randomizer.randomString(3));
		record.setBldstDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
