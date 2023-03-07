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

import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GroupsHistService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GroupsHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GroupsHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GroupsHistService groupshistService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new GroupsHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateGroupsHist() throws URISyntaxException
	{
	    GroupsHistDTO groupshist = generateRandomGroupsHist();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(groupshist.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/groupshist/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GroupsHistDTO> request = new HttpEntity<>(groupshist,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all GroupsHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllGroupsHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/groupshist/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single GroupsHist by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetGroupsHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/groupshist/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a GroupsHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateGroupsHist() throws URISyntaxException
	{
	    GroupsHistDTO groupshist = generateRandomGroupsHist();
		final String updateUrl = "http://localhost:" + randomServerPort + "/groupshist/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GroupsHistDTO> request = new HttpEntity<>(groupshist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a GroupsHist
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteGroupsHist() throws URISyntaxException
	{
		GroupsHistDTO groupshist = generateRandomGroupsHist();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/groupshist/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GroupsHistDTO> request = new HttpEntity<>(groupshist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GroupsHist by foreign key grpId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGroupsHistByGrpId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/groupshist/findByGrpId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GroupsHist by foreign key actionTypeId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGroupsHistByActionTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/groupshist/findByActionTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GroupsHist by foreign key evntOperId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGroupsHistByEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/groupshist/findByEvntOperId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all GroupsHist by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetGroupsHistByGrpIdAndActionTypeIdAndEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/groupshist/findByGrpIdAndActionTypeIdAndEvntOperId/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GroupsHistDTO generateRandomGroupsHist() {
		GroupsHistDTO record = new GroupsHistDTO();
		record.setGrpId(Randomizer.randomInt(1000));
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}