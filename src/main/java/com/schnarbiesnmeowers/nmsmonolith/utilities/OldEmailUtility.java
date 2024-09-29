package com.schnarbiesnmeowers.nmsmonolith.utilities;

import com.schnarbiesnmeowers.nmsmonolith.pojos.email.InputMessage;
import com.schnarbiesnmeowers.nmsmonolith.pojos.email.OutputMessage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OldEmailUtility {

    private final RestTemplate restTemplate;

    public OldEmailUtility(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public OutputMessage createPost(InputMessage postRequest) {
        String url = "http://localhost:8081/email-service/send-email";

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Create the HttpEntity to wrap the request body
        HttpEntity<InputMessage> requestEntity = new HttpEntity<>(postRequest, headers);

        // Send the POST request
        ResponseEntity<OutputMessage> response = restTemplate.exchange(url, HttpMethod.POST,
                requestEntity, OutputMessage.class);
        return response.getBody();
    }
}
