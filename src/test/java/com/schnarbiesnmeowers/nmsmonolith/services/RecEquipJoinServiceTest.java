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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEquipJoinDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RecEquipJoin;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RecEquipJoinRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RecEquipJoinServiceTest {

    @Mock
    private RecEquipJoinRepository recequipjoinRepository;

    @InjectMocks
    private RecEquipJoinService recequipjoinService;

    private RecEquipJoin recequipjoin;
    private RecEquipJoinDTO recequipjoinDTO;

    @BeforeEach
    void setUp() {
        recequipjoin = generateRandomRecEquipJoinEntity();
        recequipjoinDTO = generateRandomRecEquipJoin();
    }

    @Test
    void testGetAllRecEquipJoin() throws Exception {
        when(recequipjoinRepository.findAll()).thenReturn(Collections.singletonList(recequipjoin));

        List<RecEquipJoinDTO> result = recequipjoinService.getAllRecEquipJoin();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRecEquipJoinById_Found() throws Exception {
        when(recequipjoinRepository.findById(anyInt())).thenReturn(Optional.of(recequipjoin));

        RecEquipJoinDTO result = recequipjoinService.findRecEquipJoinById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRecEquipJoinById_NotFound() {
        when(recequipjoinRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recequipjoinService.findRecEquipJoinById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRecEquipJoin() {
        when(recequipjoinRepository.save(any(RecEquipJoin.class))).thenReturn(recequipjoin);

        RecEquipJoinDTO result = recequipjoinService.createRecEquipJoin(recequipjoinDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecEquipJoin_Found() throws Exception {
        when(recequipjoinRepository.findById(anyInt())).thenReturn(Optional.of(recequipjoin));
        when(recequipjoinRepository.save(any(RecEquipJoin.class))).thenReturn(recequipjoin);

        RecEquipJoinDTO result = recequipjoinService.updateRecEquipJoin(recequipjoinDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRecEquipJoin_NotFound() {
        when(recequipjoinRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recequipjoinService.updateRecEquipJoin(recequipjoinDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteRecEquipJoin_Found() throws Exception {
        when(recequipjoinRepository.findById(anyInt())).thenReturn(Optional.of(recequipjoin));
        doNothing().when(recequipjoinRepository).deleteById(anyInt());

        String result = recequipjoinService.deleteRecEquipJoin(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRecEquipJoin_NotFound() {
        when(recequipjoinRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            recequipjoinService.deleteRecEquipJoin(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RecEquipJoinDTO generateRandomRecEquipJoin() {
		RecEquipJoinDTO record = new RecEquipJoinDTO();
		record.setRecEquipJoinId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecipeEquipId(Randomizer.randomInt(1000));
		return record;
	}
    public static RecEquipJoin generateRandomRecEquipJoinEntity() {
		RecEquipJoin record = new RecEquipJoin();
		record.setRecEquipJoinId(2);
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecipeEquipId(Randomizer.randomInt(1000));
		return record;
	}
}
