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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUser;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GrpUserRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GrpUserServiceTest {

    @Mock
    private GrpUserRepository grpuserRepository;

    @InjectMocks
    private GrpUserService grpuserService;

    private GrpUser grpuser;
    private GrpUserDTO grpuserDTO;

    @BeforeEach
    void setUp() {
        grpuser = generateRandomGrpUserEntity();
        grpuserDTO = generateRandomGrpUser();
    }

    @Test
    void testGetAllGrpUser() throws Exception {
        when(grpuserRepository.findAll()).thenReturn(Collections.singletonList(grpuser));

        List<GrpUserDTO> result = grpuserService.getAllGrpUser();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGrpUserById_Found() throws Exception {
        when(grpuserRepository.findById(anyInt())).thenReturn(Optional.of(grpuser));

        GrpUserDTO result = grpuserService.findGrpUserById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGrpUserById_NotFound() {
        when(grpuserRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            grpuserService.findGrpUserById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGrpUser() {
        when(grpuserRepository.save(any(GrpUser.class))).thenReturn(grpuser);

        GrpUserDTO result = grpuserService.createGrpUser(grpuserDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGrpUser_Found() throws Exception {
        when(grpuserRepository.findById(anyInt())).thenReturn(Optional.of(grpuser));
        when(grpuserRepository.save(any(GrpUser.class))).thenReturn(grpuser);

        GrpUserDTO result = grpuserService.updateGrpUser(grpuserDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGrpUser_NotFound() {
        when(grpuserRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            grpuserService.updateGrpUser(grpuserDTO);
        });

        assertEquals("id = " + grpuserDTO.getGrpUserId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteGrpUser_Found() throws Exception {
        when(grpuserRepository.findById(anyInt())).thenReturn(Optional.of(grpuser));
        doNothing().when(grpuserRepository).deleteById(anyInt());

        String result = grpuserService.deleteGrpUser(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGrpUser_NotFound() {
        when(grpuserRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            grpuserService.deleteGrpUser(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GrpUserDTO generateRandomGrpUser() {
		GrpUserDTO record = new GrpUserDTO();
		record.setGrpUserId(2);
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
    public static GrpUser generateRandomGrpUserEntity() {
		GrpUser record = new GrpUser();
		record.setGrpUserId(2);
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}
