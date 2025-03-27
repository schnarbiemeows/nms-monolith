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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalEventDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalEvent;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalEventRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GoalEventServiceTest {

    @Mock
    private GoalEventRepository goaleventRepository;

    @InjectMocks
    private GoalEventService goaleventService;

    private GoalEvent goalevent;
    private GoalEventDTO goaleventDTO;

    @BeforeEach
    void setUp() {
        goalevent = generateRandomGoalEventEntity();
        goaleventDTO = generateRandomGoalEvent();
    }

    @Test
    void testGetAllGoalEvent() throws Exception {
        when(goaleventRepository.findAll()).thenReturn(Collections.singletonList(goalevent));

        List<GoalEventDTO> result = goaleventService.getAllGoalEvent();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGoalEventById_Found() throws Exception {
        when(goaleventRepository.findById(anyInt())).thenReturn(Optional.of(goalevent));

        GoalEventDTO result = goaleventService.findGoalEventById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGoalEventById_NotFound() {
        when(goaleventRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goaleventService.findGoalEventById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGoalEvent() {
        when(goaleventRepository.save(any(GoalEvent.class))).thenReturn(goalevent);

        GoalEventDTO result = goaleventService.createGoalEvent(goaleventDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalEvent_Found() throws Exception {
        when(goaleventRepository.findById(anyInt())).thenReturn(Optional.of(goalevent));
        when(goaleventRepository.save(any(GoalEvent.class))).thenReturn(goalevent);

        GoalEventDTO result = goaleventService.updateGoalEvent(goaleventDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalEvent_NotFound() {
        when(goaleventRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goaleventService.updateGoalEvent(goaleventDTO);
        });

        assertEquals("id = " + goaleventDTO.getGoalEventId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGoalEvent_Found() throws Exception {
        when(goaleventRepository.findById(anyInt())).thenReturn(Optional.of(goalevent));
        doNothing().when(goaleventRepository).deleteById(anyInt());

        String result = goaleventService.deleteGoalEvent(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGoalEvent_NotFound() {
        when(goaleventRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goaleventService.deleteGoalEvent(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GoalEventDTO generateRandomGoalEvent() {
		GoalEventDTO record = new GoalEventDTO();
		record.setGoalEventId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalId(Randomizer.randomInt(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
    public static GoalEvent generateRandomGoalEventEntity() {
		GoalEvent record = new GoalEvent();
		record.setGoalEventId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalId(Randomizer.randomInt(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
}
