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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.IngredientsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the IngredientsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private IngredientsService ingredientsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Ingredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateIngredients() throws URISyntaxException
	{
	    IngredientsDTO ingredients = generateRandomIngredients();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(ingredients.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/ingredients/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<IngredientsDTO> request = new HttpEntity<>(ingredients,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Ingredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllIngredients() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Ingredients by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetIngredients() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Ingredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateIngredients() throws URISyntaxException
	{
	    IngredientsDTO ingredients = generateRandomIngredients();
		final String updateUrl = "http://localhost:" + randomServerPort + "/ingredients/update";
		URI uri = new URI(updateUrl);
		HttpEntity<IngredientsDTO> request = new HttpEntity<>(ingredients);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Ingredients
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteIngredients() throws URISyntaxException
	{
		IngredientsDTO ingredients = generateRandomIngredients();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/ingredients/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<IngredientsDTO> request = new HttpEntity<>(ingredients);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Ingredients by foreign key ingrTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetIngredientsByIngrTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/findByIngrTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Ingredients by foreign key brandId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetIngredientsByBrandId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/findByBrandId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Ingredients by foreign key servTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetIngredientsByServTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/findByServTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Ingredients by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetIngredientsByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Ingredients by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetIngredientsByIngrTypeIdAndBrandIdAndServTypeIdAndImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredients/findByIngrTypeIdAndBrandIdAndServTypeIdAndImageLoc/1/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static IngredientsDTO generateRandomIngredients() {
		IngredientsDTO record = new IngredientsDTO();
		record.setIngrDesc(Randomizer.randomString(20));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setBrandId(Randomizer.randomInt(1000));
		record.setServSz(Randomizer.randomBigDecimal("1000"));
		record.setServTypeId(Randomizer.randomInt(1000));
		record.setKcalories(Randomizer.randomBigDecimal("1000"));
		record.setTotFat(Randomizer.randomBigDecimal("1000"));
		record.setSatFat(Randomizer.randomBigDecimal("1000"));
		record.setTransFat(Randomizer.randomBigDecimal("1000"));
		record.setPolyFat(Randomizer.randomBigDecimal("1000"));
		record.setMonoFat(Randomizer.randomBigDecimal("1000"));
		record.setCholes(Randomizer.randomBigDecimal("1000"));
		record.setSodium(Randomizer.randomInt(1000));
		record.setTotCarbs(Randomizer.randomBigDecimal("1000"));
		record.setTotFiber(Randomizer.randomBigDecimal("1000"));
		record.setTotSugars(Randomizer.randomBigDecimal("1000"));
		record.setTotProtein(Randomizer.randomBigDecimal("1000"));
		record.setGlycIndx(Randomizer.randomBigDecimal("1000"));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}