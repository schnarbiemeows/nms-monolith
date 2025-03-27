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

import com.schnarbiesnmeowers.nmsmonolith.repositories.BrandIngrTypeRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BrandIngrTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BrandIngrTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BrandIngrTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class BrandIngrTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private BrandIngrTypeController brandingrtypeController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private BrandIngrTypeService brandingrtypeService;

    @Mock
    private BrandIngrTypeRepository brandingrtypeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(brandingrtypeController).build();
    }

	/**
	 * test creating a new BrandIngrType
	 * @throws 
	 */
	@Test
	public void testA_CreateBrandIngrType() throws Exception
	{
	    BrandIngrTypeDTO brandingrtype = generateRandomBrandIngrType();
        when(brandingrtypeService.createBrandIngrType(any(BrandIngrTypeDTO.class))).thenReturn(brandingrtype);

        mockMvc.perform(post("/brandingrtype/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brandingrtype)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all BrandIngrType
	 * @throws 
	 */
	@Test
	public void testB_GetAllBrandIngrType() throws Exception
	{
		List<BrandIngrTypeDTO> brandingrtypes = Arrays.asList(generateRandomBrandIngrType(), generateRandomBrandIngrType());
        when(brandingrtypeService.getAllBrandIngrType()).thenReturn(brandingrtypes);

        mockMvc.perform(get("/brandingrtype/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single BrandIngrType by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetBrandIngrType() throws Exception
	{
		BrandIngrTypeDTO brandingrtype = generateRandomBrandIngrType();
        when(brandingrtypeService.findBrandIngrTypeById(anyInt())).thenReturn(brandingrtype);

        mockMvc.perform(get("/brandingrtype/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a BrandIngrType
	 * @throws 
	 */
	@Test
	public void testD_UpdateBrandIngrType() throws Exception
	{
	    BrandIngrTypeDTO brandingrtype = generateRandomBrandIngrType();
        when(brandingrtypeService.updateBrandIngrType(any(BrandIngrTypeDTO.class))).thenReturn(brandingrtype);

        mockMvc.perform(post("/brandingrtype/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(brandingrtype)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a BrandIngrType
	 * @throws 
	 */
	@Test
	public void testE_DeleteBrandIngrType() throws Exception
	{
		when(brandingrtypeService.deleteBrandIngrType(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/brandingrtype/delete/2"))
                .andExpect(status().isOk());
	}

/**
 * test getting a single BrandIngrType by field BrandId
 * @throws
 */
@Test
public void testC_findByBrandId() throws Exception
{
    List<BrandIngrTypeDTO> brandingrtype = Arrays.asList(generateRandomBrandIngrType());
    when(brandingrtypeService.findBrandIngrTypeByBrandId(anyInt())).thenReturn(brandingrtype);

    mockMvc.perform(get("/brandingrtype/findByBrandId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single BrandIngrType by field IngrTypeId
 * @throws
 */
@Test
public void testC_findByIngrTypeId() throws Exception
{
    List<BrandIngrTypeDTO> brandingrtype = Arrays.asList(generateRandomBrandIngrType());
    when(brandingrtypeService.findBrandIngrTypeByIngrTypeId(anyInt())).thenReturn(brandingrtype);

    mockMvc.perform(get("/brandingrtype/findByIngrTypeId/2"))
            .andExpect(status().isOk());
}/**
 * test getting a single BrandIngrType by field PrntIngrType
 * @throws
 */
@Test
public void testC_findByPrntIngrType() throws Exception
{
    List<BrandIngrTypeDTO> brandingrtype = Arrays.asList(generateRandomBrandIngrType());
    when(brandingrtypeService.findBrandIngrTypeByPrntIngrType(anyInt())).thenReturn(brandingrtype);

    mockMvc.perform(get("/brandingrtype/findByPrntIngrType/2"))
            .andExpect(status().isOk());
}

	public static BrandIngrTypeDTO generateRandomBrandIngrType() {
		BrandIngrTypeDTO record = new BrandIngrTypeDTO();
		record.setBrandId(Randomizer.randomInt(1000));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setPrntIngrType(Randomizer.randomInt(1000));
		return record;
	}
}