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
import com.schnarbiesnmeowers.nmsmonolith.dtos.MessagesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MessagesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MessagesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessagesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private MessagesService messagesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Messages
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateMessages() throws URISyntaxException
	{
	    MessagesDTO messages = generateRandomMessages();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(messages.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/messages/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MessagesDTO> request = new HttpEntity<>(messages,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Messages
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllMessages() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/messages/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Messages by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetMessages() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/messages/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Messages
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateMessages() throws URISyntaxException
	{
	    MessagesDTO messages = generateRandomMessages();
		final String updateUrl = "http://localhost:" + randomServerPort + "/messages/update";
		URI uri = new URI(updateUrl);
		HttpEntity<MessagesDTO> request = new HttpEntity<>(messages);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Messages
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteMessages() throws URISyntaxException
	{
		MessagesDTO messages = generateRandomMessages();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/messages/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<MessagesDTO> request = new HttpEntity<>(messages);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Messages by foreign key eventId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetMessagesByEventId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/messages/findByEventId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Messages by foreign key messageTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetMessagesByMessageTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/messages/findByMessageTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Messages by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetMessagesByEventIdAndMessageTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/messages/findByEventIdAndMessageTypeId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static MessagesDTO generateRandomMessages() {
		MessagesDTO record = new MessagesDTO();
		record.setEventId(Randomizer.randomInt(1000));
		record.setMessageTypeId(Randomizer.randomInt(1000));
		record.setMessageTxt(Randomizer.randomString(20));
		return record;
	}
}