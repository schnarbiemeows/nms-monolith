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

import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodExtDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PeriodExtService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PeriodExtController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PeriodExtControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private PeriodExtService periodextService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new PeriodExt
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreatePeriodExt() throws URISyntaxException
	{
	    PeriodExtDTO periodext = generateRandomPeriodExt();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(periodext.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/periodext/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PeriodExtDTO> request = new HttpEntity<>(periodext,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all PeriodExt
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllPeriodExt() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/periodext/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single PeriodExt by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetPeriodExt() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/periodext/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a PeriodExt
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdatePeriodExt() throws URISyntaxException
	{
	    PeriodExtDTO periodext = generateRandomPeriodExt();
		final String updateUrl = "http://localhost:" + randomServerPort + "/periodext/update";
		URI uri = new URI(updateUrl);
		HttpEntity<PeriodExtDTO> request = new HttpEntity<>(periodext);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a PeriodExt
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeletePeriodExt() throws URISyntaxException
	{
		PeriodExtDTO periodext = generateRandomPeriodExt();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/periodext/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<PeriodExtDTO> request = new HttpEntity<>(periodext);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all PeriodExt by foreign key periodId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetPeriodExtByPeriodId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/periodext/findByPeriodId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static PeriodExtDTO generateRandomPeriodExt() {
		PeriodExtDTO record = new PeriodExtDTO();
		record.setPeriodId(Randomizer.randomInt(1000));
		record.setSpecificDate(Randomizer.randomDate());
		record.setSpecificTime(Randomizer.randomTime(1000));
		return record;
	}
}