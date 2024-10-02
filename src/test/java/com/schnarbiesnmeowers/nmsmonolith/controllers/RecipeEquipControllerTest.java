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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeEquipDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RecipeEquipService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RecipeEquipController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RecipeEquipControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RecipeEquipService recipeequipService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RecipeEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRecipeEquip() throws URISyntaxException
	{
	    RecipeEquipDTO recipeequip = generateRandomRecipeEquip();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(recipeequip.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/recipeequip/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RecipeEquipDTO> request = new HttpEntity<>(recipeequip,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RecipeEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRecipeEquip() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeequip/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RecipeEquip by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRecipeEquip() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeequip/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RecipeEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRecipeEquip() throws URISyntaxException
	{
	    RecipeEquipDTO recipeequip = generateRandomRecipeEquip();
		final String updateUrl = "http://localhost:" + randomServerPort + "/recipeequip/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RecipeEquipDTO> request = new HttpEntity<>(recipeequip);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RecipeEquip
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRecipeEquip() throws URISyntaxException
	{
		RecipeEquipDTO recipeequip = generateRandomRecipeEquip();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/recipeequip/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RecipeEquipDTO> request = new HttpEntity<>(recipeequip);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeEquip by foreign key recEqTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeEquipByRecEqTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeequip/findByRecEqTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeEquip by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeEquipByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeequip/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RecipeEquip by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRecipeEquipByRecEqTypeIdAndImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/recipeequip/findByRecEqTypeIdAndImageLoc/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RecipeEquipDTO generateRandomRecipeEquip() {
		RecipeEquipDTO record = new RecipeEquipDTO();
		record.setRecEqTypeId(Randomizer.randomInt(1000));
		record.setEquipDesc(Randomizer.randomString(20));
		record.setEquipLongDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}