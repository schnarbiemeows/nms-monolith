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
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessagesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Messages;
import com.schnarbiesnmeowers.nmsmonolith.repositories.MessagesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class MessagesServiceTest {

    @Mock
    private MessagesRepository messagesRepository;

    @InjectMocks
    private MessagesService messagesService;

    private Messages messages;
    private MessagesDTO messagesDTO;

    @BeforeEach
    void setUp() {
        messages = generateRandomMessagesEntity();
        messagesDTO = generateRandomMessages();
    }

    @Test
    void testGetAllMessages() throws Exception {
        when(messagesRepository.findAll()).thenReturn(Collections.singletonList(messages));

        List<MessagesDTO> result = messagesService.getAllMessages();

        assertEquals(1, result.size());
    }

    @Test
    void testFindMessagesById_Found() throws Exception {
        when(messagesRepository.findById(anyInt())).thenReturn(Optional.of(messages));

        MessagesDTO result = messagesService.findMessagesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindMessagesById_NotFound() {
        when(messagesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            messagesService.findMessagesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateMessages() {
        when(messagesRepository.save(any(Messages.class))).thenReturn(messages);

        MessagesDTO result = messagesService.createMessages(messagesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMessages_Found() throws Exception {
        when(messagesRepository.findById(anyInt())).thenReturn(Optional.of(messages));
        when(messagesRepository.save(any(Messages.class))).thenReturn(messages);

        MessagesDTO result = messagesService.updateMessages(messagesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateMessages_NotFound() {
        when(messagesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            messagesService.updateMessages(messagesDTO);
        });

        assertEquals("id = " + messagesDTO.getMessageId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteMessages_Found() throws Exception {
        when(messagesRepository.findById(anyInt())).thenReturn(Optional.of(messages));
        doNothing().when(messagesRepository).deleteById(anyInt());

        String result = messagesService.deleteMessages(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteMessages_NotFound() {
        when(messagesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            messagesService.deleteMessages(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static MessagesDTO generateRandomMessages() {
		MessagesDTO record = new MessagesDTO();
		record.setMessageId(2);
		record.setEventId(Randomizer.randomInt(1000));
		record.setMessageTypeId(Randomizer.randomInt(1000));
		record.setMessageTxt(Randomizer.randomString(20));
		return record;
	}
    public static Messages generateRandomMessagesEntity() {
		Messages record = new Messages();
		record.setMessageId(2);
		record.setEventId(Randomizer.randomInt(1000));
		record.setMessageTypeId(Randomizer.randomInt(1000));
		record.setMessageTxt(Randomizer.randomString(20));
		return record;
	}
}
