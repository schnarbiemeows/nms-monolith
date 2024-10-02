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
import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PeriodTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PeriodTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PeriodTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private PeriodTypeService periodtypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new PeriodType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreatePeriodType() throws URISyntaxException
	{
	    PeriodTypeDTO periodtype = generateRandomPeriodType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(periodtype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/periodtype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PeriodTypeDTO> request = new HttpEntity<>(periodtype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all PeriodType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllPeriodType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/periodtype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single PeriodType by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetPeriodType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/periodtype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a PeriodType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdatePeriodType() throws URISyntaxException
	{
	    PeriodTypeDTO periodtype = generateRandomPeriodType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/periodtype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<PeriodTypeDTO> request = new HttpEntity<>(periodtype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a PeriodType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeletePeriodType() throws URISyntaxException
	{
		PeriodTypeDTO periodtype = generateRandomPeriodType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/periodtype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<PeriodTypeDTO> request = new HttpEntity<>(periodtype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static PeriodTypeDTO generateRandomPeriodType() {
		PeriodTypeDTO record = new PeriodTypeDTO();
		record.setPeriodTypeCde(Randomizer.randomString(1));
		record.setPeriodTypeDesc(Randomizer.randomString(20));
		return record;
	}
}