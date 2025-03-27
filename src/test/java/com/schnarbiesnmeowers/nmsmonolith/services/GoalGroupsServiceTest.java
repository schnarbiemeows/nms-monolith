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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GoalGroups;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GoalGroupsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GoalGroupsServiceTest {

    @Mock
    private GoalGroupsRepository goalgroupsRepository;

    @InjectMocks
    private GoalGroupsService goalgroupsService;

    private GoalGroups goalgroups;
    private GoalGroupsDTO goalgroupsDTO;

    @BeforeEach
    void setUp() {
        goalgroups = generateRandomGoalGroupsEntity();
        goalgroupsDTO = generateRandomGoalGroups();
    }

    @Test
    void testGetAllGoalGroups() throws Exception {
        when(goalgroupsRepository.findAll()).thenReturn(Collections.singletonList(goalgroups));

        List<GoalGroupsDTO> result = goalgroupsService.getAllGoalGroups();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGoalGroupsById_Found() throws Exception {
        when(goalgroupsRepository.findById(anyInt())).thenReturn(Optional.of(goalgroups));

        GoalGroupsDTO result = goalgroupsService.findGoalGroupsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGoalGroupsById_NotFound() {
        when(goalgroupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalgroupsService.findGoalGroupsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGoalGroups() {
        when(goalgroupsRepository.save(any(GoalGroups.class))).thenReturn(goalgroups);

        GoalGroupsDTO result = goalgroupsService.createGoalGroups(goalgroupsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalGroups_Found() throws Exception {
        when(goalgroupsRepository.findById(anyInt())).thenReturn(Optional.of(goalgroups));
        when(goalgroupsRepository.save(any(GoalGroups.class))).thenReturn(goalgroups);

        GoalGroupsDTO result = goalgroupsService.updateGoalGroups(goalgroupsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGoalGroups_NotFound() {
        when(goalgroupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalgroupsService.updateGoalGroups(goalgroupsDTO);
        });

        assertEquals("id = " + goalgroupsDTO.getGoalGroupId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGoalGroups_Found() throws Exception {
        when(goalgroupsRepository.findById(anyInt())).thenReturn(Optional.of(goalgroups));
        doNothing().when(goalgroupsRepository).deleteById(anyInt());

        String result = goalgroupsService.deleteGoalGroups(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGoalGroups_NotFound() {
        when(goalgroupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            goalgroupsService.deleteGoalGroups(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GoalGroupsDTO generateRandomGoalGroups() {
		GoalGroupsDTO record = new GoalGroupsDTO();
		record.setGoalGroupId(2);
		record.setGoalId1(Randomizer.randomInt(1000));
		record.setGoalId2(Randomizer.randomInt(1000));
		record.setRelation(Randomizer.randomString(3));
		return record;
	}
    public static GoalGroups generateRandomGoalGroupsEntity() {
		GoalGroups record = new GoalGroups();
		record.setGoalGroupId(2);
		record.setGoalId1(Randomizer.randomInt(1000));
		record.setGoalId2(Randomizer.randomInt(1000));
		record.setRelation(Randomizer.randomString(3));
		return record;
	}
}
