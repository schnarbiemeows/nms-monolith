package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.junit.Assert.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.schnarbiesnmeowers.nmsmonolith.dtos.WrktRecsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.WrktRecsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the WrktRecsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WrktRecsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private WrktRecsService wrktrecsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new WrktRecs
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateWrktRecs() throws URISyntaxException
	{
	    WrktRecsDTO wrktrecs = generateRandomWrktRecs();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(wrktrecs.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/wrktrecs/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<WrktRecsDTO> request = new HttpEntity<>(wrktrecs,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all WrktRecs
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllWrktRecs() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/wrktrecs/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single WrktRecs by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetWrktRecs() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/wrktrecs/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a WrktRecs
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateWrktRecs() throws URISyntaxException
	{
	    WrktRecsDTO wrktrecs = generateRandomWrktRecs();
		final String updateUrl = "http://localhost:" + randomServerPort + "/wrktrecs/update";
		URI uri = new URI(updateUrl);
		HttpEntity<WrktRecsDTO> request = new HttpEntity<>(wrktrecs);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a WrktRecs
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteWrktRecs() throws URISyntaxException
	{
		WrktRecsDTO wrktrecs = generateRandomWrktRecs();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/wrktrecs/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<WrktRecsDTO> request = new HttpEntity<>(wrktrecs);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all WrktRecs by foreign key workoutId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetWrktRecsByWorkoutId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/wrktrecs/findByWorkoutId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all WrktRecs by foreign key liftId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetWrktRecsByLiftId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/wrktrecs/findByLiftId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all WrktRecs by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetWrktRecsByWorkoutIdAndLiftId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/wrktrecs/findByWorkoutIdAndLiftId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static WrktRecsDTO generateRandomWrktRecs() {
		WrktRecsDTO record = new WrktRecsDTO();
		record.setWorkoutId(Randomizer.randomInt(1000));
		record.setLiftId(Randomizer.randomInt(1000));
		record.setWeight(Randomizer.randomBigDecimal("1000"));
		record.setReps(Randomizer.randomInt(1000));
		return record;
	}
}