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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PasswordResetDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.PasswordReset;
import com.schnarbiesnmeowers.nmsmonolith.repositories.PasswordResetRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class PasswordResetServiceTest {

    @Mock
    private PasswordResetRepository passwordresetRepository;

    @InjectMocks
    private PasswordResetService passwordresetService;

    private PasswordReset passwordreset;
    private PasswordResetDTO passwordresetDTO;

    @BeforeEach
    void setUp() {
        passwordreset = generateRandomPasswordResetEntity();
        passwordresetDTO = generateRandomPasswordReset();
    }

    @Test
    void testGetAllPasswordReset() throws Exception {
        when(passwordresetRepository.findAll()).thenReturn(Collections.singletonList(passwordreset));

        List<PasswordResetDTO> result = passwordresetService.getAllPasswordReset();

        assertEquals(1, result.size());
    }

    @Test
    void testFindPasswordResetById_Found() throws Exception {
        when(passwordresetRepository.findById(anyInt())).thenReturn(Optional.of(passwordreset));

        PasswordResetDTO result = passwordresetService.findPasswordResetById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindPasswordResetById_NotFound() {
        when(passwordresetRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            passwordresetService.findPasswordResetById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreatePasswordReset() {
        when(passwordresetRepository.save(any(PasswordReset.class))).thenReturn(passwordreset);

        PasswordResetDTO result = passwordresetService.createPasswordReset(passwordresetDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePasswordReset_Found() throws Exception {
        when(passwordresetRepository.findById(anyInt())).thenReturn(Optional.of(passwordreset));
        when(passwordresetRepository.save(any(PasswordReset.class))).thenReturn(passwordreset);

        PasswordResetDTO result = passwordresetService.updatePasswordReset(passwordresetDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdatePasswordReset_NotFound() {
        when(passwordresetRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            passwordresetService.updatePasswordReset(passwordresetDTO);
        });

        assertEquals("id = " + passwordresetDTO.getPasswordResetId() + " not found", exception.getMessage());
    }

    @Test
    void testDeletePasswordReset_Found() throws Exception {
        when(passwordresetRepository.findById(anyInt())).thenReturn(Optional.of(passwordreset));
        doNothing().when(passwordresetRepository).deleteById(anyInt());

        String result = passwordresetService.deletePasswordReset(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeletePasswordReset_NotFound() {
        when(passwordresetRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            passwordresetService.deletePasswordReset(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static PasswordResetDTO generateRandomPasswordReset() {
		PasswordResetDTO record = new PasswordResetDTO();
		record.setPasswordResetId(2);
		record.setUniqueId(Randomizer.randomString(20));
		record.setEmailAddr(Randomizer.randomString(20));
		record.setCreatedDate(Randomizer.randomDate());
		return record;
	}
    public static PasswordReset generateRandomPasswordResetEntity() {
		PasswordReset record = new PasswordReset();
		record.setPasswordResetId(2);
		record.setUniqueId(Randomizer.randomString(20));
		record.setEmailAddr(Randomizer.randomString(20));
		record.setCreatedDate(Randomizer.randomDate());
		return record;
	}

}
