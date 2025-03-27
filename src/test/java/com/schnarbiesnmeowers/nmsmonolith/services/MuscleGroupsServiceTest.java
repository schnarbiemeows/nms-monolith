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
import com.schnarbiesnmeowers.nmsmonolith.dtos.MuscleGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.MuscleGroups;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MuscleGroupsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class MuscleGroupsServiceTest {

    @Mock
    private MuscleGroupsRepository musclegroupsRepository;

    @InjectMocks
    private MuscleGroupsService musclegroupsService;

    private MuscleGroups musclegroups;
    private MuscleGroupsDTO musclegroupsDTO;

    @BeforeEach
    void setUp() {
        musclegroups = generateRandomMuscleGroupsEntity();
        musclegroupsDTO = generateRandomMuscleGroups();
    }

    @Test
    void testGetAllMuscleGroups() throws Exception {
        when(musclegroupsRepository.findAll()).thenReturn(Collections.singletonList(musclegroups));

        List<MuscleGroupsDTO> result = musclegroupsService.getAllMuscleGroups();

        assertEquals(1, result.size());
    }

    @Test
    void testFindMuscleGroupsById_Found() throws Exception {
        when(musclegroupsRepository.findById(anyInt())).thenReturn(Optional.of(musclegroups));

        MuscleGroupsDTO result = musclegroupsService.findMuscleGroupsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindMuscleGroupsById_NotFound() {
        when(musclegroupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            musclegroupsService.findMuscleGroupsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateMuscleGroups() {
        when(musclegroupsRepository.save(any(MuscleGroups.class))).thenReturn(musclegroups);

        MuscleGroupsDTO result = musclegroupsService.createMuscleGroups(musclegroupsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMuscleGroups_Found() throws Exception {
        when(musclegroupsRepository.findById(anyInt())).thenReturn(Optional.of(musclegroups));
        when(musclegroupsRepository.save(any(MuscleGroups.class))).thenReturn(musclegroups);

        MuscleGroupsDTO result = musclegroupsService.updateMuscleGroups(musclegroupsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMuscleGroups_NotFound() {
        when(musclegroupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            musclegroupsService.updateMuscleGroups(musclegroupsDTO);
        });

        assertEquals("id = " + musclegroupsDTO.getMuscleGroupId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteMuscleGroups_Found() throws Exception {
        when(musclegroupsRepository.findById(anyInt())).thenReturn(Optional.of(musclegroups));
        doNothing().when(musclegroupsRepository).deleteById(anyInt());

        String result = musclegroupsService.deleteMuscleGroups(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteMuscleGroups_NotFound() {
        when(musclegroupsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            musclegroupsService.deleteMuscleGroups(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static MuscleGroupsDTO generateRandomMuscleGroups() {
		MuscleGroupsDTO record = new MuscleGroupsDTO();
		record.setMuscleGroupId(2);
		record.setMuscleGrpName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static MuscleGroups generateRandomMuscleGroupsEntity() {
		MuscleGroups record = new MuscleGroups();
		record.setMuscleGroupId(2);
		record.setMuscleGrpName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
