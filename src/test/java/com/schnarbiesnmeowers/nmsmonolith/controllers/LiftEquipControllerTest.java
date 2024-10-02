package com.schnarbiesnmeowers.nmsmonolith.controllers;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;



import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftEquipService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftEquipController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LiftEquipControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private LiftEquipService liftequipService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new LiftEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateLiftEquip() throws URISyntaxException
	{
	    LiftEquipDTO liftequip = generateRandomLiftEquip();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(liftequip.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/liftequip/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LiftEquipDTO> request = new HttpEntity<>(liftequip,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all LiftEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllLiftEquip() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftequip/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single LiftEquip by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetLiftEquip() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftequip/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a LiftEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateLiftEquip() throws URISyntaxException
	{
	    LiftEquipDTO liftequip = generateRandomLiftEquip();
		final String updateUrl = "http://localhost:" + randomServerPort + "/liftequip/update";
		URI uri = new URI(updateUrl);
		HttpEntity<LiftEquipDTO> request = new HttpEntity<>(liftequip);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a LiftEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteLiftEquip() throws URISyntaxException
	{
		LiftEquipDTO liftequip = generateRandomLiftEquip();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/liftequip/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<LiftEquipDTO> request = new HttpEntity<>(liftequip);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftEquip by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftEquipByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftequip/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static LiftEquipDTO generateRandomLiftEquip() {
		LiftEquipDTO record = new LiftEquipDTO();
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}