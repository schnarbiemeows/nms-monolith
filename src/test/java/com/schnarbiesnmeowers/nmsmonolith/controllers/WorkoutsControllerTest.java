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

import com.schnarbiesnmeowers.nmsmonolith.dtos.WorkoutsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.WorkoutsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the WorkoutsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WorkoutsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private WorkoutsService workoutsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Workouts
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateWorkouts() throws URISyntaxException
	{
	    WorkoutsDTO workouts = generateRandomWorkouts();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(workouts.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/workouts/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<WorkoutsDTO> request = new HttpEntity<>(workouts,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Workouts
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllWorkouts() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/workouts/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Workouts by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetWorkouts() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/workouts/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Workouts
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateWorkouts() throws URISyntaxException
	{
	    WorkoutsDTO workouts = generateRandomWorkouts();
		final String updateUrl = "http://localhost:" + randomServerPort + "/workouts/update";
		URI uri = new URI(updateUrl);
		HttpEntity<WorkoutsDTO> request = new HttpEntity<>(workouts);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Workouts
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteWorkouts() throws URISyntaxException
	{
		WorkoutsDTO workouts = generateRandomWorkouts();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/workouts/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<WorkoutsDTO> request = new HttpEntity<>(workouts);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Workouts by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetWorkoutsByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/workouts/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Workouts by foreign key exerciseTypeId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetWorkoutsByExerciseTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/workouts/findByExerciseTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Workouts by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetWorkoutsByUserIdAndExerciseTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/workouts/findByUserIdAndExerciseTypeId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static WorkoutsDTO generateRandomWorkouts() {
		WorkoutsDTO record = new WorkoutsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setExerciseTypeId(Randomizer.randomInt(1000));
		record.setDuration(Randomizer.randomInt(1000));
		record.setRating(Randomizer.randomBigDecimal("1000"));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}