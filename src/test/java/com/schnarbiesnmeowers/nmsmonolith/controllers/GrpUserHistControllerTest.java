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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GrpUserHistService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GrpUserHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GrpUserHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GrpUserHistService grpuserhistService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GrpUserHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateGrpUserHist() throws URISyntaxException
	{
	    GrpUserHistDTO grpuserhist = generateRandomGrpUserHist();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(grpuserhist.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/grpuserhist/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GrpUserHistDTO> request = new HttpEntity<>(grpuserhist,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GrpUserHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllGrpUserHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GrpUserHist by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetGrpUserHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GrpUserHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateGrpUserHist() throws URISyntaxException
	{
	    GrpUserHistDTO grpuserhist = generateRandomGrpUserHist();
		final String updateUrl = "http://localhost:" + randomServerPort + "/grpuserhist/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GrpUserHistDTO> request = new HttpEntity<>(grpuserhist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GrpUserHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteGrpUserHist() throws URISyntaxException
	{
		GrpUserHistDTO grpuserhist = generateRandomGrpUserHist();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/grpuserhist/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GrpUserHistDTO> request = new HttpEntity<>(grpuserhist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUserHist by foreign key grpUserId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserHistByGrpUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findByGrpUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUserHist by foreign key grpId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserHistByGrpId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findByGrpId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUserHist by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserHistByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUserHist by foreign key actionTypeId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserHistByActionTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findByActionTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUserHist by foreign key evntOperId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserHistByEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findByEvntOperId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GrpUserHist by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGrpUserHistByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/grpuserhist/findByGrpUserIdAndGrpIdAndUserIdAndActionTypeIdAndEvntOperId/1/1/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GrpUserHistDTO generateRandomGrpUserHist() {
		GrpUserHistDTO record = new GrpUserHistDTO();
		record.setGrpUserId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setUserId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}