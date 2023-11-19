package com.caykhe.order_service.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationResult {
    private final boolean isAuthenticated;
    
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}
