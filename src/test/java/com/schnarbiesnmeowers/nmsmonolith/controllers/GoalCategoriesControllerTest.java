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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalCategoriesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GoalCategoriesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GoalCategoriesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GoalCategoriesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GoalCategoriesService goalcategoriesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GoalCategories
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateGoalCategories() throws URISyntaxException
	{
	    GoalCategoriesDTO goalcategories = generateRandomGoalCategories();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(goalcategories.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/goalcategories/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GoalCategoriesDTO> request = new HttpEntity<>(goalcategories,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GoalCategories
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllGoalCategories() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalcategories/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GoalCategories by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetGoalCategories() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalcategories/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GoalCategories
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateGoalCategories() throws URISyntaxException
	{
	    GoalCategoriesDTO goalcategories = generateRandomGoalCategories();
		final String updateUrl = "http://localhost:" + randomServerPort + "/goalcategories/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GoalCategoriesDTO> request = new HttpEntity<>(goalcategories);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GoalCategories
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteGoalCategories() throws URISyntaxException
	{
		GoalCategoriesDTO goalcategories = generateRandomGoalCategories();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/goalcategories/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GoalCategoriesDTO> request = new HttpEntity<>(goalcategories);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GoalCategories by foreign key goalTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetGoalCategoriesByGoalTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/goalcategories/findByGoalTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GoalCategoriesDTO generateRandomGoalCategories() {
		GoalCategoriesDTO record = new GoalCategoriesDTO();
		record.setGoalTypeId(Randomizer.randomInt(1000));
		record.setGcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}