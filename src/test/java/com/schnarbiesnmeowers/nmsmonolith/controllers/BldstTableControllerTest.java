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

import com.schnarbiesnmeowers.nmsmonolith.repositories.BldstTableRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BldstTableService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BldstTableController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class BldstTableControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private BldstTableController bldsttableController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private BldstTableService bldsttableService;

    @Mock
    private BldstTableRepository bldsttableRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(bldsttableController).build();
    }

	/**
	 * test creating a new BldstTable
	 * @throws 
	 */
	@Test
	public void testA_CreateBldstTable() throws Exception
	{
	    BldstTableDTO bldsttable = generateRandomBldstTable();
        when(bldsttableService.createBldstTable(any(BldstTableDTO.class))).thenReturn(bldsttable);

        mockMvc.perform(post("/bldsttable/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bldsttable)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all BldstTable
	 * @throws 
	 */
	@Test
	public void testB_GetAllBldstTable() throws Exception
	{
		List<BldstTableDTO> bldsttables = Arrays.asList(generateRandomBldstTable(), generateRandomBldstTable());
        when(bldsttableService.getAllBldstTable()).thenReturn(bldsttables);

        mockMvc.perform(get("/bldsttable/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single BldstTable by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetBldstTable() throws Exception
	{
		BldstTableDTO bldsttable = generateRandomBldstTable();
        when(bldsttableService.findBldstTableById(anyInt())).thenReturn(bldsttable);

        mockMvc.perform(get("/bldsttable/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a BldstTable
	 * @throws 
	 */
	@Test
	public void testD_UpdateBldstTable() throws Exception
	{
	    BldstTableDTO bldsttable = generateRandomBldstTable();
        when(bldsttableService.updateBldstTable(any(BldstTableDTO.class))).thenReturn(bldsttable);

        mockMvc.perform(post("/bldsttable/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bldsttable)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a BldstTable
	 * @throws 
	 */
	@Test
	public void testE_DeleteBldstTable() throws Exception
	{
		when(bldsttableService.deleteBldstTable(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/bldsttable/delete/2"))
                .andExpect(status().isOk());
	}



	public static BldstTableDTO generateRandomBldstTable() {
		BldstTableDTO record = new BldstTableDTO();
		record.setBldstCde(Randomizer.randomString(3));
		record.setBldstDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
}