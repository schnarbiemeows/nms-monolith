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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftMuscleDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftMuscle;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftMuscleRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LiftMuscleServiceTest {

    @Mock
    private LiftMuscleRepository liftmuscleRepository;

    @InjectMocks
    private LiftMuscleService liftmuscleService;

    private LiftMuscle liftmuscle;
    private LiftMuscleDTO liftmuscleDTO;

    @BeforeEach
    void setUp() {
        liftmuscle = generateRandomLiftMuscleEntity();
        liftmuscleDTO = generateRandomLiftMuscle();
    }

    @Test
    void testGetAllLiftMuscle() throws Exception {
        when(liftmuscleRepository.findAll()).thenReturn(Collections.singletonList(liftmuscle));

        List<LiftMuscleDTO> result = liftmuscleService.getAllLiftMuscle();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLiftMuscleById_Found() throws Exception {
        when(liftmuscleRepository.findById(anyInt())).thenReturn(Optional.of(liftmuscle));

        LiftMuscleDTO result = liftmuscleService.findLiftMuscleById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLiftMuscleById_NotFound() {
        when(liftmuscleRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftmuscleService.findLiftMuscleById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLiftMuscle() {
        when(liftmuscleRepository.save(any(LiftMuscle.class))).thenReturn(liftmuscle);

        LiftMuscleDTO result = liftmuscleService.createLiftMuscle(liftmuscleDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftMuscle_Found() throws Exception {
        when(liftmuscleRepository.findById(anyInt())).thenReturn(Optional.of(liftmuscle));
        when(liftmuscleRepository.save(any(LiftMuscle.class))).thenReturn(liftmuscle);

        LiftMuscleDTO result = liftmuscleService.updateLiftMuscle(liftmuscleDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftMuscle_NotFound() {
        when(liftmuscleRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftmuscleService.updateLiftMuscle(liftmuscleDTO);
        });

        assertEquals("id = " + liftmuscleDTO.getLiftMuscleId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteLiftMuscle_Found() throws Exception {
        when(liftmuscleRepository.findById(anyInt())).thenReturn(Optional.of(liftmuscle));
        doNothing().when(liftmuscleRepository).deleteById(anyInt());

        String result = liftmuscleService.deleteLiftMuscle(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLiftMuscle_NotFound() {
        when(liftmuscleRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftmuscleService.deleteLiftMuscle(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LiftMuscleDTO generateRandomLiftMuscle() {
		LiftMuscleDTO record = new LiftMuscleDTO();
		record.setLiftMuscleId(2);
		record.setLiftId(Randomizer.randomInt(1000));
		record.setMuscleId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static LiftMuscle generateRandomLiftMuscleEntity() {
		LiftMuscle record = new LiftMuscle();
		record.setLiftMuscleId(2);
		record.setLiftId(Randomizer.randomInt(1000));
		record.setMuscleId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
