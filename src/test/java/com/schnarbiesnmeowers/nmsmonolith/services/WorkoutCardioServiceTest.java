package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WorkoutCardioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WorkoutCardioDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WorkoutCardio;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.WorkoutCardioRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class WorkoutCardioServiceTest {

    @Mock
    private WorkoutCardioRepository workoutcardioRepository;

    @InjectMocks
    private WorkoutCardioService workoutcardioService;

    private WorkoutCardio workoutcardio;
    private WorkoutCardioDTO workoutcardioDTO;

    @BeforeEach
    void setUp() {
        workoutcardio = generateRandomWorkoutCardioEntity();
        workoutcardioDTO = generateRandomWorkoutCardio();
    }

    @Test
    void testGetAllWorkoutCardio() throws Exception {
        when(workoutcardioRepository.findAll()).thenReturn(Collections.singletonList(workoutcardio));

        List<WorkoutCardioDTO> result = workoutcardioService.getAllWorkoutCardio();

        assertEquals(1, result.size());
    }

    @Test
    void testFindWorkoutCardioById_Found() throws Exception {
        when(workoutcardioRepository.findById(anyInt())).thenReturn(Optional.of(workoutcardio));

        WorkoutCardioDTO result = workoutcardioService.findWorkoutCardioById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindWorkoutCardioById_NotFound() {
        when(workoutcardioRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutcardioService.findWorkoutCardioById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateWorkoutCardio() {
        when(workoutcardioRepository.save(any(WorkoutCardio.class))).thenReturn(workoutcardio);

        WorkoutCardioDTO result = workoutcardioService.createWorkoutCardio(workoutcardioDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWorkoutCardio_Found() throws Exception {
        when(workoutcardioRepository.findById(anyInt())).thenReturn(Optional.of(workoutcardio));
        when(workoutcardioRepository.save(any(WorkoutCardio.class))).thenReturn(workoutcardio);

        WorkoutCardioDTO result = workoutcardioService.updateWorkoutCardio(workoutcardioDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWorkoutCardio_NotFound() {
        when(workoutcardioRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutcardioService.updateWorkoutCardio(workoutcardioDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteWorkoutCardio_Found() throws Exception {
        when(workoutcardioRepository.findById(anyInt())).thenReturn(Optional.of(workoutcardio));
        doNothing().when(workoutcardioRepository).deleteById(anyInt());

        String result = workoutcardioService.deleteWorkoutCardio(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteWorkoutCardio_NotFound() {
        when(workoutcardioRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            workoutcardioService.deleteWorkoutCardio(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static WorkoutCardioDTO generateRandomWorkoutCardio() {
		WorkoutCardioDTO record = new WorkoutCardioDTO();
		record.setWorkoutCardioId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setCardioTypeId(Randomizer.randomInt(1000));
		return record;
	}
    public static WorkoutCardio generateRandomWorkoutCardioEntity() {
		WorkoutCardio record = new WorkoutCardio();
		record.setWorkoutCardioId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setCardioTypeId(Randomizer.randomInt(1000));
		return record;
	}
}
