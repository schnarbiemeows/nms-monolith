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

import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UsersHistBusiness;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UsersHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsersHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private UsersHistBusiness usershistBusiness;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new UsersHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateUsersHist() throws URISyntaxException
	{
	    UsersHistDTO usershist = generateRandomUsersHist();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(usershist.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/usershist/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UsersHistDTO> request = new HttpEntity<>(usershist,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all UsersHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllUsersHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/usershist/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single UsersHist by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetUsersHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usershist/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a UsersHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateUsersHist() throws URISyntaxException
	{
	    UsersHistDTO usershist = generateRandomUsersHist();
		final String updateUrl = "http://localhost:" + randomServerPort + "/usershist/update";
		URI uri = new URI(updateUrl);
		HttpEntity<UsersHistDTO> request = new HttpEntity<>(usershist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a UsersHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteUsersHist() throws URISyntaxException
	{
		UsersHistDTO usershist = generateRandomUsersHist();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/usershist/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<UsersHistDTO> request = new HttpEntity<>(usershist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UsersHist by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetUsersHistByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usershist/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UsersHist by foreign key actionTypeId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetUsersHistByActionTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usershist/findByActionTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UsersHist by foreign key evntOperId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetUsersHistByEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usershist/findByEvntOperId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UsersHist by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetUsersHistByUserIdAndActionTypeIdAndEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usershist/findByUserIdAndActionTypeIdAndEvntOperId/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static UsersHistDTO generateRandomUsersHist() {
		UsersHistDTO record = new UsersHistDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}