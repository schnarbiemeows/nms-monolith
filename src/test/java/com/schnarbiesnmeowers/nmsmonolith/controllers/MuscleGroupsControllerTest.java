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
import com.schnarbiesnmeowers.nmsmonolith.dtos.MuscleGroupsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.MuscleGroupsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the MuscleGroupsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MuscleGroupsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private MuscleGroupsService musclegroupsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new MuscleGroups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateMuscleGroups() throws URISyntaxException
	{
	    MuscleGroupsDTO musclegroups = generateRandomMuscleGroups();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(musclegroups.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/musclegroups/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MuscleGroupsDTO> request = new HttpEntity<>(musclegroups,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all MuscleGroups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllMuscleGroups() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/musclegroups/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single MuscleGroups by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetMuscleGroups() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/musclegroups/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a MuscleGroups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateMuscleGroups() throws URISyntaxException
	{
	    MuscleGroupsDTO musclegroups = generateRandomMuscleGroups();
		final String updateUrl = "http://localhost:" + randomServerPort + "/musclegroups/update";
		URI uri = new URI(updateUrl);
		HttpEntity<MuscleGroupsDTO> request = new HttpEntity<>(musclegroups);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a MuscleGroups
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteMuscleGroups() throws URISyntaxException
	{
		MuscleGroupsDTO musclegroups = generateRandomMuscleGroups();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/musclegroups/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<MuscleGroupsDTO> request = new HttpEntity<>(musclegroups);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static MuscleGroupsDTO generateRandomMuscleGroups() {
		MuscleGroupsDTO record = new MuscleGroupsDTO();
		record.setMuscleGrpName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}