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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserTempDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.UserTemp;
import com.schnarbiesnmeowers.nmsmonolith.repositories.UserTempRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class UserTempServiceTest {

    @Mock
    private UserTempRepository usertempRepository;

    @InjectMocks
    private UserTempService usertempService;

    private UserTemp usertemp;
    private UserTempDTO usertempDTO;

    @BeforeEach
    void setUp() {
        usertemp = generateRandomUserTempEntity();
        usertempDTO = generateRandomUserTemp();
    }

    @Test
    void testGetAllUserTemp() throws Exception {
        when(usertempRepository.findAll()).thenReturn(Collections.singletonList(usertemp));

        List<UserTempDTO> result = usertempService.getAllUserTemp();

        assertEquals(1, result.size());
    }

    @Test
    void testFindUserTempById_Found() throws Exception {
        when(usertempRepository.findById(anyInt())).thenReturn(Optional.of(usertemp));

        UserTempDTO result = usertempService.findUserTempById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindUserTempById_NotFound() {
        when(usertempRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usertempService.findUserTempById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateUserTemp() {
        when(usertempRepository.save(any(UserTemp.class))).thenReturn(usertemp);

        UserTempDTO result = usertempService.createUserTemp(usertempDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUserTemp_Found() throws Exception {
        when(usertempRepository.findById(anyInt())).thenReturn(Optional.of(usertemp));
        when(usertempRepository.save(any(UserTemp.class))).thenReturn(usertemp);

        UserTempDTO result = usertempService.updateUserTemp(usertempDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateUserTemp_NotFound() {
        when(usertempRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usertempService.updateUserTemp(usertempDTO);
        });

        assertEquals("id = " + usertempDTO.getUserTempId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteUserTemp_Found() throws Exception {
        when(usertempRepository.findById(anyInt())).thenReturn(Optional.of(usertemp));
        doNothing().when(usertempRepository).deleteById(anyInt());

        String result = usertempService.deleteUserTemp(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteUserTemp_NotFound() {
        when(usertempRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usertempService.deleteUserTemp(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static UserTempDTO generateRandomUserTemp() {
		UserTempDTO record = new UserTempDTO();
		record.setUserTempId(2);
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPhone(Randomizer.randomString(10));
		record.setFirstName(Randomizer.randomString(20));
		record.setLastName(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomBoolean());
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		record.setAuthorizations(stringarray);
		record.setUserNotLocked(Randomizer.randomBoolean());
		record.setCreatedDate(Randomizer.randomDate());
		record.setJoinDate(Randomizer.randomDate());
		record.setLastLoginDate(Randomizer.randomDate());
		record.setLastLoginDateDisplay(Randomizer.randomDate());
		record.setPassword(Randomizer.randomString(20));
		record.setProfileImage(Randomizer.randomString(20));
		record.setRoles(Randomizer.randomString(20));
		record.setUserIdentifier(Randomizer.randomString(20));
		record.setUniqueId(Randomizer.randomString(20));
		return record;
	}
    public static UserTemp generateRandomUserTempEntity() {
		UserTemp record = new UserTemp();
		record.setUserTempId(2);
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPhone(Randomizer.randomString(10));
		record.setFirstName(Randomizer.randomString(20));
		record.setLastName(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomBoolean());
		String[] stringarray = new String[1];
		stringarray[0] = Randomizer.randomString(3);
		record.setAuthorizations(stringarray);
		record.setUserNotLocked(Randomizer.randomBoolean());
		record.setCreatedDate(Randomizer.randomDate());
		record.setJoinDate(Randomizer.randomDate());
		record.setLastLoginDate(Randomizer.randomDate());
		record.setLastLoginDateDisplay(Randomizer.randomDate());
		record.setPassword(Randomizer.randomString(20));
		record.setProfileImage(Randomizer.randomString(20));
		record.setRoles(Randomizer.randomString(20));
		record.setUserIdentifier(Randomizer.randomString(20));
		record.setUniqueId(Randomizer.randomString(20));
		return record;
	}

}
