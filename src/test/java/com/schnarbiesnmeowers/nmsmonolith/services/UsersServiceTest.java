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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Users;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UsersRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersService usersService;

    private Users users;
    private UsersDTO usersDTO;

    @BeforeEach
    void setUp() {
        users = generateRandomUsersEntity();
        usersDTO = generateRandomUsers();
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(usersRepository.findAll()).thenReturn(Collections.singletonList(users));

        List<UsersDTO> result = usersService.getAllUsers();

        assertEquals(1, result.size());
    }

    @Test
    void testFindUsersById_Found() throws Exception {
        when(usersRepository.findById(anyInt())).thenReturn(Optional.of(users));

        UsersDTO result = usersService.findUsersById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindUsersById_NotFound() {
        when(usersRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usersService.findUsersById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateUsers() {
        when(usersRepository.save(any(Users.class))).thenReturn(users);

        UsersDTO result = usersService.createUsers(usersDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUsers_Found() throws Exception {
        when(usersRepository.findById(anyInt())).thenReturn(Optional.of(users));
        when(usersRepository.save(any(Users.class))).thenReturn(users);

        UsersDTO result = usersService.updateUsers(usersDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUsers_NotFound() {
        when(usersRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usersService.updateUsers(usersDTO);
        });

        assertEquals("id = " + usersDTO.getUserId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteUsers_Found() throws Exception {
        when(usersRepository.findById(anyInt())).thenReturn(Optional.of(users));
        doNothing().when(usersRepository).deleteById(anyInt());

        String result = usersService.deleteUsers(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteUsers_NotFound() {
        when(usersRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usersService.deleteUsers(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static UsersDTO generateRandomUsers() {
		UsersDTO record = new UsersDTO();
		record.setUserId(2);
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setPhone(Randomizer.randomString(10));
		record.setActv(Randomizer.randomBoolean());
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		record.setAuthorizations(stringarray);
		record.setFirstName(Randomizer.randomString(20));
		record.setLastName(Randomizer.randomString(20));
		record.setUserNotLocked(Randomizer.randomBoolean());
		record.setJoinDate(Randomizer.randomDate());
		record.setLastLoginDateDisplay(Randomizer.randomDate());
		record.setProfileImage(Randomizer.randomString(20));
		record.setRoles(Randomizer.randomString(20));
		record.setUserIdentifier(Randomizer.randomString(20));
		return record;
	}
    public static Users generateRandomUsersEntity() {
		Users record = new Users();
		record.setUserId(2);
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setPhone(Randomizer.randomString(10));
		record.setActv(Randomizer.randomBoolean());
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		record.setAuthorizations(stringarray);
		record.setFirstName(Randomizer.randomString(20));
		record.setLastName(Randomizer.randomString(20));
		record.setUserNotLocked(Randomizer.randomBoolean());
		record.setJoinDate(Randomizer.randomDate());
		record.setLastLoginDateDisplay(Randomizer.randomDate());
		record.setProfileImage(Randomizer.randomString(20));
		record.setRoles(Randomizer.randomString(20));
		record.setUserIdentifier(Randomizer.randomString(20));
		return record;
	}

}
