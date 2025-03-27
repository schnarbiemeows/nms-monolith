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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Roles;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RolesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RolesServiceTest {

    @Mock
    private RolesRepository rolesRepository;

    @InjectMocks
    private RolesService rolesService;

    private Roles roles;
    private RolesDTO rolesDTO;

    @BeforeEach
    void setUp() {
        roles = generateRandomRolesEntity();
        rolesDTO = generateRandomRoles();
    }

    @Test
    void testGetAllRoles() throws Exception {
        when(rolesRepository.findAll()).thenReturn(Collections.singletonList(roles));

        List<RolesDTO> result = rolesService.getAllRoles();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRolesById_Found() throws Exception {
        when(rolesRepository.findById(anyInt())).thenReturn(Optional.of(roles));

        RolesDTO result = rolesService.findRolesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRolesById_NotFound() {
        when(rolesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rolesService.findRolesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRoles() {
        when(rolesRepository.save(any(Roles.class))).thenReturn(roles);

        RolesDTO result = rolesService.createRoles(rolesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRoles_Found() throws Exception {
        when(rolesRepository.findById(anyInt())).thenReturn(Optional.of(roles));
        when(rolesRepository.save(any(Roles.class))).thenReturn(roles);

        RolesDTO result = rolesService.updateRoles(rolesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRoles_NotFound() {
        when(rolesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rolesService.updateRoles(rolesDTO);
        });

        assertEquals("id = " + rolesDTO.getRoleId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteRoles_Found() throws Exception {
        when(rolesRepository.findById(anyInt())).thenReturn(Optional.of(roles));
        doNothing().when(rolesRepository).deleteById(anyInt());

        String result = rolesService.deleteRoles(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRoles_NotFound() {
        when(rolesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rolesService.deleteRoles(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RolesDTO generateRandomRoles() {
		RolesDTO record = new RolesDTO();
		record.setRoleId(2);
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		return record;
	}
    public static Roles generateRandomRolesEntity() {
		Roles record = new Roles();
		record.setRoleId(2);
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		return record;
	}
}
