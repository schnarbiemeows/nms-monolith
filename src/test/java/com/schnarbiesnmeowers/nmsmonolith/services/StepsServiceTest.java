package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.StepsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.StepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.Steps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.StepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class StepsServiceTest {

    @Mock
    private StepsRepository stepsRepository;

    @InjectMocks
    private StepsService stepsService;

    private Steps steps;
    private StepsDTO stepsDTO;

    @BeforeEach
    void setUp() {
        steps = generateRandomStepsEntity();
        stepsDTO = generateRandomSteps();
    }

    @Test
    void testGetAllSteps() throws Exception {
        when(stepsRepository.findAll()).thenReturn(Collections.singletonList(steps));

        List<StepsDTO> result = stepsService.getAllSteps();

        assertEquals(1, result.size());
    }

    @Test
    void testFindStepsById_Found() throws Exception {
        when(stepsRepository.findById(anyInt())).thenReturn(Optional.of(steps));

        StepsDTO result = stepsService.findStepsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindStepsById_NotFound() {
        when(stepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            stepsService.findStepsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateSteps() {
        when(stepsRepository.save(any(Steps.class))).thenReturn(steps);

        StepsDTO result = stepsService.createSteps(stepsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateSteps_Found() throws Exception {
        when(stepsRepository.findById(anyInt())).thenReturn(Optional.of(steps));
        when(stepsRepository.save(any(Steps.class))).thenReturn(steps);

        StepsDTO result = stepsService.updateSteps(stepsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateSteps_NotFound() {
        when(stepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            stepsService.updateSteps(stepsDTO);
        });

        assertEquals("id = " + stepsDTO.getStepId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteSteps_Found() throws Exception {
        when(stepsRepository.findById(anyInt())).thenReturn(Optional.of(steps));
        doNothing().when(stepsRepository).deleteById(anyInt());

        String result = stepsService.deleteSteps(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteSteps_NotFound() {
        when(stepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            stepsService.deleteSteps(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static StepsDTO generateRandomSteps() {
		StepsDTO record = new StepsDTO();
		record.setStepId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setSteps(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Steps generateRandomStepsEntity() {
		Steps record = new Steps();
		record.setStepId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setSteps(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
