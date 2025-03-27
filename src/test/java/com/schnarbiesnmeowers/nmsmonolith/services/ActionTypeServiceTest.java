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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ActionTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ActionType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ActionTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ActionTypeServiceTest {

    @Mock
    private ActionTypeRepository actiontypeRepository;

    @InjectMocks
    private ActionTypeService actiontypeService;

    private ActionType actiontype;
    private ActionTypeDTO actiontypeDTO;

    @BeforeEach
    void setUp() {
        actiontype = generateRandomActionTypeEntity();
        actiontypeDTO = generateRandomActionType();
    }

    @Test
    void testGetAllActionType() throws Exception {
        when(actiontypeRepository.findAll()).thenReturn(Collections.singletonList(actiontype));

        List<ActionTypeDTO> result = actiontypeService.getAllActionType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindActionTypeById_Found() throws Exception {
        when(actiontypeRepository.findById(anyInt())).thenReturn(Optional.of(actiontype));

        ActionTypeDTO result = actiontypeService.findActionTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindActionTypeById_NotFound() {
        when(actiontypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            actiontypeService.findActionTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateActionType() {
        when(actiontypeRepository.save(any(ActionType.class))).thenReturn(actiontype);

        ActionTypeDTO result = actiontypeService.createActionType(actiontypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateActionType_Found() throws Exception {
        when(actiontypeRepository.findById(anyInt())).thenReturn(Optional.of(actiontype));
        when(actiontypeRepository.save(any(ActionType.class))).thenReturn(actiontype);

        ActionTypeDTO result = actiontypeService.updateActionType(actiontypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateActionType_NotFound() {
        when(actiontypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            actiontypeService.updateActionType(actiontypeDTO);
        });

        assertEquals("id = " + actiontypeDTO.getActionTypeId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteActionType_Found() throws Exception {
        when(actiontypeRepository.findById(anyInt())).thenReturn(Optional.of(actiontype));
        doNothing().when(actiontypeRepository).deleteById(anyInt());

        String result = actiontypeService.deleteActionType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteActionType_NotFound() {
        when(actiontypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            actiontypeService.deleteActionType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ActionTypeDTO generateRandomActionType() {
		ActionTypeDTO record = new ActionTypeDTO();
		record.setActionTypeId(2);
		record.setActionTypeCde(Randomizer.randomString(5));
		record.setActionTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static ActionType generateRandomActionTypeEntity() {
		ActionType record = new ActionType();
		record.setActionTypeId(2);
		record.setActionTypeCde(Randomizer.randomString(5));
		record.setActionTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

}
