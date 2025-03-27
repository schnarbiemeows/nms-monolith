package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.services.workouts.LiftSetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.workout.LiftSetDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.workout.LiftSet;
import com.schnarbiesnmeowers.nmsmonolith.repositories.workouts.LiftSetRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LiftSetServiceTest {

    @Mock
    private LiftSetRepository liftsetRepository;

    @InjectMocks
    private LiftSetService liftsetService;

    private LiftSet liftset;
    private LiftSetDTO liftsetDTO;

    @BeforeEach
    void setUp() {
        liftset = generateRandomLiftSetEntity();
        liftsetDTO = generateRandomLiftSet();
    }

    @Test
    void testGetAllLiftSet() throws Exception {
        when(liftsetRepository.findAll()).thenReturn(List.of(liftset));

        List<LiftSetDTO> result = liftsetService.getAllLiftSet();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLiftSetById_Found() throws Exception {
        when(liftsetRepository.findById(anyInt())).thenReturn(Optional.of(liftset));

        LiftSetDTO result = liftsetService.findLiftSetById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLiftSetById_NotFound() {
        when(liftsetRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftsetService.findLiftSetById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLiftSet() {
        when(liftsetRepository.save(any(LiftSet.class))).thenReturn(liftset);

        LiftSetDTO result = liftsetService.createLiftSet(liftsetDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftSet_Found() throws Exception {
        when(liftsetRepository.findById(anyInt())).thenReturn(Optional.of(liftset));
        when(liftsetRepository.save(any(LiftSet.class))).thenReturn(liftset);

        LiftSetDTO result = liftsetService.updateLiftSet(liftsetDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftSet_NotFound() {
        when(liftsetRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftsetService.updateLiftSet(liftsetDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteLiftSet_Found() throws Exception {
        when(liftsetRepository.findById(anyInt())).thenReturn(Optional.of(liftset));
        doNothing().when(liftsetRepository).deleteById(anyInt());

        String result = liftsetService.deleteLiftSet(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLiftSet_NotFound() {
        when(liftsetRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftsetService.deleteLiftSet(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LiftSetDTO generateRandomLiftSet() {
		LiftSetDTO record = new LiftSetDTO();
		record.setLiftSetId(2);
		record.setWorkoutLiftId(Randomizer.randomInt(1000));
		record.setWeight(Randomizer.randomBigDecimal("1000"));
		record.setReps(Randomizer.randomInt(1000));
		return record;
	}
    public static LiftSet generateRandomLiftSetEntity() {
		LiftSet record = new LiftSet();
		record.setLiftSetId(2);
		record.setWorkoutLiftId(Randomizer.randomInt(1000));
		record.setWeight(Randomizer.randomBigDecimal("1000"));
		record.setReps(Randomizer.randomInt(1000));
		return record;
	}
}
