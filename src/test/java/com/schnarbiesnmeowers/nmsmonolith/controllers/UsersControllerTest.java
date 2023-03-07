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

import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UsersService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UsersController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsersControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private UsersService usersService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Users
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateUsers() throws URISyntaxException
	{
	    UsersDTO users = generateRandomUsers();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(users.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/users/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UsersDTO> request = new HttpEntity<>(users,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Users
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllUsers() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/users/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Users by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetUsers() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/users/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Users
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateUsers() throws URISyntaxException
	{
	    UsersDTO users = generateRandomUsers();
		final String updateUrl = "http://localhost:" + randomServerPort + "/users/update";
		URI uri = new URI(updateUrl);
		HttpEntity<UsersDTO> request = new HttpEntity<>(users);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Users
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteUsers() throws URISyntaxException
	{
		UsersDTO users = generateRandomUsers();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/users/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<UsersDTO> request = new HttpEntity<>(users);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static UsersDTO generateRandomUsers() {
		UsersDTO record = new UsersDTO();
		record.setUsername(Randomizer.randomString(20));
		record.setEmail(Randomizer.randomString(20));
		record.setPhone(Randomizer.randomString(10));
		record.setPassword(Randomizer.randomString(20));
		record.setAge(Randomizer.randomInt(1000));
		record.setLstLogdIn(Randomizer.randomDate());
		return record;
	}
}