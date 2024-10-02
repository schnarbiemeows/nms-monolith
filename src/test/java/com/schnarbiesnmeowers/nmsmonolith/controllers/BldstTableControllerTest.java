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

import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.BldstTableService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * this class tests the BldstTableController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BldstTableControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private BldstTableService bldsttableService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new BldstTable
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateBldstTable() throws URISyntaxException
	{
	    BldstTableDTO bldsttable = generateRandomBldstTable();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(bldsttable.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/bldsttable/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BldstTableDTO> request = new HttpEntity<>(bldsttable,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all BldstTable
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllBldstTable() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/bldsttable/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single BldstTable by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetBldstTable() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/bldsttable/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a BldstTable
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateBldstTable() throws URISyntaxException
	{
	    BldstTableDTO bldsttable = generateRandomBldstTable();
		final String updateUrl = "http://localhost:" + randomServerPort + "/bldsttable/update";
		URI uri = new URI(updateUrl);
		HttpEntity<BldstTableDTO> request = new HttpEntity<>(bldsttable);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a BldstTable
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteBldstTable() throws URISyntaxException
	{
		BldstTableDTO bldsttable = generateRandomBldstTable();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/bldsttable/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<BldstTableDTO> request = new HttpEntity<>(bldsttable);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static BldstTableDTO generateRandomBldstTable() {
		BldstTableDTO record = new BldstTableDTO();
		record.setBldstCde(Randomizer.randomString(3));
		record.setBldstDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}