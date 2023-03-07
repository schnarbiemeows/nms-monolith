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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GoalTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GoalTypesService goaltypesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GoalTypes
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateGoalTypes() throws URISyntaxException
	{
	    GoalTypesDTO goaltypes = generateRandomGoalTypes();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(goaltypes.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/goaltypes/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GoalTypesDTO> request = new HttpEntity<>(goaltypes,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GoalTypes
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllGoalTypes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/goaltypes/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GoalTypes by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetGoalTypes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goaltypes/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GoalTypes
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateGoalTypes() throws URISyntaxException
	{
	    GoalTypesDTO goaltypes = generateRandomGoalTypes();
		final String updateUrl = "http://localhost:" + randomServerPort + "/goaltypes/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GoalTypesDTO> request = new HttpEntity<>(goaltypes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GoalTypes
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteGoalTypes() throws URISyntaxException
	{
		GoalTypesDTO goaltypes = generateRandomGoalTypes();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/goaltypes/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GoalTypesDTO> request = new HttpEntity<>(goaltypes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GoalTypesDTO generateRandomGoalTypes() {
		GoalTypesDTO record = new GoalTypesDTO();
		record.setGoalTypeCde(Randomizer.randomString(3));
		record.setGoalTypeDesc(Randomizer.randomString(20));
		return record;
	}
}