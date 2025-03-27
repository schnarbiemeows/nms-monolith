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
import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietTotals;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyDietTotalsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DailyDietTotalsServiceTest {

    @Mock
    private DailyDietTotalsRepository dailydiettotalsRepository;

    @InjectMocks
    private DailyDietTotalsService dailydiettotalsService;

    private DailyDietTotals dailydiettotals;
    private DailyDietTotalsDTO dailydiettotalsDTO;

    @BeforeEach
    void setUp() {
        dailydiettotals = generateRandomDailyDietTotalsEntity();
        dailydiettotalsDTO = generateRandomDailyDietTotals();
    }

    @Test
    void testGetAllDailyDietTotals() throws Exception {
        when(dailydiettotalsRepository.findAll()).thenReturn(Collections.singletonList(dailydiettotals));

        List<DailyDietTotalsDTO> result = dailydiettotalsService.getAllDailyDietTotals();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDailyDietTotalsById_Found() throws Exception {
        when(dailydiettotalsRepository.findById(anyInt())).thenReturn(Optional.of(dailydiettotals));

        DailyDietTotalsDTO result = dailydiettotalsService.findDailyDietTotalsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDailyDietTotalsById_NotFound() {
        when(dailydiettotalsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydiettotalsService.findDailyDietTotalsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDailyDietTotals() {
        when(dailydiettotalsRepository.save(any(DailyDietTotals.class))).thenReturn(dailydiettotals);

        DailyDietTotalsDTO result = dailydiettotalsService.createDailyDietTotals(dailydiettotalsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDietTotals_Found() throws Exception {
        when(dailydiettotalsRepository.findById(anyInt())).thenReturn(Optional.of(dailydiettotals));
        when(dailydiettotalsRepository.save(any(DailyDietTotals.class))).thenReturn(dailydiettotals);

        DailyDietTotalsDTO result = dailydiettotalsService.updateDailyDietTotals(dailydiettotalsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyDietTotals_NotFound() {
        when(dailydiettotalsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydiettotalsService.updateDailyDietTotals(dailydiettotalsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteDailyDietTotals_Found() throws Exception {
        when(dailydiettotalsRepository.findById(anyInt())).thenReturn(Optional.of(dailydiettotals));
        doNothing().when(dailydiettotalsRepository).deleteById(anyInt());

        String result = dailydiettotalsService.deleteDailyDietTotals(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteDailyDietTotals_NotFound() {
        when(dailydiettotalsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailydiettotalsService.deleteDailyDietTotals(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DailyDietTotalsDTO generateRandomDailyDietTotals() {
		DailyDietTotalsDTO record = new DailyDietTotalsDTO();
		record.setDailyDietTotalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		return record;
	}
    public static DailyDietTotals generateRandomDailyDietTotalsEntity() {
		DailyDietTotals record = new DailyDietTotals();
		record.setDailyDietTotalId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}
