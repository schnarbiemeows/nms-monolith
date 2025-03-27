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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEqTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecEqType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecEqTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecEqTypeServiceTest {

    @Mock
    private RecEqTypeRepository receqtypeRepository;

    @InjectMocks
    private RecEqTypeService receqtypeService;

    private RecEqType receqtype;
    private RecEqTypeDTO receqtypeDTO;

    @BeforeEach
    void setUp() {
        receqtype = generateRandomRecEqTypeEntity();
        receqtypeDTO = generateRandomRecEqType();
    }

    @Test
    void testGetAllRecEqType() throws Exception {
        when(receqtypeRepository.findAll()).thenReturn(Collections.singletonList(receqtype));

        List<RecEqTypeDTO> result = receqtypeService.getAllRecEqType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecEqTypeById_Found() throws Exception {
        when(receqtypeRepository.findById(anyInt())).thenReturn(Optional.of(receqtype));

        RecEqTypeDTO result = receqtypeService.findRecEqTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecEqTypeById_NotFound() {
        when(receqtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            receqtypeService.findRecEqTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecEqType() {
        when(receqtypeRepository.save(any(RecEqType.class))).thenReturn(receqtype);

        RecEqTypeDTO result = receqtypeService.createRecEqType(receqtypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecEqType_Found() throws Exception {
        when(receqtypeRepository.findById(anyInt())).thenReturn(Optional.of(receqtype));
        when(receqtypeRepository.save(any(RecEqType.class))).thenReturn(receqtype);

        RecEqTypeDTO result = receqtypeService.updateRecEqType(receqtypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecEqType_NotFound() {
        when(receqtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            receqtypeService.updateRecEqType(receqtypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRecEqType_Found() throws Exception {
        when(receqtypeRepository.findById(anyInt())).thenReturn(Optional.of(receqtype));
        doNothing().when(receqtypeRepository).deleteById(anyInt());

        String result = receqtypeService.deleteRecEqType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecEqType_NotFound() {
        when(receqtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            receqtypeService.deleteRecEqType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecEqTypeDTO generateRandomRecEqType() {
		RecEqTypeDTO record = new RecEqTypeDTO();
		record.setRecEqTypeId(2);
		record.setRecEqCde(Randomizer.randomString(5));
		record.setRecEqDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RecEqType generateRandomRecEqTypeEntity() {
		RecEqType record = new RecEqType();
		record.setRecEqTypeId(2);
		record.setRecEqCde(Randomizer.randomString(5));
		record.setRecEqDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
