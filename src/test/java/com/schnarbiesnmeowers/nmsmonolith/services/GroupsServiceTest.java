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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Groups;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GroupsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GroupsServiceTest {

    @Mock
    private GroupsRepository groupsRepository;

    @InjectMocks
    private GroupsService groupsService;

    private Groups groups;
    private GroupsDTO groupsDTO;

    @BeforeEach
    void setUp() {
        groups = generateRandomGroupsEntity();
        groupsDTO = generateRandomGroups();
    }

    @Test
    void testGetAllGroups() throws Exception {
        when(groupsRepository.findAll()).thenReturn(Collections.singletonList(groups));

        List<GroupsDTO> result = groupsService.getAllGroups();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGroupsById_Found() throws Exception {
        when(groupsRepository.findById(anyInt())).thenReturn(Optional.of(groups));

        GroupsDTO result = groupsService.findGroupsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGroupsById_NotFound() {
        when(groupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            groupsService.findGroupsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGroups() {
        when(groupsRepository.save(any(Groups.class))).thenReturn(groups);

        GroupsDTO result = groupsService.createGroups(groupsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGroups_Found() throws Exception {
        when(groupsRepository.findById(anyInt())).thenReturn(Optional.of(groups));
        when(groupsRepository.save(any(Groups.class))).thenReturn(groups);

        GroupsDTO result = groupsService.updateGroups(groupsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGroups_NotFound() {
        when(groupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            groupsService.updateGroups(groupsDTO);
        });

        assertEquals("id = " + groupsDTO.getGrpId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGroups_Found() throws Exception {
        when(groupsRepository.findById(anyInt())).thenReturn(Optional.of(groups));
        doNothing().when(groupsRepository).deleteById(anyInt());

        String result = groupsService.deleteGroups(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGroups_NotFound() {
        when(groupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            groupsService.deleteGroups(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GroupsDTO generateRandomGroups() {
		GroupsDTO record = new GroupsDTO();
		record.setGrpId(2);
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		return record;
	}
    public static Groups generateRandomGroupsEntity() {
		Groups record = new Groups();
		record.setGrpId(2);
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		return record;
	}

}
