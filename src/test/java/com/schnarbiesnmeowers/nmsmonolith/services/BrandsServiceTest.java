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
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Brands;
import com.schnarbiesnmeowers.nmsmonolith.repositories.BrandsRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class BrandsServiceTest {

    @Mock
    private BrandsRepository brandsRepository;

    @Mock
    private FavoriteBrandsService favoriteBrandsService;

    @Mock
    private IngredientsService ingredientsService;

    @InjectMocks
    private BrandsService brandsService;

    private Brands brands;
    private BrandsDTO brandsDTO;

    @BeforeEach
    void setUp() {
        brands = generateRandomBrandsEntity();
        brandsDTO = generateRandomBrands();
    }

    @Test
    void testGetAllBrands() throws Exception {
        when(brandsRepository.findActiveBrands()).thenReturn(Collections.singletonList(brands));

        List<BrandsDTO> result = brandsService.getAllBrands();

        assertEquals(1, result.size());
    }

    @Test
    void testFindBrandsById_Found() throws Exception {
        when(brandsRepository.findById(anyInt())).thenReturn(Optional.of(brands));

        BrandsDTO result = brandsService.findBrandsById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindBrandsById_NotFound() {
        when(brandsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            brandsService.findBrandsById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateBrands() {
        when(brandsRepository.save(any(Brands.class))).thenReturn(brands);

        BrandsDTO result = brandsService.createBrands(brandsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBrands_Found() throws Exception {
        when(brandsRepository.findById(anyInt())).thenReturn(Optional.of(brands));
        when(brandsRepository.save(any(Brands.class))).thenReturn(brands);

        BrandsDTO result = brandsService.updateBrands(brandsDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateBrands_NotFound() {
        when(brandsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            brandsService.updateBrands(brandsDTO);
        });

        assertEquals("id = " + brandsDTO.getBrandId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteBrands_Found() throws Exception {
        when(brandsRepository.findById(anyInt())).thenReturn(Optional.of(brands));
        when(brandsRepository.save(any()))
                .thenReturn(brands);
        when(favoriteBrandsService.checkForFavoriteDependencies(anyInt(),isNull(),eq(false)))
                .thenReturn(false);
        when(ingredientsService.checkForGlobalIngredientDependencies(anyInt()))
                .thenReturn(false);
        String result = brandsService.deleteBrands(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteBrands_NotFound() {
        when(brandsRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            brandsService.deleteBrands(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static BrandsDTO generateRandomBrands() {
		BrandsDTO record = new BrandsDTO();
		record.setBrandId(2);
		record.setBrandType(Randomizer.randomString(2));
		record.setBrandName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Brands generateRandomBrandsEntity() {
		Brands record = new Brands();
		record.setBrandId(2);
		record.setBrandType(Randomizer.randomString(2));
		record.setBrandName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

	/**
	 * get List<BrandsDTO> by foreign key : imageLoc
	 * @param id
	 * @return List<Brands>
	 * @throws Exception
	*/
	public List<BrandsDTO> findBrandsByImageLoc(int id) throws Exception {
		List<BrandsDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
