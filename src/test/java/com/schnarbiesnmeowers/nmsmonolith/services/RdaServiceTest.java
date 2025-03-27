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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RdaDTO;
import com.schnarbiesnmeowers.nmsmonolith.entities.Rda;
import com.schnarbiesnmeowers.nmsmonolith.repositories.RdaRepository;
import com.schnarbiesnmeowers.nmsmonolith.exceptions.ResourceNotFoundException;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
class RdaServiceTest {

    @Mock
    private RdaRepository rdaRepository;

    @InjectMocks
    private RdaService rdaService;

    private Rda rda;
    private RdaDTO rdaDTO;

    @BeforeEach
    void setUp() {
        rda = generateRandomRdaEntity();
        rdaDTO = generateRandomRda();
    }

    @Test
    void testGetAllRda() throws Exception {
        when(rdaRepository.findAll()).thenReturn(Collections.singletonList(rda));

        List<RdaDTO> result = rdaService.getAllRda();

        assertEquals(1, result.size());
    }

    @Test
    void testFindRdaById_Found() throws Exception {
        when(rdaRepository.findById(anyInt())).thenReturn(Optional.of(rda));

        RdaDTO result = rdaService.findRdaById(anyInt());

        assertNotNull(result);
    }

    @Test
    void testFindRdaById_NotFound() {
        when(rdaRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rdaService.findRdaById(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    @Test
    void testCreateRda() {
        when(rdaRepository.save(any(Rda.class))).thenReturn(rda);

        RdaDTO result = rdaService.createRda(rdaDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRda_Found() throws Exception {
        when(rdaRepository.findById(anyInt())).thenReturn(Optional.of(rda));
        when(rdaRepository.save(any(Rda.class))).thenReturn(rda);

        RdaDTO result = rdaService.updateRda(rdaDTO);

        assertNotNull(result);
    }

    @Test
    void testUpdateRda_NotFound() {
        when(rdaRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rdaService.updateRda(rdaDTO);
        });

        assertEquals("id = " + rdaDTO.getRdaId() + " not found", exception.getMessage());
    }

    @Test
    void testDeleteRda_Found() throws Exception {
        when(rdaRepository.findById(anyInt())).thenReturn(Optional.of(rda));
        doNothing().when(rdaRepository).deleteById(anyInt());

        String result = rdaService.deleteRda(anyInt());

        assertEquals("Successfully Deleted", result);
    }

    @Test
    void testDeleteRda_NotFound() {
        when(rdaRepository.findById(anyInt())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            rdaService.deleteRda(2);
        });

        assertEquals("id = 2 not found", exception.getMessage());
    }

    public static RdaDTO generateRandomRda() {
		RdaDTO record = new RdaDTO();
		record.setRdaId(2);
		record.setRdaName(Randomizer.randomString(20));
		record.setRdaValue(Randomizer.randomBigDecimal("1000"));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}
    public static Rda generateRandomRdaEntity() {
		Rda record = new Rda();
		record.setRdaId(2);
		record.setRdaName(Randomizer.randomString(20));
		record.setRdaValue(Randomizer.randomBigDecimal("1000"));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(2));
		return record;
	}

	/**
	 * get List<RdaDTO> by foreign key : userId
	 * @param id
	 * @return List<Rda>
	 * @throws Exception
	*/
	public List<RdaDTO> findRdaByUserId(int id) throws Exception {
		List<RdaDTO> resultsdto = new ArrayList();
		return resultsdto;
	}

}
