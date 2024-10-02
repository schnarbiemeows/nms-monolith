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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeStepsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeStepsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipeStepsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RecipeStepsService recipestepsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RecipeSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRecipeSteps() throws URISyntaxException
	{
	    RecipeStepsDTO recipesteps = generateRandomRecipeSteps();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(recipesteps.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/recipesteps/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RecipeStepsDTO> request = new HttpEntity<>(recipesteps,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RecipeSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRecipeSteps() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipesteps/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RecipeSteps by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRecipeSteps() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipesteps/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RecipeSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRecipeSteps() throws URISyntaxException
	{
	    RecipeStepsDTO recipesteps = generateRandomRecipeSteps();
		final String updateUrl = "http://localhost:" + randomServerPort + "/recipesteps/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RecipeStepsDTO> request = new HttpEntity<>(recipesteps);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RecipeSteps
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRecipeSteps() throws URISyntaxException
	{
		RecipeStepsDTO recipesteps = generateRandomRecipeSteps();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/recipesteps/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RecipeStepsDTO> request = new HttpEntity<>(recipesteps);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeSteps by foreign key recipeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeStepsByRecipeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipesteps/findByRecipeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeSteps by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeStepsByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipesteps/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeSteps by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeStepsByRecipeIdAndImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipesteps/findByRecipeIdAndImageLoc/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RecipeStepsDTO generateRandomRecipeSteps() {
		RecipeStepsDTO record = new RecipeStepsDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setStepNum(Randomizer.randomInt(1000));
		record.setStepDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		return record;
	}
}