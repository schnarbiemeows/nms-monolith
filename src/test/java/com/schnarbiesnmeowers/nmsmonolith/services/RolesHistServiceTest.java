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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.RolesHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RolesHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RolesHistServiceTest {

    @Mock
    private RolesHistRepository roleshistRepository;

    @InjectMocks
    private RolesHistService roleshistService;

    private RolesHist roleshist;
    private RolesHistDTO roleshistDTO;

    @BeforeEach
    void setUp() {
        roleshist = generateRandomRolesHistEntity();
        roleshistDTO = generateRandomRolesHist();
    }

    @Test
    void testGetAllRolesHist() throws Exception {
        when(roleshistRepository.findAll()).thenReturn(Collections.singletonList(roleshist));

        List<RolesHistDTO> result = roleshistService.getAllRolesHist();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRolesHistById_Found() throws Exception {
        when(roleshistRepository.findById(anyInt())).thenReturn(Optional.of(roleshist));

        RolesHistDTO result = roleshistService.findRolesHistById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRolesHistById_NotFound() {
        when(roleshistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            roleshistService.findRolesHistById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRolesHist() {
        when(roleshistRepository.save(any(RolesHist.class))).thenReturn(roleshist);

        RolesHistDTO result = roleshistService.createRolesHist(roleshistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRolesHist_Found() throws Exception {
        when(roleshistRepository.findById(anyInt())).thenReturn(Optional.of(roleshist));
        when(roleshistRepository.save(any(RolesHist.class))).thenReturn(roleshist);

        RolesHistDTO result = roleshistService.updateRolesHist(roleshistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRolesHist_NotFound() {
        when(roleshistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            roleshistService.updateRolesHist(roleshistDTO);
        });

        assertEquals("id = " + roleshistDTO.getRoleHistId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteRolesHist_Found() throws Exception {
        when(roleshistRepository.findById(anyInt())).thenReturn(Optional.of(roleshist));
        doNothing().when(roleshistRepository).deleteById(anyInt());

        String result = roleshistService.deleteRolesHist(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRolesHist_NotFound() {
        when(roleshistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            roleshistService.deleteRolesHist(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RolesHistDTO generateRandomRolesHist() {
		RolesHistDTO record = new RolesHistDTO();
		record.setRoleHistId(2);
		record.setRoleId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
    public static RolesHist generateRandomRolesHistEntity() {
		RolesHist record = new RolesHist();
		record.setRoleHistId(2);
		record.setRoleId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}
