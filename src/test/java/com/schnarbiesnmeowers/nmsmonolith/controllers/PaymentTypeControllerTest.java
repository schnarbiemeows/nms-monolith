package com.schnarbiesnmeowers.nmsmonolith.controllers;

import static org.junit.Assert.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentTypeDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PaymentTypeService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PaymentTypeController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PaymentTypeControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private PaymentTypeService paymenttypeService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new PaymentType
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreatePaymentType() throws URISyntaxException
	{
	    PaymentTypeDTO paymenttype = generateRandomPaymentType();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(paymenttype.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/paymenttype/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PaymentTypeDTO> request = new HttpEntity<>(paymenttype,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all PaymentType
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllPaymentType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/paymenttype/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single PaymentType by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetPaymentType() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/paymenttype/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a PaymentType
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdatePaymentType() throws URISyntaxException
	{
	    PaymentTypeDTO paymenttype = generateRandomPaymentType();
		final String updateUrl = "http://localhost:" + randomServerPort + "/paymenttype/update";
		URI uri = new URI(updateUrl);
		HttpEntity<PaymentTypeDTO> request = new HttpEntity<>(paymenttype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a PaymentType
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeletePaymentType() throws URISyntaxException
	{
		PaymentTypeDTO paymenttype = generateRandomPaymentType();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/paymenttype/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<PaymentTypeDTO> request = new HttpEntity<>(paymenttype);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all PaymentType by foreign key imageLoc
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetPaymentTypeByImageLoc() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/paymenttype/findByImageLoc/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static PaymentTypeDTO generateRandomPaymentType() {
		PaymentTypeDTO record = new PaymentTypeDTO();
		record.setPaymentTypeCde(Randomizer.randomString(10));
		record.setPaymentTypeDesc(Randomizer.randomString(20));
		record.setImageLoc(Randomizer.randomInt(1000));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}