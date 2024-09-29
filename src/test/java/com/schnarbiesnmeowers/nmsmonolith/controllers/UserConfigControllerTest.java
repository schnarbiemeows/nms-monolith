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

import com.schnarbiesnmeowers.nmsmonolith.dtos.UserConfigDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UserConfigService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UserConfigController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserConfigControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private UserConfigService userconfigService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new UserConfig
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateUserConfig() throws URISyntaxException
	{
	    UserConfigDTO userconfig = generateRandomUserConfig();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(userconfig.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/userconfig/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserConfigDTO> request = new HttpEntity<>(userconfig,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all UserConfig
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllUserConfig() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/userconfig/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single UserConfig by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetUserConfig() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/userconfig/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a UserConfig
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateUserConfig() throws URISyntaxException
	{
	    UserConfigDTO userconfig = generateRandomUserConfig();
		final String updateUrl = "http://localhost:" + randomServerPort + "/userconfig/update";
		URI uri = new URI(updateUrl);
		HttpEntity<UserConfigDTO> request = new HttpEntity<>(userconfig);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a UserConfig
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteUserConfig() throws URISyntaxException
	{
		UserConfigDTO userconfig = generateRandomUserConfig();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/userconfig/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<UserConfigDTO> request = new HttpEntity<>(userconfig);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UserConfig by foreign key userId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetUserConfigByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/userconfig/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static UserConfigDTO generateRandomUserConfig() {
		UserConfigDTO record = new UserConfigDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setPropertyKey(Randomizer.randomString(20));
		record.setPropertyValue(Randomizer.randomString(20));
		return record;
	}
}