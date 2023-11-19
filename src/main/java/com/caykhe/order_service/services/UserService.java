package com.caykhe.order_service.services;

import com.caykhe.order_service.middlewares.RestTemplateAuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RestTemplate restTemplate;
    private String USER_SERVICE_URL = "http://localhost:8080/api/v1/";
    
    // get User kiểm tra tồn tại hay không cho Bảng Order
    // xác thực 
     // verify token
    public boolean verifyToken(String token) {
        String url = USER_SERVICE_URL + "verify-token";
        restTemplate.getInterceptors().add(new RestTemplateAuthInterceptor(token));
        
        return Boolean.TRUE.equals(restTemplate.getForObject(url, Boolean.class));
    }
    
    public boolean checkUserExist(String userId, String token) {
        String url = USER_SERVICE_URL + "users/" + userId;
        restTemplate.getInterceptors().add(new RestTemplateAuthInterceptor(token));
        return restTemplate.getForEntity(url, Boolean.class).getStatusCode() == HttpStatus.OK;
    }
}
