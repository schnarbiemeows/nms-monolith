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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GrpUserService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GrpUserController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GrpUserControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GrpUserService grpuserService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GrpUser
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateGrpUser() throws URISyntaxException
	{
	    GrpUserDTO grpuser = generateRandomGrpUser();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(grpuser.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/grpuser/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GrpUserDTO> request = new HttpEntity<>(grpuser,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GrpUser
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllGrpUser() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuser/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GrpUser by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetGrpUser() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuser/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GrpUser
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateGrpUser() throws URISyntaxException
	{
	    GrpUserDTO grpuser = generateRandomGrpUser();
		final String updateUrl = "http://localhost:" + randomServerPort + "/grpuser/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GrpUserDTO> request = new HttpEntity<>(grpuser);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GrpUser
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteGrpUser() throws URISyntaxException
	{
		GrpUserDTO grpuser = generateRandomGrpUser();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/grpuser/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GrpUserDTO> request = new HttpEntity<>(grpuser);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUser by foreign key grpId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserByGrpId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuser/findByGrpId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUser by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuser/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUser by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserByGrpIdAndUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuser/findByGrpIdAndUserId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GrpUserDTO generateRandomGrpUser() {
		GrpUserDTO record = new GrpUserDTO();
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		return record;
	}
}