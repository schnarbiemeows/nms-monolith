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

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEqTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecEqTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecEqTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecEqTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RecEqTypeService receqtypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RecEqType
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateRecEqType() throws URISyntaxException
	{
	    RecEqTypeDTO receqtype = generateRandomRecEqType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(receqtype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/receqtype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RecEqTypeDTO> request = new HttpEntity<>(receqtype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RecEqType
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllRecEqType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/receqtype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RecEqType by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetRecEqType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/receqtype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RecEqType
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateRecEqType() throws URISyntaxException
	{
	    RecEqTypeDTO receqtype = generateRandomRecEqType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/receqtype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RecEqTypeDTO> request = new HttpEntity<>(receqtype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RecEqType
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteRecEqType() throws URISyntaxException
	{
		RecEqTypeDTO receqtype = generateRandomRecEqType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/receqtype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RecEqTypeDTO> request = new HttpEntity<>(receqtype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RecEqTypeDTO generateRandomRecEqType() {
		RecEqTypeDTO record = new RecEqTypeDTO();
		record.setRecEqCde(Randomizer.randomString(5));
		record.setRecEqDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}