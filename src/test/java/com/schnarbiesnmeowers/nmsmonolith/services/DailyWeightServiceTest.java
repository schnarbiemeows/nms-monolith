package com.schnarbiesnmeowers.nmsmonolith.services;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import com.schnarbiesnmeowers.nmsmonolith.entities.email.InputMessage;
import com.schnarbiesnmeowers.nmsmonolith.utilities.EmailUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.DailyWeight;
import com.schnarbiesnmeowers.nmsmonolith.repositories.DailyWeightRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class DailyWeightServiceTest {

    @Mock
    private DailyWeightRepository dailyweightRepository;

    @Mock
    private EmailUtility emailUtility;

    @InjectMocks
    private DailyWeightService dailyweightService;

    private DailyWeight dailyweight;
    private DailyWeightDataPoint dailyweightDTO;

    @BeforeEach
    void setUp() {
        dailyweight = generateRandomDailyWeightEntity();
        dailyweightDTO = createRandomDailyDietDataPoint();
    }

    @Test
    void testGetAllDailyWeight() throws Exception {
        when(dailyweightRepository.findAll()).thenReturn(Collections.singletonList(dailyweight));

        List<DailyWeightDataPoint> result = dailyweightService.getAllDailyWeight();

        assertEquals(1, result.size());
    }

    @Test
    void testFindDailyWeightById_Found() throws Exception {
        when(dailyweightRepository.findById(anyInt())).thenReturn(Optional.of(dailyweight));

        DailyWeightDataPoint result = dailyweightService.findDailyWeightById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindDailyWeightById_NotFound() {
        when(dailyweightRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailyweightService.findDailyWeightById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateDailyWeight() {
        when(dailyweightRepository.save(any(DailyWeight.class))).thenReturn(dailyweight);
        when(dailyweightRepository.findSingleDailyWeightByUserIdAndDate(anyInt(),anyString()))
                .thenReturn(Optional.of(dailyweight));
        when(emailUtility.sendTestEmailUsingWebflux(any(InputMessage.class)))
                .thenReturn(Mono.just("mocked response"));
        DailyWeightDataPoint result = dailyweightService.createDailyWeight(dailyweightDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyWeight_Found() throws Exception {
        when(dailyweightRepository.findById(anyInt())).thenReturn(Optional.of(dailyweight));
        when(dailyweightRepository.save(any(DailyWeight.class))).thenReturn(dailyweight);

        DailyWeightDataPoint result = dailyweightService.updateDailyWeight(dailyweightDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateDailyWeight_NotFound() {
        when(dailyweightRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailyweightService.updateDailyWeight(dailyweightDTO);
        });

        assertEquals("id = " + dailyweightDTO.getDailyWeightId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteDailyWeight_Found() throws Exception {
        when(dailyweightRepository.findById(anyInt())).thenReturn(Optional.of(dailyweight));
        doNothing().when(dailyweightRepository).deleteById(anyInt());

        String result = dailyweightService.deleteDailyWeight(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteDailyWeight_NotFound() {
        when(dailyweightRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            dailyweightService.deleteDailyWeight(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static DailyWeightDTO generateRandomDailyWeight() {
		DailyWeightDTO record = new DailyWeightDTO();
		record.setAverage(Randomizer.randomBigDecimal("10"));
        record.setData(new ArrayList<>());
        record.setMax(Randomizer.randomBigDecimal("10"));
        record.setMin(Randomizer.randomBigDecimal("10"));
        record.setDayRange(Randomizer.randomInt(10));
        record.setMissingData(new ArrayList<>());
        record.setMissingDates(new ArrayList<>());
		return record;
	}
    public static DailyWeight generateRandomDailyWeightEntity() {
		DailyWeight record = new DailyWeight();
		record.setDailyWeightId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomLocalDate());
		record.setWeight(Randomizer.randomBigDecimal("1000"));
		return record;
	}

    public static DailyWeightDataPoint createRandomDailyDietDataPoint() {
        DailyWeightDataPoint dto = new DailyWeightDataPoint();
        dto.setCalendarDate(Randomizer.randomLocalDate());
        dto.setWeight(Randomizer.randomBigDecimal("3"));
        dto.setDailyWeightId(Randomizer.randomInt(2));
        dto.setUserId(Randomizer.randomInt(9));
        return dto;
    }
}
