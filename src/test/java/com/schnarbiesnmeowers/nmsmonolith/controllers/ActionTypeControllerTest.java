package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;



import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ActionTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ActionTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ActionTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ActionTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private ActionTypeService actiontypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new ActionType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateActionType() throws URISyntaxException
	{
	    ActionTypeDTO actiontype = generateRandomActionType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(actiontype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/actiontype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ActionTypeDTO> request = new HttpEntity<>(actiontype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all ActionType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllActionType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/actiontype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single ActionType by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetActionType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/actiontype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a ActionType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateActionType() throws URISyntaxException
	{
	    ActionTypeDTO actiontype = generateRandomActionType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/actiontype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<ActionTypeDTO> request = new HttpEntity<>(actiontype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a ActionType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteActionType() throws URISyntaxException
	{
		ActionTypeDTO actiontype = generateRandomActionType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/actiontype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<ActionTypeDTO> request = new HttpEntity<>(actiontype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static ActionTypeDTO generateRandomActionType() {
		ActionTypeDTO record = new ActionTypeDTO();
		record.setActionTypeCde(Randomizer.randomString(5));
		record.setActionTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}