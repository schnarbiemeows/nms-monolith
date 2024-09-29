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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GoalsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GoalsService goalsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Goals
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateGoals() throws URISyntaxException
	{
	    GoalsDTO goals = generateRandomGoals();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(goals.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/goals/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GoalsDTO> request = new HttpEntity<>(goals,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Goals
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllGoals() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/goals/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Goals by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetGoals() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goals/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Goals
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateGoals() throws URISyntaxException
	{
	    GoalsDTO goals = generateRandomGoals();
		final String updateUrl = "http://localhost:" + randomServerPort + "/goals/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GoalsDTO> request = new HttpEntity<>(goals);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Goals
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteGoals() throws URISyntaxException
	{
		GoalsDTO goals = generateRandomGoals();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/goals/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GoalsDTO> request = new HttpEntity<>(goals);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Goals by foreign key userId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetGoalsByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goals/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Goals by foreign key gcId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetGoalsByGcId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goals/findByGcId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Goals by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetGoalsByUserIdAndGcId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goals/findByUserIdAndGcId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GoalsDTO generateRandomGoals() {
		GoalsDTO record = new GoalsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalName(Randomizer.randomString(20));
		record.setGcId(Randomizer.randomInt(1000));
		record.setComparator(Randomizer.randomString(3));
		record.setCompFld(Randomizer.randomString(20));
		record.setNumTimes(Randomizer.randomInt(1000));
		record.setTimesMet(Randomizer.randomInt(1000));
		record.setConseq(Randomizer.randomString(1));
		record.setRenew(Randomizer.randomString(1));
		record.setAchieved(Randomizer.randomString(1));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}