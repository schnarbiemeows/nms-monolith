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

import com.schnarbiesnmeowers.nmsmonolith.dtos.RsrcTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RsrcTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RsrcTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RsrcTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RsrcTypeService rsrctypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RsrcType
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateRsrcType() throws URISyntaxException
	{
	    RsrcTypeDTO rsrctype = generateRandomRsrcType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(rsrctype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/rsrctype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RsrcTypeDTO> request = new HttpEntity<>(rsrctype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RsrcType
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllRsrcType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/rsrctype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RsrcType by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetRsrcType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/rsrctype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RsrcType
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateRsrcType() throws URISyntaxException
	{
	    RsrcTypeDTO rsrctype = generateRandomRsrcType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/rsrctype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RsrcTypeDTO> request = new HttpEntity<>(rsrctype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RsrcType
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteRsrcType() throws URISyntaxException
	{
		RsrcTypeDTO rsrctype = generateRandomRsrcType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/rsrctype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RsrcTypeDTO> request = new HttpEntity<>(rsrctype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RsrcTypeDTO generateRandomRsrcType() {
		RsrcTypeDTO record = new RsrcTypeDTO();
		record.setRsrcType(Randomizer.randomString(20));
		record.setRsrcTypeDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}