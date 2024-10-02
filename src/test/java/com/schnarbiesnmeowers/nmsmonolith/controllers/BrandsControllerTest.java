package com.schnarbiesnmeowers.nmsmonolith.controllers;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BrandsService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BrandsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BrandsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private BrandsService brandsService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Brands
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateBrands() throws URISyntaxException
	{
	    BrandsDTO brands = generateRandomBrands();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(brands.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/brands/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BrandsDTO> request = new HttpEntity<>(brands,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Brands
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllBrands() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/brands/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Brands by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetBrands() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brands/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Brands
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateBrands() throws URISyntaxException
	{
	    BrandsDTO brands = generateRandomBrands();
		final String updateUrl = "http://localhost:" + randomServerPort + "/brands/update";
		URI uri = new URI(updateUrl);
		HttpEntity<BrandsDTO> request = new HttpEntity<>(brands);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Brands
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteBrands() throws URISyntaxException
	{
		BrandsDTO brands = generateRandomBrands();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/brands/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<BrandsDTO> request = new HttpEntity<>(brands);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Brands by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetBrandsByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brands/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static BrandsDTO generateRandomBrands() {
		BrandsDTO record = new BrandsDTO();
		record.setBrandType(Randomizer.randomString(1));
		record.setBrandName(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}