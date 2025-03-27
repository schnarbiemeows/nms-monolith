package com.schnarbiesnmeowers.nmsmonolith.utilities;

import com.schnarbiesnmeowers.nmsmonolith.entities.email.InputMessage;
import com.schnarbiesnmeowers.nmsmonolith.entities.email.OutputMessage;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;

@Service
public class EmailUtility {

    private final WebClient webClient;

    public EmailUtility(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    public Mono<String> createPost(InputMessage postRequest) {
        return webClient.post()
                .uri("/email-service/send-email")
                .body(Mono.just(postRequest), InputMessage.class)  // Set the body to the PostRequest object
                .retrieve()
                .bodyToMono(String.class);
    }

    public OutputMessage sendTestEmailUsingTemplate(InputMessage message) {
        OutputMessage outputMessage = new OutputMessage();
        return outputMessage;
    }

    public Mono<String> sendTestEmailUsingWebflux(InputMessage message) {
        OutputMessage outputMessage = new OutputMessage();
        Mono<String> results = createPost(message);
        return results;
    }
}
