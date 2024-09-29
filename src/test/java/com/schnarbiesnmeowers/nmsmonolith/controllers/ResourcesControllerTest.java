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

import com.schnarbiesnmeowers.nmsmonolith.dtos.ResourcesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ResourcesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ResourcesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ResourcesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private ResourcesService resourcesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Resources
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateResources() throws URISyntaxException
	{
	    ResourcesDTO resources = generateRandomResources();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(resources.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/resources/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ResourcesDTO> request = new HttpEntity<>(resources,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Resources
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllResources() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/resources/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Resources by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetResources() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/resources/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Resources
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateResources() throws URISyntaxException
	{
	    ResourcesDTO resources = generateRandomResources();
		final String updateUrl = "http://localhost:" + randomServerPort + "/resources/update";
		URI uri = new URI(updateUrl);
		HttpEntity<ResourcesDTO> request = new HttpEntity<>(resources);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Resources
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteResources() throws URISyntaxException
	{
		ResourcesDTO resources = generateRandomResources();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/resources/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<ResourcesDTO> request = new HttpEntity<>(resources);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Resources by foreign key rsrcTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetResourcesByRsrcTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/resources/findByRsrcTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static ResourcesDTO generateRandomResources() {
		ResourcesDTO record = new ResourcesDTO();
		record.setRsrcTypeId(Randomizer.randomInt(1000));
		record.setRsrcDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}