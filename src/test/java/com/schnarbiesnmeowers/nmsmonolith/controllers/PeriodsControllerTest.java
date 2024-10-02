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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PeriodsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PeriodsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PeriodsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private PeriodsService periodsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Periods
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreatePeriods() throws URISyntaxException
	{
	    PeriodsDTO periods = generateRandomPeriods();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(periods.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/periods/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PeriodsDTO> request = new HttpEntity<>(periods,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Periods
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllPeriods() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/periods/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Periods by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetPeriods() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/periods/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Periods
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdatePeriods() throws URISyntaxException
	{
	    PeriodsDTO periods = generateRandomPeriods();
		final String updateUrl = "http://localhost:" + randomServerPort + "/periods/update";
		URI uri = new URI(updateUrl);
		HttpEntity<PeriodsDTO> request = new HttpEntity<>(periods);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Periods
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeletePeriods() throws URISyntaxException
	{
		PeriodsDTO periods = generateRandomPeriods();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/periods/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<PeriodsDTO> request = new HttpEntity<>(periods);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Periods by foreign key periodTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetPeriodsByPeriodTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/periods/findByPeriodTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static PeriodsDTO generateRandomPeriods() {
		PeriodsDTO record = new PeriodsDTO();
		record.setPeriodTypeId(Randomizer.randomInt(1000));
		record.setOneTimeDate(Randomizer.randomDate());
		record.setDayOfWeek(Randomizer.randomString(2));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}