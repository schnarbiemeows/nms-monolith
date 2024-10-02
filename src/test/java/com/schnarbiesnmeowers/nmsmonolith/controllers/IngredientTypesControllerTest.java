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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.IngredientTypesService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the IngredientTypesController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IngredientTypesControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private IngredientTypesService ingredienttypesService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new IngredientTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateIngredientTypes() throws URISyntaxException
	{
	    IngredientTypesDTO ingredienttypes = generateRandomIngredientTypes();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(ingredienttypes.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/ingredienttypes/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<IngredientTypesDTO> request = new HttpEntity<>(ingredienttypes,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all IngredientTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllIngredientTypes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredienttypes/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single IngredientTypes by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetIngredientTypes() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredienttypes/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a IngredientTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateIngredientTypes() throws URISyntaxException
	{
	    IngredientTypesDTO ingredienttypes = generateRandomIngredientTypes();
		final String updateUrl = "http://localhost:" + randomServerPort + "/ingredienttypes/update";
		URI uri = new URI(updateUrl);
		HttpEntity<IngredientTypesDTO> request = new HttpEntity<>(ingredienttypes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a IngredientTypes
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteIngredientTypes() throws URISyntaxException
	{
		IngredientTypesDTO ingredienttypes = generateRandomIngredientTypes();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/ingredienttypes/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<IngredientTypesDTO> request = new HttpEntity<>(ingredienttypes);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all IngredientTypes by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetIngredientTypesByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/ingredienttypes/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static IngredientTypesDTO generateRandomIngredientTypes() {
		IngredientTypesDTO record = new IngredientTypesDTO();
		record.setPrntIngrType(Randomizer.randomInt(1000));
		record.setIngrTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}