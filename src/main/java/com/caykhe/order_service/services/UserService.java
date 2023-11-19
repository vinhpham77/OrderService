package com.caykhe.order_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RestTemplate restTemplate;
    private String USER_SERVICE_URL = "http://localhost:8080/api/v1/";
    
    
}
