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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalEventDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalEventService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalEventController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GoalEventControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GoalEventService goaleventService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GoalEvent
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateGoalEvent() throws URISyntaxException
	{
	    GoalEventDTO goalevent = generateRandomGoalEvent();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(goalevent.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/goalevent/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GoalEventDTO> request = new HttpEntity<>(goalevent,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GoalEvent
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllGoalEvent() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalevent/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GoalEvent by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetGoalEvent() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalevent/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GoalEvent
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateGoalEvent() throws URISyntaxException
	{
	    GoalEventDTO goalevent = generateRandomGoalEvent();
		final String updateUrl = "http://localhost:" + randomServerPort + "/goalevent/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GoalEventDTO> request = new HttpEntity<>(goalevent);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GoalEvent
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteGoalEvent() throws URISyntaxException
	{
		GoalEventDTO goalevent = generateRandomGoalEvent();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/goalevent/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GoalEventDTO> request = new HttpEntity<>(goalevent);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalEvent by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalEventByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalevent/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalEvent by foreign key goalId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalEventByGoalId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalevent/findByGoalId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalEvent by foreign key eventId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalEventByEventId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalevent/findByEventId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalEvent by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalEventByUserIdAndGoalIdAndEventId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalevent/findByUserIdAndGoalIdAndEventId/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GoalEventDTO generateRandomGoalEvent() {
		GoalEventDTO record = new GoalEventDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setGoalId(Randomizer.randomInt(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
}