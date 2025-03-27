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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GroupsHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GroupsHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GroupsHistServiceTest {

    @Mock
    private GroupsHistRepository groupshistRepository;

    @InjectMocks
    private GroupsHistService groupshistService;

    private GroupsHist groupshist;
    private GroupsHistDTO groupshistDTO;

    @BeforeEach
    void setUp() {
        groupshist = generateRandomGroupsHistEntity();
        groupshistDTO = generateRandomGroupsHist();
    }

    @Test
    void testGetAllGroupsHist() throws Exception {
        when(groupshistRepository.findAll()).thenReturn(Collections.singletonList(groupshist));

        List<GroupsHistDTO> result = groupshistService.getAllGroupsHist();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGroupsHistById_Found() throws Exception {
        when(groupshistRepository.findById(anyInt())).thenReturn(Optional.of(groupshist));

        GroupsHistDTO result = groupshistService.findGroupsHistById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGroupsHistById_NotFound() {
        when(groupshistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            groupshistService.findGroupsHistById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGroupsHist() {
        when(groupshistRepository.save(any(GroupsHist.class))).thenReturn(groupshist);

        GroupsHistDTO result = groupshistService.createGroupsHist(groupshistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGroupsHist_Found() throws Exception {
        when(groupshistRepository.findById(anyInt())).thenReturn(Optional.of(groupshist));
        when(groupshistRepository.save(any(GroupsHist.class))).thenReturn(groupshist);

        GroupsHistDTO result = groupshistService.updateGroupsHist(groupshistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGroupsHist_NotFound() {
        when(groupshistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            groupshistService.updateGroupsHist(groupshistDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteGroupsHist_Found() throws Exception {
        when(groupshistRepository.findById(anyInt())).thenReturn(Optional.of(groupshist));
        doNothing().when(groupshistRepository).deleteById(anyInt());

        String result = groupshistService.deleteGroupsHist(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGroupsHist_NotFound() {
        when(groupshistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            groupshistService.deleteGroupsHist(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GroupsHistDTO generateRandomGroupsHist() {
		GroupsHistDTO record = new GroupsHistDTO();
		record.setGrpHistId(2);
		record.setGrpId(Randomizer.randomInt(1000));
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
    public static GroupsHist generateRandomGroupsHistEntity() {
		GroupsHist record = new GroupsHist();
		record.setGrpHistId(2);
		record.setGrpId(Randomizer.randomInt(1000));
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}
