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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserConfigDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserConfig;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UserConfigRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class UserConfigServiceTest {

    @Mock
    private UserConfigRepository userconfigRepository;

    @InjectMocks
    private UserConfigService userconfigService;

    private UserConfig userconfig;
    private UserConfigDTO userconfigDTO;

    @BeforeEach
    void setUp() {
        userconfig = generateRandomUserConfigEntity();
        userconfigDTO = generateRandomUserConfig();
    }

    @Test
    void testGetAllUserConfig() throws Exception {
        when(userconfigRepository.findAll()).thenReturn(Collections.singletonList(userconfig));

        List<UserConfigDTO> result = userconfigService.getAllUserConfig();

        assertEquals(1, result.size());
    }

    @Test
    void testFindUserConfigById_Found() throws Exception {
        when(userconfigRepository.findById(anyInt())).thenReturn(Optional.of(userconfig));

        UserConfigDTO result = userconfigService.findUserConfigById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindUserConfigById_NotFound() {
        when(userconfigRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            userconfigService.findUserConfigById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateUserConfig() {
        when(userconfigRepository.save(any(UserConfig.class))).thenReturn(userconfig);

        UserConfigDTO result = userconfigService.createUserConfig(userconfigDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUserConfig_Found() throws Exception {
        when(userconfigRepository.findById(anyInt())).thenReturn(Optional.of(userconfig));
        when(userconfigRepository.save(any(UserConfig.class))).thenReturn(userconfig);

        UserConfigDTO result = userconfigService.updateUserConfig(userconfigDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUserConfig_NotFound() {
        when(userconfigRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            userconfigService.updateUserConfig(userconfigDTO);
        });

        assertEquals("id = " + userconfigDTO.getUsersConfigId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteUserConfig_Found() throws Exception {
        when(userconfigRepository.findById(anyInt())).thenReturn(Optional.of(userconfig));
        doNothing().when(userconfigRepository).deleteById(anyInt());

        String result = userconfigService.deleteUserConfig(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteUserConfig_NotFound() {
        when(userconfigRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            userconfigService.deleteUserConfig(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static UserConfigDTO generateRandomUserConfig() {
		UserConfigDTO record = new UserConfigDTO();
		record.setUsersConfigId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setPropertyKey(Randomizer.randomString(20));
		record.setPropertyValue(Randomizer.randomString(20));
		return record;
	}
    public static UserConfig generateRandomUserConfigEntity() {
		UserConfig record = new UserConfig();
		record.setUsersConfigId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setPropertyKey(Randomizer.randomString(20));
		record.setPropertyValue(Randomizer.randomString(20));
		return record;
	}
}
