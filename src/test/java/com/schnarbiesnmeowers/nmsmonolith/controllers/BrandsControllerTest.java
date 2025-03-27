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

import com.schnarbiesnmeowers.nmsmonolith.repositories.BrandsRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BrandsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BrandsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class BrandsControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private BrandsController brandsController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private BrandsService brandsService;

    @Mock
    private BrandsRepository brandsRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(brandsController).build();
    }

	/**
	 * test creating a new Brands
	 * @throws 
	 */
	@Test
	public void testA_CreateBrands() throws Exception
	{
	    BrandsDTO brands = generateRandomBrands();
        when(brandsService.createBrands(any(BrandsDTO.class))).thenReturn(brands);

        mockMvc.perform(post("/brands/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brands)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all Brands
	 * @throws 
	 */
	@Test
	public void testB_GetAllBrands() throws Exception
	{
		List<BrandsDTO> brandss = Arrays.asList(generateRandomBrands(), generateRandomBrands());
        when(brandsService.getAllBrands()).thenReturn(brandss);

        mockMvc.perform(get("/brands/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single Brands by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetBrands() throws Exception
	{
		BrandsDTO brands = generateRandomBrands();
        when(brandsService.findBrandsById(anyInt())).thenReturn(brands);

        mockMvc.perform(get("/brands/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a Brands
	 * @throws 
	 */
	@Test
	public void testD_UpdateBrands() throws Exception
	{
	    BrandsDTO brands = generateRandomBrands();
        when(brandsService.updateBrands(any(BrandsDTO.class))).thenReturn(brands);

        mockMvc.perform(post("/brands/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brands)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a Brands
	 * @throws 
	 */
	@Test
	public void testE_DeleteBrands() throws Exception
	{
		when(brandsService.deleteBrands(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/brands/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single Brands by field ImageLoc
 * @throws
 */
@Test
public void testC_findByImageLoc() throws Exception
{
    List<BrandsDTO> brands = Arrays.asList(generateRandomBrands());
    when(brandsService.findBrandsByImageLoc(anyInt())).thenReturn(brands);

    mockMvc.perform(get("/brands/findByImageLoc/2"))
            .andExpect(status().isOk());
}

	public static BrandsDTO generateRandomBrands() {
		BrandsDTO record = new BrandsDTO();
		record.setBrandType(Randomizer.randomString(2));
		record.setBrandName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}