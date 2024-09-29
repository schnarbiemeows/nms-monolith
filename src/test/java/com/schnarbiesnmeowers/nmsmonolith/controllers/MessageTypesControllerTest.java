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

import com.schnarbiesnmeowers.nmsmonolith.dtos.MessageTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MessageTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MessageTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MessageTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private MessageTypesService messagetypesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new MessageTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateMessageTypes() throws URISyntaxException
	{
	    MessageTypesDTO messagetypes = generateRandomMessageTypes();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(messagetypes.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/messagetypes/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MessageTypesDTO> request = new HttpEntity<>(messagetypes,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all MessageTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllMessageTypes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/messagetypes/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single MessageTypes by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetMessageTypes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/messagetypes/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a MessageTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateMessageTypes() throws URISyntaxException
	{
	    MessageTypesDTO messagetypes = generateRandomMessageTypes();
		final String updateUrl = "http://localhost:" + randomServerPort + "/messagetypes/update";
		URI uri = new URI(updateUrl);
		HttpEntity<MessageTypesDTO> request = new HttpEntity<>(messagetypes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a MessageTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteMessageTypes() throws URISyntaxException
	{
		MessageTypesDTO messagetypes = generateRandomMessageTypes();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/messagetypes/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<MessageTypesDTO> request = new HttpEntity<>(messagetypes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static MessageTypesDTO generateRandomMessageTypes() {
		MessageTypesDTO record = new MessageTypesDTO();
		record.setMessageTypeCde(Randomizer.randomString(1));
		record.setMessageTypeDesc(Randomizer.randomString(20));
		return record;
	}
}