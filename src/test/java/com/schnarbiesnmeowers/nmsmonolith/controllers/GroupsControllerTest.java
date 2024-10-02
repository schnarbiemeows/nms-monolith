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
import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.GroupsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the GroupsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GroupsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private GroupsService groupsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Groups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateGroups() throws URISyntaxException
	{
	    GroupsDTO groups = generateRandomGroups();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(groups.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/groups/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GroupsDTO> request = new HttpEntity<>(groups,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Groups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllGroups() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/groups/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Groups by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetGroups() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/groups/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Groups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateGroups() throws URISyntaxException
	{
	    GroupsDTO groups = generateRandomGroups();
		final String updateUrl = "http://localhost:" + randomServerPort + "/groups/update";
		URI uri = new URI(updateUrl);
		HttpEntity<GroupsDTO> request = new HttpEntity<>(groups);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Groups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteGroups() throws URISyntaxException
	{
		GroupsDTO groups = generateRandomGroups();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/groups/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<GroupsDTO> request = new HttpEntity<>(groups);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static GroupsDTO generateRandomGroups() {
		GroupsDTO record = new GroupsDTO();
		record.setGrpName(Randomizer.randomString(20));
		record.setGrpDesc(Randomizer.randomString(20));
		return record;
	}
}