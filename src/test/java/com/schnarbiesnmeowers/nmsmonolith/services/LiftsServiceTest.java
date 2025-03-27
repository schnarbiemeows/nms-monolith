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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Lifts;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LiftsServiceTest {

    @Mock
    private LiftsRepository liftsRepository;

    @InjectMocks
    private LiftsService liftsService;

    private Lifts lifts;
    private LiftsDTO liftsDTO;

    @BeforeEach
    void setUp() {
        lifts = generateRandomLiftsEntity();
        liftsDTO = generateRandomLifts();
    }

    @Test
    void testGetAllLifts() throws Exception {
        when(liftsRepository.findAll()).thenReturn(Collections.singletonList(lifts));

        List<LiftsDTO> result = liftsService.getAllLifts();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLiftsById_Found() throws Exception {
        when(liftsRepository.findById(anyInt())).thenReturn(Optional.of(lifts));

        LiftsDTO result = liftsService.findLiftsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLiftsById_NotFound() {
        when(liftsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftsService.findLiftsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLifts() {
        when(liftsRepository.save(any(Lifts.class))).thenReturn(lifts);

        LiftsDTO result = liftsService.createLifts(liftsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLifts_Found() throws Exception {
        when(liftsRepository.findById(anyInt())).thenReturn(Optional.of(lifts));
        when(liftsRepository.save(any(Lifts.class))).thenReturn(lifts);

        LiftsDTO result = liftsService.updateLifts(liftsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLifts_NotFound() {
        when(liftsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftsService.updateLifts(liftsDTO);
        });

        assertEquals("id = " + liftsDTO.getLiftId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteLifts_Found() throws Exception {
        when(liftsRepository.findById(anyInt())).thenReturn(Optional.of(lifts));
        doNothing().when(liftsRepository).deleteById(anyInt());

        String result = liftsService.deleteLifts(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLifts_NotFound() {
        when(liftsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftsService.deleteLifts(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LiftsDTO generateRandomLifts() {
		LiftsDTO record = new LiftsDTO();
		record.setLiftId(2);
		record.setLiftDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		return record;
	}
    public static Lifts generateRandomLiftsEntity() {
		Lifts record = new Lifts();
		record.setLiftId(2);
		record.setLiftDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		return record;
	}
}
