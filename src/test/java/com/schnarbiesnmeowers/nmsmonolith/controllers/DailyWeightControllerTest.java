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
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyWeightService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyWeightController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DailyWeightControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private DailyWeightService dailyweightBusiness;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new DailyWeight
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateDailyWeight() throws URISyntaxException
	{
	    DailyWeightDataPoint dailyweight = generateRandomDailyWeight();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(dailyweight.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/dailyweight/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DailyWeightDataPoint> request = new HttpEntity<>(dailyweight,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all DailyWeight
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllDailyWeight() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailyweight/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single DailyWeight by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetDailyWeight() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailyweight/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a DailyWeight
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateDailyWeight() throws URISyntaxException
	{
	    DailyWeightDataPoint dailyweight = generateRandomDailyWeight();
		final String updateUrl = "http://localhost:" + randomServerPort + "/dailyweight/update";
		URI uri = new URI(updateUrl);
		HttpEntity<DailyWeightDataPoint> request = new HttpEntity<>(dailyweight);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a DailyWeight
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteDailyWeight() throws URISyntaxException
	{
		DailyWeightDataPoint dailyweight = generateRandomDailyWeight();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/dailyweight/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<DailyWeightDataPoint> request = new HttpEntity<>(dailyweight);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyWeight by foreign key userId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetDailyWeightByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailyweight/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static DailyWeightDataPoint generateRandomDailyWeight() {
		DailyWeightDataPoint record = new DailyWeightDataPoint();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomLocalDate());
		record.setWeight(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}