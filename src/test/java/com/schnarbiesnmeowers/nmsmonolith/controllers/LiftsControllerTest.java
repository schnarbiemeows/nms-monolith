package com.schnarbiesnmeowers.nmsmonolith.controllers;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.LiftsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * this class tests the LiftsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
//@ExtendWith(MockitoExtension.class)
////@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LiftsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private LiftsService liftsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Lifts
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateLifts() throws URISyntaxException
	{
	    LiftsDTO lifts = generateRandomLifts();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(lifts.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/lifts/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LiftsDTO> request = new HttpEntity<>(lifts,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Lifts
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllLifts() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/lifts/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Lifts by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetLifts() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/lifts/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Lifts
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateLifts() throws URISyntaxException
	{
	    LiftsDTO lifts = generateRandomLifts();
		final String updateUrl = "http://localhost:" + randomServerPort + "/lifts/update";
		URI uri = new URI(updateUrl);
		HttpEntity<LiftsDTO> request = new HttpEntity<>(lifts);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Lifts
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteLifts() throws URISyntaxException
	{
		LiftsDTO lifts = generateRandomLifts();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/lifts/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<LiftsDTO> request = new HttpEntity<>(lifts);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Lifts by foreign key muscleId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftsByMuscleId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/lifts/findByMuscleId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Lifts by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftsByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/lifts/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Lifts by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetLiftsByMuscleIdAndImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/lifts/findByMuscleIdAndImageLoc/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static LiftsDTO generateRandomLifts() {
		LiftsDTO record = new LiftsDTO();
		record.setLiftDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}