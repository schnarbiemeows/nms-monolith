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
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessageTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.MessageTypes;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MessageTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class MessageTypesServiceTest {

    @Mock
    private MessageTypesRepository messagetypesRepository;

    @InjectMocks
    private MessageTypesService messagetypesService;

    private MessageTypes messagetypes;
    private MessageTypesDTO messagetypesDTO;

    @BeforeEach
    void setUp() {
        messagetypes = generateRandomMessageTypesEntity();
        messagetypesDTO = generateRandomMessageTypes();
    }

    @Test
    void testGetAllMessageTypes() throws Exception {
        when(messagetypesRepository.findAll()).thenReturn(Collections.singletonList(messagetypes));

        List<MessageTypesDTO> result = messagetypesService.getAllMessageTypes();

        assertEquals(1, result.size());
    }

    @Test
    void testFindMessageTypesById_Found() throws Exception {
        when(messagetypesRepository.findById(anyInt())).thenReturn(Optional.of(messagetypes));

        MessageTypesDTO result = messagetypesService.findMessageTypesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindMessageTypesById_NotFound() {
        when(messagetypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            messagetypesService.findMessageTypesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateMessageTypes() {
        when(messagetypesRepository.save(any(MessageTypes.class))).thenReturn(messagetypes);

        MessageTypesDTO result = messagetypesService.createMessageTypes(messagetypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMessageTypes_Found() throws Exception {
        when(messagetypesRepository.findById(anyInt())).thenReturn(Optional.of(messagetypes));
        when(messagetypesRepository.save(any(MessageTypes.class))).thenReturn(messagetypes);

        MessageTypesDTO result = messagetypesService.updateMessageTypes(messagetypesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMessageTypes_NotFound() {
        when(messagetypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            messagetypesService.updateMessageTypes(messagetypesDTO);
        });

        assertEquals("id = " + messagetypesDTO.getMessageTypeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteMessageTypes_Found() throws Exception {
        when(messagetypesRepository.findById(anyInt())).thenReturn(Optional.of(messagetypes));
        doNothing().when(messagetypesRepository).deleteById(anyInt());

        String result = messagetypesService.deleteMessageTypes(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteMessageTypes_NotFound() {
        when(messagetypesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            messagetypesService.deleteMessageTypes(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static MessageTypesDTO generateRandomMessageTypes() {
		MessageTypesDTO record = new MessageTypesDTO();
		record.setMessageTypeId(2);
		record.setMessageTypeCde(Randomizer.randomString(2));
		record.setMessageTypeDesc(Randomizer.randomString(20));
		return record;
	}
    public static MessageTypes generateRandomMessageTypesEntity() {
		MessageTypes record = new MessageTypes();
		record.setMessageTypeId(2);
		record.setMessageTypeCde(Randomizer.randomString(2));
		record.setMessageTypeDesc(Randomizer.randomString(20));
		return record;
	}

}
