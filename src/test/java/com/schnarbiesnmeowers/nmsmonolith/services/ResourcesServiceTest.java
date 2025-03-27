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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ResourcesDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Resources;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ResourcesRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ResourcesServiceTest {

    @Mock
    private ResourcesRepository resourcesRepository;

    @InjectMocks
    private ResourcesService resourcesService;

    private Resources resources;
    private ResourcesDTO resourcesDTO;

    @BeforeEach
    void setUp() {
        resources = generateRandomResourcesEntity();
        resourcesDTO = generateRandomResources();
    }

    @Test
    void testGetAllResources() throws Exception {
        when(resourcesRepository.findAll()).thenReturn(Collections.singletonList(resources));

        List<ResourcesDTO> result = resourcesService.getAllResources();

        assertEquals(1, result.size());
    }

    @Test
    void testFindResourcesById_Found() throws Exception {
        when(resourcesRepository.findById(anyInt())).thenReturn(Optional.of(resources));

        ResourcesDTO result = resourcesService.findResourcesById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindResourcesById_NotFound() {
        when(resourcesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            resourcesService.findResourcesById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateResources() {
        when(resourcesRepository.save(any(Resources.class))).thenReturn(resources);

        ResourcesDTO result = resourcesService.createResources(resourcesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateResources_Found() throws Exception {
        when(resourcesRepository.findById(anyInt())).thenReturn(Optional.of(resources));
        when(resourcesRepository.save(any(Resources.class))).thenReturn(resources);

        ResourcesDTO result = resourcesService.updateResources(resourcesDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateResources_NotFound() {
        when(resourcesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            resourcesService.updateResources(resourcesDTO);
        });

        assertEquals("id = " + resourcesDTO.getRsrcId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteResources_Found() throws Exception {
        when(resourcesRepository.findById(anyInt())).thenReturn(Optional.of(resources));
        doNothing().when(resourcesRepository).deleteById(anyInt());

        String result = resourcesService.deleteResources(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteResources_NotFound() {
        when(resourcesRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            resourcesService.deleteResources(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ResourcesDTO generateRandomResources() {
		ResourcesDTO record = new ResourcesDTO();
		record.setRsrcId(2);
		record.setRsrcTypeId(Randomizer.randomInt(1000));
		record.setRsrcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Resources generateRandomResourcesEntity() {
		Resources record = new Resources();
		record.setRsrcId(2);
		record.setRsrcTypeId(Randomizer.randomInt(1000));
		record.setRsrcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}
