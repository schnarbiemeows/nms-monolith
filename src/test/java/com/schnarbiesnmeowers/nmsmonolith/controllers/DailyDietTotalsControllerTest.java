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

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietTotalsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietTotalsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietTotalsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DailyDietTotalsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private DailyDietTotalsService dailydiettotalsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new DailyDietTotals
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateDailyDietTotals() throws URISyntaxException
	{
	    DailyDietTotalsDTO dailydiettotals = generateRandomDailyDietTotals();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(dailydiettotals.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DailyDietTotalsDTO> request = new HttpEntity<>(dailydiettotals,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all DailyDietTotals
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllDailyDietTotals() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single DailyDietTotals by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetDailyDietTotals() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a DailyDietTotals
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateDailyDietTotals() throws URISyntaxException
	{
	    DailyDietTotalsDTO dailydiettotals = generateRandomDailyDietTotals();
		final String updateUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/update";
		URI uri = new URI(updateUrl);
		HttpEntity<DailyDietTotalsDTO> request = new HttpEntity<>(dailydiettotals);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a DailyDietTotals
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteDailyDietTotals() throws URISyntaxException
	{
		DailyDietTotalsDTO dailydiettotals = generateRandomDailyDietTotals();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<DailyDietTotalsDTO> request = new HttpEntity<>(dailydiettotals);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDietTotals by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetDailyDietTotalsByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDietTotals by foreign key bldstId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetDailyDietTotalsByBldstId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/findByBldstId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDietTotals by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetDailyDietTotalsByUserIdAndBldstId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiettotals/findByUserIdAndBldstId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static DailyDietTotalsDTO generateRandomDailyDietTotals() {
		DailyDietTotalsDTO record = new DailyDietTotalsDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}