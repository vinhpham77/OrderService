package com.caykhe.order_service.services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenAuthenticationService {
    private final RestTemplate restTemplate;

    public TokenAuthenticationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean authenticate(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        try {
            ResponseEntity<?> response = restTemplate.exchange(
                    "http://localhost:8080/api/v1/auth/verify-token",
                    HttpMethod.GET,
                    entity,
                    String.class);

            return HttpStatus.OK.equals(response.getStatusCode());
        } catch (RestClientException e) {
            return false;
        }
    }
}
