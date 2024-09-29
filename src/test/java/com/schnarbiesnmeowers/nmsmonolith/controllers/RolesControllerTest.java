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

import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RolesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RolesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RolesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RolesService rolesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Roles
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRoles() throws URISyntaxException
	{
	    RolesDTO roles = generateRandomRoles();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(roles.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/roles/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RolesDTO> request = new HttpEntity<>(roles,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Roles
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRoles() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/roles/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Roles by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRoles() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roles/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Roles
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRoles() throws URISyntaxException
	{
	    RolesDTO roles = generateRandomRoles();
		final String updateUrl = "http://localhost:" + randomServerPort + "/roles/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RolesDTO> request = new HttpEntity<>(roles);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Roles
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRoles() throws URISyntaxException
	{
		RolesDTO roles = generateRandomRoles();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/roles/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RolesDTO> request = new HttpEntity<>(roles);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Roles by foreign key grpId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesByGrpId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roles/findByGrpId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Roles by foreign key rsrcId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesByRsrcId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roles/findByRsrcId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Roles by foreign key actionTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesByActionTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roles/findByActionTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Roles by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesByGrpIdAndRsrcIdAndActionTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roles/findByGrpIdAndRsrcIdAndActionTypeId/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RolesDTO generateRandomRoles() {
		RolesDTO record = new RolesDTO();
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		return record;
	}
}