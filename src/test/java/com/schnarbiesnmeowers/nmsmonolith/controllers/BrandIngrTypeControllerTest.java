package com.schnarbiesnmeowers.nmsmonolith.controllers;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.schnarbiesnmeowers.nmsmonolith.dtos.BrandIngrTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BrandIngrTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the BrandIngrTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BrandIngrTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private BrandIngrTypeService brandingrtypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new BrandIngrType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateBrandIngrType() throws URISyntaxException
	{
	    BrandIngrTypeDTO brandingrtype = generateRandomBrandIngrType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(brandingrtype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/brandingrtype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BrandIngrTypeDTO> request = new HttpEntity<>(brandingrtype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all BrandIngrType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllBrandIngrType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/brandingrtype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single BrandIngrType by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetBrandIngrType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brandingrtype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a BrandIngrType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateBrandIngrType() throws URISyntaxException
	{
	    BrandIngrTypeDTO brandingrtype = generateRandomBrandIngrType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/brandingrtype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<BrandIngrTypeDTO> request = new HttpEntity<>(brandingrtype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a BrandIngrType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteBrandIngrType() throws URISyntaxException
	{
		BrandIngrTypeDTO brandingrtype = generateRandomBrandIngrType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/brandingrtype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<BrandIngrTypeDTO> request = new HttpEntity<>(brandingrtype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all BrandIngrType by foreign key brandId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetBrandIngrTypeByBrandId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brandingrtype/findByBrandId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all BrandIngrType by foreign key ingrTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetBrandIngrTypeByIngrTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brandingrtype/findByIngrTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all BrandIngrType by foreign key prntIngrType
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetBrandIngrTypeByPrntIngrType() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brandingrtype/findByPrntIngrType/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all BrandIngrType by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetBrandIngrTypeByBrandIdAndIngrTypeIdAndPrntIngrType() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/brandingrtype/findByBrandIdAndIngrTypeIdAndPrntIngrType/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static BrandIngrTypeDTO generateRandomBrandIngrType() {
		BrandIngrTypeDTO record = new BrandIngrTypeDTO();
		record.setBrandId(Randomizer.randomInt(1000));
		record.setIngrTypeId(Randomizer.randomInt(1000));
		record.setPrntIngrType(Randomizer.randomInt(1000));
		return record;
	}
}