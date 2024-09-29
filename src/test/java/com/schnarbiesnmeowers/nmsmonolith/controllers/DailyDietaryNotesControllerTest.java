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

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietaryNotesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietaryNotesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DailyDietaryNotesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private DailyDietaryNotesService dailydietarynotesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new DailyDietaryNotes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateDailyDietaryNotes() throws URISyntaxException
	{
	    DailyDietaryNotesDTO dailydietarynotes = generateRandomDailyDietaryNotes();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(dailydietarynotes.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/dailydietarynotes/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DailyDietaryNotesDTO> request = new HttpEntity<>(dailydietarynotes,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all DailyDietaryNotes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllDailyDietaryNotes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydietarynotes/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single DailyDietaryNotes by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetDailyDietaryNotes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydietarynotes/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a DailyDietaryNotes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateDailyDietaryNotes() throws URISyntaxException
	{
	    DailyDietaryNotesDTO dailydietarynotes = generateRandomDailyDietaryNotes();
		final String updateUrl = "http://localhost:" + randomServerPort + "/dailydietarynotes/update";
		URI uri = new URI(updateUrl);
		HttpEntity<DailyDietaryNotesDTO> request = new HttpEntity<>(dailydietarynotes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a DailyDietaryNotes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteDailyDietaryNotes() throws URISyntaxException
	{
		DailyDietaryNotesDTO dailydietarynotes = generateRandomDailyDietaryNotes();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/dailydietarynotes/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<DailyDietaryNotesDTO> request = new HttpEntity<>(dailydietarynotes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDietaryNotes by foreign key userId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetDailyDietaryNotesByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydietarynotes/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static DailyDietaryNotesDTO generateRandomDailyDietaryNotes() {
		DailyDietaryNotesDTO record = new DailyDietaryNotesDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setDailyNotes(Randomizer.randomString(20));
		return record;
	}
}