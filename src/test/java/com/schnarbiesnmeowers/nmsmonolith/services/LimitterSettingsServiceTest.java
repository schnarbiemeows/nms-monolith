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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LimitterSettingsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.LimitterSettings;
import com.schnarbiesnmeowers.nmsmonolith.repositories.LimitterSettingsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class LimitterSettingsServiceTest {

    @Mock
    private LimitterSettingsRepository limittersettingsRepository;

    @InjectMocks
    private LimitterSettingsService limittersettingsService;

    private LimitterSettings limittersettings;
    private LimitterSettingsDTO limittersettingsDTO;

    @BeforeEach
    void setUp() {
        limittersettings = generateRandomLimitterSettingsEntity();
        limittersettingsDTO = generateRandomLimitterSettings();
    }

    @Test
    void testGetAllLimitterSettings() throws Exception {
        when(limittersettingsRepository.findAll()).thenReturn(Collections.singletonList(limittersettings));

        List<LimitterSettingsDTO> result = limittersettingsService.getAllLimitterSettings();

        assertEquals(1, result.size());
    }

    @Test
    void testFindLimitterSettingsById_Found() throws Exception {
        when(limittersettingsRepository.findById(anyInt())).thenReturn(Optional.of(limittersettings));

        LimitterSettingsDTO result = limittersettingsService.findLimitterSettingsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindLimitterSettingsById_NotFound() {
        when(limittersettingsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            limittersettingsService.findLimitterSettingsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateLimitterSettings() {
        when(limittersettingsRepository.save(any(LimitterSettings.class))).thenReturn(limittersettings);

        LimitterSettingsDTO result = limittersettingsService.createLimitterSettings(limittersettingsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLimitterSettings_Found() throws Exception {
        when(limittersettingsRepository.findById(anyInt())).thenReturn(Optional.of(limittersettings));
        when(limittersettingsRepository.save(any(LimitterSettings.class))).thenReturn(limittersettings);

        LimitterSettingsDTO result = limittersettingsService.updateLimitterSettings(limittersettingsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateLimitterSettings_NotFound() {
        when(limittersettingsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            limittersettingsService.updateLimitterSettings(limittersettingsDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteLimitterSettings_Found() throws Exception {
        when(limittersettingsRepository.findById(anyInt())).thenReturn(Optional.of(limittersettings));
        doNothing().when(limittersettingsRepository).deleteById(anyInt());

        String result = limittersettingsService.deleteLimitterSettings(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteLimitterSettings_NotFound() {
        when(limittersettingsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            limittersettingsService.deleteLimitterSettings(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static LimitterSettingsDTO generateRandomLimitterSettings() {
		LimitterSettingsDTO record = new LimitterSettingsDTO();
		record.setSettingId(2);
		record.setUrl(Randomizer.randomString(20));
		record.setDomain(Randomizer.randomString(20));
		record.setPermissions(Randomizer.randomString(20));
		record.setTotnumreqpersec(Randomizer.randomInt(1000));
		record.setWndwforratelmtinms(Randomizer.randomInt(1000));
		record.setTotalmaxbucketsize(Randomizer.randomInt(1000));
		record.setIptotnumreqpersec(Randomizer.randomInt(1000));
		record.setIpwndwrtlmt(Randomizer.randomInt(1000));
		record.setIpmaxwndw(Randomizer.randomInt(1000));
		record.setEnvironment(Randomizer.randomString(10));
		return record;
	}
    public static LimitterSettings generateRandomLimitterSettingsEntity() {
		LimitterSettings record = new LimitterSettings();
		record.setSettingId(2);
		record.setUrl(Randomizer.randomString(20));
		record.setDomain(Randomizer.randomString(20));
		record.setPermissions(Randomizer.randomString(20));
		record.setTotnumreqpersec(Randomizer.randomInt(1000));
		record.setWndwforratelmtinms(Randomizer.randomInt(1000));
		record.setTotalmaxbucketsize(Randomizer.randomInt(1000));
		record.setIptotnumreqpersec(Randomizer.randomInt(1000));
		record.setIpwndwrtlmt(Randomizer.randomInt(1000));
		record.setIpmaxwndw(Randomizer.randomInt(1000));
		record.setEnvironment(Randomizer.randomString(10));
		return record;
	}

}
