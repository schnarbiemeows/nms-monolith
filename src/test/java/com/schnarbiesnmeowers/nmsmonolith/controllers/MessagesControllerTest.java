package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import com.schnarbiesnmeowers.nmsmonolith.repositories.MessagesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessagesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MessagesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MessagesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class MessagesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private MessagesController messagesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private MessagesService messagesService;

    @Mock
    private MessagesRepository messagesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(messagesController).build();
    }

	/**
	 * test creating a new Messages
	 * @throws 
	 */
	@Test
	public void testA_CreateMessages() throws Exception
	{
	    MessagesDTO messages = generateRandomMessages();
        when(messagesService.createMessages(any(MessagesDTO.class))).thenReturn(messages);

        mockMvc.perform(post("/messages/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(messages)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Messages
	 * @throws 
	 */
	@Test
	public void testB_GetAllMessages() throws Exception
	{
		List<MessagesDTO> messagess = Arrays.asList(generateRandomMessages(), generateRandomMessages());
        when(messagesService.getAllMessages()).thenReturn(messagess);

        mockMvc.perform(get("/messages/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Messages by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetMessages() throws Exception
	{
		MessagesDTO messages = generateRandomMessages();
        when(messagesService.findMessagesById(anyInt())).thenReturn(messages);

        mockMvc.perform(get("/messages/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Messages
	 * @throws 
	 */
	@Test
	public void testD_UpdateMessages() throws Exception
	{
	    MessagesDTO messages = generateRandomMessages();
        when(messagesService.updateMessages(any(MessagesDTO.class))).thenReturn(messages);

        mockMvc.perform(post("/messages/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(messages)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Messages
	 * @throws 
	 */
	@Test
	public void testE_DeleteMessages() throws Exception
	{
		when(messagesService.deleteMessages(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/messages/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Messages by field EventId
 * @throws
 */
@Test
public void testC_findByEventId() throws Exception
{
    List<MessagesDTO> messages = Arrays.asList(generateRandomMessages());
    when(messagesService.findMessagesByEventId(anyInt())).thenReturn(messages);

    mockMvc.perform(get("/messages/findByEventId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single Messages by field MessageTypeId
 * @throws
 */
@Test
public void testC_findByMessageTypeId() throws Exception
{
    List<MessagesDTO> messages = Arrays.asList(generateRandomMessages());
    when(messagesService.findMessagesByMessageTypeId(anyInt())).thenReturn(messages);

    mockMvc.perform(get("/messages/findByMessageTypeId/2"))
            .andExpect(status().isOk());
}

	public static MessagesDTO generateRandomMessages() {
		MessagesDTO record = new MessagesDTO();
		record.setEventId(Randomizer.randomInt(1000));
		record.setMessageTypeId(Randomizer.randomInt(1000));
		record.setMessageTxt(Randomizer.randomString(20));
		return record;
	}
}