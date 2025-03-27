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
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeRatios;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ServingTypeRatiosRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ServingTypeRatiosServiceTest {

    @Mock
    private ServingTypeRatiosRepository servingtyperatiosRepository;

    @InjectMocks
    private ServingTypeRatiosService servingtyperatiosService;

    private ServingTypeRatios servingtyperatios;
    private ServingTypeRatiosDTO servingtyperatiosDTO;

    @BeforeEach
    void setUp() {
        servingtyperatios = generateRandomServingTypeRatiosEntity();
        servingtyperatiosDTO = generateRandomServingTypeRatios();
    }

    @Test
    void testGetAllServingTypeRatios() throws Exception {
        when(servingtyperatiosRepository.findAll()).thenReturn(Collections.singletonList(servingtyperatios));

        List<ServingTypeRatiosDTO> result = servingtyperatiosService.getAllServingTypeRatios();

        assertEquals(1, result.size());
    }

    @Test
    void testFindServingTypeRatiosById_Found() throws Exception {
        when(servingtyperatiosRepository.findById(anyInt())).thenReturn(Optional.of(servingtyperatios));

        ServingTypeRatiosDTO result = servingtyperatiosService.findServingTypeRatiosById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindServingTypeRatiosById_NotFound() {
        when(servingtyperatiosRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtyperatiosService.findServingTypeRatiosById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateServingTypeRatios() {
        when(servingtyperatiosRepository.save(any(ServingTypeRatios.class))).thenReturn(servingtyperatios);

        ServingTypeRatiosDTO result = servingtyperatiosService.createServingTypeRatios(servingtyperatiosDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateServingTypeRatios_Found() throws Exception {
        when(servingtyperatiosRepository.findById(anyInt())).thenReturn(Optional.of(servingtyperatios));
        when(servingtyperatiosRepository.save(any(ServingTypeRatios.class))).thenReturn(servingtyperatios);

        ServingTypeRatiosDTO result = servingtyperatiosService.updateServingTypeRatios(servingtyperatiosDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateServingTypeRatios_NotFound() {
        when(servingtyperatiosRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtyperatiosService.updateServingTypeRatios(servingtyperatiosDTO);
        });

        assertEquals("id = " + servingtyperatiosDTO.getServTypeRatioId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteServingTypeRatios_Found() throws Exception {
        when(servingtyperatiosRepository.findById(anyInt())).thenReturn(Optional.of(servingtyperatios));
        doNothing().when(servingtyperatiosRepository).deleteById(anyInt());

        String result = servingtyperatiosService.deleteServingTypeRatios(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteServingTypeRatios_NotFound() {
        when(servingtyperatiosRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            servingtyperatiosService.deleteServingTypeRatios(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ServingTypeRatiosDTO generateRandomServingTypeRatios() {
		ServingTypeRatiosDTO record = new ServingTypeRatiosDTO();
		record.setServTypeRatioId(2);
		record.setServTypeId1(Randomizer.randomInt(1000));
		record.setServTypeId2(Randomizer.randomInt(1000));
		record.setRatio(Randomizer.randomBigDecimal("1000"));
		return record;
	}
    public static ServingTypeRatios generateRandomServingTypeRatiosEntity() {
		ServingTypeRatios record = new ServingTypeRatios();
		record.setServTypeRatioId(2);
		record.setServTypeId1(Randomizer.randomInt(1000));
		record.setServTypeId2(Randomizer.randomInt(1000));
		record.setRatio(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}
