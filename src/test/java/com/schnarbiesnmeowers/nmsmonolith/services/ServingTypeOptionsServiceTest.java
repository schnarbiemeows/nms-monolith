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
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeOptionsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeOptions;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeOptionsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ServingTypeOptionsServiceTest {

    @Mock
    private ServingTypeOptionsRepository servingtypeoptionsRepository;

    @InjectMocks
    private ServingTypeOptionsService servingtypeoptionsService;

    private ServingTypeOptions servingtypeoptions;
    private ServingTypeOptionsDTO servingtypeoptionsDTO;

    @BeforeEach
    void setUp() {
        servingtypeoptions = generateRandomServingTypeOptionsEntity();
        servingtypeoptionsDTO = generateRandomServingTypeOptions();
    }

    @Test
    void testGetAllServingTypeOptions() throws Exception {
        when(servingtypeoptionsRepository.findAll()).thenReturn(Collections.singletonList(servingtypeoptions));

        List<ServingTypeOptionsDTO> result = servingtypeoptionsService.getAllServingTypeOptions();

        assertEquals(1, result.size());
    }

    @Test
    void testFindServingTypeOptionsById_Found() throws Exception {
        when(servingtypeoptionsRepository.findById(anyInt())).thenReturn(Optional.of(servingtypeoptions));

        ServingTypeOptionsDTO result = servingtypeoptionsService.findServingTypeOptionsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindServingTypeOptionsById_NotFound() {
        when(servingtypeoptionsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtypeoptionsService.findServingTypeOptionsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateServingTypeOptions() {
        when(servingtypeoptionsRepository.save(any(ServingTypeOptions.class))).thenReturn(servingtypeoptions);

        ServingTypeOptionsDTO result = servingtypeoptionsService.createServingTypeOptions(servingtypeoptionsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateServingTypeOptions_Found() throws Exception {
        when(servingtypeoptionsRepository.findById(anyInt())).thenReturn(Optional.of(servingtypeoptions));
        when(servingtypeoptionsRepository.save(any(ServingTypeOptions.class))).thenReturn(servingtypeoptions);

        ServingTypeOptionsDTO result = servingtypeoptionsService.updateServingTypeOptions(servingtypeoptionsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateServingTypeOptions_NotFound() {
        when(servingtypeoptionsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtypeoptionsService.updateServingTypeOptions(servingtypeoptionsDTO);
        });

        assertEquals("id = " + servingtypeoptionsDTO.getServTypeOptId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteServingTypeOptions_Found() throws Exception {
        when(servingtypeoptionsRepository.findById(anyInt())).thenReturn(Optional.of(servingtypeoptions));
        doNothing().when(servingtypeoptionsRepository).deleteById(anyInt());

        String result = servingtypeoptionsService.deleteServingTypeOptions(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteServingTypeOptions_NotFound() {
        when(servingtypeoptionsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtypeoptionsService.deleteServingTypeOptions(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ServingTypeOptionsDTO generateRandomServingTypeOptions() {
		ServingTypeOptionsDTO record = new ServingTypeOptionsDTO();
		record.setServTypeOptId(2);
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setMenuOption(Randomizer.randomInt(1000));
		return record;
	}
    public static ServingTypeOptions generateRandomServingTypeOptionsEntity() {
		ServingTypeOptions record = new ServingTypeOptions();
		record.setServTypeOptId(2);
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setMenuOption(Randomizer.randomInt(1000));
		return record;
	}
}
