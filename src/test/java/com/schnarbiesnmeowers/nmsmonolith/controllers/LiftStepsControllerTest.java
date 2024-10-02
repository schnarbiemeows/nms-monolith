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
import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftStepsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the LiftStepsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LiftStepsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private LiftStepsService liftstepsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new LiftSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateLiftSteps() throws URISyntaxException
	{
	    LiftStepsDTO liftsteps = generateRandomLiftSteps();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(liftsteps.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/liftsteps/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LiftStepsDTO> request = new HttpEntity<>(liftsteps,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all LiftSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllLiftSteps() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftsteps/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single LiftSteps by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetLiftSteps() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftsteps/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a LiftSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateLiftSteps() throws URISyntaxException
	{
	    LiftStepsDTO liftsteps = generateRandomLiftSteps();
		final String updateUrl = "http://localhost:" + randomServerPort + "/liftsteps/update";
		URI uri = new URI(updateUrl);
		HttpEntity<LiftStepsDTO> request = new HttpEntity<>(liftsteps);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a LiftSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteLiftSteps() throws URISyntaxException
	{
		LiftStepsDTO liftsteps = generateRandomLiftSteps();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/liftsteps/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<LiftStepsDTO> request = new HttpEntity<>(liftsteps);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftSteps by foreign key liftId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftStepsByLiftId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftsteps/findByLiftId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftSteps by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftStepsByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftsteps/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all LiftSteps by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftStepsByLiftIdAndImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/liftsteps/findByLiftIdAndImageLoc/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static LiftStepsDTO generateRandomLiftSteps() {
		LiftStepsDTO record = new LiftStepsDTO();
		record.setLiftId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
}