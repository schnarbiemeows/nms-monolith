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
import com.schnarbiesnmeowers.nmsmonolith.dtos.EventsTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.EventsTable;
import com.schnarbiesnmeowers.nmsmonolith.repositories.EventsTableRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class EventsTableServiceTest {

    @Mock
    private EventsTableRepository eventstableRepository;

    @InjectMocks
    private EventsTableService eventstableService;

    private EventsTable eventstable;
    private EventsTableDTO eventstableDTO;

    @BeforeEach
    void setUp() {
        eventstable = generateRandomEventsTableEntity();
        eventstableDTO = generateRandomEventsTable();
    }

    @Test
    void testGetAllEventsTable() throws Exception {
        when(eventstableRepository.findAll()).thenReturn(Collections.singletonList(eventstable));

        List<EventsTableDTO> result = eventstableService.getAllEventsTable();

        assertEquals(1, result.size());
    }

    @Test
    void testFindEventsTableById_Found() throws Exception {
        when(eventstableRepository.findById(anyInt())).thenReturn(Optional.of(eventstable));

        EventsTableDTO result = eventstableService.findEventsTableById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindEventsTableById_NotFound() {
        when(eventstableRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            eventstableService.findEventsTableById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateEventsTable() {
        when(eventstableRepository.save(any(EventsTable.class))).thenReturn(eventstable);

        EventsTableDTO result = eventstableService.createEventsTable(eventstableDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateEventsTable_Found() throws Exception {
        when(eventstableRepository.findById(anyInt())).thenReturn(Optional.of(eventstable));
        when(eventstableRepository.save(any(EventsTable.class))).thenReturn(eventstable);

        EventsTableDTO result = eventstableService.updateEventsTable(eventstableDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateEventsTable_NotFound() {
        when(eventstableRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            eventstableService.updateEventsTable(eventstableDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteEventsTable_Found() throws Exception {
        when(eventstableRepository.findById(anyInt())).thenReturn(Optional.of(eventstable));
        doNothing().when(eventstableRepository).deleteById(anyInt());

        String result = eventstableService.deleteEventsTable(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteEventsTable_NotFound() {
        when(eventstableRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            eventstableService.deleteEventsTable(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static EventsTableDTO generateRandomEventsTable() {
		EventsTableDTO record = new EventsTableDTO();
		record.setEventId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setEventName(Randomizer.randomString(20));
		record.setEventDesc(Randomizer.randomString(20));
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static EventsTable generateRandomEventsTableEntity() {
		EventsTable record = new EventsTable();
		record.setEventId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setEventName(Randomizer.randomString(20));
		record.setEventDesc(Randomizer.randomString(20));
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
