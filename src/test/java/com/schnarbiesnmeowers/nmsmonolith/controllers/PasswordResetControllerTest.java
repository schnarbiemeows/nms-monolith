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

import com.schnarbiesnmeowers.nmsmonolith.repositories.PasswordResetRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.PasswordResetDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PasswordResetService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PasswordResetController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class PasswordResetControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private PasswordResetController passwordresetController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private PasswordResetService passwordresetService;

    @Mock
    private PasswordResetRepository passwordresetRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(passwordresetController).build();
    }

	/**
	 * test creating a new PasswordReset
	 * @throws 
	 */
	@Test
	public void testA_CreatePasswordReset() throws Exception
	{
	    PasswordResetDTO passwordreset = generateRandomPasswordReset();
        when(passwordresetService.createPasswordReset(any(PasswordResetDTO.class))).thenReturn(passwordreset);

        mockMvc.perform(post("/passwordreset/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(passwordreset)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all PasswordReset
	 * @throws 
	 */
	@Test
	public void testB_GetAllPasswordReset() throws Exception
	{
		List<PasswordResetDTO> passwordresets = Arrays.asList(generateRandomPasswordReset(), generateRandomPasswordReset());
        when(passwordresetService.getAllPasswordReset()).thenReturn(passwordresets);

        mockMvc.perform(get("/passwordreset/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single PasswordReset by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetPasswordReset() throws Exception
	{
		PasswordResetDTO passwordreset = generateRandomPasswordReset();
        when(passwordresetService.findPasswordResetById(anyInt())).thenReturn(passwordreset);

        mockMvc.perform(get("/passwordreset/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a PasswordReset
	 * @throws 
	 */
	@Test
	public void testD_UpdatePasswordReset() throws Exception
	{
	    PasswordResetDTO passwordreset = generateRandomPasswordReset();
        when(passwordresetService.updatePasswordReset(any(PasswordResetDTO.class))).thenReturn(passwordreset);

        mockMvc.perform(post("/passwordreset/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(passwordreset)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a PasswordReset
	 * @throws 
	 */
	@Test
	public void testE_DeletePasswordReset() throws Exception
	{
		when(passwordresetService.deletePasswordReset(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/passwordreset/delete/2"))
                .andExpect(status().isOk());
	}



	public static PasswordResetDTO generateRandomPasswordReset() {
		PasswordResetDTO record = new PasswordResetDTO();
		record.setUniqueId(Randomizer.randomString(20));
		record.setEmailAddr(Randomizer.randomString(20));
		record.setCreatedDate(Randomizer.randomDate());
		return record;
	}
}