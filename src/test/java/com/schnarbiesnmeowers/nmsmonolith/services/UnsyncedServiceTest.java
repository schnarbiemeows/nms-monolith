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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UnsyncedDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Unsynced;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UnsyncedRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class UnsyncedServiceTest {

    @Mock
    private UnsyncedRepository unsyncedRepository;

    @InjectMocks
    private UnsyncedService unsyncedService;

    private Unsynced unsynced;
    private UnsyncedDTO unsyncedDTO;

    @BeforeEach
    void setUp() {
        unsynced = generateRandomUnsyncedEntity();
        unsyncedDTO = generateRandomUnsynced();
    }

    @Test
    void testGetAllUnsynced() throws Exception {
        when(unsyncedRepository.findAll()).thenReturn(Collections.singletonList(unsynced));

        List<UnsyncedDTO> result = unsyncedService.getAllUnsynced();

        assertEquals(1, result.size());
    }

    @Test
    void testFindUnsyncedById_Found() throws Exception {
        when(unsyncedRepository.findById(anyInt())).thenReturn(Optional.of(unsynced));

        UnsyncedDTO result = unsyncedService.findUnsyncedById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindUnsyncedById_NotFound() {
        when(unsyncedRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            unsyncedService.findUnsyncedById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateUnsynced() {
        when(unsyncedRepository.save(any(Unsynced.class))).thenReturn(unsynced);

        UnsyncedDTO result = unsyncedService.createUnsynced(unsyncedDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUnsynced_Found() throws Exception {
        when(unsyncedRepository.findById(anyInt())).thenReturn(Optional.of(unsynced));
        when(unsyncedRepository.save(any(Unsynced.class))).thenReturn(unsynced);

        UnsyncedDTO result = unsyncedService.updateUnsynced(unsyncedDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUnsynced_NotFound() {
        when(unsyncedRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            unsyncedService.updateUnsynced(unsyncedDTO);
        });

        assertEquals("id = " + unsyncedDTO.getUnsyncedId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteUnsynced_Found() throws Exception {
        when(unsyncedRepository.findById(anyInt())).thenReturn(Optional.of(unsynced));
        doNothing().when(unsyncedRepository).deleteById(anyInt());

        String result = unsyncedService.deleteUnsynced(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteUnsynced_NotFound() {
        when(unsyncedRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            unsyncedService.deleteUnsynced(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static UnsyncedDTO generateRandomUnsynced() {
		UnsyncedDTO record = new UnsyncedDTO();
		record.setUnsyncedId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		return record;
	}
    public static Unsynced generateRandomUnsyncedEntity() {
		Unsynced record = new Unsynced();
		record.setUnsyncedId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		return record;
	}
}
