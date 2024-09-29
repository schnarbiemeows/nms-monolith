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

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeIngredientsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeIngredientsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipeIngredientsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RecipeIngredientsService recipeingredientsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RecipeIngredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRecipeIngredients() throws URISyntaxException
	{
	    RecipeIngredientsDTO recipeingredients = generateRandomRecipeIngredients();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(recipeingredients.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/recipeingredients/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RecipeIngredientsDTO> request = new HttpEntity<>(recipeingredients,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RecipeIngredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRecipeIngredients() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeingredients/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RecipeIngredients by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRecipeIngredients() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeingredients/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RecipeIngredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRecipeIngredients() throws URISyntaxException
	{
	    RecipeIngredientsDTO recipeingredients = generateRandomRecipeIngredients();
		final String updateUrl = "http://localhost:" + randomServerPort + "/recipeingredients/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RecipeIngredientsDTO> request = new HttpEntity<>(recipeingredients);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RecipeIngredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRecipeIngredients() throws URISyntaxException
	{
		RecipeIngredientsDTO recipeingredients = generateRandomRecipeIngredients();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/recipeingredients/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RecipeIngredientsDTO> request = new HttpEntity<>(recipeingredients);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeIngredients by foreign key recipeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeIngredientsByRecipeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeingredients/findByRecipeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RecipeIngredientsDTO generateRandomRecipeIngredients() {
		RecipeIngredientsDTO record = new RecipeIngredientsDTO();
		record.setRecipeId(Randomizer.randomInt(1000));
		record.setRecOrIngrId(Randomizer.randomInt(1000));
		record.setRecipeFlg(Randomizer.randomString(1));
		return record;
	}
}