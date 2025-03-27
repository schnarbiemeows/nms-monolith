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

import com.schnarbiesnmeowers.nmsmonolith.repositories.MessageTypesRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessageTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MessageTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MessageTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class MessageTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private MessageTypesController messagetypesController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private MessageTypesService messagetypesService;

    @Mock
    private MessageTypesRepository messagetypesRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(messagetypesController).build();
    }

	/**
	 * test creating a new MessageTypes
	 * @throws 
	 */
	@Test
	public void testA_CreateMessageTypes() throws Exception
	{
	    MessageTypesDTO messagetypes = generateRandomMessageTypes();
        when(messagetypesService.createMessageTypes(any(MessageTypesDTO.class))).thenReturn(messagetypes);

        mockMvc.perform(post("/messagetypes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(messagetypes)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all MessageTypes
	 * @throws 
	 */
	@Test
	public void testB_GetAllMessageTypes() throws Exception
	{
		List<MessageTypesDTO> messagetypess = Arrays.asList(generateRandomMessageTypes(), generateRandomMessageTypes());
        when(messagetypesService.getAllMessageTypes()).thenReturn(messagetypess);

        mockMvc.perform(get("/messagetypes/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single MessageTypes by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetMessageTypes() throws Exception
	{
		MessageTypesDTO messagetypes = generateRandomMessageTypes();
        when(messagetypesService.findMessageTypesById(anyInt())).thenReturn(messagetypes);

        mockMvc.perform(get("/messagetypes/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a MessageTypes
	 * @throws 
	 */
	@Test
	public void testD_UpdateMessageTypes() throws Exception
	{
	    MessageTypesDTO messagetypes = generateRandomMessageTypes();
        when(messagetypesService.updateMessageTypes(any(MessageTypesDTO.class))).thenReturn(messagetypes);

        mockMvc.perform(post("/messagetypes/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(messagetypes)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a MessageTypes
	 * @throws 
	 */
	@Test
	public void testE_DeleteMessageTypes() throws Exception
	{
		when(messagetypesService.deleteMessageTypes(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/messagetypes/delete/2"))
                .andExpect(status().isOk());
	}



	public static MessageTypesDTO generateRandomMessageTypes() {
		MessageTypesDTO record = new MessageTypesDTO();
		record.setMessageTypeCde(Randomizer.randomString(2));
		record.setMessageTypeDesc(Randomizer.randomString(20));
		return record;
	}
}