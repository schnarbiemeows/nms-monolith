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
import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.DailyDietService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the DailyDietController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DailyDietControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private DailyDietService dailydietService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new DailyDiet
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateDailyDiet() throws URISyntaxException
	{
	    DailyDietDTO dailydiet = generateRandomDailyDiet();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(dailydiet.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/dailydiet/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<DailyDietDTO> request = new HttpEntity<>(dailydiet,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all DailyDiet
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllDailyDiet() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiet/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single DailyDiet by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetDailyDiet() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiet/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a DailyDiet
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateDailyDiet() throws URISyntaxException
	{
	    DailyDietDTO dailydiet = generateRandomDailyDiet();
		final String updateUrl = "http://localhost:" + randomServerPort + "/dailydiet/update";
		URI uri = new URI(updateUrl);
		HttpEntity<DailyDietDTO> request = new HttpEntity<>(dailydiet);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a DailyDiet
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteDailyDiet() throws URISyntaxException
	{
		DailyDietDTO dailydiet = generateRandomDailyDiet();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/dailydiet/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<DailyDietDTO> request = new HttpEntity<>(dailydiet);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDiet by foreign key userId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetDailyDietByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiet/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDiet by foreign key ingrId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetDailyDietByIngrId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiet/findByIngrId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDiet by foreign key bldstId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetDailyDietByBldstId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiet/findByBldstId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all DailyDiet by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetDailyDietByUserIdAndIngrIdAndBldstId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/dailydiet/findByUserIdAndIngrIdAndBldstId/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static DailyDietDTO generateRandomDailyDiet() {
		DailyDietDTO record = new DailyDietDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setIngrId(Randomizer.randomInt(1000));
		record.setIsRecipe(Randomizer.randomBoolean());
		record.setBldstId(Randomizer.randomInt(1000));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setTimeEaten("1000");
		return record;
	}
}