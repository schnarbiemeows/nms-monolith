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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ExerciseTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ExerciseType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ExerciseTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ExerciseTypeServiceTest {

    @Mock
    private ExerciseTypeRepository exercisetypeRepository;

    @InjectMocks
    private ExerciseTypeService exercisetypeService;

    private ExerciseType exercisetype;
    private ExerciseTypeDTO exercisetypeDTO;

    @BeforeEach
    void setUp() {
        exercisetype = generateRandomExerciseTypeEntity();
        exercisetypeDTO = generateRandomExerciseType();
    }

    @Test
    void testGetAllExerciseType() throws Exception {
        when(exercisetypeRepository.findAll()).thenReturn(Collections.singletonList(exercisetype));

        List<ExerciseTypeDTO> result = exercisetypeService.getAllExerciseType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindExerciseTypeById_Found() throws Exception {
        when(exercisetypeRepository.findById(anyInt())).thenReturn(Optional.of(exercisetype));

        ExerciseTypeDTO result = exercisetypeService.findExerciseTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindExerciseTypeById_NotFound() {
        when(exercisetypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            exercisetypeService.findExerciseTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateExerciseType() {
        when(exercisetypeRepository.save(any(ExerciseType.class))).thenReturn(exercisetype);

        ExerciseTypeDTO result = exercisetypeService.createExerciseType(exercisetypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateExerciseType_Found() throws Exception {
        when(exercisetypeRepository.findById(anyInt())).thenReturn(Optional.of(exercisetype));
        when(exercisetypeRepository.save(any(ExerciseType.class))).thenReturn(exercisetype);

        ExerciseTypeDTO result = exercisetypeService.updateExerciseType(exercisetypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateExerciseType_NotFound() {
        when(exercisetypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            exercisetypeService.updateExerciseType(exercisetypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteExerciseType_Found() throws Exception {
        when(exercisetypeRepository.findById(anyInt())).thenReturn(Optional.of(exercisetype));
        doNothing().when(exercisetypeRepository).deleteById(anyInt());

        String result = exercisetypeService.deleteExerciseType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteExerciseType_NotFound() {
        when(exercisetypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            exercisetypeService.deleteExerciseType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ExerciseTypeDTO generateRandomExerciseType() {
		ExerciseTypeDTO record = new ExerciseTypeDTO();
		record.setExerciseTypeId(2);
		record.setPrntExerciseType(Randomizer.randomInt(1000));
		record.setExerciseTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static ExerciseType generateRandomExerciseTypeEntity() {
		ExerciseType record = new ExerciseType();
		record.setExerciseTypeId(2);
		record.setPrntExerciseType(Randomizer.randomInt(1000));
		record.setExerciseTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
