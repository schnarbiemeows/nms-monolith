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
import com.schnarbiesnmeowers.nmsmonolith.dtos.MusclesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Muscles;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MusclesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class MusclesServiceTest {

    @Mock
    private MusclesRepository musclesRepository;

    @InjectMocks
    private MusclesService musclesService;

    private Muscles muscles;
    private MusclesDTO musclesDTO;

    @BeforeEach
    void setUp() {
        muscles = generateRandomMusclesEntity();
        musclesDTO = generateRandomMuscles();
    }

    @Test
    void testGetAllMuscles() throws Exception {
        when(musclesRepository.findAll()).thenReturn(Collections.singletonList(muscles));

        List<MusclesDTO> result = musclesService.getAllMuscles();

        assertEquals(1, result.size());
    }

    @Test
    void testFindMusclesById_Found() throws Exception {
        when(musclesRepository.findById(anyInt())).thenReturn(Optional.of(muscles));

        MusclesDTO result = musclesService.findMusclesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindMusclesById_NotFound() {
        when(musclesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            musclesService.findMusclesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateMuscles() {
        when(musclesRepository.save(any(Muscles.class))).thenReturn(muscles);

        MusclesDTO result = musclesService.createMuscles(musclesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMuscles_Found() throws Exception {
        when(musclesRepository.findById(anyInt())).thenReturn(Optional.of(muscles));
        when(musclesRepository.save(any(Muscles.class))).thenReturn(muscles);

        MusclesDTO result = musclesService.updateMuscles(musclesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMuscles_NotFound() {
        when(musclesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            musclesService.updateMuscles(musclesDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteMuscles_Found() throws Exception {
        when(musclesRepository.findById(anyInt())).thenReturn(Optional.of(muscles));
        doNothing().when(musclesRepository).deleteById(anyInt());

        String result = musclesService.deleteMuscles(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteMuscles_NotFound() {
        when(musclesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            musclesService.deleteMuscles(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static MusclesDTO generateRandomMuscles() {
		MusclesDTO record = new MusclesDTO();
		record.setMuscleId(2);
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		record.setMuscleName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Muscles generateRandomMusclesEntity() {
		Muscles record = new Muscles();
		record.setMuscleId(2);
		record.setMuscleGroupId(Randomizer.randomInt(1000));
		record.setMuscleName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
