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
import com.schnarbiesnmeowers.nmsmonolith.dtos.CardioTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.CardioType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.CardioTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class CardioTypeServiceTest {

    @Mock
    private CardioTypeRepository cardiotypeRepository;

    @InjectMocks
    private CardioTypeService cardiotypeService;

    private CardioType cardiotype;
    private CardioTypeDTO cardiotypeDTO;

    @BeforeEach
    void setUp() {
        cardiotype = generateRandomCardioTypeEntity();
        cardiotypeDTO = generateRandomCardioType();
    }

    @Test
    void testGetAllCardioType() throws Exception {
        when(cardiotypeRepository.findAll()).thenReturn(Collections.singletonList(cardiotype));

        List<CardioTypeDTO> result = cardiotypeService.getAllCardioType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindCardioTypeById_Found() throws Exception {
        when(cardiotypeRepository.findById(anyInt())).thenReturn(Optional.of(cardiotype));

        CardioTypeDTO result = cardiotypeService.findCardioTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindCardioTypeById_NotFound() {
        when(cardiotypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            cardiotypeService.findCardioTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateCardioType() {
        when(cardiotypeRepository.save(any(CardioType.class))).thenReturn(cardiotype);

        CardioTypeDTO result = cardiotypeService.createCardioType(cardiotypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateCardioType_Found() throws Exception {
        when(cardiotypeRepository.findById(anyInt())).thenReturn(Optional.of(cardiotype));
        when(cardiotypeRepository.save(any(CardioType.class))).thenReturn(cardiotype);

        CardioTypeDTO result = cardiotypeService.updateCardioType(cardiotypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateCardioType_NotFound() {
        when(cardiotypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            cardiotypeService.updateCardioType(cardiotypeDTO);
        });

        assertEquals("id = " + cardiotypeDTO.getCardioTypeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteCardioType_Found() throws Exception {
        when(cardiotypeRepository.findById(anyInt())).thenReturn(Optional.of(cardiotype));
        doNothing().when(cardiotypeRepository).deleteById(anyInt());

        String result = cardiotypeService.deleteCardioType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteCardioType_NotFound() {
        when(cardiotypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            cardiotypeService.deleteCardioType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static CardioTypeDTO generateRandomCardioType() {
		CardioTypeDTO record = new CardioTypeDTO();
		record.setCardioTypeId(2);
		record.setDescription(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static CardioType generateRandomCardioTypeEntity() {
		CardioType record = new CardioType();
		record.setCardioTypeId(2);
		record.setDescription(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
