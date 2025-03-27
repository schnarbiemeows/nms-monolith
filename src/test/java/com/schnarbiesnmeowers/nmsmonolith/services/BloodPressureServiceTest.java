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
import com.schnarbiesnmeowers.nmsmonolith.dtos.BloodPressureDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.BloodPressure;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BloodPressureRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class BloodPressureServiceTest {

    @Mock
    private BloodPressureRepository bloodpressureRepository;

    @InjectMocks
    private BloodPressureService bloodpressureService;

    private BloodPressure bloodpressure;
    private BloodPressureDTO bloodpressureDTO;

    @BeforeEach
    void setUp() {
        bloodpressure = generateRandomBloodPressureEntity();
        bloodpressureDTO = generateRandomBloodPressure();
    }

    @Test
    void testGetAllBloodPressure() throws Exception {
        when(bloodpressureRepository.findAll()).thenReturn(Collections.singletonList(bloodpressure));

        List<BloodPressureDTO> result = bloodpressureService.getAllBloodPressure();

        assertEquals(1, result.size());
    }

    @Test
    void testFindBloodPressureById_Found() throws Exception {
        when(bloodpressureRepository.findById(anyInt())).thenReturn(Optional.of(bloodpressure));

        BloodPressureDTO result = bloodpressureService.findBloodPressureById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindBloodPressureById_NotFound() {
        when(bloodpressureRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bloodpressureService.findBloodPressureById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateBloodPressure() {
        when(bloodpressureRepository.save(any(BloodPressure.class))).thenReturn(bloodpressure);

        BloodPressureDTO result = bloodpressureService.createBloodPressure(bloodpressureDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBloodPressure_Found() throws Exception {
        when(bloodpressureRepository.findById(anyInt())).thenReturn(Optional.of(bloodpressure));
        when(bloodpressureRepository.save(any(BloodPressure.class))).thenReturn(bloodpressure);

        BloodPressureDTO result = bloodpressureService.updateBloodPressure(bloodpressureDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBloodPressure_NotFound() {
        when(bloodpressureRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bloodpressureService.updateBloodPressure(bloodpressureDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteBloodPressure_Found() throws Exception {
        when(bloodpressureRepository.findById(anyInt())).thenReturn(Optional.of(bloodpressure));
        doNothing().when(bloodpressureRepository).deleteById(anyInt());

        String result = bloodpressureService.deleteBloodPressure(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteBloodPressure_NotFound() {
        when(bloodpressureRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bloodpressureService.deleteBloodPressure(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static BloodPressureDTO generateRandomBloodPressure() {
		BloodPressureDTO record = new BloodPressureDTO();
		record.setBloodPressureId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setSystolic(Randomizer.randomInt(1000));
		record.setDiastolic(Randomizer.randomInt(1000));
		record.setPulse(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static BloodPressure generateRandomBloodPressureEntity() {
		BloodPressure record = new BloodPressure();
		record.setBloodPressureId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setSystolic(Randomizer.randomInt(1000));
		record.setDiastolic(Randomizer.randomInt(1000));
		record.setPulse(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
