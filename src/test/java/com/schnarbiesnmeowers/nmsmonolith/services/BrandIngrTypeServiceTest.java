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
import com.schnarbiesnmeowers.nmsmonolith.dtos.BrandIngrTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.BrandIngrType;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BrandIngrTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class BrandIngrTypeServiceTest {

    @Mock
    private BrandIngrTypeRepository brandingrtypeRepository;

    @InjectMocks
    private BrandIngrTypeService brandingrtypeService;

    private BrandIngrType brandingrtype;
    private BrandIngrTypeDTO brandingrtypeDTO;

    @BeforeEach
    void setUp() {
        brandingrtype = generateRandomBrandIngrTypeEntity();
        brandingrtypeDTO = generateRandomBrandIngrType();
    }

    @Test
    void testGetAllBrandIngrType() throws Exception {
        when(brandingrtypeRepository.findAll()).thenReturn(Collections.singletonList(brandingrtype));

        List<BrandIngrTypeDTO> result = brandingrtypeService.getAllBrandIngrType();

        assertEquals(1, result.size());
    }

    @Test
    void testFindBrandIngrTypeById_Found() throws Exception {
        when(brandingrtypeRepository.findById(anyInt())).thenReturn(Optional.of(brandingrtype));

        BrandIngrTypeDTO result = brandingrtypeService.findBrandIngrTypeById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindBrandIngrTypeById_NotFound() {
        when(brandingrtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            brandingrtypeService.findBrandIngrTypeById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateBrandIngrType() {
        when(brandingrtypeRepository.save(any(BrandIngrType.class))).thenReturn(brandingrtype);

        BrandIngrTypeDTO result = brandingrtypeService.createBrandIngrType(brandingrtypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBrandIngrType_Found() throws Exception {
        when(brandingrtypeRepository.findById(anyInt())).thenReturn(Optional.of(brandingrtype));
        when(brandingrtypeRepository.save(any(BrandIngrType.class))).thenReturn(brandingrtype);

        BrandIngrTypeDTO result = brandingrtypeService.updateBrandIngrType(brandingrtypeDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBrandIngrType_NotFound() {
        when(brandingrtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            brandingrtypeService.updateBrandIngrType(brandingrtypeDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteBrandIngrType_Found() throws Exception {
        when(brandingrtypeRepository.findById(anyInt())).thenReturn(Optional.of(brandingrtype));
        doNothing().when(brandingrtypeRepository).deleteById(anyInt());

        String result = brandingrtypeService.deleteBrandIngrType(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteBrandIngrType_NotFound() {
        when(brandingrtypeRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            brandingrtypeService.deleteBrandIngrType(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static BrandIngrTypeDTO generateRandomBrandIngrType() {
		BrandIngrTypeDTO record = new BrandIngrTypeDTO();
		record.setBrandIngrTypeId(2);
		record.setBrandId(Randomizer.randomInt(1000));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setPrntIngrType(Randomizer.randomInt(1000));
		return record;
	}
    public static BrandIngrType generateRandomBrandIngrTypeEntity() {
		BrandIngrType record = new BrandIngrType();
		record.setBrandIngrTypeId(2);
		record.setBrandId(Randomizer.randomInt(1000));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setPrntIngrType(Randomizer.randomInt(1000));
		return record;
	}
}
