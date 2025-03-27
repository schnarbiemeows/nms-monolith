package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.WeightWorkoutTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.WeightWorkoutTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WeightWorkoutType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.WeightWorkoutTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class WeightWorkoutTypeServiceTest {

    @Mock
    private WeightWorkoutTypeRepository weightworkouttypeRepository;

    @InjectMocks
    private WeightWorkoutTypeService weightworkouttypeService;

    private WeightWorkoutType weightworkouttype;
    private WeightWorkoutTypeDTO weightworkouttypeDTO;

    @BeforeEach
    void setUp() {
        weightworkouttype = generateRandomWeightWorkoutTypeEntity();
        weightworkouttypeDTO = generateRandomWeightWorkoutType();
    }

    @Test
    void testGetAllWeightWorkoutType() throws Exception {
        when(weightworkouttypeRepository.findAll()).thenReturn(Collections.singletonList(weightworkouttype));

        List<WeightWorkoutTypeDTO> result = weightworkouttypeService.getAllWeightWorkoutType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindWeightWorkoutTypeById_Found() throws Exception {
        when(weightworkouttypeRepository.findById(anyInt())).thenReturn(Optional.of(weightworkouttype));

        WeightWorkoutTypeDTO result = weightworkouttypeService.findWeightWorkoutTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindWeightWorkoutTypeById_NotFound() {
        when(weightworkouttypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            weightworkouttypeService.findWeightWorkoutTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateWeightWorkoutType() {
        when(weightworkouttypeRepository.save(any(WeightWorkoutType.class))).thenReturn(weightworkouttype);

        WeightWorkoutTypeDTO result = weightworkouttypeService.createWeightWorkoutType(weightworkouttypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWeightWorkoutType_Found() throws Exception {
        when(weightworkouttypeRepository.findById(anyInt())).thenReturn(Optional.of(weightworkouttype));
        when(weightworkouttypeRepository.save(any(WeightWorkoutType.class))).thenReturn(weightworkouttype);

        WeightWorkoutTypeDTO result = weightworkouttypeService.updateWeightWorkoutType(weightworkouttypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateWeightWorkoutType_NotFound() {
        when(weightworkouttypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            weightworkouttypeService.updateWeightWorkoutType(weightworkouttypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteWeightWorkoutType_Found() throws Exception {
        when(weightworkouttypeRepository.findById(anyInt())).thenReturn(Optional.of(weightworkouttype));
        doNothing().when(weightworkouttypeRepository).deleteById(anyInt());

        String result = weightworkouttypeService.deleteWeightWorkoutType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteWeightWorkoutType_NotFound() {
        when(weightworkouttypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            weightworkouttypeService.deleteWeightWorkoutType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static WeightWorkoutTypeDTO generateRandomWeightWorkoutType() {
		WeightWorkoutTypeDTO record = new WeightWorkoutTypeDTO();
		record.setWeightWorkoutTypeId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		return record;
	}
    public static WeightWorkoutType generateRandomWeightWorkoutTypeEntity() {
		WeightWorkoutType record = new WeightWorkoutType();
		record.setWeightWorkoutTypeId(2);
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		return record;
	}
}
