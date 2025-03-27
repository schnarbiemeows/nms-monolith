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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UsersHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class UsersHistServiceTest {

    @Mock
    private UsersHistRepository usershistRepository;

    @InjectMocks
    private UsersHistService usershistService;

    private UsersHist usershist;
    private UsersHistDTO usershistDTO;

    @BeforeEach
    void setUp() {
        usershist = generateRandomUsersHistEntity();
        usershistDTO = generateRandomUsersHist();
    }

    @Test
    void testGetAllUsersHist() throws Exception {
        when(usershistRepository.findAll()).thenReturn(Collections.singletonList(usershist));

        List<UsersHistDTO> result = usershistService.getAllUsersHist();

        assertEquals(1, result.size());
    }

    @Test
    void testFindUsersHistById_Found() throws Exception {
        when(usershistRepository.findById(anyInt())).thenReturn(Optional.of(usershist));

        UsersHistDTO result = usershistService.findUsersHistById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindUsersHistById_NotFound() {
        when(usershistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usershistService.findUsersHistById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateUsersHist() {
        when(usershistRepository.save(any(UsersHist.class))).thenReturn(usershist);

        UsersHistDTO result = usershistService.createUsersHist(usershistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUsersHist_Found() throws Exception {
        when(usershistRepository.findById(anyInt())).thenReturn(Optional.of(usershist));
        when(usershistRepository.save(any(UsersHist.class))).thenReturn(usershist);

        UsersHistDTO result = usershistService.updateUsersHist(usershistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUsersHist_NotFound() {
        when(usershistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usershistService.updateUsersHist(usershistDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteUsersHist_Found() throws Exception {
        when(usershistRepository.findById(anyInt())).thenReturn(Optional.of(usershist));
        doNothing().when(usershistRepository).deleteById(anyInt());

        String result = usershistService.deleteUsersHist(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteUsersHist_NotFound() {
        when(usershistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usershistService.deleteUsersHist(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static UsersHistDTO generateRandomUsersHist() {
		UsersHistDTO record = new UsersHistDTO();
		record.setUsersHistId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
    public static UsersHist generateRandomUsersHistEntity() {
		UsersHist record = new UsersHist();
		record.setUsersHistId(2);
		record.setUserId(Randomizer.randomInt(1000));
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}
