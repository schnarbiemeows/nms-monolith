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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.GrpUserHist;
import com.schnarbiesnmeowers.nmsmonolith.repositories.GrpUserHistRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class GrpUserHistServiceTest {

    @Mock
    private GrpUserHistRepository grpuserhistRepository;

    @InjectMocks
    private GrpUserHistService grpuserhistService;

    private GrpUserHist grpuserhist;
    private GrpUserHistDTO grpuserhistDTO;

    @BeforeEach
    void setUp() {
        grpuserhist = generateRandomGrpUserHistEntity();
        grpuserhistDTO = generateRandomGrpUserHist();
    }

    @Test
    void testGetAllGrpUserHist() throws Exception {
        when(grpuserhistRepository.findAll()).thenReturn(Collections.singletonList(grpuserhist));

        List<GrpUserHistDTO> result = grpuserhistService.getAllGrpUserHist();

        assertEquals(1, result.size());
    }

    @Test
    void testFindGrpUserHistById_Found() throws Exception {
        when(grpuserhistRepository.findById(anyInt())).thenReturn(Optional.of(grpuserhist));

        GrpUserHistDTO result = grpuserhistService.findGrpUserHistById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindGrpUserHistById_NotFound() {
        when(grpuserhistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            grpuserhistService.findGrpUserHistById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateGrpUserHist() {
        when(grpuserhistRepository.save(any(GrpUserHist.class))).thenReturn(grpuserhist);

        GrpUserHistDTO result = grpuserhistService.createGrpUserHist(grpuserhistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGrpUserHist_Found() throws Exception {
        when(grpuserhistRepository.findById(anyInt())).thenReturn(Optional.of(grpuserhist));
        when(grpuserhistRepository.save(any(GrpUserHist.class))).thenReturn(grpuserhist);

        GrpUserHistDTO result = grpuserhistService.updateGrpUserHist(grpuserhistDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateGrpUserHist_NotFound() {
        when(grpuserhistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            grpuserhistService.updateGrpUserHist(grpuserhistDTO);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testDeleteGrpUserHist_Found() throws Exception {
        when(grpuserhistRepository.findById(anyInt())).thenReturn(Optional.of(grpuserhist));
        doNothing().when(grpuserhistRepository).deleteById(anyInt());

        String result = grpuserhistService.deleteGrpUserHist(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteGrpUserHist_NotFound() {
        when(grpuserhistRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            grpuserhistService.deleteGrpUserHist(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static GrpUserHistDTO generateRandomGrpUserHist() {
		GrpUserHistDTO record = new GrpUserHistDTO();
		record.setGrpUserHistId(2);
		record.setGrpUserId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
    public static GrpUserHist generateRandomGrpUserHistEntity() {
		GrpUserHist record = new GrpUserHist();
		record.setGrpUserHistId(2);
		record.setGrpUserId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}
