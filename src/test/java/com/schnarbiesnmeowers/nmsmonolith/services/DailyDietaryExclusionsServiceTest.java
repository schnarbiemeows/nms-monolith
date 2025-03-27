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
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietaryExclusionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryExclusions;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietaryExclusionsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DailyDietaryExclusionsServiceTest {

    @Mock
    private DailyDietaryExclusionsRepository dailydietaryexclusionsRepository;

    @InjectMocks
    private DailyDietaryExclusionsService dailydietaryexclusionsService;

    private DailyDietaryExclusions dailydietaryexclusions;
    private DailyDietaryExclusionsDTO dailydietaryexclusionsDTO;

    @BeforeEach
    void setUp() {
        dailydietaryexclusions = generateRandomDailyDietaryExclusionsEntity();
        dailydietaryexclusionsDTO = generateRandomDailyDietaryExclusions();
    }

    @Test
    void testGetAllDailyDietaryExclusions() throws Exception {
        when(dailydietaryexclusionsRepository.findAll()).thenReturn(Collections.singletonList(dailydietaryexclusions));

        List<DailyDietaryExclusionsDTO> result = dailydietaryexclusionsService.getAllDailyDietaryExclusions();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDailyDietaryExclusionsById_Found() throws Exception {
        when(dailydietaryexclusionsRepository.findById(anyInt())).thenReturn(Optional.of(dailydietaryexclusions));

        DailyDietaryExclusionsDTO result = dailydietaryexclusionsService.findDailyDietaryExclusionsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDailyDietaryExclusionsById_NotFound() {
        when(dailydietaryexclusionsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietaryexclusionsService.findDailyDietaryExclusionsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDailyDietaryExclusions() {
        when(dailydietaryexclusionsRepository.save(any(DailyDietaryExclusions.class))).thenReturn(dailydietaryexclusions);

        DailyDietaryExclusionsDTO result = dailydietaryexclusionsService.createDailyDietaryExclusions(dailydietaryexclusionsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDietaryExclusions_Found() throws Exception {
        when(dailydietaryexclusionsRepository.findById(anyInt())).thenReturn(Optional.of(dailydietaryexclusions));
        when(dailydietaryexclusionsRepository.save(any(DailyDietaryExclusions.class))).thenReturn(dailydietaryexclusions);

        DailyDietaryExclusionsDTO result = dailydietaryexclusionsService.updateDailyDietaryExclusions(dailydietaryexclusionsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDietaryExclusions_NotFound() {
        when(dailydietaryexclusionsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietaryexclusionsService.updateDailyDietaryExclusions(dailydietaryexclusionsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteDailyDietaryExclusions_Found() throws Exception {
        when(dailydietaryexclusionsRepository.findById(anyInt())).thenReturn(Optional.of(dailydietaryexclusions));
        doNothing().when(dailydietaryexclusionsRepository).deleteById(anyInt());

        String result = dailydietaryexclusionsService.deleteDailyDietaryExclusions(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteDailyDietaryExclusions_NotFound() {
        when(dailydietaryexclusionsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydietaryexclusionsService.deleteDailyDietaryExclusions(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DailyDietaryExclusionsDTO generateRandomDailyDietaryExclusions() {
		DailyDietaryExclusionsDTO record = new DailyDietaryExclusionsDTO();
		record.setDailyDietaryExclusionId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		return record;
	}
    public static DailyDietaryExclusions generateRandomDailyDietaryExclusionsEntity() {
		DailyDietaryExclusions record = new DailyDietaryExclusions();
		record.setDailyDietaryExclusionId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		return record;
	}
}
