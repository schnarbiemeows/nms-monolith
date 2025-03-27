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

import com.schnarbiesnmeowers.nmsmonolith.repositories.ImageLocRepository;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ImageLocDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ImageLocService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ImageLocController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
public class ImageLocControllerTest {

	/**
	 * generate a random port for testing
	 */
	private MockMvc mockMvc;

    @InjectMocks
    private ImageLocController imagelocController;

	/**
	 * create a Mock Business object
	 */

	@Mock
	private ImageLocService imagelocService;

    @Mock
    private ImageLocRepository imagelocRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
    void setUp() {
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mockMvc = MockMvcBuilders.standaloneSetup(imagelocController).build();
    }

	/**
	 * test creating a new ImageLoc
	 * @throws 
	 */
	@Test
	public void testA_CreateImageLoc() throws Exception
	{
	    ImageLocDTO imageloc = generateRandomImageLoc();
        when(imagelocService.createImageLoc(any(ImageLocDTO.class))).thenReturn(imageloc);

        mockMvc.perform(post("/imageloc/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imageloc)))
                .andExpect(status().isCreated());
    }

    /**
	 * test getting all ImageLoc
	 * @throws 
	 */
	@Test
	public void testB_GetAllImageLoc() throws Exception
	{
		List<ImageLocDTO> imagelocs = Arrays.asList(generateRandomImageLoc(), generateRandomImageLoc());
        when(imagelocService.getAllImageLoc()).thenReturn(imagelocs);

        mockMvc.perform(get("/imageloc/all"))
                .andExpect(status().isOk());
	}

	/**
	 * test getting a single ImageLoc by primary key
	 * @throws 
	 */
	@Test
	public void testC_GetImageLoc() throws Exception
	{
		ImageLocDTO imageloc = generateRandomImageLoc();
        when(imagelocService.findImageLocById(anyInt())).thenReturn(imageloc);

        mockMvc.perform(get("/imageloc/findById/2"))
                .andExpect(status().isOk());
	}

    /**
	 * test updating a ImageLoc
	 * @throws 
	 */
	@Test
	public void testD_UpdateImageLoc() throws Exception
	{
	    ImageLocDTO imageloc = generateRandomImageLoc();
        when(imagelocService.updateImageLoc(any(ImageLocDTO.class))).thenReturn(imageloc);

        mockMvc.perform(post("/imageloc/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imageloc)))
                .andExpect(status().isOk());
	}

	/**
	 * test deleting a ImageLoc
	 * @throws 
	 */
	@Test
	public void testE_DeleteImageLoc() throws Exception
	{
		when(imagelocService.deleteImageLoc(anyInt())).thenReturn("successfully deleted");

        mockMvc.perform(delete("/imageloc/delete/2"))
                .andExpect(status().isOk());
	}



	public static ImageLocDTO generateRandomImageLoc() {
		ImageLocDTO record = new ImageLocDTO();
		record.setImgDesc(Randomizer.randomString(20));
		record.setImgPath(Randomizer.randomString(20));
		return record;
	}
}