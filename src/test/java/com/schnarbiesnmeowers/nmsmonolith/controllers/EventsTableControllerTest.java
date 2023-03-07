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

import com.schnarbiesnmeowers.nmsmonolith.dtos.EventsTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.EventsTableService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the EventsTableController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EventsTableControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private EventsTableService eventstableService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new EventsTable
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateEventsTable() throws URISyntaxException
	{
	    EventsTableDTO eventstable = generateRandomEventsTable();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(eventstable.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/eventstable/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EventsTableDTO> request = new HttpEntity<>(eventstable,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all EventsTable
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllEventsTable() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/eventstable/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single EventsTable by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetEventsTable() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/eventstable/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a EventsTable
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateEventsTable() throws URISyntaxException
	{
	    EventsTableDTO eventstable = generateRandomEventsTable();
		final String updateUrl = "http://localhost:" + randomServerPort + "/eventstable/update";
		URI uri = new URI(updateUrl);
		HttpEntity<EventsTableDTO> request = new HttpEntity<>(eventstable);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a EventsTable
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteEventsTable() throws URISyntaxException
	{
		EventsTableDTO eventstable = generateRandomEventsTable();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/eventstable/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<EventsTableDTO> request = new HttpEntity<>(eventstable);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all EventsTable by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetEventsTableByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/eventstable/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all EventsTable by foreign key periodId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetEventsTableByPeriodId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/eventstable/findByPeriodId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all EventsTable by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetEventsTableByUserIdAndPeriodId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/eventstable/findByUserIdAndPeriodId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static EventsTableDTO generateRandomEventsTable() {
		EventsTableDTO record = new EventsTableDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setEventName(Randomizer.randomString(20));
		record.setEventDesc(Randomizer.randomString(20));
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}