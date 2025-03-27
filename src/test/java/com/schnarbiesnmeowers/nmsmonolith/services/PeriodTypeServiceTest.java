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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PeriodTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class PeriodTypeServiceTest {

    @Mock
    private PeriodTypeRepository periodtypeRepository;

    @InjectMocks
    private PeriodTypeService periodtypeService;

    private PeriodType periodtype;
    private PeriodTypeDTO periodtypeDTO;

    @BeforeEach
    void setUp() {
        periodtype = generateRandomPeriodTypeEntity();
        periodtypeDTO = generateRandomPeriodType();
    }

    @Test
    void testGetAllPeriodType() throws Exception {
        when(periodtypeRepository.findAll()).thenReturn(Collections.singletonList(periodtype));

        List<PeriodTypeDTO> result = periodtypeService.getAllPeriodType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindPeriodTypeById_Found() throws Exception {
        when(periodtypeRepository.findById(anyInt())).thenReturn(Optional.of(periodtype));

        PeriodTypeDTO result = periodtypeService.findPeriodTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindPeriodTypeById_NotFound() {
        when(periodtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodtypeService.findPeriodTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreatePeriodType() {
        when(periodtypeRepository.save(any(PeriodType.class))).thenReturn(periodtype);

        PeriodTypeDTO result = periodtypeService.createPeriodType(periodtypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePeriodType_Found() throws Exception {
        when(periodtypeRepository.findById(anyInt())).thenReturn(Optional.of(periodtype));
        when(periodtypeRepository.save(any(PeriodType.class))).thenReturn(periodtype);

        PeriodTypeDTO result = periodtypeService.updatePeriodType(periodtypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePeriodType_NotFound() {
        when(periodtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodtypeService.updatePeriodType(periodtypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeletePeriodType_Found() throws Exception {
        when(periodtypeRepository.findById(anyInt())).thenReturn(Optional.of(periodtype));
        doNothing().when(periodtypeRepository).deleteById(anyInt());

        String result = periodtypeService.deletePeriodType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeletePeriodType_NotFound() {
        when(periodtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            periodtypeService.deletePeriodType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static PeriodTypeDTO generateRandomPeriodType() {
		PeriodTypeDTO record = new PeriodTypeDTO();
		record.setPeriodTypeId(2);
		record.setPeriodTypeCde(Randomizer.randomString(2));
		record.setPeriodTypeDesc(Randomizer.randomString(20));
		return record;
	}
    public static PeriodType generateRandomPeriodTypeEntity() {
		PeriodType record = new PeriodType();
		record.setPeriodTypeId(2);
		record.setPeriodTypeCde(Randomizer.randomString(2));
		record.setPeriodTypeDesc(Randomizer.randomString(20));
		return record;
	}

}
