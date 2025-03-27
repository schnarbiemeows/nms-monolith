package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutLiftService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutLiftDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutLift;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutLiftRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class WorkoutLiftServiceTest {

    @Mock
    private WorkoutLiftRepository workoutliftRepository;

    @InjectMocks
    private WorkoutLiftService workoutliftService;

    private WorkoutLift workoutlift;
    private WorkoutLiftDTO workoutliftDTO;

    @BeforeEach
    void setUp() {
        workoutlift = generateRandomWorkoutLiftEntity();
        workoutliftDTO = generateRandomWorkoutLift();
    }

    @Test
    void testGetAllWorkoutLift() throws Exception {
        when(workoutliftRepository.findAll()).thenReturn(Collections.singletonList(workoutlift));

        List<WorkoutLiftDTO> result = workoutliftService.getAllWorkoutLift();

        assertEquals(1, result.size());
    }

    @Test
    void testFindWorkoutLiftById_Found() throws Exception {
        when(workoutliftRepository.findById(anyInt())).thenReturn(Optional.of(workoutlift));

        WorkoutLiftDTO result = workoutliftService.findWorkoutLiftById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindWorkoutLiftById_NotFound() {
        when(workoutliftRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutliftService.findWorkoutLiftById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateWorkoutLift() {
        when(workoutliftRepository.save(any(WorkoutLift.class))).thenReturn(workoutlift);

        WorkoutLiftDTO result = workoutliftService.createWorkoutLift(workoutliftDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWorkoutLift_Found() throws Exception {
        when(workoutliftRepository.findById(anyInt())).thenReturn(Optional.of(workoutlift));
        when(workoutliftRepository.save(any(WorkoutLift.class))).thenReturn(workoutlift);

        WorkoutLiftDTO result = workoutliftService.updateWorkoutLift(workoutliftDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWorkoutLift_NotFound() {
        when(workoutliftRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutliftService.updateWorkoutLift(workoutliftDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteWorkoutLift_Found() throws Exception {
        when(workoutliftRepository.findById(anyInt())).thenReturn(Optional.of(workoutlift));
        doNothing().when(workoutliftRepository).deleteById(anyInt());

        String result = workoutliftService.deleteWorkoutLift(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteWorkoutLift_NotFound() {
        when(workoutliftRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutliftService.deleteWorkoutLift(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static WorkoutLiftDTO generateRandomWorkoutLift() {
		WorkoutLiftDTO record = new WorkoutLiftDTO();
		record.setWorkoutLiftId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setLiftId(Randomizer.randomInt(1000));
		return record;
	}
    public static WorkoutLift generateRandomWorkoutLiftEntity() {
		WorkoutLift record = new WorkoutLift();
		record.setWorkoutLiftId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setLiftId(Randomizer.randomInt(1000));
		return record;
	}
}
