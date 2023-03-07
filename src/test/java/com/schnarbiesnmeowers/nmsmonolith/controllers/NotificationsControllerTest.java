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

import com.schnarbiesnmeowers.nmsmonolith.dtos.NotificationsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.NotificationsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the NotificationsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NotificationsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private NotificationsService notificationsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Notifications
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateNotifications() throws URISyntaxException
	{
	    NotificationsDTO notifications = generateRandomNotifications();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(notifications.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/notifications/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<NotificationsDTO> request = new HttpEntity<>(notifications,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Notifications
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllNotifications() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/notifications/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Notifications by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetNotifications() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/notifications/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Notifications
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateNotifications() throws URISyntaxException
	{
	    NotificationsDTO notifications = generateRandomNotifications();
		final String updateUrl = "http://localhost:" + randomServerPort + "/notifications/update";
		URI uri = new URI(updateUrl);
		HttpEntity<NotificationsDTO> request = new HttpEntity<>(notifications);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Notifications
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteNotifications() throws URISyntaxException
	{
		NotificationsDTO notifications = generateRandomNotifications();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/notifications/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<NotificationsDTO> request = new HttpEntity<>(notifications);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Notifications by foreign key eventId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetNotificationsByEventId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/notifications/findByEventId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static NotificationsDTO generateRandomNotifications() {
		NotificationsDTO record = new NotificationsDTO();
		record.setEventId(Randomizer.randomInt(1000));
		record.setNotifTime(Randomizer.randomTime(1000));
		record.setNextNotifDate(Randomizer.randomDate());
		record.setDelivered(Randomizer.randomString(1));
		return record;
	}
}