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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalGroupsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalGroupsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GoalGroupsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GoalGroupsService goalgroupsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GoalGroups
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateGoalGroups() throws URISyntaxException
	{
	    GoalGroupsDTO goalgroups = generateRandomGoalGroups();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(goalgroups.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/goalgroups/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GoalGroupsDTO> request = new HttpEntity<>(goalgroups,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GoalGroups
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllGoalGroups() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalgroups/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GoalGroups by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetGoalGroups() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalgroups/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GoalGroups
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateGoalGroups() throws URISyntaxException
	{
	    GoalGroupsDTO goalgroups = generateRandomGoalGroups();
		final String updateUrl = "http://localhost:" + randomServerPort + "/goalgroups/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GoalGroupsDTO> request = new HttpEntity<>(goalgroups);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GoalGroups
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteGoalGroups() throws URISyntaxException
	{
		GoalGroupsDTO goalgroups = generateRandomGoalGroups();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/goalgroups/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GoalGroupsDTO> request = new HttpEntity<>(goalgroups);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalGroups by foreign key goalId1
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalGroupsByGoalId1() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalgroups/findByGoalId1/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalGroups by foreign key goalId2
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalGroupsByGoalId2() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalgroups/findByGoalId2/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalGroups by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGoalGroupsByGoalId1AndGoalId2() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalgroups/findByGoalId1AndGoalId2/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GoalGroupsDTO generateRandomGoalGroups() {
		GoalGroupsDTO record = new GoalGroupsDTO();
		record.setGoalId1(Randomizer.randomInt(1000));
		record.setGoalId2(Randomizer.randomInt(1000));
		record.setRelation(Randomizer.randomString(3));
		return record;
	}
}