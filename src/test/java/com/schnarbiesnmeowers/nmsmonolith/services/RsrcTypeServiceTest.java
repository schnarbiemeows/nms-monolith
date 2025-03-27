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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RsrcTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RsrcType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RsrcTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RsrcTypeServiceTest {

    @Mock
    private RsrcTypeRepository rsrctypeRepository;

    @InjectMocks
    private RsrcTypeService rsrctypeService;

    private RsrcType rsrctype;
    private RsrcTypeDTO rsrctypeDTO;

    @BeforeEach
    void setUp() {
        rsrctype = generateRandomRsrcTypeEntity();
        rsrctypeDTO = generateRandomRsrcType();
    }

    @Test
    void testGetAllRsrcType() throws Exception {
        when(rsrctypeRepository.findAll()).thenReturn(Collections.singletonList(rsrctype));

        List<RsrcTypeDTO> result = rsrctypeService.getAllRsrcType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRsrcTypeById_Found() throws Exception {
        when(rsrctypeRepository.findById(anyInt())).thenReturn(Optional.of(rsrctype));

        RsrcTypeDTO result = rsrctypeService.findRsrcTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRsrcTypeById_NotFound() {
        when(rsrctypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rsrctypeService.findRsrcTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRsrcType() {
        when(rsrctypeRepository.save(any(RsrcType.class))).thenReturn(rsrctype);

        RsrcTypeDTO result = rsrctypeService.createRsrcType(rsrctypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRsrcType_Found() throws Exception {
        when(rsrctypeRepository.findById(anyInt())).thenReturn(Optional.of(rsrctype));
        when(rsrctypeRepository.save(any(RsrcType.class))).thenReturn(rsrctype);

        RsrcTypeDTO result = rsrctypeService.updateRsrcType(rsrctypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRsrcType_NotFound() {
        when(rsrctypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rsrctypeService.updateRsrcType(rsrctypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRsrcType_Found() throws Exception {
        when(rsrctypeRepository.findById(anyInt())).thenReturn(Optional.of(rsrctype));
        doNothing().when(rsrctypeRepository).deleteById(anyInt());

        String result = rsrctypeService.deleteRsrcType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRsrcType_NotFound() {
        when(rsrctypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rsrctypeService.deleteRsrcType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RsrcTypeDTO generateRandomRsrcType() {
		RsrcTypeDTO record = new RsrcTypeDTO();
		record.setRsrcTypeId(2);
		record.setRsrcType(Randomizer.randomString(20));
		record.setRsrcTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static RsrcType generateRandomRsrcTypeEntity() {
		RsrcType record = new RsrcType();
		record.setRsrcTypeId(2);
		record.setRsrcType(Randomizer.randomString(20));
		record.setRsrcTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
