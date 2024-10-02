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
import com.schnarbiesnmeowers.nmsmonolith.dtos.UserCalendarDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.UserCalendarService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the UserCalendarController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserCalendarControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private UserCalendarService usercalendarService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new UserCalendar
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateUserCalendar() throws URISyntaxException
	{
	    UserCalendarDTO usercalendar = generateRandomUserCalendar();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(usercalendar.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/usercalendar/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserCalendarDTO> request = new HttpEntity<>(usercalendar,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all UserCalendar
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllUserCalendar() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/usercalendar/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single UserCalendar by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetUserCalendar() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usercalendar/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a UserCalendar
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateUserCalendar() throws URISyntaxException
	{
	    UserCalendarDTO usercalendar = generateRandomUserCalendar();
		final String updateUrl = "http://localhost:" + randomServerPort + "/usercalendar/update";
		URI uri = new URI(updateUrl);
		HttpEntity<UserCalendarDTO> request = new HttpEntity<>(usercalendar);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a UserCalendar
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteUserCalendar() throws URISyntaxException
	{
		UserCalendarDTO usercalendar = generateRandomUserCalendar();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/usercalendar/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<UserCalendarDTO> request = new HttpEntity<>(usercalendar);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UserCalendar by foreign key userId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetUserCalendarByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usercalendar/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UserCalendar by foreign key eventId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetUserCalendarByEventId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usercalendar/findByEventId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all UserCalendar by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetUserCalendarByUserIdAndEventId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/usercalendar/findByUserIdAndEventId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static UserCalendarDTO generateRandomUserCalendar() {
		UserCalendarDTO record = new UserCalendarDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setCalendarDate(Randomizer.randomDate());
		record.setCalendarTime(Randomizer.randomTime(1000));
		record.setEventId(Randomizer.randomInt(1000));
		return record;
	}
}