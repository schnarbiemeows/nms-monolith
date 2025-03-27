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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ImageLocDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.ImageLoc;
import com.schnarbiesnmeowers.nmsmonolith.repositories.ImageLocRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class ImageLocServiceTest {

    @Mock
    private ImageLocRepository imagelocRepository;

    @InjectMocks
    private ImageLocService imagelocService;

    private ImageLoc imageloc;
    private ImageLocDTO imagelocDTO;

    @BeforeEach
    void setUp() {
        imageloc = generateRandomImageLocEntity();
        imagelocDTO = generateRandomImageLoc();
    }

    @Test
    void testGetAllImageLoc() throws Exception {
        when(imagelocRepository.findAll()).thenReturn(Collections.singletonList(imageloc));

        List<ImageLocDTO> result = imagelocService.getAllImageLoc();

        assertEquals(1, result.size());
    }

    @Test
    void testFindImageLocById_Found() throws Exception {
        when(imagelocRepository.findById(anyInt())).thenReturn(Optional.of(imageloc));

        ImageLocDTO result = imagelocService.findImageLocById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindImageLocById_NotFound() {
        when(imagelocRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            imagelocService.findImageLocById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateImageLoc() {
        when(imagelocRepository.save(any(ImageLoc.class))).thenReturn(imageloc);

        ImageLocDTO result = imagelocService.createImageLoc(imagelocDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateImageLoc_Found() throws Exception {
        when(imagelocRepository.findById(anyInt())).thenReturn(Optional.of(imageloc));
        when(imagelocRepository.save(any(ImageLoc.class))).thenReturn(imageloc);

        ImageLocDTO result = imagelocService.updateImageLoc(imagelocDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateImageLoc_NotFound() {
        when(imagelocRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            imagelocService.updateImageLoc(imagelocDTO);
        });

        assertEquals("id = " + imagelocDTO.getImageLocId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteImageLoc_Found() throws Exception {
        when(imagelocRepository.findById(anyInt())).thenReturn(Optional.of(imageloc));
        doNothing().when(imagelocRepository).deleteById(anyInt());

        String result = imagelocService.deleteImageLoc(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteImageLoc_NotFound() {
        when(imagelocRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            imagelocService.deleteImageLoc(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static ImageLocDTO generateRandomImageLoc() {
		ImageLocDTO record = new ImageLocDTO();
		record.setImageLocId(2);
		record.setImgDesc(Randomizer.randomString(20));
		record.setImgPath(Randomizer.randomString(20));
		return record;
	}
    public static ImageLoc generateRandomImageLocEntity() {
		ImageLoc record = new ImageLoc();
		record.setImageLocId(2);
		record.setImgDesc(Randomizer.randomString(20));
		record.setImgPath(Randomizer.randomString(20));
		return record;
	}

}
