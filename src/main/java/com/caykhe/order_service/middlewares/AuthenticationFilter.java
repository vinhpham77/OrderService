package com.caykhe.order_service.middlewares;

import com.caykhe.order_service.dtos.AuthenticationResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.io.IOException;

@Component
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final RestTemplate restTemplate;
    public AuthenticationFilter(RestTemplate restTemplate) {
        super(AnyRequestMatcher.INSTANCE);
        this.restTemplate = restTemplate;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        // Lấy token từ request
        String token = request.getHeader("Authorization");
        
        AuthenticationResult result = authenticateWithThirdParty(token);

        if (result.isAuthenticated()) {
            // Nếu xác thực thành công, tạo một đối tượng Authentication và trả về
            return new UsernamePasswordAuthenticationToken(null, null, null);
        } else {
            // Nếu xác thực thất bại, ném một ngoại lệ
            throw new BadCredentialsException("Authentication failed");
        }
    }

    private AuthenticationResult authenticateWithThirdParty(String token) {
        String url = "http://localhost:8080/api/v1/verify-token";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<AuthenticationResult> response = restTemplate.exchange(url, HttpMethod.GET, entity, AuthenticationResult.class);
        return response.getBody();
    }
}
