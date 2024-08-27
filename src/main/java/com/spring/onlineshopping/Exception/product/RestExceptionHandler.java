package com.spring.onlineshopping.Exception.product;

import com.spring.onlineshopping.apierror.ApiError;
import com.spring.onlineshopping.dto.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ApiError> productNotFound(ProductNotFoundException e) {
        ApiError apiError = new ApiError(400,"Product not found",new Date());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<ApiError> productValidationException(ProductValidationException e) {
        ApiError apiError = new ApiError(400,"Product validation error",new Date());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
    }
}
