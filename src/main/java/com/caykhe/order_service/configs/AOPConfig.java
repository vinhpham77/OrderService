package com.caykhe.order_service.configs;



import com.caykhe.order_service.dtos.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class AOPConfig {
    private final MessageSource fieldMessageSource;

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<?> handleException(final ApiException exception) {
        return new ResponseEntity<>(exception.getMessage(), exception.getStatus());
    }




}