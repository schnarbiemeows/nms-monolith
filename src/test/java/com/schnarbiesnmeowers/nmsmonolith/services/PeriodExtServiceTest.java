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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodExtDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodExt;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodExtRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class PeriodExtServiceTest {

    @Mock
    private PeriodExtRepository periodextRepository;

    @InjectMocks
    private PeriodExtService periodextService;

    private PeriodExt periodext;
    private PeriodExtDTO periodextDTO;

    @BeforeEach
    void setUp() {
        periodext = generateRandomPeriodExtEntity();
        periodextDTO = generateRandomPeriodExt();
    }

    @Test
    void testGetAllPeriodExt() throws Exception {
        when(periodextRepository.findAll()).thenReturn(Collections.singletonList(periodext));

        List<PeriodExtDTO> result = periodextService.getAllPeriodExt();

        assertEquals(1, result.size());
    }

    @Test
    void testFindPeriodExtById_Found() throws Exception {
        when(periodextRepository.findById(anyInt())).thenReturn(Optional.of(periodext));

        PeriodExtDTO result = periodextService.findPeriodExtById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindPeriodExtById_NotFound() {
        when(periodextRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodextService.findPeriodExtById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreatePeriodExt() {
        when(periodextRepository.save(any(PeriodExt.class))).thenReturn(periodext);

        PeriodExtDTO result = periodextService.createPeriodExt(periodextDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePeriodExt_Found() throws Exception {
        when(periodextRepository.findById(anyInt())).thenReturn(Optional.of(periodext));
        when(periodextRepository.save(any(PeriodExt.class))).thenReturn(periodext);

        PeriodExtDTO result = periodextService.updatePeriodExt(periodextDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePeriodExt_NotFound() {
        when(periodextRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodextService.updatePeriodExt(periodextDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeletePeriodExt_Found() throws Exception {
        when(periodextRepository.findById(anyInt())).thenReturn(Optional.of(periodext));
        doNothing().when(periodextRepository).deleteById(anyInt());

        String result = periodextService.deletePeriodExt(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeletePeriodExt_NotFound() {
        when(periodextRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodextService.deletePeriodExt(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static PeriodExtDTO generateRandomPeriodExt() {
		PeriodExtDTO record = new PeriodExtDTO();
		record.setPeriodExtId(2);
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setSpecificDate(Randomizer.randomDate());
		record.setSpecificTime(Randomizer.randomTime(1000));
		return record;
	}
    public static PeriodExt generateRandomPeriodExtEntity() {
		PeriodExt record = new PeriodExt();
		record.setPeriodExtId(2);
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setSpecificDate(Randomizer.randomDate());
		record.setSpecificTime(Randomizer.randomTime(1000));
		return record;
	}
}
