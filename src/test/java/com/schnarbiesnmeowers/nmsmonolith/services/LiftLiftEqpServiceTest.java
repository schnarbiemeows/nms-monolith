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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftLiftEqpDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LiftLiftEqp;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LiftLiftEqpRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LiftLiftEqpServiceTest {

    @Mock
    private LiftLiftEqpRepository liftlifteqpRepository;

    @InjectMocks
    private LiftLiftEqpService liftlifteqpService;

    private LiftLiftEqp liftlifteqp;
    private LiftLiftEqpDTO liftlifteqpDTO;

    @BeforeEach
    void setUp() {
        liftlifteqp = generateRandomLiftLiftEqpEntity();
        liftlifteqpDTO = generateRandomLiftLiftEqp();
    }

    @Test
    void testGetAllLiftLiftEqp() throws Exception {
        when(liftlifteqpRepository.findAll()).thenReturn(Collections.singletonList(liftlifteqp));

        List<LiftLiftEqpDTO> result = liftlifteqpService.getAllLiftLiftEqp();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLiftLiftEqpById_Found() throws Exception {
        when(liftlifteqpRepository.findById(anyInt())).thenReturn(Optional.of(liftlifteqp));

        LiftLiftEqpDTO result = liftlifteqpService.findLiftLiftEqpById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLiftLiftEqpById_NotFound() {
        when(liftlifteqpRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftlifteqpService.findLiftLiftEqpById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLiftLiftEqp() {
        when(liftlifteqpRepository.save(any(LiftLiftEqp.class))).thenReturn(liftlifteqp);

        LiftLiftEqpDTO result = liftlifteqpService.createLiftLiftEqp(liftlifteqpDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftLiftEqp_Found() throws Exception {
        when(liftlifteqpRepository.findById(anyInt())).thenReturn(Optional.of(liftlifteqp));
        when(liftlifteqpRepository.save(any(LiftLiftEqp.class))).thenReturn(liftlifteqp);

        LiftLiftEqpDTO result = liftlifteqpService.updateLiftLiftEqp(liftlifteqpDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLiftLiftEqp_NotFound() {
        when(liftlifteqpRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftlifteqpService.updateLiftLiftEqp(liftlifteqpDTO);
        });

        assertEquals("id = " + liftlifteqpDTO.getLiftLiftEqpId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteLiftLiftEqp_Found() throws Exception {
        when(liftlifteqpRepository.findById(anyInt())).thenReturn(Optional.of(liftlifteqp));
        doNothing().when(liftlifteqpRepository).deleteById(anyInt());

        String result = liftlifteqpService.deleteLiftLiftEqp(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLiftLiftEqp_NotFound() {
        when(liftlifteqpRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            liftlifteqpService.deleteLiftLiftEqp(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LiftLiftEqpDTO generateRandomLiftLiftEqp() {
		LiftLiftEqpDTO record = new LiftLiftEqpDTO();
		record.setLiftLiftEqpId(2);
		record.setLiftId(Randomizer.randomInt(1000));
		record.setLiftEquipId(Randomizer.randomInt(1000));
		return record;
	}
    public static LiftLiftEqp generateRandomLiftLiftEqpEntity() {
		LiftLiftEqp record = new LiftLiftEqp();
		record.setLiftLiftEqpId(2);
		record.setLiftId(Randomizer.randomInt(1000));
		record.setLiftEquipId(Randomizer.randomInt(1000));
		return record;
	}
}
