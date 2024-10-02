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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ImageLocDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ImageLocService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ImageLocController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ImageLocControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private ImageLocService imagelocService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new ImageLoc
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateImageLoc() throws URISyntaxException
	{
	    ImageLocDTO imageloc = generateRandomImageLoc();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(imageloc.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/imageloc/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ImageLocDTO> request = new HttpEntity<>(imageloc,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all ImageLoc
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllImageLoc() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/imageloc/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single ImageLoc by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetImageLoc() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/imageloc/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a ImageLoc
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateImageLoc() throws URISyntaxException
	{
	    ImageLocDTO imageloc = generateRandomImageLoc();
		final String updateUrl = "http://localhost:" + randomServerPort + "/imageloc/update";
		URI uri = new URI(updateUrl);
		HttpEntity<ImageLocDTO> request = new HttpEntity<>(imageloc);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a ImageLoc
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteImageLoc() throws URISyntaxException
	{
		ImageLocDTO imageloc = generateRandomImageLoc();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/imageloc/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<ImageLocDTO> request = new HttpEntity<>(imageloc);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static ImageLocDTO generateRandomImageLoc() {
		ImageLocDTO record = new ImageLocDTO();
		record.setImgDesc(Randomizer.randomString(20));
		record.setImgPath(Randomizer.randomString(20));
		return record;
	}
}