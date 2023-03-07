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

import com.schnarbiesnmeowers.nmsmonolith.dtos.PaymentDTO;
import com.schnarbiesnmeowers.nmsmonolith.services.PaymentService;
import com.schnarbiesnmeowers.nmsmonolith.utilities.Randomizer;

/**
 * this class tests the PaymentController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PaymentControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private PaymentService paymentService;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Payment
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreatePayment() throws URISyntaxException
	{
	    PaymentDTO payment = generateRandomPayment();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(payment.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/payment/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PaymentDTO> request = new HttpEntity<>(payment,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Payment
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllPayment() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/payment/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Payment by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetPayment() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/payment/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Payment
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdatePayment() throws URISyntaxException
	{
	    PaymentDTO payment = generateRandomPayment();
		final String updateUrl = "http://localhost:" + randomServerPort + "/payment/update";
		URI uri = new URI(updateUrl);
		HttpEntity<PaymentDTO> request = new HttpEntity<>(payment);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Payment
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeletePayment() throws URISyntaxException
	{
		PaymentDTO payment = generateRandomPayment();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/payment/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<PaymentDTO> request = new HttpEntity<>(payment);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Payment by foreign key userId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetPaymentByUserId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/payment/findByUserId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Payment by foreign key paymentTypeId
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetPaymentByPaymentTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/payment/findByPaymentTypeId/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting all Payment by all foreign keys
	 * @throws URISyntaxException
	*/
	@Test
	public void testGetPaymentByUserIdAndPaymentTypeId() throws URISyntaxException {
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/payment/findByUserIdAndPaymentTypeId/1/1";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}


	public static PaymentDTO generateRandomPayment() {
		PaymentDTO record = new PaymentDTO();
		record.setUserId(Randomizer.randomInt(1000));
		record.setPaymentTypeId(Randomizer.randomInt(1000));
		record.setPaymentAmt(Randomizer.randomBigDecimal("1000"));
		record.setPaymentDesc(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}