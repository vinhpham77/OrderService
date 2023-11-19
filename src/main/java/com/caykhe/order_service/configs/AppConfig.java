package com.caykhe.order_service.configs;

import com.caykhe.order_service.middlewares.RestTemplateAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateAuthInterceptor());
        return restTemplate;
    }
}
