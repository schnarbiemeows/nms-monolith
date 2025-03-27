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

import com.schnarbiesnmeowers.nmsmonolith.repositories.CardioTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.CardioTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.CardioTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the CardioTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class CardioTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private CardioTypeController cardiotypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private CardioTypeService cardiotypeService;

    @Mock
    private CardioTypeRepository cardiotypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(cardiotypeController).build();
    }

	/**
	 * test creating a new CardioType
	 * @throws 
	 */
	@Test
	public void testA_CreateCardioType() throws Exception
	{
	    CardioTypeDTO cardiotype = generateRandomCardioType();
        when(cardiotypeService.createCardioType(any(CardioTypeDTO.class))).thenReturn(cardiotype);

        mockMvc.perform(post("/cardiotype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cardiotype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all CardioType
	 * @throws 
	 */
	@Test
	public void testB_GetAllCardioType() throws Exception
	{
		List<CardioTypeDTO> cardiotypes = Arrays.asList(generateRandomCardioType(), generateRandomCardioType());
        when(cardiotypeService.getAllCardioType()).thenReturn(cardiotypes);

        mockMvc.perform(get("/cardiotype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single CardioType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetCardioType() throws Exception
	{
		CardioTypeDTO cardiotype = generateRandomCardioType();
        when(cardiotypeService.findCardioTypeById(anyInt())).thenReturn(cardiotype);

        mockMvc.perform(get("/cardiotype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a CardioType
	 * @throws 
	 */
	@Test
	public void testD_UpdateCardioType() throws Exception
	{
	    CardioTypeDTO cardiotype = generateRandomCardioType();
        when(cardiotypeService.updateCardioType(any(CardioTypeDTO.class))).thenReturn(cardiotype);

        mockMvc.perform(post("/cardiotype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cardiotype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a CardioType
	 * @throws 
	 */
	@Test
	public void testE_DeleteCardioType() throws Exception
	{
		when(cardiotypeService.deleteCardioType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/cardiotype/delete/2"))
                .andExpect(status().isOk());
	}



	public static CardioTypeDTO generateRandomCardioType() {
		CardioTypeDTO record = new CardioTypeDTO();
		record.setDescription(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}