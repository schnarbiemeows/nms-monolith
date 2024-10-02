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
import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ServingTypeRatiosService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ServingTypeRatiosController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServingTypeRatiosControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private ServingTypeRatiosService servingtyperatiosService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new ServingTypeRatios
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateServingTypeRatios() throws URISyntaxException
	{
	    ServingTypeRatiosDTO servingtyperatios = generateRandomServingTypeRatios();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(servingtyperatios.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ServingTypeRatiosDTO> request = new HttpEntity<>(servingtyperatios,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all ServingTypeRatios
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllServingTypeRatios() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single ServingTypeRatios by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetServingTypeRatios() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a ServingTypeRatios
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateServingTypeRatios() throws URISyntaxException
	{
	    ServingTypeRatiosDTO servingtyperatios = generateRandomServingTypeRatios();
		final String updateUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/update";
		URI uri = new URI(updateUrl);
		HttpEntity<ServingTypeRatiosDTO> request = new HttpEntity<>(servingtyperatios);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a ServingTypeRatios
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteServingTypeRatios() throws URISyntaxException
	{
		ServingTypeRatiosDTO servingtyperatios = generateRandomServingTypeRatios();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<ServingTypeRatiosDTO> request = new HttpEntity<>(servingtyperatios);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all ServingTypeRatios by foreign key servTypeId1
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetServingTypeRatiosByServTypeId1() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/findByServTypeId1/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all ServingTypeRatios by foreign key servTypeId2
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetServingTypeRatiosByServTypeId2() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/findByServTypeId2/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all ServingTypeRatios by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetServingTypeRatiosByServTypeId1AndServTypeId2() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/servingtyperatios/findByServTypeId1AndServTypeId2/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static ServingTypeRatiosDTO generateRandomServingTypeRatios() {
		ServingTypeRatiosDTO record = new ServingTypeRatiosDTO();
		record.setServTypeId1(Randomizer.randomInt(1000));
		record.setServTypeId2(Randomizer.randomInt(1000));
		record.setRatio(Randomizer.randomBigDecimal("1000"));
		return record;
	}
}