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
import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.RecipesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RecipesService recipesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Recipes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRecipes() throws URISyntaxException
	{
	    RecipesDTO recipes = generateRandomRecipes();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(recipes.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/recipes/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RecipesDTO> request = new HttpEntity<>(recipes,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Recipes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRecipes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipes/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Recipes by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRecipes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipes/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Recipes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRecipes() throws URISyntaxException
	{
	    RecipesDTO recipes = generateRandomRecipes();
		final String updateUrl = "http://localhost:" + randomServerPort + "/recipes/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RecipesDTO> request = new HttpEntity<>(recipes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Recipes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRecipes() throws URISyntaxException
	{
		RecipesDTO recipes = generateRandomRecipes();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/recipes/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RecipesDTO> request = new HttpEntity<>(recipes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Recipes by foreign key ingrId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipesByIngrId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipes/findByIngrId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RecipesDTO generateRandomRecipes() {
		RecipesDTO record = new RecipesDTO();
		record.setRecipeName(Randomizer.randomString(20));
		record.setIngrId(Randomizer.randomInt(1000));
		record.setRecipeDesc(Randomizer.randomString(20));
		record.setRecipeLink(Randomizer.randomString(20));
		record.setNumSrv(Randomizer.randomBigDecimal("1000"));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}