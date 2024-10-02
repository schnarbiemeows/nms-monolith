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
import com.schnarbiesnmeowers.nmsmonolith.dtos.ExerciseTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.ExerciseTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the ExerciseTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExerciseTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private ExerciseTypeService exercisetypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new ExerciseType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateExerciseType() throws URISyntaxException
	{
	    ExerciseTypeDTO exercisetype = generateRandomExerciseType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(exercisetype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/exercisetype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ExerciseTypeDTO> request = new HttpEntity<>(exercisetype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all ExerciseType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllExerciseType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/exercisetype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single ExerciseType by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetExerciseType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/exercisetype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a ExerciseType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateExerciseType() throws URISyntaxException
	{
	    ExerciseTypeDTO exercisetype = generateRandomExerciseType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/exercisetype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<ExerciseTypeDTO> request = new HttpEntity<>(exercisetype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a ExerciseType
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteExerciseType() throws URISyntaxException
	{
		ExerciseTypeDTO exercisetype = generateRandomExerciseType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/exercisetype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<ExerciseTypeDTO> request = new HttpEntity<>(exercisetype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all ExerciseType by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetExerciseTypeByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/exercisetype/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static ExerciseTypeDTO generateRandomExerciseType() {
		ExerciseTypeDTO record = new ExerciseTypeDTO();
		record.setPrntExerciseType(Randomizer.randomInt(1000));
		record.setExerciseTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}