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
import com.schnarbiesnmeowers.nmsmonolith.dtos.BodyMeasurementsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.BodyMeasurements;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BodyMeasurementsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class BodyMeasurementsServiceTest {

    @Mock
    private BodyMeasurementsRepository bodymeasurementsRepository;

    @InjectMocks
    private BodyMeasurementsService bodymeasurementsService;

    private BodyMeasurements bodymeasurements;
    private BodyMeasurementsDTO bodymeasurementsDTO;

    @BeforeEach
    void setUp() {
        bodymeasurements = generateRandomBodyMeasurementsEntity();
        bodymeasurementsDTO = generateRandomBodyMeasurements();
    }

    @Test
    void testGetAllBodyMeasurements() throws Exception {
        when(bodymeasurementsRepository.findAll()).thenReturn(Collections.singletonList(bodymeasurements));

        List<BodyMeasurementsDTO> result = bodymeasurementsService.getAllBodyMeasurements();

        assertEquals(1, result.size());
    }

    @Test
    void testFindBodyMeasurementsById_Found() throws Exception {
        when(bodymeasurementsRepository.findById(anyInt())).thenReturn(Optional.of(bodymeasurements));

        BodyMeasurementsDTO result = bodymeasurementsService.findBodyMeasurementsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindBodyMeasurementsById_NotFound() {
        when(bodymeasurementsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bodymeasurementsService.findBodyMeasurementsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateBodyMeasurements() {
        when(bodymeasurementsRepository.save(any(BodyMeasurements.class))).thenReturn(bodymeasurements);

        BodyMeasurementsDTO result = bodymeasurementsService.createBodyMeasurements(bodymeasurementsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBodyMeasurements_Found() throws Exception {
        when(bodymeasurementsRepository.findById(anyInt())).thenReturn(Optional.of(bodymeasurements));
        when(bodymeasurementsRepository.save(any(BodyMeasurements.class))).thenReturn(bodymeasurements);

        BodyMeasurementsDTO result = bodymeasurementsService.updateBodyMeasurements(bodymeasurementsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBodyMeasurements_NotFound() {
        when(bodymeasurementsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bodymeasurementsService.updateBodyMeasurements(bodymeasurementsDTO);
        });

        assertEquals("id = " + bodymeasurementsDTO.getBodyMeasurementId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteBodyMeasurements_Found() throws Exception {
        when(bodymeasurementsRepository.findById(anyInt())).thenReturn(Optional.of(bodymeasurements));
        doNothing().when(bodymeasurementsRepository).deleteById(anyInt());

        String result = bodymeasurementsService.deleteBodyMeasurements(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteBodyMeasurements_NotFound() {
        when(bodymeasurementsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            bodymeasurementsService.deleteBodyMeasurements(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static BodyMeasurementsDTO generateRandomBodyMeasurements() {
        BodyMeasurementsDTO record = new BodyMeasurementsDTO();
        record.setBodyMeasurementId(2);
        record.setUserId(Randomizer.randomInt(1000));
        record.setCalendarDate(Randomizer.randomLocalDate());
        record.setLeftCalf(Randomizer.randomBigDecimal("1000"));
        record.setRightCalf(Randomizer.randomBigDecimal("1000"));
        record.setLeftThigh(Randomizer.randomBigDecimal("1000"));
        record.setRightThigh(Randomizer.randomBigDecimal("1000"));
        record.setWaist(Randomizer.randomBigDecimal("1000"));
        record.setChest(Randomizer.randomBigDecimal("1000"));
        record.setLeftBicep(Randomizer.randomBigDecimal("1000"));
        record.setRightBicep(Randomizer.randomBigDecimal("1000"));
        record.setLeftForearm(Randomizer.randomBigDecimal("1000"));
        record.setRightForearm(Randomizer.randomBigDecimal("1000"));
        record.setShoulders(Randomizer.randomBigDecimal("1000"));
        record.setActv(Randomizer.randomString(2));
        return record;
    }

    public static BodyMeasurements generateRandomBodyMeasurementsEntity() {
		BodyMeasurements record = new BodyMeasurements();
        record.setBodyMeasurementId(2);
        record.setUserId(Randomizer.randomInt(1000));
        record.setCalendarDate(Randomizer.randomLocalDate());
        record.setLeftCalf(Randomizer.randomBigDecimal("1000"));
        record.setRightCalf(Randomizer.randomBigDecimal("1000"));
        record.setLeftThigh(Randomizer.randomBigDecimal("1000"));
        record.setRightThigh(Randomizer.randomBigDecimal("1000"));
        record.setWaist(Randomizer.randomBigDecimal("1000"));
        record.setChest(Randomizer.randomBigDecimal("1000"));
        record.setLeftBicep(Randomizer.randomBigDecimal("1000"));
        record.setRightBicep(Randomizer.randomBigDecimal("1000"));
        record.setLeftForearm(Randomizer.randomBigDecimal("1000"));
        record.setRightForearm(Randomizer.randomBigDecimal("1000"));
        record.setShoulders(Randomizer.randomBigDecimal("1000"));
        record.setActv(Randomizer.randomString(2));
		return record;
	}
}
