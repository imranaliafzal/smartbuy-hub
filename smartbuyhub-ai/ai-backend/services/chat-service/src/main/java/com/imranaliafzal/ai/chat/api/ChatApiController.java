package com.imranaliafzal.ai.chat.api;

import com.imranaliafzal.ai.chat.model.ChatCompletionRequest;
import com.imranaliafzal.ai.chat.model.ChatCompletionResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ChatApiController implements ChatApi {

    private final WebClient databricksClient;
    private final String baseUrl;

    public ChatApiController(WebClient.Builder builder,
                             @Value("${databricks.base-url}") String baseUrl,
                             @Value("${databricks.api-key:}") String apiKey) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length()-1) : baseUrl;
        this.databricksClient = builder
                .baseUrl(this.baseUrl)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

//    @Override
    @CircuitBreaker(name = "default")
    public Mono<ChatCompletionResponse> createChatCompletion(Mono<ChatCompletionRequest> requestMono) {
        return requestMono.flatMap(req ->
                databricksClient.post()
                        .uri("/v1/chat/completions") // adjust path to match your backend
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .bodyValue(req)
                        .retrieve()
                        .bodyToMono(ChatCompletionResponse.class)
        );
    }
}
