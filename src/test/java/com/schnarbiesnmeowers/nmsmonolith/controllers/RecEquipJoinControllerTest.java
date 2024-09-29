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

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEquipJoinDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecEquipJoinService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecEquipJoinController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecEquipJoinControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RecEquipJoinService recequipjoinService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RecEquipJoin
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRecEquipJoin() throws URISyntaxException
	{
	    RecEquipJoinDTO recequipjoin = generateRandomRecEquipJoin();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(recequipjoin.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/recequipjoin/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RecEquipJoinDTO> request = new HttpEntity<>(recequipjoin,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RecEquipJoin
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRecEquipJoin() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/recequipjoin/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RecEquipJoin by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRecEquipJoin() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recequipjoin/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RecEquipJoin
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRecEquipJoin() throws URISyntaxException
	{
	    RecEquipJoinDTO recequipjoin = generateRandomRecEquipJoin();
		final String updateUrl = "http://localhost:" + randomServerPort + "/recequipjoin/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RecEquipJoinDTO> request = new HttpEntity<>(recequipjoin);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RecEquipJoin
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRecEquipJoin() throws URISyntaxException
	{
		RecEquipJoinDTO recequipjoin = generateRandomRecEquipJoin();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/recequipjoin/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RecEquipJoinDTO> request = new HttpEntity<>(recequipjoin);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecEquipJoin by foreign key recipeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecEquipJoinByRecipeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recequipjoin/findByRecipeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecEquipJoin by foreign key recipeEquipId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecEquipJoinByRecipeEquipId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recequipjoin/findByRecipeEquipId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecEquipJoin by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecEquipJoinByRecipeIdAndRecipeEquipId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recequipjoin/findByRecipeIdAndRecipeEquipId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RecEquipJoinDTO generateRandomRecEquipJoin() {
		RecEquipJoinDTO record = new RecEquipJoinDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecipeEquipId(Randomizer.randomInt(1000));
		return record;
	}
}