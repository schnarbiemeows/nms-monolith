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
import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesHistDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.RolesHistServiceTest;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the RolesHistController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@ExtendWith(MockitoExtension.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RolesHistControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private RolesHistServiceTest roleshistServiceTest;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new RolesHist
	 * @throws URISyntaxException
	 */
	//@Test
	public void testA_CreateRolesHist() throws URISyntaxException
	{
	    RolesHistDTO roleshist = generateRandomRolesHist();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(roleshist.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/roleshist/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<RolesHistDTO> request = new HttpEntity<>(roleshist,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all RolesHist
	 * @throws URISyntaxException
	 */
	//@Test
	public void testB_GetAllRolesHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single RolesHist by primary key
	 * @throws URISyntaxException
	 */
	//@Test
	public void testC_GetRolesHist() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a RolesHist
	 * @throws URISyntaxException
	 */
	//@Test
	public void testD_UpdateRolesHist() throws URISyntaxException
	{
	    RolesHistDTO roleshist = generateRandomRolesHist();
		final String updateUrl = "http://localhost:" + randomServerPort + "/roleshist/update";
		URI uri = new URI(updateUrl);
		HttpEntity<RolesHistDTO> request = new HttpEntity<>(roleshist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a RolesHist
	 * @throws URISyntaxException
	 */
	//@Test
	public void testE_DeleteRolesHist() throws URISyntaxException
	{
		RolesHistDTO roleshist = generateRandomRolesHist();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/roleshist/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<RolesHistDTO> request = new HttpEntity<>(roleshist);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RolesHist by foreign key roleId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesHistByRoleId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findByRoleId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RolesHist by foreign key grpId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesHistByGrpId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findByGrpId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RolesHist by foreign key rsrcId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesHistByRsrcId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findByRsrcId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RolesHist by foreign key actionTypeId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesHistByActionTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findByActionTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RolesHist by foreign key evntOperId
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesHistByEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findByEvntOperId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all RolesHist by all foreign keys
	 * @throws URISyntaxException
	*/
	//@Test
	public void testGetRolesHistByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/roleshist/findByRoleIdAndGrpIdAndRsrcIdAndActionTypeIdAndEvntOperId/1/1/1/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static RolesHistDTO generateRandomRolesHist() {
		RolesHistDTO record = new RolesHistDTO();
		record.setRoleId(Randomizer.randomInt(1000));
		record.setGrpId(Randomizer.randomInt(1000));
		record.setRsrcId(Randomizer.randomInt(1000));
		record.setActionTypeId(Randomizer.randomInt(1000));
		record.setEvntTmestmp(Randomizer.randomDate());
		record.setEvntOperId(Randomizer.randomInt(1000));
		return record;
	}
}