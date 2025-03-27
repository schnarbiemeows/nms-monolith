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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftEquip;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftEquipRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LiftEquipServiceTest {

    @Mock
    private LiftEquipRepository liftequipRepository;

    @InjectMocks
    private LiftEquipService liftequipService;

    private LiftEquip liftequip;
    private LiftEquipDTO liftequipDTO;

    @BeforeEach
    void setUp() {
        liftequip = generateRandomLiftEquipEntity();
        liftequipDTO = generateRandomLiftEquip();
    }

    @Test
    void testGetAllLiftEquip() throws Exception {
        when(liftequipRepository.findAll()).thenReturn(Collections.singletonList(liftequip));

        List<LiftEquipDTO> result = liftequipService.getAllLiftEquip();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLiftEquipById_Found() throws Exception {
        when(liftequipRepository.findById(anyInt())).thenReturn(Optional.of(liftequip));

        LiftEquipDTO result = liftequipService.findLiftEquipById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLiftEquipById_NotFound() {
        when(liftequipRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftequipService.findLiftEquipById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLiftEquip() {
        when(liftequipRepository.save(any(LiftEquip.class))).thenReturn(liftequip);

        LiftEquipDTO result = liftequipService.createLiftEquip(liftequipDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftEquip_Found() throws Exception {
        when(liftequipRepository.findById(anyInt())).thenReturn(Optional.of(liftequip));
        when(liftequipRepository.save(any(LiftEquip.class))).thenReturn(liftequip);

        LiftEquipDTO result = liftequipService.updateLiftEquip(liftequipDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftEquip_NotFound() {
        when(liftequipRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftequipService.updateLiftEquip(liftequipDTO);
        });

        assertEquals("id = " + liftequipDTO.getLiftEquipId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteLiftEquip_Found() throws Exception {
        when(liftequipRepository.findById(anyInt())).thenReturn(Optional.of(liftequip));
        doNothing().when(liftequipRepository).deleteById(anyInt());

        String result = liftequipService.deleteLiftEquip(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLiftEquip_NotFound() {
        when(liftequipRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftequipService.deleteLiftEquip(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LiftEquipDTO generateRandomLiftEquip() {
		LiftEquipDTO record = new LiftEquipDTO();
		record.setLiftEquipId(2);
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static LiftEquip generateRandomLiftEquipEntity() {
		LiftEquip record = new LiftEquip();
		record.setLiftEquipId(2);
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
