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

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftLiftEqpDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftLiftEqpService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftLiftEqpController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LiftLiftEqpControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private LiftLiftEqpService liftlifteqpService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new LiftLiftEqp
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateLiftLiftEqp() throws URISyntaxException
	{
	    LiftLiftEqpDTO liftlifteqp = generateRandomLiftLiftEqp();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(liftlifteqp.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LiftLiftEqpDTO> request = new HttpEntity<>(liftlifteqp,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all LiftLiftEqp
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllLiftLiftEqp() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single LiftLiftEqp by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetLiftLiftEqp() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a LiftLiftEqp
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateLiftLiftEqp() throws URISyntaxException
	{
	    LiftLiftEqpDTO liftlifteqp = generateRandomLiftLiftEqp();
		final String updateUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/update";
		URI uri = new URI(updateUrl);
		HttpEntity<LiftLiftEqpDTO> request = new HttpEntity<>(liftlifteqp);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a LiftLiftEqp
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteLiftLiftEqp() throws URISyntaxException
	{
		LiftLiftEqpDTO liftlifteqp = generateRandomLiftLiftEqp();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<LiftLiftEqpDTO> request = new HttpEntity<>(liftlifteqp);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftLiftEqp by foreign key liftId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetLiftLiftEqpByLiftId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/findByLiftId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftLiftEqp by foreign key liftEquipId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetLiftLiftEqpByLiftEquipId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/findByLiftEquipId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftLiftEqp by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetLiftLiftEqpByLiftIdAndLiftEquipId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftlifteqp/findByLiftIdAndLiftEquipId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static LiftLiftEqpDTO generateRandomLiftLiftEqp() {
		LiftLiftEqpDTO record = new LiftLiftEqpDTO();
		record.setLiftId(Randomizer.randomInt(1000));
		record.setLiftEquipId(Randomizer.randomInt(1000));
		return record;
	}
}