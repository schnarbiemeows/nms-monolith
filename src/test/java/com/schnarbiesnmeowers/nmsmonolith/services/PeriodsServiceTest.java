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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Periods;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class PeriodsServiceTest {

    @Mock
    private PeriodsRepository periodsRepository;

    @InjectMocks
    private PeriodsService periodsService;

    private Periods periods;
    private PeriodsDTO periodsDTO;

    @BeforeEach
    void setUp() {
        periods = generateRandomPeriodsEntity();
        periodsDTO = generateRandomPeriods();
    }

    @Test
    void testGetAllPeriods() throws Exception {
        when(periodsRepository.findAll()).thenReturn(Collections.singletonList(periods));

        List<PeriodsDTO> result = periodsService.getAllPeriods();

        assertEquals(1, result.size());
    }

    @Test
    void testFindPeriodsById_Found() throws Exception {
        when(periodsRepository.findById(anyInt())).thenReturn(Optional.of(periods));

        PeriodsDTO result = periodsService.findPeriodsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindPeriodsById_NotFound() {
        when(periodsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodsService.findPeriodsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreatePeriods() {
        when(periodsRepository.save(any(Periods.class))).thenReturn(periods);

        PeriodsDTO result = periodsService.createPeriods(periodsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePeriods_Found() throws Exception {
        when(periodsRepository.findById(anyInt())).thenReturn(Optional.of(periods));
        when(periodsRepository.save(any(Periods.class))).thenReturn(periods);

        PeriodsDTO result = periodsService.updatePeriods(periodsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePeriods_NotFound() {
        when(periodsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodsService.updatePeriods(periodsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeletePeriods_Found() throws Exception {
        when(periodsRepository.findById(anyInt())).thenReturn(Optional.of(periods));
        doNothing().when(periodsRepository).deleteById(anyInt());

        String result = periodsService.deletePeriods(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeletePeriods_NotFound() {
        when(periodsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodsService.deletePeriods(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static PeriodsDTO generateRandomPeriods() {
		PeriodsDTO record = new PeriodsDTO();
		record.setPeriodId(2);
		record.setPeriodTypeId(Randomizer.randomInt(1000));
		record.setOneTimeDate(Randomizer.randomDate());
		record.setDayOfWeek(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Periods generateRandomPeriodsEntity() {
		Periods record = new Periods();
		record.setPeriodId(2);
		record.setPeriodTypeId(Randomizer.randomInt(1000));
		record.setOneTimeDate(Randomizer.randomDate());
		record.setDayOfWeek(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
