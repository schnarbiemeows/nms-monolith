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
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ServingTypesServiceTest {

    @Mock
    private ServingTypesRepository servingtypesRepository;

    @InjectMocks
    private ServingTypesService servingtypesService;

    private ServingTypes servingtypes;
    private ServingTypesDTO servingtypesDTO;

    @BeforeEach
    void setUp() {
        servingtypes = generateRandomServingTypesEntity();
        servingtypesDTO = generateRandomServingTypes();
    }

    @Test
    void testGetAllServingTypes() throws Exception {
        when(servingtypesRepository.findActiveServingTypes())
                .thenReturn(Collections.singletonList(servingtypes));
        List<ServingTypesDTO> result = servingtypesService.getAllServingTypes();
        assertEquals(1, result.size());
    }

    @Test
    void testFindServingTypesById_Found() throws Exception {
        when(servingtypesRepository.findById(anyInt())).thenReturn(Optional.of(servingtypes));

        ServingTypesDTO result = servingtypesService.findServingTypesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindServingTypesById_NotFound() {
        when(servingtypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtypesService.findServingTypesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateServingTypes() {
        when(servingtypesRepository.save(any(ServingTypes.class))).thenReturn(servingtypes);

        ServingTypesDTO result = servingtypesService.createServingTypes(servingtypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateServingTypes_Found() throws Exception {
        when(servingtypesRepository.findById(anyInt())).thenReturn(Optional.of(servingtypes));
        when(servingtypesRepository.save(any(ServingTypes.class))).thenReturn(servingtypes);

        ServingTypesDTO result = servingtypesService.updateServingTypes(servingtypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateServingTypes_NotFound() {
        when(servingtypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtypesService.updateServingTypes(servingtypesDTO);
        });

        assertEquals("id = " + servingtypesDTO.getServTypeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteServingTypes_Found() throws Exception {
        when(servingtypesRepository.findById(anyInt())).thenReturn(Optional.of(servingtypes));
        doNothing().when(servingtypesRepository).deleteById(anyInt());

        String result = servingtypesService.deleteServingTypes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteServingTypes_NotFound() {
        when(servingtypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtypesService.deleteServingTypes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ServingTypesDTO generateRandomServingTypes() {
		ServingTypesDTO record = new ServingTypesDTO();
		record.setServTypeId(2);
		record.setServTypeCde(Randomizer.randomString(10));
		record.setServTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static ServingTypes generateRandomServingTypesEntity() {
		ServingTypes record = new ServingTypes();
		record.setServTypeId(2);
		record.setServTypeCde(Randomizer.randomString(10));
		record.setServTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
