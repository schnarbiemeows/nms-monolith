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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftSteps;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftStepsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LiftStepsServiceTest {

    @Mock
    private LiftStepsRepository liftstepsRepository;

    @InjectMocks
    private LiftStepsService liftstepsService;

    private LiftSteps liftsteps;
    private LiftStepsDTO liftstepsDTO;

    @BeforeEach
    void setUp() {
        liftsteps = generateRandomLiftStepsEntity();
        liftstepsDTO = generateRandomLiftSteps();
    }

    @Test
    void testGetAllLiftSteps() throws Exception {
        when(liftstepsRepository.findAll()).thenReturn(Collections.singletonList(liftsteps));

        List<LiftStepsDTO> result = liftstepsService.getAllLiftSteps();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLiftStepsById_Found() throws Exception {
        when(liftstepsRepository.findById(anyInt())).thenReturn(Optional.of(liftsteps));

        LiftStepsDTO result = liftstepsService.findLiftStepsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLiftStepsById_NotFound() {
        when(liftstepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftstepsService.findLiftStepsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLiftSteps() {
        when(liftstepsRepository.save(any(LiftSteps.class))).thenReturn(liftsteps);

        LiftStepsDTO result = liftstepsService.createLiftSteps(liftstepsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftSteps_Found() throws Exception {
        when(liftstepsRepository.findById(anyInt())).thenReturn(Optional.of(liftsteps));
        when(liftstepsRepository.save(any(LiftSteps.class))).thenReturn(liftsteps);

        LiftStepsDTO result = liftstepsService.updateLiftSteps(liftstepsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftSteps_NotFound() {
        when(liftstepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftstepsService.updateLiftSteps(liftstepsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteLiftSteps_Found() throws Exception {
        when(liftstepsRepository.findById(anyInt())).thenReturn(Optional.of(liftsteps));
        doNothing().when(liftstepsRepository).deleteById(anyInt());

        String result = liftstepsService.deleteLiftSteps(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLiftSteps_NotFound() {
        when(liftstepsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftstepsService.deleteLiftSteps(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LiftStepsDTO generateRandomLiftSteps() {
		LiftStepsDTO record = new LiftStepsDTO();
		record.setLiftStepId(2);
		record.setLiftId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
    public static LiftSteps generateRandomLiftStepsEntity() {
		LiftSteps record = new LiftSteps();
		record.setLiftStepId(2);
		record.setLiftId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
}
